package patterns.delegation.office;
import java.util.function.BinaryOperator;


public class Clerk implements Employee{
	
	private Printer printer;
	private int taskCount;
	
	public Clerk(Printer printer) {
		this.printer = printer;
		taskCount = 0;
	}

	@Override
	public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
		taskCount++;
		return operation.apply(value1, value2);
	}

	@Override
	public void printDocument(String document) {
		printer.printDocument(document, this);
		taskCount++;
	}

	@Override
	public int getTaskCount() {
		return taskCount;
	}

	@Override
	public int getResourceCount() {
		return 1;
	}
	
	public String toString() {
		return "Clerk ";
	}

}
