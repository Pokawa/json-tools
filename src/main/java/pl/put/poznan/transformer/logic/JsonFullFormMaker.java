package pl.put.poznan.transformer.logic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


/**
* Decorator class that formats json to human readeable form
*/
public class JsonFullFormMaker extends JsonDecorator {
    
    /**
     * Constructor
     * @param jsonObject internal decorator
     */
    public JsonFullFormMaker(JSONObject jsonObject){ super(jsonObject); }
    
     /**
     * this method takes string without white signs
     * @return formatted json, which is more human-readable
     */
    @Override
    public String getJson(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(jsonObject.getJson());
        return gson.toJson(je);

    }

}
