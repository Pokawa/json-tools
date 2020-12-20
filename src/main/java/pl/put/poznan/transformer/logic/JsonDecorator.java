package pl.put.poznan.transformer.logic;

/**
 * This class is an abstract class, that is decorator of the decorator pattern approach
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
