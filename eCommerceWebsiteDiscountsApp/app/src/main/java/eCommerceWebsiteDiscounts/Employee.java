// package impl;

/*
*	Customer who is an employee as well
*/
public class Employee extends Customer{

	private static final float discount = 0.3f; //discount offered to this customer
	public Employee() {}

	@Override
	public float getDiscount() {
		// TODO Auto-generated method stub
		return Employee.discount;
	
	}

}
