package interfaces;
import java.util.Comparator;

public class NamedComparator implements Comparator<Named> {
	
	@Override
	public int compare(Named o1, Named o2) {
		String f1 = o1.getGivenName();
		String f2 = o2.getGivenName();
		String l1 = o1.getFamilyName();
		String l2 = o2.getFamilyName();
		
		if(l1.equals(l2)){
			return f1.compareTo(f2);
		}
		return l1.compareTo(l2);
	}
	
	public static void main(String[] args) {
		Person1 axel = new Person1("Axel", "Harstad");
		Person1 eirik = new Person1("Eirik", "Dahlen");
		Person2 william = new Person2("William Kvaale");
		NamedComparator sjekk = new NamedComparator();
		int a = sjekk.compare(axel, william);
		System.out.println(a);
		int b = sjekk.compare(axel, eirik);
		System.out.println(b);
		System.out.println(sjekk.compare(eirik, william));
	}

}
