package patterns.delegation.office;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BinaryOperator;

public class Manager implements Employee{
	
	private List<Employee> employees;
	int turn;
	int taskCount;
	
	public Manager(Collection<Employee> employees) {
		if (employees.isEmpty()) {
			throw new IllegalArgumentException("Ingen ansatte i lista.");
		}
		this.employees = new ArrayList<>();
		for (Employee emp : employees) {
			this.employees.add(emp);
		}
		turn = 0;
		taskCount = 0;
	}
	
	public void checkTurn() {
		if (turn == this.employees.size() - 1) {
			turn = 0;
		}
		else {
			turn++;
		}
	}

	@Override
	public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
		checkTurn();
		Employee emp = this.employees.get(turn);
		taskCount++;
		return emp.doCalculations(operation, value1, value2);
	}

	@Override
	public void printDocument(String document) {
		checkTurn();
		Employee emp = this.employees.get(turn);
		taskCount++;
		emp.printDocument(document);
		
	}

	@Override
	public int getTaskCount() {
		return taskCount;
	}

	@Override
	public int getResourceCount() {
		int count = 0;
		for (Employee emp : employees) {
			count += emp.getResourceCount();
		}
		return count + 1;
	}
}
