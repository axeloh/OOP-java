package patterns.delegation.office;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Printer {
	
	private HashMap<Employee, List<String>> printHistory = new HashMap<>();
	
	public void printDocument(String document, Employee employee) {
		if (printHistory.containsKey(employee)) {
			printHistory.get(employee).add(document);
		}
		else if (!printHistory.containsKey(employee)) {
			List<String> a = new ArrayList<>();
			a.add(document);
			printHistory.put(employee, a);
		}
		System.out.println(document);
	}
	
	public List<String> getPrintHistory(Employee employee) {
		if(printHistory == null){
			throw new NullPointerException("Nej");
		}
		if (!printHistory.containsKey(employee)) {
			List<String> a = new ArrayList<>();
			return a;
		}
		return printHistory.get(employee);
	}
	
	public void printAllHistory() {
		for (Employee empl : printHistory.keySet()) {
			System.out.println(empl.toString() + printHistory.get(empl));
		}
	}
	
	public static void main(String[] args) {
		Printer printer = new Printer();
		Clerk c1 = new Clerk(printer);
		c1.printDocument("heihei");
		c1.printDocument("hallo");
		c1.printDocument("skjer?");
		printer.printAllHistory();
	}

}
