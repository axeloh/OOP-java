package interfaces.twitter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TwitterAccount {
	
	private String username;
	private ArrayList<Tweet> tweets;
	private ArrayList<TwitterAccount> following;
	private ArrayList<TwitterAccount> followers;
	private int numberOfTweets;
	private int numberOfRetweets;
	
	public TwitterAccount(String username) {
		tweets = new ArrayList<>();
		following = new ArrayList<>();
		followers = new ArrayList<>();
		this.username = username;
		numberOfTweets = 0;
		numberOfRetweets = 0;
	}
	
	public String getUserName() {
		return username;
	}
	
	public void follow(TwitterAccount account) {
		following.add(account);
		account.followers.add(this);
	}
	
	public void unfollow(TwitterAccount account) {
		following.remove(account);
		account.followers.remove(this);
	}
	
	public boolean isFollowing(TwitterAccount account) {
		for (TwitterAccount followed_account : following) {
			if (followed_account == account) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isFollowedBy(TwitterAccount account) {
		for (TwitterAccount followed_account : followers) {
			if (followed_account == account) {
				return true;
			}
		}
		return false;
	}
	
	public void tweet(String tweet) {
		Tweet newTweet = new Tweet(this, tweet);
		tweets.add(newTweet);
		numberOfTweets++;
	}
	
	public void retweet(Tweet tweet) {
		Tweet retweet = new Tweet(this, tweet);
		tweets.add(retweet);
		numberOfRetweets++;
	}
	
	public Tweet getTweet(int i) {
		return tweets.get(tweets.size() - i);
	}
	
	public int getTweetCount() {
		return numberOfTweets;
	}
	
	public int getRetweetCount() {
		return numberOfRetweets;
	}
	
	public int getFollowerCount() {
		return followers.size();
	}
	
	public ArrayList<TwitterAccount> getFollowers(Comparator<TwitterAccount> compis){
		if (compis == null){
			return followers;
		}
		ArrayList<TwitterAccount> sortedFollowers = followers;
		Collections.sort(sortedFollowers, compis);
		return sortedFollowers;
	}
	
	
	public static void main(String[] args) {
		TwitterAccount axel = new TwitterAccount("axelharstad");
		TwitterAccount henrik = new TwitterAccount("henrikrogers");
		TwitterAccount martin = new TwitterAccount("martinfossli");
		axel.follow(henrik);
		henrik.follow(martin);
		System.out.println(henrik.isFollowedBy(axel));
		System.out.println(martin.isFollowedBy(henrik));
		axel.follow(martin);
		axel.unfollow(henrik);
		System.out.println(axel.isFollowing(henrik));
		axel.tweet("Dette er Axel sin konto.");
		axel.tweet("Ser på Tv!");
		axel.tweet("How I met your mother er bra!");
		Tweet tweet = axel.getTweet(1);
		System.out.println(tweet.getText());
		henrik.retweet(tweet);
		System.out.println(henrik.getRetweetCount());
		System.out.println(axel.getTweetCount());
		System.out.println(axel.getUserName());
		System.out.println(tweet.getOwner().getUserName());
		
	}
}


