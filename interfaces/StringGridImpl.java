package interfaces;

import java.util.ArrayList;
import java.util.Iterator;

public class StringGridImpl implements StringGrid {
	
	private int rows;
	private int columnCount;
	private ArrayList<ArrayList<String>> sg;
	
	public StringGridImpl(int rows, int columnCount) {
		this.rows = rows;
		this.columnCount = columnCount;
		sg = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < rows; i++) {
			ArrayList<String> row = new ArrayList<>();
			for (int j = 0; j < columnCount; j++) {
				row.add("");
			}
			sg.add(row);
		}
		
	}
	@Override
	public int getRowCount() {
		return rows;
	}

	@Override
	public int getColumnCount() {
		return columnCount;
	}

	@Override
	public String getElement(int row, int column) {
		if (row < 0 || row > rows || column < 0 || column > columnCount) {
			throw new IllegalArgumentException("Enter legal values for row and column");
		}
		ArrayList<String> rad = sg.get(row);
		return rad.get(column);
	}

	@Override
	public void setElement(int row, int column, String element) {
		if (row < 0 || row > rows || column < 0 || column > columnCount) {
			throw new IllegalArgumentException("Enter legal values for row and column");
		}
		sg.get(row).set(column, element);
	}
	
	@Override
	public Iterator<String> iterator() {
		return new StringGridIterator(this, true);
	}
	
	
	
	

}
