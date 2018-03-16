package model.Qualities.impl;

import model.Qualities.Quality;

public class HighQuality implements Quality {

    public static final String SYMBOL = "X";

    public String type() {
        return SYMBOL;
    }

    public boolean isBetterThan(Quality quality) {
        return true;
    }
}
