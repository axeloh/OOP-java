package objectstructures;
import java.util.ArrayList;

public class Person {
	
	private String name;
	private char gender;
	private Person mother;
	private Person father;
	private ArrayList<Person> children;
	
	public Person(String name, char gender) {
		if (gender != 'F' && gender != 'M') {
			throw new IllegalArgumentException("Du må være hann- eller hunnkjønn (F eller M)");
		}
		this.name = name;
		this.gender = gender;
		children = new ArrayList<>();
	}
	
	
	public String getName() {
		return name;
	}
	
	public char getGender() {
		return gender;
	}
	
	public Person getMother() {
		return mother;
	}
	
	public Person getFather() {
		return father;
	}
	
	public int getChildCount() {
		return children.size();
	}
	
	public Person getChild(int n) {
		if (n > 0 || n < children.size()) {
			return children.get(n);
		}
		throw new IllegalArgumentException("Skriv inn et gyldig tall");
	}
	
	public void addChild(Person child) {
		if (this == child) {
			throw new IllegalArgumentException("Du kan ikke være ditt eget barn.");
		}
		if (children.contains(child)) {
			throw new IllegalArgumentException(child.getName() + " står allerede oppført som ditt barn.");
		}
		children.add(child);
		if (this.getGender() == 'F') {
			if (child.mother != null) {
				child.mother.removeChild(child);
			}
			child.mother = this;
		}
		else {
			if (child.father != null) {
				child.father.removeChild(child);
			}
			child.father = this;
		}
	}
	
	public void removeChild(Person child) {
		if (child == this) {
			throw new IllegalArgumentException("Du er ikke ditt eget barn");
		}
		if (!children.contains(child)) {
			throw new IllegalArgumentException("Du har ikke dette barnet");
		}
		this.children.remove(child);
		if (this.getGender() == 'F') {
			child.mother = null;
		}
		else {
			child.father = null;
		}
	}
	
	public void setMother(Person mother) {
		if (this == mother) {
			throw new IllegalArgumentException("Du kan ikke være din egen mor."); 
		}
		if (mother.getGender() != 'F') {
			throw new IllegalArgumentException("Din mor må være hunnkjønn");
		}
		if (this.mother != null) {
			this.mother.removeChild(this);
		}
		this.mother = mother;
		mother.children.add(this);
	}
	
	public void setFather(Person father) {
		if (this == father) {
			throw new IllegalArgumentException("Du kan ikke være din egen mor."); 
		}
		if (father.getGender() != 'M') {
			throw new IllegalArgumentException("Din mor må være hunnkjønn");
		}
		if (this.father != null) {
			this.father.removeChild(this);
		}
		this.father = father;
		father.children.add(this);
	}

	
	public String toString() {
		if (mother == null && father != null) {
			return getName() + " har " + children.size() + " barn, og har ingen mor. Faren er " + father.getName();
		}
		if (father == null && mother != null) {
			return getName() + " har " + children.size() + " barn, og har ingen far. Moren er " + mother.getName();
		}
		if (father == null && mother == null) {
			return getName() + " har " + children.size() + " barn, og har ingen foreldre.";
		}
		
		return getName() + " har " + children.size() + " barn. Moren er: " + mother.getName() + ". Og faren er: " + father.getName() + "\n";
	}
	
	public static void main(String[] args) {
		Person axel = new Person("Axel", 'M');
		Person selma = new Person("Selma", 'F');
		Person stein = new Person("Stein", 'M');
		Person cecilia = new Person("Cecilia", 'F');
		Person gunnel = new Person("Gunnel", 'F');
		Person helge = new Person("Helge", 'M');
		Person bodil = new Person("Bodil", 'F');
		axel.setFather(stein);
		axel.setMother(cecilia);
		cecilia.addChild(selma);
		stein.addChild(selma);
		gunnel.addChild(cecilia);
		cecilia.setFather(helge);
		bodil.addChild(stein);
		System.out.println(axel);
		System.out.println(selma);
		System.out.println(stein);
		System.out.println(cecilia);
		System.out.println(gunnel);
		System.out.println(helge);
		
	}
	
	

}
