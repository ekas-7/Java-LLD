// Association is a relationship

class Teacher{
	String  name;
	Teacher(String name){
		this.name = name ;
	}
	
	void teach(Student s){
		System.out.println(this.name + " is teaches "+ s.name);
	}
}
class Student{
	String name;
	Student(String name){
		this.name = name;
	}
	void attendClasses(){
		System.out.println(this.name + "attending class");
	}
}

public class Association{
	public static void main(String[] args){
		Teacher t1 = new Teacher("Ceri");
		Student s1 = new Student("Bald");

		s1.attendClasses();
		t1.teach(s1);
	}
}
