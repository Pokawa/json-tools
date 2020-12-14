package pl.put.poznan.transformer.logic;

public class JsonTransformer {
    private final String[] transforms;

    public JsonTransformer(String[] transforms) {
        this.transforms = transforms;
    }

    public String transform(JSONObject jsonObject) {
        for (String transformation : transforms) {
        }
        return jsonObject.getJson();
    }
}
