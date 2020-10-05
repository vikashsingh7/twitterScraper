package personal.projects.twitterProj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(value = "/testUser")
public class UserController {

    @Autowired
    private Environment env;

    @RequestMapping(value="/test",method = RequestMethod.GET)
    public void getUserTimeline(){

        RestTemplate restTemplate = new RestTemplate();
        String testProp = env.getProperty("twitter.bearerToken");
        String baseURI = env.getProperty("twitter.baseURI");
        HttpHeaders headers2 = new HttpHeaders();
        headers2.setContentType(MediaType.APPLICATION_JSON);
    }

}
