package encapsulation;
import java.util.Date;


public class Person {
	
	private String fullName;
	private String mailAdress;
	private Date birthDate;
	private char gender;
	private String SSN;
	
	
	
	public void checkName(String fullName) {
		int pos = fullName.indexOf(" ");
		if  (pos == -1) {
			throw new IllegalArgumentException("Enter name again.");
		}
		
		String firstName = fullName.substring(0, pos);
		String lastName = fullName.substring(pos + 1, fullName.length());
		
		String firstName_upper = firstName.toUpperCase();
		String lastName_upper = lastName.toUpperCase();
		System.out.println(firstName_upper);
		System.out.println(lastName_upper);
		
		if  ((firstName.length() < 2) || (lastName.length() < 2)) {
			throw new IllegalArgumentException("FirstName and LastName must contain more than 2 characters.");
		}
		
		
		else if ((firstName_upper.matches("[A-Z]+") == false) || (lastName_upper.matches("[A-Z]+") == false)) {
			throw new IllegalArgumentException("Name can only contain letters.");
		}
				
	}
	
	String[] countryCodes = {"ad", "ae", "af", "ag", "ai", "al", "am", "ao", "aq", "ar", "as", "at", "au", "aw", "ax", "az", "ba", "bb", "bd",
            "be", "bf", "bg", "bh", "bi", "bj", "bl", "bm", "bn", "bo", "bq", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc",
            "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cr", "cu", "cv", "cw", "cx", "cy", "cz", "de", "dj", "dk",
            "dm", "do", "dz", "ec", "ee", "eg", "eh", "er", "es", "et", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge",
            "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht",
            "hu", "id", "ie", "il", "im", "in", "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km",
            "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc", "md",
            "me", "mf", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz",
            "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa", "pe", "pf", "pg", "ph", "pk", "pl",
            "pm", "pn", "pr", "ps", "pt", "pw", "py", "qa", "re", "ro", "rs", "ru", "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh",
            "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "ss", "st", "sv", "sx", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj",
            "tk", "tl", "tm", "tn", "to", "tr", "tt", "tv", "tw", "tz", "ua", "ug", "um", "us", "uy", "uz", "va", "vc", "ve", "vg",
            "vi", "vn", "vu", "wf", "ws", "ye", "yt", "za", "zm", "zw"};
	
	public void checkMail(String mailAdress) {
		if ((!mailAdress.contains("@") || !mailAdress.contains(".")) && (!mailAdress.equals(0))) {
			throw new IllegalArgumentException("Email must contain '@' and '.'");
		}
		
		else if (!mailAdress.equals(mailAdress.toLowerCase())) {
			throw new IllegalArgumentException("Email must only have lowercase letters.");
		}
		
		int b = 0;
		for (int i = 0; i < mailAdress.length(); i++) {
			char k = mailAdress.charAt(i);
			if (k == '.') {
				b++;
			}
		}
		
		if (b != 2) {
			throw new IllegalArgumentException("Email must contain excactly two '.'");
		
		}
		
		String code = mailAdress.substring(mailAdress.length()-2, mailAdress.length());
		int c = 0;
		for (int j = 0; j < countryCodes.length; j++) {
			String a = countryCodes[j];
			if (a.equals(code)) {
				c++;
			}
		}
			
		if (c != 1) {
			throw new IllegalArgumentException("mailAdress must end with valid contryCode.");
			}
				
		}
		

			
	public void checkGender(char gender) {
		if ((gender != 'M') && (gender != 'F') && (gender != 0 )) {
			throw new IllegalArgumentException("Gender must be eighter 'M', 'F' or '0'.");
		}
	}
	
	
	public void setName(String fullName) {
		checkName(fullName);
		this.fullName = fullName;
	}
	
	public void setEmail(String email) {
		checkMail(email);
		this.mailAdress = email;
	}
	
	public void setBirthday(Date birthday) {
		Date today = new Date();
		if (birthday.after(today)) {
			throw new IllegalArgumentException("Must be born before today!");
		}
		this.birthDate = birthday;
	}
	
	public void setGender(char gender) {
		checkGender(gender);
		this.gender = gender;
	}
	
	public void setSSN(String SSN) {
		this.SSN = SSN;
	}
	
	public String getName() {
		return fullName;
	}

	public String getEmail() {
		return mailAdress;
	}
	public Date getBirthday() {
		return birthDate;
	}
	public char getGender() {
		return gender;
	}
	public String getSSN() {
		return SSN;
	}
	

}
