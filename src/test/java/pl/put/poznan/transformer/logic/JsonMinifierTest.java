package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JsonMinifierTest {

    @Test
    void getJson() {
        JSONObject jsonObject = mock(JSONObject.class);
        when(jsonObject.getJson()).thenReturn("{    \"sample\":  \"json\" \n \"sample\":  \"json\" }");

        JsonMinifier jsonMinifier = new JsonMinifier(jsonObject);
        assertEquals(jsonMinifier.getJson(), "{\"sample\":\"json\"\"sample\":\"json\"}");
    }
}