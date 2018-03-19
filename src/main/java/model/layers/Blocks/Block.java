package model.layers.Blocks;

import model.Drawable;
import model.qualities.Quality;

public class Block implements Drawable{
    private final Quality quality;

    public Block(Quality quality) {
        this.quality = quality;
    }

    public String print() {
        return quality.type();
    }

    public boolean isBetterThan(Block block) {
        return quality.isBetterThan(block.quality);
    }
}
