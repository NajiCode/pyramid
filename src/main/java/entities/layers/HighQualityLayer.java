package entities.layers;

import entities.blocks.Block;

import java.util.List;

public class HighQualityLayer extends Layer {
     HighQualityLayer(List<Block> blocks) {
        super(blocks);
    }

    public boolean isBetterThan(Layer previousLayer) {
        return this.size() > previousLayer.size();
    }

    public boolean isLowQuality() {
        return false;
    }
}
