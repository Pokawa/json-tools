package pl.put.poznan.transformer.logic;

/**
 * This class is an abstract class, that is decorator of the decorator pattern approach
 */
abstract public class JsonDecorator extends JSONObject{
    protected JSONObject jsonObject;
    
    /**
    * class constructor
    */
    public JsonDecorator(JSONObject jsonObject){
        this.jsonObject = jsonObject;
    }
    
    /**
    * basic getter (actually never in use)
    */
    
    @Override
    public String getJson() {
        return jsonObject.getJson();
    }
}
