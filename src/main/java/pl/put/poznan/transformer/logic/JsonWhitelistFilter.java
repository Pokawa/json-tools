package pl.put.poznan.transformer.logic;

import org.json.*;
/**
 * extends {@see JsonDecorator} and adds excludedKey that stores key to be left in json
 */
public class JsonWhitelistFilter extends JsonDecorator {
    private final String[] includeKeys;

    public JsonWhitelistFilter(JSONObject jsonObject, String includeKey) {
        super(jsonObject);
        this.includeKeys = includeKey.split("[.]");
    }
    /**
     * Returns Filtered JSON as String. It removes every key except given one.
     * It reads variable code, which starts from "include" and then element we want to filter is given
     * for example"includetitle" will remove every JSON with key other than title.
     * multiple keys can be given, and must be separated with dots, for example "includetitle.text"
     * @return JSON String with only specified key
     */
    @Override
    public String getJson() {
        var js = jsonObject.getJson();
        org.json.JSONObject jo = new org.json.JSONObject(js);

        jo.keySet().removeIf(key -> !isIncluded(key));
        return jo.toString();
    }

    private boolean isIncluded(String key) {
        for (String includedKey : includeKeys) {
            if (includedKey.equals(key))
                return true;
        }
        return false;
    }

}
