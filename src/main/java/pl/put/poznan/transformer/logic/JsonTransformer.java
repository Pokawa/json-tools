package pl.put.poznan.transformer.logic;


/**
 * This class connects decorators
 */
public class JsonTransformer {
    private final String[] transforms;
    
    /**
     * Contructor
     * @param transforms list of transforms to perform
     */
    public JsonTransformer(String[] transforms) {
        this.transforms = transforms;
    }
    
     /**
     * This method processes query form URL
     * @param jsonObject which has content of query's body
     * @return string with wanted changes
     */

    public String transform(JSONObject jsonObject) {
        JSONObject decorators = jsonObject;
        for (String transformation : transforms) {

            //Minification transform
            if (transformation.equalsIgnoreCase("minify")) {
                decorators = new JsonMinifier(decorators);
            }
            //json formatting
            else if (transformation.equalsIgnoreCase("fullForm")){
                decorators = new JsonFullFormMaker(decorators);
            }
            //Excluding keys
            else if (transformation.startsWith("exclude")){
                decorators = new JsonBlacklistFilter(decorators,transformation.substring(7));
            }
            //Whitelisting keys
            else if (transformation.startsWith("include")){
                decorators = new JsonWhitelistFilter(decorators,transformation.substring(7));
            }
        }
        return decorators.getJson();
    }
}
