package model.layers;

import model.Drawable;

import java.util.ArrayList;
import java.util.List;

public class Layers implements Drawable {
    private List<Layer> layers;

    public Layers() {
        this.layers = new ArrayList<Layer>();
    }

    public void add(String description) {
        Layer previousLayer = null;
        if (!layers.isEmpty()) {
            previousLayer = layers.get(layers.size()-1);
        }
        Layer layer = new Layer(description,previousLayer);
        layers.add(layer);
        collapse();
    }

    private void collapse() {
        if (layers.size()>1) {
            Layer currentLayer = layers.get(layers.size() - 1);
            if (currentLayer.collapse()) {
                layers.remove(layers.size()-2);
            }
        }
    }

    public String print() {
        StringBuilder result = new StringBuilder();
        int baseSize = layers.get(0).size();
        for (Layer layer : layers) {
            result.append(layer.print(baseSize)+"\n");
        }
        result.setLength(result.length()-1);
        result.reverse();
        return result.toString();
    }
}
