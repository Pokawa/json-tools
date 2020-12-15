package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JSONObjectTest {

    @Test
    void getJson() {
        JSONObject jsonObject = new JSONObject("{ \"sample\" : \"json\" }");
        assertEquals(jsonObject.getJson(), "{ \"sample\" : \"json\" }");
    }
}