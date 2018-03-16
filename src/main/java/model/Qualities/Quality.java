package model.Qualities;

public interface Quality {
    String type();

    boolean isBetterThan(Quality quality);
}
