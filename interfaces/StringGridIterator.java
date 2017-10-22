package interfaces;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringGridIterator implements Iterator<String> {
	
	private StringGrid sg;
	private boolean rowMajor;
	private int posRow;
	private int posCol;
	
	StringGridIterator(StringGrid sg, boolean rowMajor) {
		this.sg = sg;
		this.rowMajor = rowMajor;
		posRow = 0;
		posCol = 0;
		
	}

	@Override
	public boolean hasNext() {
		return (posRow < sg.getRowCount() && posCol < sg.getColumnCount());
	}


	@Override
	public String next() {
		if (hasNext()) {
			String element = sg.getElement(posRow, posCol);
			if (rowMajor) {
				if (posCol == sg.getColumnCount() - 1) {
					posCol = 0;
					posRow++;
				}
				else {
					posCol++;
			}
			}
			if (!rowMajor) {
				if (posRow == sg.getRowCount() - 1) {
					posRow = 0;
					posCol++;
				}
				else {
					posRow++;
				}
			}
			return element;
		}
		throw new NoSuchElementException();
	}
	
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
	public static void main(String[] args) {
		StringGridImpl stringGrid = new StringGridImpl(5,5);
		stringGrid.setElement(0, 0, "Dette");
		stringGrid.setElement(0, 1, "...");
		stringGrid.setElement(0, 2, " er");
		stringGrid.setElement(0, 3, "...");
		stringGrid.setElement(0, 4, " en");
		stringGrid.setElement(1, 0, "...");
		stringGrid.setElement(1, 1, " skjult");
		stringGrid.setElement(1, 2, "...");
		stringGrid.setElement(1, 3, " melding.");
		StringGridIterator iterator = new StringGridIterator(stringGrid, true);
		String a = "";
		String b = "";
		for (int i = 0; i < 10; i++) {
			if (iterator.hasNext() && i % 2 == 0) {
				a += iterator.next();
			}
			else {
				b += iterator.next();
			}
		}
		System.out.println(a);
		
		
	}

}
