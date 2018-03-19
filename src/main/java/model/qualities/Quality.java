package model.qualities;

public interface Quality {
    String type();

    boolean isBetterThan(Quality quality);
}
