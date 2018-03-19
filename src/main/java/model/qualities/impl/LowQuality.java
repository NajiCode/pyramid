package model.qualities.impl;

import model.qualities.Quality;

public class LowQuality implements Quality {

    private static final String SYMBOL = "V";

    public String type() {
        return SYMBOL;
    }

    public boolean isBetterThan(Quality quality) {
        return quality instanceof LowQuality;
    }
}
