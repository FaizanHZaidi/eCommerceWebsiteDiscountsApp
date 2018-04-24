// package impl;

/*
*	A regular customer, whose been shopping for 2 yrs at least
*/

public class RegularCustomer extends Customer{

	private static final float discount = 0.05f; //discount offered to this customer
	
	@Override
	public float getDiscount() {
		// TODO Auto-generated method stub
		
		return RegularCustomer.discount;
	}
	

}
