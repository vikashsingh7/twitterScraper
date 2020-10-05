package personal.projects.twitterProj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.projects.twitterProj.dao.TweetRepository;
import personal.projects.twitterProj.dao.UserRepository;
import personal.projects.twitterProj.entity.Tweets;
import personal.projects.twitterProj.entity.User;

import java.util.List;

@Service
public class SaveTweetsService {

    @Autowired
    TweetRepository tweetRepository;
    @Autowired
    UserRepository userRepository;

    public String saveTweets(List<Tweets> listOfTweets){
        try{
            tweetRepository.saveAll(listOfTweets);
        }
        catch (Exception e){
            System.out.println(e);
            return IConstants.SAVE_ERROR;
        }
        return IConstants.SAVE_SUCCESS;
    }

    public String saveTweetsAndUser(List<Tweets> tweets, User user){
        try{
            saveTweets(tweets);
            userRepository.save(user);
        }
        catch (Exception e){
            System.out.println(e);
            return IConstants.SAVE_ERROR;
        }
        return IConstants.SAVE_SUCCESS;
    }
}
