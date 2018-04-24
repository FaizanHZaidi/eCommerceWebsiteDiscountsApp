package eCommerceWebsiteDiscounts;// package impl;


/*
*   This class calculates the total discount for a particular
*   customer and sends it to the main class i.e. BillTest
*/
public class Bill {

	private Customer customer;
	private float bill;
    private float groceries;
	
	public Bill(Customer customer, float bill, float groceries) {
		// TODO Auto-generated constructor stub
		this.customer = customer;
		this.bill = bill;
        this.groceries = groceries;
	}
	
    /*
    *   Percentage discount available to a particular customer
    *   based on their association to the store
    */
    protected float customerDiscount () {
    		
    		float discount = ((this.bill-this.groceries) * customer.getDiscount());
    		
    		return discount; 
    }
    
    /*
    *   Discount available to all shoppers, except for on groceries
    */
    protected int salesDiscount() {
    		
    		int discount = (int)this.bill/100 * 5;
    		
    		return discount;
    }
    
    public float totalDiscount(){

    		float discount = this.salesDiscount() + this.customerDiscount();
    		
    		return discount;
    		
    }

}


