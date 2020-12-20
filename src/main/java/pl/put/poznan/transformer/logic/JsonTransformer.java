package pl.put.poznan.transformer.logic;

public class JsonTransformer {
    private final String[] transforms;

    public JsonTransformer(String[] transforms) {
        this.transforms = transforms;
    }
    
     /**
     * This method processes query form URL
     * @param jsonObject which has content of query's body
     * @return string with wanted changes
     */

    public String transform(JSONObject jsonObject) {
        for (String transformation : transforms) {

            //Minification transform
            if (transformation.equalsIgnoreCase("minify")) {
                JsonMinifier minifier = new JsonMinifier(jsonObject);
                jsonObject = new JSONObject(minifier.getJson());
            }
            //formatowanie jsona
            else if (transformation.equalsIgnoreCase("fullForm")){
                JsonFullFormMaker fullForm = new JsonFullFormMaker(jsonObject);
                jsonObject = new JSONObject(fullForm.getJson());
            }
            //Excluding keys
            else if (transformation.startsWith("exclude")){
                JsonFilter filter = new JsonFilter(jsonObject,transformation.substring(7));
                jsonObject = new JSONObject(filter.getJson());
            }

        }
        return jsonObject.getJson();
    }
}
