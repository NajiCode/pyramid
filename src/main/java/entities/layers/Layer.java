package entities.layers;

import entities.blocks.Block;

import java.util.List;

import static config.Configuration.SPACE;
import static config.Configuration.UNDERSCORE;

public abstract class Layer {
    private final List<Block> blocks;

    Layer(List<Block> blocks) {
        this.blocks = blocks;
    }

    String print(int baseSize, int previousSize) {
        StringBuilder sb = new StringBuilder();
        int nbrOfRepetition1 = (baseSize - previousSize) / 2;
        int nbrOfRepetition2 = (previousSize - blocks.size()) / 2;
        sb.append(symbolPresentation(SPACE, nbrOfRepetition1));
        sb.append(symbolPresentation(UNDERSCORE, nbrOfRepetition2));
        sb.append(blocksPresentation());
        sb.append(symbolPresentation(UNDERSCORE, nbrOfRepetition2));
        sb.append(symbolPresentation(SPACE, nbrOfRepetition1));
        return sb.toString();
    }

    private String symbolPresentation(String symbol, int nbrOfRepetition) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nbrOfRepetition; i++) {
            sb.append(symbol);
        }
        return sb.toString();
    }

    private String blocksPresentation() {
        StringBuilder sb = new StringBuilder();
        for (Block block : blocks) {
            sb.append(block.print());
        }
        return sb.toString();
    }

    int size() {
        return blocks.size();
    }

    public abstract boolean isBetterThan(Layer previousLayer);

    public abstract boolean isLowQuality();
}
