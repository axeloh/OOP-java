package patterns.observable;

import java.util.ArrayList;
import java.util.List;

public abstract class ObservableList {
	
	protected List<Object> results;
	protected List<ObservableListListener> listeners;
	
	protected ObservableList() {
		results = new ArrayList<>();
		listeners = new ArrayList<>();
	}
	
	public abstract boolean acceptsElement(Object o);
	
	public int size() {
		return results.size();
	}
	
	public Object getElement(int n) {
		if (results.isEmpty() || n > results.size() || n < 0) {
			throw new IllegalArgumentException("Du har enten valgt ulovlig tall eller så er ingen resultater registrert.");
		}
		return results.get(n);
	}
	
	
	protected void addElement(int n, Object o) {
		if (!acceptsElement(o)) {
			throw new IllegalArgumentException("Feil type objekt.");
		}
		else if (n < 0 || n > size()) {
			throw new IndexOutOfBoundsException("Ulovlig indeks");
		}
		results.add(n, o);
		notifyListeners(n);
	}
	
	protected void addElement(Object o) {
		if (!acceptsElement(o)) {
			throw new IllegalArgumentException("Feil type objekt.");
		}
		results.add(o);
		notifyListeners(size()-1);
	}
	
	protected void removeElement(int n) {
		if (n < 0 || n > size()) {
			throw new IndexOutOfBoundsException("Ulovlig indeks");
		}
		results.remove(n);
		notifyListeners(n);
	}
	
	public void notifyListeners(int n) {
		for (ObservableListListener listener : listeners) {
			listener.listChanged(this, n);
		}
	}
	
	public void addObservableListListener(ObservableListListener listener) {
		listeners.add(listener);
	}
	
	public void removeHighscoreListListener(ObservableListListener listener) {
		listeners.remove(listener);
	}
	
	
	
	
	

}
