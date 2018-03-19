package model.qualities.impl;

import model.qualities.Quality;

public class HighQuality implements Quality {

    private static final String SYMBOL = "X";

    public String type() {
        return SYMBOL;
    }

    public boolean isBetterThan(Quality quality) {
        return true;
    }
}
