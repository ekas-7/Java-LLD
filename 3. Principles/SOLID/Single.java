/*
Single responsiblity 


Bread baker
Inventory manager
Supply order

*/

class Breadbaker{
	void bake(){
	 	System.out.println("Baking");
	}
}

class Inmanager {
 	void man(){
		System.out.println("managing");        
	}
}
class Order{
	void order(){
		System.out.println("order");
	}
}




class Single{
	public static  void main (String[] args){
		
		Breadbaker b1 = new Breadbaker();
		Inmanager I = new Inmanager();
		Order o = new Order();

		b1.bake();
		I.man();
		o.order();
	}
}
