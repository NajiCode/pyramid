package entities.blocks;

import static config.Configuration.LOWQUALITY_SYMBOL;

public class LowQualityBlock extends Block {
    public String print() {
        return LOWQUALITY_SYMBOL;
    }
}
