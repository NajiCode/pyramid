package entities.layers;

import entities.blocks.Block;
import entities.blocks.BlockFactory;
import entities.blocks.HighQualityBlock;
import entities.blocks.LowQualityBlock;

import java.util.List;

public class LayerFactory {
    private BlockFactory blockFactory;

    public LayerFactory(BlockFactory blockFactory) {
        this.blockFactory = blockFactory;
    }

    public Layer createFrom(String description) {
        List<Block> blocks = blockFactory.createFrom(description);
        if (blocks.get(0) instanceof HighQualityBlock) {
            return new HighQualityLayer(blocks);
        }
        else if (blocks.get(0) instanceof LowQualityBlock) {
            return new LowQualityLayer(blocks);
        }

        return null;
    }
}
