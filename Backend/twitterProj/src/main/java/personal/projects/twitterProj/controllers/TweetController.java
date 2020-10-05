package personal.projects.twitterProj.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import personal.projects.twitterProj.entity.Tweets;
import personal.projects.twitterProj.service.ConnectionEntity;
import personal.projects.twitterProj.service.ReturnEntity;
import personal.projects.twitterProj.service.SaveTweetsService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/tweets")
public class TweetController {

    @Autowired
    ConnectionEntity connectionEntity;
    @Autowired
    SaveTweetsService saveTweetsService;
    @Autowired
    ReturnEntity returnEntity;

    RestTemplate restTemplate = new RestTemplate();

    @RequestMapping(value="/fromUser:{userName}",method = RequestMethod.GET)
    public ResponseEntity<?> tweetFromUser(@PathVariable("userName") String userName){

        String URI = "https://api.twitter.com/1.1/search/tweets.json?q=from%3A"+userName+"&result_type=popular";
        ResponseEntity<String> res = restTemplate.exchange(URI, HttpMethod.GET, connectionEntity.getConnectionEntity(), String.class);

        String returnedBody = res.getBody();
        JsonObject jobject = null;
        JsonElement  jelement = null;

        JsonParser jsonParser = new JsonParser();
        String result = null;
        try {
            jelement = new JsonParser().parse(returnedBody);
            jobject = jelement.getAsJsonObject();
            JsonArray jarray = jobject.getAsJsonArray("statuses");
            List<Tweets> tweetsList = new ArrayList<>();
//            Loop through statuses to find exact Text element
            for (int i=0;i<jarray.size();i++) {
                jobject = jarray.get(i).getAsJsonObject();
                result = jobject.get("text").getAsString();
                long tweetId =jobject.get("id").getAsLong();
                Tweets tweets = new Tweets();
                tweets.setTweetId(tweetId);
                tweets.setCreatedAt(jobject.get("created_at").getAsString().trim());
                tweets.setTweetIdStr(jobject.get("id_str").getAsString());
                tweets.setTweetText(result.trim());
                jobject = jobject.get("user").getAsJsonObject();
                tweets.setUserIdStr(jobject.get("id_str").getAsString());
                tweetsList.add(tweets);
            }
            System.out.println(saveTweetsService.saveTweets(tweetsList));
            jelement = jsonParser.parse(res.getBody());
            jobject = jelement.getAsJsonObject();

        }
        catch (Exception e){
            System.out.println(e);
        }
        return new ResponseEntity<>(jobject, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/userTimelines:{userName}", method = RequestMethod.POST)
    public ResponseEntity<?> userRetweets(@PathVariable("userName") String userName){

        int retrieveTweetCount = 20;
        String URI = "https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name="+userName+"&count="+retrieveTweetCount+"&exclude_replies=true";
        ResponseEntity<String> res = restTemplate.exchange(URI, HttpMethod.GET, connectionEntity.getConnectionEntity(), String.class);
        String returnedBody = res.getBody();
        JsonObject jsonObject = null;
        JsonElement  jsonElement = null;
        JsonArray jsonArray = null;
        List<Tweets> listOfTweets = new ArrayList<>();

        try{
            jsonElement = new JsonParser().parse(returnedBody);
            jsonArray = jsonElement.getAsJsonArray();
            for(int i=0;i<jsonArray.size();i++){
                Tweets tweets = new Tweets();
                jsonObject = jsonArray.get(i).getAsJsonObject();
                tweets.setTweetText(jsonObject.get("text").getAsString());
                tweets.setTweetId(jsonObject.get("id").getAsLong());
                tweets.setTweetIdStr(jsonObject.get("id_str").getAsString());
                tweets.setCreatedAt(jsonObject.get("created_at").getAsString());
                jsonObject = jsonObject.get("user").getAsJsonObject();
                tweets.setUserId(jsonObject.get("id").getAsLong());
                tweets.setUserIdStr(jsonObject.get("id_str").getAsString());
                listOfTweets.add(tweets);
            }
            saveTweetsService.saveTweets(listOfTweets);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return new ResponseEntity<>(returnEntity.userTimelineTweets(listOfTweets), HttpStatus.OK);
    }

    @RequestMapping(value="/hashTag:{hashTag}",method = RequestMethod.POST)
    public ResponseEntity<?> followHashTags(@PathVariable("hashTag") String hashTag){

        String URI = "https://api.twitter.com/1.1/search/tweets.json?q=%23"+hashTag;
        ResponseEntity<String> res = restTemplate.exchange(URI, HttpMethod.GET, connectionEntity.getConnectionEntity(), String.class);

        String returnedBody = res.getBody();
        JsonObject jobject = null;
        JsonElement  jelement = null;

        JsonParser jsonParser = new JsonParser();
        String result = null;
        List<Tweets> tweetsList = new ArrayList<>();
        try {
            jelement = new JsonParser().parse(returnedBody);
            jobject = jelement.getAsJsonObject();
            JsonArray jarray = jobject.getAsJsonArray("statuses");

//            Loop through statuses to find exact Text element
            for (int i=0;i<jarray.size();i++) {
                jobject = jarray.get(i).getAsJsonObject();
                result = jobject.get("text").getAsString();
                long tweetId =jobject.get("id").getAsLong();
                Tweets tweets = new Tweets();
                tweets.setTweetId(tweetId);
                tweets.setCreatedAt(jobject.get("created_at").getAsString().trim());
                tweets.setTweetIdStr(jobject.get("id_str").getAsString());
                tweets.setTweetText(result.trim());
                jobject = jobject.get("user").getAsJsonObject();
                tweets.setUserId(jobject.get("id").getAsLong());
                tweets.setUserIdStr(jobject.get("id_str").getAsString());
                tweetsList.add(tweets);
            }
            System.out.println(saveTweetsService.saveTweets(tweetsList));
            jelement = jsonParser.parse(res.getBody());
            jobject = jelement.getAsJsonObject();

        }
        catch (Exception e){
            System.out.println(e);
        }
        return new ResponseEntity<>(returnEntity.userTimelineTweets(tweetsList), HttpStatus.OK);
    }
}
