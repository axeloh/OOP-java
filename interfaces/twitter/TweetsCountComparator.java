package interfaces.twitter;
import java.util.Comparator;

public class TweetsCountComparator implements Comparator<TwitterAccount> {
	
	public int compare(TwitterAccount o1, TwitterAccount o2) {
		int t1 = o1.getTweetCount();
		int t2 = o2.getTweetCount();
		
		if (t1 > t2){
			return -1;
		}
		if (t1 < t2){
			return 1;
		}
		return 0;
	}

}
