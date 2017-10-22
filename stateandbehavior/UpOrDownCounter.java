package stateandbehavior;

public class UpOrDownCounter {
	
	private int start;
	private int end;
	
	public UpOrDownCounter(int start, int end) {	
		checkValues(start, end);
		this.start = start;
		this.end = end;
		
	}
	
	
	public void checkValues(int start, int end) throws IllegalArgumentException {
		if (start == end) {
			throw new IllegalArgumentException("The start- and end-value cannot be the same");
		}
	}
	
	public int getCounter() {
		return start;
		
	}
	
	public boolean count() {
		if (start < end) {
			start ++;
			if (start == end){
				return false;
			}
			return true;
			
		}else if (start > end) {
			start --;
			if (start == end) {
				return false;
			}
			return true;
		}
	
		return false;

}
	
}
