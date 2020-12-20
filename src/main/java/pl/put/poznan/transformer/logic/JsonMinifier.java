package pl.put.poznan.transformer.logic;

/**
 * Decorator of JSONObject, removes white chars
 */
public class JsonMinifier extends JsonDecorator {
    /**
     * Constructor
     */
    public JsonMinifier(JSONObject jsonObject) {
        super(jsonObject);
    }
    /**
     * this method takes format text
     * @return string without white signs inside it
     */
    @Override
    public String getJson() {
        String json = jsonObject.getJson();
        return json.replaceAll("\\s+","");
    }
}
