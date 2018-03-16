package model;


public class Pyramid {
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
