package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.JSONObject;
import pl.put.poznan.transformer.logic.JsonTransformer;

import java.util.Arrays;


@RestController
@RequestMapping("/api")
public class JsonToolsController {

    private static final Logger logger = LoggerFactory.getLogger(JsonToolsController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String get(@RequestParam String json,
                              @RequestParam String[] transforms) {

        // log the parameters
        logger.debug(json);
        logger.debug(Arrays.toString(transforms));

        JsonTransformer jsonTransformer = new JsonTransformer(transforms);
        json = jsonTransformer.transform(new JSONObject(json));

        return json;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String post(@RequestBody String json,
                      @RequestParam String[] transforms) {

        // log the parameters
        logger.debug(json);
        logger.debug(Arrays.toString(transforms));

        JsonTransformer jsonTransformer = new JsonTransformer(transforms);
        json = jsonTransformer.transform(new JSONObject(json));

        return json;
    }




}


