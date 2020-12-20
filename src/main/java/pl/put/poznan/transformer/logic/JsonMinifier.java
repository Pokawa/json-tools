package pl.put.poznan.transformer.logic;

public class JsonMinifier extends JsonDecorator {
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
