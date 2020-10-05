package personal.projects.twitterProj.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import personal.projects.twitterProj.entity.Tweets;

import java.util.HashMap;
import java.util.List;

@Service
public class ReturnEntity {

    @Autowired
    ObjectMapper mapper;

    public JsonArray userTimelineTweets(List<Tweets> tweetsList){
        JsonArray newJsonArray = new JsonArray();
        int count = 0;
        for(int i=0;i<tweetsList.size();i++){
            Tweets tweet = new Tweets();
            tweet = tweetsList.get(i);
            HashMap<String, String> map = new HashMap<>();
            JsonObject newJsonObject =  new JsonObject();
            newJsonObject.addProperty("id", String.valueOf(tweet.getTweetId()));
            newJsonObject.addProperty("idStr", String.valueOf(tweet.getTweetIdStr()));
            newJsonObject.addProperty("tweetText", String.valueOf(tweet.getTweetText()));
            newJsonObject.addProperty("tweetLink", String.valueOf(tweet.getTweetLink()));
            newJsonObject.addProperty("userId", String.valueOf(tweet.getUserId()));
            newJsonObject.addProperty("userIdStr", String.valueOf(tweet.getUserIdStr()));
            newJsonObject.addProperty("createdAt", String.valueOf(tweet.getCreatedAt()));
            System.out.println(newJsonObject);
//            return new ResponseEntity<>(new Gson().toJson(newJsonObject),HttpStatus.OK);
            newJsonArray.add(newJsonObject);
        }
        return  newJsonArray;
    }
}
