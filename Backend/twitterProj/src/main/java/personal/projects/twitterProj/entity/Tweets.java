package personal.projects.twitterProj.entity;

import javax.persistence.*;

@Entity
@Table(name = "tweets")
public class Tweets {

    @Id
    @Column(name = "id")
    private long tweetId;

    @Column(name = "id_str")
    private String tweetIdStr;

    @Column(name = "tweet_text")
    private String tweetText;

    @Column(name = "tweet_link")
    private String tweetLink;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "user_id_str")
    private String userIdStr;

    @Column(name = "created_at")
    private String createdAt;

    public long getTweetId() {
        return tweetId;
    }

    public void setTweetId(long tweetId) {
        this.tweetId = tweetId;
    }

    public String getTweetIdStr() {
        return tweetIdStr;
    }

    public void setTweetIdStr(String tweetIdStr) {
        this.tweetIdStr = tweetIdStr;
    }

    public String getTweetText() {
        return tweetText;
    }

    public void setTweetText(String tweetText) {
        this.tweetText = tweetText;
    }

    public String getTweetLink() {
        return tweetLink;
    }

    public void setTweetLink(String tweetLink) {
        this.tweetLink = tweetLink;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserIdStr() {
        return userIdStr;
    }

    public void setUserIdStr(String userIdStr) {
        this.userIdStr = userIdStr;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
