package patterns.observable;

import java.util.ArrayList;
import java.util.List;

public class HighscoreList {
	
	private int maxSize;
	private List<Integer> results;
	private List<HighscoreListListener> listeners;
	
	public HighscoreList(int maxSize) {
		this.maxSize = maxSize;
		results = new ArrayList<>();
		listeners = new ArrayList<>();
	}
	
	public int size() {
		return results.size();
	}
	
	public int getElement(int n) {
		if (results.isEmpty() || n > results.size() || n < 0) {
			throw new IllegalArgumentException("Du har enten valgt ulovlig tall eller så er ingen resultater registrert.");
		}
		return results.get(n);
	}
	
	public void addResult(int n) {
		if (results.isEmpty()) {
			results.add(n);
			notifyListeners(0);
		}
		
		else if (n < results.get(0)) {
			results.add(0, n);
			notifyListeners(0);
			if (results.size() > maxSize) {
				results.remove(maxSize);
			}
		}
		
		else if (results.size() < maxSize && n >= results.get(results.size() - 1)) {
			results.add(results.size(), n);
			notifyListeners(results.size() - 1);
		}
		
		else {
			int k = results.size() - 2;
			for (int i = results.size() - 1; i > 0; i--) {
				if (n == results.get(i)) {
					results.add(i + 1, n);
					notifyListeners(i + 1);
					if (results.size() > maxSize) {
						results.remove(maxSize);
					}
					break;
				}

				else if (n < results.get(i) && n >= results.get(k)) {
					results.add(i, n);
					notifyListeners(i);
					if (results.size() > maxSize) {
						results.remove(maxSize);
					}
					break;
				}
				k--;
			}
		}
	}
	
	public void notifyListeners(int n) {
		for (HighscoreListListener listener : listeners) {
			listener.listChanged(this, n);
		}
	}
	
	public void addHighscoreListListener(HighscoreListListener listener) {
		listeners.add(listener);
	}
	
	public void removeHighscoreListListener(HighscoreListListener listener) {
		listeners.remove(listener);
	}
	
	
	

}
