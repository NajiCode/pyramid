import entities.blocks.BlockFactory;
import entities.layers.Layer;
import entities.layers.LayerFactory;
import entities.layers.Layers;

class Pyramid {
    private Layers layers;
    private LayerFactory layerFactory;

    Pyramid() {
        this.layers = new Layers();
        this.layerFactory = new LayerFactory(new BlockFactory());
    }

    void addLayer(String description) {
        Layer layer = createLayer(description);
        layers.add(layer);
    }

    private Layer createLayer(String description) {
        return layerFactory.createFrom(description);
    }

    String print() {
        return layers.print();
    }
}
