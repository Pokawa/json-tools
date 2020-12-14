package pl.put.poznan.transformer.logic;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
abstract public class JsonDecorator extends JSONObject{
    protected JSONObject jsonObject;

    public JsonDecorator(JSONObject jsonObject){
        this.jsonObject = jsonObject;
    }

    @Override
    public String getJson() {
        return jsonObject.getJson();
    }
}
