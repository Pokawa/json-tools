package pl.put.poznan.transformer.logic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class JsonFullFormMaker extends JsonDecorator {
    public JsonFullFormMaker(JSONObject jsonObject){ super(jsonObject); }


    @Override
    public String getJson(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(jsonObject.getJson());
        return gson.toJson(je);

    }

}
