package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JsonFilterTest {

    @Test
    void getJson() {
        JSONObject jsonObject = mock(JSONObject.class);
        when(jsonObject.getJson()).thenReturn("{\"title\":\"exampleglossary\",\"GlossDiv\":{\"title\":\"S\",\"GlossList\":{\"GlossEntry\":{\"ID\":\"SGML\",\"SortAs\":\"SGML\",\"GlossTerm\":\"StandardGeneralizedMarkupLanguage\",\"Acronym\":\"SGML\",\"Abbrev\":\"ISO8879:1986\",\"GlossDef\":{\"para\":\"Ameta-markuplanguage,usedtocreatemarkuplanguagessuchasDocBook.\",\"GlossSeeAlso\":[\"GML\",\"XML\"]},\"GlossSee\":\"markup\"}}}}");
        JsonFilter filter = new JsonFilter(jsonObject,"excludeGlossList");
        jsonObject = new JSONObject(filter.getJson());
        JsonMinifier jsonMinifier = new JsonMinifier(jsonObject);
        assertEquals(jsonMinifier.getJson(), "{\"title\":\"exampleglossary\",\"GlossDiv\":{\"title\":\"S\"}}");
    }
}