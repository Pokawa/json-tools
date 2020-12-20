package pl.put.poznan.transformer.logic;

import org.json.*;

public class JsonFilter extends JsonDecorator {
    private String excludedKey;

    public JsonFilter(JSONObject jsonObject, String excludedKey) {
        super(jsonObject);
        this.excludedKey = excludedKey;
    }
    /**
     * Returns Filtered JSON as String. It removes every instance of given code that is at most nested only once.
     * It reads variable code, which starts from "exclude" and then element we want to filter is given
     * for example"excludetitle" will remove every JSON with title as key.
     * @return JSON String without specified keys
     */
    @Override
    public String getJson() {
        var js = jsonObject.getJson();
        org.json.JSONObject jo = new org.json.JSONObject(js);
        jo.remove(excludedKey);
        jo.keys().forEachRemaining(key -> {
            Object value = jo.get(key);
            if (value instanceof org.json.JSONObject) {
                ((org.json.JSONObject) value).remove(excludedKey);
            }
        });
        return jo.toString();

    }

}
