package entities.layers;

import entities.blocks.Block;

import java.util.List;

public class LowQualityLayer extends Layer {
    public LowQualityLayer(List<Block> blocks) {
        super(blocks);
    }

    public boolean isBetterThan(Layer previousLayer) {
        if (previousLayer.isLowQuality()) {
            if (this.size() >= previousLayer.size()) {
                return true;
            }
        }
        return false;
    }

    public boolean isLowQuality() {
        return true;
    }
}
