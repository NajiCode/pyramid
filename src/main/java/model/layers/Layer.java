package model.layers;

import model.Qualities.QualityFactory;
import model.layers.Blocks.Block;
import model.Qualities.Quality;

import java.util.ArrayList;
import java.util.List;

public class Layer {

    private Layer previousLayer;
    private List<Block> blocks;
    private QualityFactory qualityFactory;

    Layer(String description, Layer previousLayer) {
        this.blocks = new ArrayList<Block>();
        this.previousLayer = previousLayer;
        this.qualityFactory = new QualityFactory();

        String[] model = description.split(",");
        String[] slavesModel = model[0].trim().split(" ");
        String[] anksModel = model[1].trim().split(" ");

        createBlocks(slavesModel[0], anksModel[0]);
    }

    private void createBlocks(String slavesModel, String anksModel) {
        int nbrOfSlaves = Integer.valueOf(slavesModel);
        int nbrOfAnks = Integer.valueOf(anksModel);

        int nbrOfBlocks = nbrOfSlaves / 50;

        if (nbrOfBlocks * 2 <= nbrOfAnks) {
            addBlocks(nbrOfBlocks, "highQuality");
        } else {
            addBlocks(nbrOfBlocks,"lowQuality");
        }
    }

    private void addBlocks(int nbrOfBlocks, String qualityType) {
        for (int i=0; i<nbrOfBlocks;i++) {
            Quality quality = qualityFactory.create(qualityType);
            blocks.add(new Block(quality));
        }
    }

    String print(int baseSize) {
        StringBuilder result = new StringBuilder();
        for (Block block : blocks) {
            result.append(block.print());
        }

        result = layerPresentation(baseSize, result);

        return result.toString();
    }

    private StringBuilder layerPresentation(int baseSize, StringBuilder result) {
        if (previousLayer!=null) {
            result = adjustResult(baseSize, result);
        }
        return result;
    }

    private StringBuilder adjustResult(int baseSize, StringBuilder result) {
        StringBuilder underscore = new StringBuilder("_");
        StringBuilder space = new StringBuilder(" ");
        if (size() != previousLayer.size()) {
            int nbrOfSymbols = (previousLayer.size() - size()) / 2;
            result = addSymbols(result, underscore, nbrOfSymbols);
        }
        int nbrOfSymbols = (baseSize - previousLayer.size()) / 2;
        result = addSymbols(result, space, nbrOfSymbols);
        return result;
    }

    private StringBuilder addSymbols(StringBuilder result, StringBuilder symbol, int size) {
        StringBuilder prefixSuffix = createPrefixSuffix(size, symbol);

        result.append(prefixSuffix);
        result = prefixSuffix.append(result);

        return result;
    }

    private StringBuilder createPrefixSuffix(int size, StringBuilder symbol) {
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < size; i++) {
            prefix.append(symbol);
        }

        return prefix;
    }

    int size() {
        return blocks.size();
    }

    boolean collapse() {
        if (size() >= previousLayer.size() && blocksAreBetterThan(previousLayer)) {
            this.previousLayer = previousLayer.previousLayer;
            return true;
        }
        return false;
    }

    private boolean blocksAreBetterThan(Layer previousLayer) {
        return blocks.get(0).isBetterThan(previousLayer.blocks.get(0));
    }
}
