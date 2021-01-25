package pl.put.poznan.transformer.logic;

import com.github.difflib.text.DiffRow;
import com.github.difflib.text.DiffRowGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * Decorator class that tag differences between two texts separated with <splitPoint> tag line
 */

public class JsonTextDifference extends JsonDecorator{

    /**
     * Constructor
     * @param jsonObject internal decorator
     */

    public JsonTextDifference(JSONObject jsonObject){ super(jsonObject); }


    /**
     * this method takes 2 strings separated by <splitPoint> line tag
     * @return formatted text with <dif> tags added where differences between two texts are
     */

    @Override
    public String getJson(){

        String Str = jsonObject.getJson();


        if(Str.startsWith("<splitPoint>") && Str.endsWith("<splitPoint>") ||
                (Str.startsWith("\n") && Str.endsWith("<splitPoint>")) ||
                (Str.startsWith("<splitPoint>") && Str.endsWith("\n"))){
            return "missing args";
        }


        if(Str.startsWith("<splitPoint>\n")){
            Str = "\n" + Str;
        }

        if(Str.endsWith("<splitPoint>")){
            Str = Str + "\n";
        }



        String[] StrTable = Str.split("\n<splitPoint>\n");

        if (StrTable.length == 1){
            String[] newStrTable = {StrTable[0],""};
            StrTable = newStrTable;
        }


        if (StrTable.length > 2) return "error, wrong arguments";

        DiffRowGenerator generator = DiffRowGenerator.create()
                .showInlineDiffs(true)
                .inlineDiffByWord(true)
                .oldTag(f -> " <dif> ")
                .newTag(f -> " <dif> ")
                .build();

        List<DiffRow> rows = generator.generateDiffRows(
                Arrays.asList(StrTable[0]),
                Arrays.asList(StrTable[1]));

        Vector<String> VString = new Vector<String>();
        StringBuilder endString = new StringBuilder();
        for (DiffRow row : rows) {
            VString.add( row.getOldLine());
        }
        VString.add("\n<splitPoint>\n");
        for (DiffRow row : rows) {
            VString.add( row.getNewLine());
        }
        for (String str : VString){
            endString.append(str);
        }
        return endString.toString();
    }
}
