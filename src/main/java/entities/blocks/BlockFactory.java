package entities.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BlockFactory {

    private static final int BLOCK_COST = 50;
    private static final int COST_FOR_HIGH_QUALITY = 2;

    public List<Block> createFrom(String description) {
        String regex = "(\\d+) Slaves, (\\d+) Anks";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(description);
        matcher.find();
        int nbrOfSlaves = Integer.parseInt(matcher.group(1));
        int nbrOfAnks = Integer.parseInt(matcher.group(2));
        int nbrOfBlocks = nbrOfSlaves / BLOCK_COST;
        int anksForOneBlock = nbrOfAnks / nbrOfBlocks;
        List<Block> blocks = new ArrayList<Block>();
        for (int i = 0; i < nbrOfBlocks; i++) {
            Block block = createBy(anksForOneBlock);
            blocks.add(block);
        }
        return blocks;
    }

    private Block createBy(int anksForOneBlock) {
        if (anksForOneBlock >= COST_FOR_HIGH_QUALITY) {
            return new HighQualityBlock();
        } else {
            return new LowQualityBlock();
        }
    }
}
