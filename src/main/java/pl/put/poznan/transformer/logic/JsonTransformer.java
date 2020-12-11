package pl.put.poznan.transformer.logic;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
abstract public class JsonTransformer {

    private final String[] transforms;

    public JsonTransformer(String[] transforms){
        this.transforms = transforms;
    }

    public String transform(String text){
        return text;
    }
}
