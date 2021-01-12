package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class JsonWhitelistFilterTest {

    @Test
    void getJson() {
        JSONObject jsonObject = mock(JSONObject.class);
        when(jsonObject.getJson()).thenReturn("{\"title\":\"exampleglossary\",\"GlossDiv\":{\"title\":\"S\",\"GlossList\":\"XD\"},\"titles\":\"some dub titles\"}");

        JsonWhitelistFilter filter = new JsonWhitelistFilter(jsonObject,"title.titles");
        assertEquals("{\"titles\":\"some dub titles\",\"title\":\"exampleglossary\"}", filter.getJson());
    }
}