package patterns.observable;

import java.util.Collections;
import java.util.List;

public class ObservableHighscoreList extends ObservableList {
	
	private int maxSize;
	
	public ObservableHighscoreList(int maxSize) {
		super();
		this.maxSize = maxSize;
		
	}

	@Override
	public boolean acceptsElement(Object o) {
		return (o instanceof Integer);
	}
	
	public void addResult(int n) {
		results.add(n);
		if (acceptsElement(n) && results.size() > 1) {
			Collections.sort(results, new IntegerComparator());
		}
		
		if (results.size() > maxSize){
			results.remove(maxSize);
		}
		if (results.contains(n)) {
			notifyListeners(results.lastIndexOf(n));
		}

	}
		

//	public void addResult(int n) {
//		if (results.isEmpty()) {
//			results.add(n);
//			notifyListeners(0);
//		}
//		
//		else if (n < (Integer) results.get(0)) {
//			results.add(0, n);
//			notifyListeners(0);
//			if (results.size() > maxSize) {
//				results.remove(maxSize);
//			}
//		}
//		
//		else if (results.size() < maxSize && n >= (Integer) results.get(results.size() - 1)) {
//			results.add(results.size(), n);
//			notifyListeners(results.size() - 1);
//		}
//		
//		else {
//			int k = results.size() - 2;
//			for (int i = results.size() - 1; i > 0; i--) {
//				if (n == (Integer) results.get(i)) {
//					results.add(i + 1, n);
//					notifyListeners(i + 1);
//					if (results.size() > maxSize) {
//						results.remove(maxSize);
//					}
//					break;
//				}
//
//				else if (n < (Integer) results.get(i) && n >= (Integer) results.get(k)) {
//					results.add(i, n);
//					notifyListeners(i);
//					if (results.size() > maxSize) {
//						results.remove(maxSize);
//					}
//					break;
//				}
//				k--;
//			}
//		}
//	}
	
	
	
	

	
}
