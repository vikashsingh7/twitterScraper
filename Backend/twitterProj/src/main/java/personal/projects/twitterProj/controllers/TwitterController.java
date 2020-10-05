package personal.projects.twitterProj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import personal.projects.twitterProj.service.ConnectionEntity;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/getTwitter")
public class TwitterController {

    @Autowired
    ConnectionEntity connectionEntity;

    @RequestMapping(value="/getUser/{userName}",method = RequestMethod.GET)
    public ResponseEntity<?> retrieveAllUsers(@PathVariable("userName") String userName) {

        final String uri = "https://api.twitter.com/2/users/by?usernames=" + userName;
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<?> res = restTemplate.exchange(uri, HttpMethod.GET, connectionEntity.getConnectionEntity(), String.class);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
