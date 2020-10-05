package personal.projects.twitterProj.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

@Service
public class ConnectionEntity {

    @Value("${twitter.bearerToken}")
    private String accessToken;

//    @Autowired
//    private Environment env;

//    Returns a connection entity to be used in Rest Template
    public HttpEntity<String> getConnectionEntity(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<String> entity = new HttpEntity<>("body", headers);
        return entity;
    }

}
