package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JsonTextDifferenceTest {

    @Test
    void getJson() {
        JSONObject jsonObject = mock(JSONObject.class);
        when(jsonObject.getJson()).thenReturn("hello what is this\n<splitPoint>\nkek what is this");

        JsonTextDifference jsonTextDifference = new JsonTextDifference(jsonObject);
        assertEquals(jsonTextDifference.getJson(), " <dif> hello <dif>  what is this\n<splitPoint>\n <dif> kek <dif>  what is this");
    }

    @Test
    void getJson2() {
        JSONObject jsonObject = mock(JSONObject.class);
        when(jsonObject.getJson()).thenReturn("hello what is this\n<splitPoint>");

        JsonTextDifference jsonTextDifference = new JsonTextDifference(jsonObject);
        assertEquals(jsonTextDifference.getJson(), " <dif> hello what is this <dif> \n<splitPoint>\n");
    }


    @Test
    void getJson3() {
        JSONObject jsonObject = mock(JSONObject.class);
        when(jsonObject.getJson()).thenReturn("<splitPoint>\nkek what is this");

        JsonTextDifference jsonTextDifference = new JsonTextDifference(jsonObject);
        assertEquals(jsonTextDifference.getJson(), "\n<splitPoint>\n <dif> kek what is this <dif> ");
    }

    @Test
    void getJson4() {
        JSONObject jsonObject = mock(JSONObject.class);
        when(jsonObject.getJson()).thenReturn("<splitPoint>");

        JsonTextDifference jsonTextDifference = new JsonTextDifference(jsonObject);
        assertEquals(jsonTextDifference.getJson(), "missing args");
    }
}