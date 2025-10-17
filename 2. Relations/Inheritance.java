//PARENT CLASS
class Animal{
	void eat(){
		System.out.println("Animal is Eating");
	}

}

//CHILD CLASS 
class dog extends Animal{
	void bark(){
		System.out.println("Dog is Barking");
	}
}

public class Inheritance{
	public static void main(String[] arrgs){
		
		dog d1 = new dog();
		d1.eat();   // PARENT CLASS bheviour
		d1.bark(); // CHILD CLASS bheviour 
	}
}
