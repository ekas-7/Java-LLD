package vehicles;

public class Car{
	// Attributes
	String manufacturer;
	String model;
	int year;
	
	//Constructor
	public Car(String manufacturer , String model , int year){
		this.manufacturer = manufacturer;
		this.model = model ;
		this.year = year;
	}

	//Methods
	public void startEngine(){
		System.out.println("The " + year + " " + manufacturer + " " + model + " 's engine started" );
	}

}
