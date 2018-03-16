package model.Qualities.impl;

import model.Qualities.Quality;

public class LowQuality implements Quality {

    public static final String SYMBOL = "V";

    public String type() {
        return SYMBOL;
    }

    public boolean isBetterThan(Quality quality) {
        if (quality instanceof LowQuality) {
            return true;
        }
        return false;
    }
}
