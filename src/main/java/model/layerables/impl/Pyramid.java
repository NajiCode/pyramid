package model.layerables.impl;


import model.Drawable;
import model.layerables.Layerable;
import model.layers.Layers;

public class Pyramid implements Layerable, Drawable {
    private Layers layers;

    public Pyramid() {
        this.layers = new Layers();
    }

    public void addLayer(String description) {
            layers.add(description);
    }

    public String print() {
        return layers.print();
    }
}
