interface ProcessMethod {
	void ProcessPaymet();
}

class CreditCard implements ProcessMethod {
	public void ProcessPaymet(){
		System.out.println("Processing payemtnt using Credit card");
	}
}

class Cash implements ProcessMethod {
	public void ProcessPaymet(){
		System.out.println("Processing payemtnt using Cash");
	}
}

class Crypto implements ProcessMethod {
	public void ProcessPaymet(){
		System.out.println("Processing payemtnt using Crypto");
	}
}

class PaymentProccess{
	private ProcessMethod paymentMehod;

	PaymentProccess(ProcessMethod paymetnMethod){
		this.paymentMehod = paymetnMethod;
	}

	public void ProcessPaymet(){
		paymentMehod.ProcessPaymet();
	}

	public void setPaymentMethod(ProcessMethod paymetnMethod){
		this.paymentMehod = paymetnMethod;
	}
}

public class Stragety {
	public static void main(String[] args){
		ProcessMethod CreditCard = new CreditCard();
		ProcessMethod Cash = new Cash();
		ProcessMethod Crypto = new Crypto();

		PaymentProccess proccessPayment = new PaymentProccess(CreditCard);
        CreditCard.ProcessPaymet();

		proccessPayment.setPaymentMethod(Crypto);
		Crypto.ProcessPaymet();

		proccessPayment.setPaymentMethod(Cash);
		Cash.ProcessPaymet();

	}
}
