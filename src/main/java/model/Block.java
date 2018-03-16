package model;

public class Block {
    private final String type;

    public Block(String type) {
        this.type = type;
    }

    public String print() {
        return type;
    }

    public boolean isBetterThan(Block block) {
        if (type.equals("V") && block.type.equals("V")) {
            return true;
        }
        if (type.equals("X")) {
            return true;
        }
        return false;
    }
}
