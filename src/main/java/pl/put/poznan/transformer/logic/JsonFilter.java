package pl.put.poznan.transformer.logic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;
import org.json.*;

public class JsonFilter extends JsonDecorator {private String code;
    public JsonFilter(JSONObject jsonObject, String code){
        super(jsonObject);
        this.code = code;
    }

@Override
    public String getJson(){
        code=code.substring(7);
        var js = jsonObject.getJson();
        org.json.JSONObject jo = new org.json.JSONObject(js);
        jo.remove(code);
    jo.keys().forEachRemaining(key -> {
        Object value = jo.get(key);
        if(value instanceof JSONArray)
        {
                JSONArray v=new JSONArray(value);
            org.json.JSONObject toe= v.getJSONObject(0);
            toe.remove(code);
            JSONArray vi=new JSONArray(toe.toString());


                        jo.put(key,vi);

        }
        else if(value instanceof org.json.JSONObject)
        {
            org.json.JSONObject v = new org.json.JSONObject(value.toString());
            v.remove(code);
            jo.put(key,v);

        }
    });
        return jo.toString();

    }

}
