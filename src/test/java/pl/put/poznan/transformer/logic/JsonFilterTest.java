package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JsonFilterTest {

    @Test
    void getJson() {
        JSONObject jsonObject = mock(JSONObject.class);
        when(jsonObject.getJson()).thenReturn("{\"title\":\"exampleglossary\",\"GlossDiv\":{\"title\":\"S\",\"GlossList\":\"XD\"}}");

        JsonFilter filter = new JsonFilter(jsonObject,"title");
        assertEquals(filter.getJson(), "{\"GlossDiv\":{\"GlossList\":\"XD\"}}");
    }
}