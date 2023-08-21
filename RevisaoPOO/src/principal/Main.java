package principal;

public class Main {
public static void main(String[] args) {
	Student maria = new Student(1, 999);
	maria.setName("Maria");
	maria.setBirthDate("11/06/2000");
	maria.setCourse("SI");
	maria.setSemester((short)4);
		
	Professor emerson = new Professor (2, "217");
	emerson.setName("Emerson");
	emerson.setLevel("Doutor");
	emerson.setLevel("Informática");
	
	At ju = new At(3, "891");
	ju.setName("Julia");
	ju.setArea("TI");
	ju.setRole("Técnica em Laboratório");
	
	
	//System.out.println(maria.toString() + "\n" + maria.formatPersonalData());
	//System.out.println(emerson.toString() + "\n" + emerson.formatPersonalData());
	//System.out.println(ju.toString() + "\n" + ju.formatPersonalData());
	
	}
	
	public static void printUserData(User user) {
		System.out.println(user.formatPersonalData());
	}
}