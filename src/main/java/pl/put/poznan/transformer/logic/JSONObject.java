package pl.put.poznan.transformer.logic;
/**
 * Class that stores JSON to be modified and by method getJson() allows to acces it at any given moment.
 */
public class JSONObject {
    private String json;

    public JSONObject(String json){
        this.json = json;
    }

    public JSONObject(){}
    /**
     * 
     * @return String that is JSON
     */
    public String getJson() {
        return json;
    }
}
