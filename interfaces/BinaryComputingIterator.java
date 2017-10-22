package interfaces;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.BinaryOperator;

public class BinaryComputingIterator implements BinaryOperator<Double>, Iterator<Double>   {
	
	private Double default1;
	private Double default2;
	private Iterator<Double> iterator1;
	private Iterator<Double> iterator2;
	private BinaryOperator<Double> operator;
	
	public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, 
			BinaryOperator<Double> operator) {
		this.iterator1 = iterator1;
		this.iterator2 = iterator2;
		this.operator = operator;
		default1 = null;
		default2 = null;
	}
	
	public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, 
			Double default1, Double default2, BinaryOperator<Double> operator) {
		this.iterator1 = iterator1;
		this.iterator2 = iterator2;
		this.default1 = default1;
		this.default2 = default2;
		this.operator = operator;
	}
	
	
	@Override
	public Double apply(Double t, Double u) {
		return t + u;
	}
	
	public static void main(String[] args) {
		Iterator<Double> iterator1 = Arrays.asList(2.0, 3.0).iterator();
		Iterator<Double> iterator2 = Arrays.asList(5.0).iterator();	
		BinaryComputingIterator binaryIterator = new BinaryComputingIterator(iterator1, iterator2, null, 10.0, (x, y) -> x+y);
	} 

	
	public boolean hasNext() {
		if (iterator1.hasNext() && iterator2.hasNext()) {
			return true;
		}
		if (iterator1.hasNext() && !iterator2.hasNext() && default2 != null) {
			iterator2 = Arrays.asList(default2).iterator();
			return true;
		}
		if (!iterator1.hasNext() && default1 != null && iterator2.hasNext()) {
			iterator1 = Arrays.asList(default1).iterator();
			return true;
		}
		return false;
	}

	@Override
	public Double next() {
		if (hasNext()) {
			return operator.apply(iterator1.next(), iterator2.next());
		}
		throw new NoSuchElementException();
	}


	

}
