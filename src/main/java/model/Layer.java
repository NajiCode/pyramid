package model;

import java.util.ArrayList;
import java.util.List;

public class Layer {

    private Layer previousLayer;
    private List<Block> blocks;

    public Layer(String description, Layer previousLayer) {
        blocks = new ArrayList<Block>();
        this.previousLayer = previousLayer;

        String[] model = description.split(",");
        String[] slavesModel = model[0].trim().split(" ");
        String[] anksModel = model[1].trim().split(" ");

        int nbrOfSlaves = Integer.valueOf(slavesModel[0]);
        int nbrOfAnks = Integer.valueOf(anksModel[0]);

        int nbOfblocks = nbrOfSlaves / 50;

        if (nbOfblocks * 2 <= nbrOfAnks) {
            addBlocks(nbOfblocks, "X");
        } else {
            addBlocks(nbOfblocks,"V");
        }
    }

    private void addBlocks(int nbrOfblocks, String type) {
        for (int i=0; i<nbrOfblocks;i++) {
            blocks.add(new Block(type));
        }
    }

    public String print(int baseSize) {
        StringBuilder result = new StringBuilder();
        StringBuilder underscore = new StringBuilder("_");
        StringBuilder space = new StringBuilder(" ");
        for (Block block : blocks) {
            result.append(block.print());
        }

        if (previousLayer!=null) {
            if (size() != previousLayer.size()) {
                result = updateResult(result, underscore, (previousLayer.size()-size()) / 2);
            }

            result = updateResult(result, space, (baseSize-previousLayer.size())/2);
        }

        return result.toString();
    }

    private StringBuilder updateResult(StringBuilder result, StringBuilder symbol, int size) {
        for (int i = 0; i < size; i++) {
            result.append(symbol);
        }
        StringBuilder prefix = createPrefix(size, symbol);
        result = prefix.append(result);
        return result;
    }

    private StringBuilder createPrefix(int size, StringBuilder symbol) {
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < size; i++) {
            prefix.append(symbol);
        }

        return prefix;
    }

    public int size() {
        return blocks.size();
    }

    public boolean collapse() {
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
