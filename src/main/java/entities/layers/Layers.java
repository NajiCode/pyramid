package entities.layers;

import java.util.ArrayList;
import java.util.List;

import static config.Configuration.LINE_SEPARATOR;

public class Layers {
    private List<Layer> layers;

    public Layers() {
        this.layers = new ArrayList<Layer>();
    }

    public void add(Layer layer) {
        Layer previousLayer = getPreviousLayer();
        if (previousLayer != null) {
            if (layer.isBetterThan(previousLayer)) {
                this.layers.set(layers.size() - 1, layer);
            } else {
                this.layers.add(layer);
            }
        }else {
            this.layers.add(layer);
        }
    }

    private Layer getPreviousLayer() {
        if (layers.size() > 0) {
            return layers.get(layers.size() - 1);
        }
        return null;
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        Layer baseLayer = layers.get(0);
        int baseSize = baseLayer.size();
        int previousSize = baseLayer.size();
        for (Layer layer : layers) {
            sb.insert(0,layer.print(baseSize, previousSize) + LINE_SEPARATOR);
            previousSize = layer.size();
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
