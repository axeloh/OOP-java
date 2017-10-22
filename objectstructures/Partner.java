package objectstructures;

public class Partner {
	
	private String name;
	private Partner partner;
	
	public Partner(String name) {
		this.name = name;
		partner = null;	
	}
	
	public String getName() {
		return name;
	}
	
	public Partner getPartner() {
		return partner;
	}
	
	public void setPartner(Partner partner) {
		if (partner != null) {
			if (this.partner != null) {
				getPartner().setPartner(null);
				
			}
			this.partner = partner;
			if (partner.getPartner() != this) {
				partner.setPartner(this);
			}
		}
		else {
			getPartner().partner = null;
			this.partner = null;
		}
	}
	
	public String toString() {
		if (partner != null) {
		return partner.getName() + " er " + name + " sin partner."; 
		}
		return name + " har ingen partner.";
	}
	
	public static void main(String[] args) {
		Partner person1 = new Partner("Axel");
		Partner person2 = new Partner("Henrik");
		Partner person3 = new Partner("Simen");
		Partner person4 = new Partner("Martin");
		person1.setPartner(person2);
		System.out.println(person1);
		System.out.println(person2);
		System.out.println(person3);
		person3.setPartner(person1);
		System.out.println(person1);
		System.out.println(person2);
		System.out.println(person3);
		person1.setPartner(null);
		System.out.println(person1);
		System.out.println(person2);
		System.out.println(person3);
		person1.setPartner(person2);
		person3.setPartner(person4);
		System.out.println(person1);
		System.out.println(person2);
		System.out.println(person3);
		System.out.println(person4);
		person1.setPartner(person3);
		System.out.println(person1);
		System.out.println(person2);
		System.out.println(person3);
		System.out.println(person4);
		
		
		
	}
	
	
	
	
	

}
