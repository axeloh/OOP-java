package interfaces.twitter;


public class Tweet {
	
	private String tweet;
	private TwitterAccount account;
	private Tweet originalTweet;
	private boolean isRetweet;
	private int retweetCount = 0;
	
	
	public Tweet(TwitterAccount account, String tweet) {
		this.tweet = tweet;
		this.account = account;
		isRetweet = false;
	}
	
	public Tweet(TwitterAccount account, Tweet retweet) {
		if (retweet.account == account) {
			throw new RuntimeException("Your own tweet is not a retweet!");
		}
		originalTweet = retweet;
		this.account = account;
		retweet.retweetCount ++;
		isRetweet = true;
		tweet = retweet.tweet;
		
	}
	
	public String getText() {
		return tweet;
	}
	
	public TwitterAccount getOwner() {
		return account;
	}
	
	public Tweet getOriginalTweet() {
		if (isRetweet) {
			return originalTweet;
		}
		return null;
	}
	
	public int getRetweetCount() {
		return retweetCount;
	}
	
	

}
