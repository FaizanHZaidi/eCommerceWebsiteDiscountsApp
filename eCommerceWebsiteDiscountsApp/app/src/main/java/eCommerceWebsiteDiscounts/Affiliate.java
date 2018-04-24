// package impl;

/*
*	A customer who is an affiliate of the store
*/
public class Affiliate extends Customer {

	private static final float discount = 0.1f;	//discount offered to this customer
	
	@Override
	public float getDiscount() {
		// TODO Auto-generated method stub
		return Affiliate.discount;
	}

}
