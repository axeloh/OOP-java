package interfaces;

public interface StringGrid extends Iterable<String> {
	
	int getRowCount();
	int getColumnCount();
	String getElement(int row, int column);
	void setElement(int row, int column, String element);
}
