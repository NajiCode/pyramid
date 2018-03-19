package model.qualities;


import model.qualities.impl.HighQuality;
import model.qualities.impl.LowQuality;

public class QualityFactory {
    public Quality create(String type) {
        if ("highQuality".equals(type)) {
            return new HighQuality();
        }
        else if ("lowQuality".equals(type)) {
            return new LowQuality();
        }

        return null;
    }
}
