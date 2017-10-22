package interfaces.twitter;
import java.util.Comparator;

public class FollowersCountComparator implements Comparator<TwitterAccount> {
	
	public int compare(TwitterAccount o1, TwitterAccount o2) {
		int f1 = o1.getFollowerCount();
		int f2 = o2.getFollowerCount();
		
		if (f1 > f2){
			return -1;
		}
		if (f1 < f2){
			return 1;
		}
		return 0;
	}

}
