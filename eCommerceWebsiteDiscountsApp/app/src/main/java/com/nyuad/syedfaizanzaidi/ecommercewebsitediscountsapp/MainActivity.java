package com.nyuad.syedfaizanzaidi.ecommercewebsitediscountsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import eCommerceWebsiteDiscounts.Affiliate;
import eCommerceWebsiteDiscounts.Bill;
import eCommerceWebsiteDiscounts.Customer;
import eCommerceWebsiteDiscounts.Employee;
import eCommerceWebsiteDiscounts.RegularCustomer;


public class MainActivity extends AppCompatActivity {

    /*
        Variables used in this class
     */
    private Spinner customerDropdown;
    private Button btnCalculate, btnRefresh;
    private TextView displayDiscount, displayBill;
    private EditText totalBill, groceryBill;
    private String customerSelected, discount, finalBill;
    private Customer customer;
    private Bill bill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //User Input on the app
        customerDropdown = findViewById(R.id.customer_types);
        totalBill = findViewById(R.id.total_bill);
        groceryBill = findViewById(R.id.grocery_discount);

        // Button to calculate discount and bill
        btnCalculate = findViewById(R.id.calculate_btn);

        //Text views to display the final bill
        displayDiscount = findViewById(R.id.discount_availed);
        displayBill = findViewById(R.id.payable_bill);

        // Button to Refresh page
        btnRefresh = findViewById(R.id.refresh_btn);


        getCustomer(); // gets customer selected from dropdown spinner

        // Click button to calculate the discount and bill
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInformation();

            }
        });

        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());
            }
        });


    }

    // The activity that triggers the calculation of the bill
    public void getInformation(){

        //Creates Customer object, depending on customer type selected
        switch (customerSelected){
            case ("Employee"):
                customer = new Employee();
                break;
            case("Affiliate"):
                customer = new Affiliate();
                break;
            case ("Regular"):
                customer = new RegularCustomer();
                break;
            default:
                customer = new Customer();
        }

        //If there is no bill amount, tell user to enter an amount
        if (totalBill.getText().toString().isEmpty()){
            Toast.makeText(getBaseContext(), "Please enter bill amount", Toast.LENGTH_SHORT).show();
            return;
        }

        float f = Float.parseFloat(totalBill.getText().toString());
        float g;

        //without checking if this field is empty, we get an error
        if (groceryBill.getText().toString().isEmpty()) {
                g = 0;
        } else {
            g = Float.valueOf(groceryBill.getText().toString());
        }

        //grocery bill cannot be greater than total bill
        if (f<g){
            Toast.makeText(getBaseContext(), "Total bill cannot be less than groceries", Toast.LENGTH_SHORT).show();
            return;
        }

        Log.i("message", String.valueOf(g));

        //create a bill object, for that particular customer
        bill = new Bill(customer,  f, g);

        /*
            Show the final payable bill and the discount availed by the customer
         */

        discount = String.valueOf(bill.totalDiscount());
        double d = Math.round((f-bill.totalDiscount())*100.0)/100.0; // to round off to two decimal points
        finalBill = String.valueOf(d);
        displayBill.setText(finalBill);
        displayDiscount.setText(discount);


    }

    /*
        Get the customer selected by the user from the spinner and set global variable to it
     */
    public void getCustomer() {

        customerDropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                customerSelected = String.valueOf(customerDropdown.getSelectedItem());
                Log.i("msg",customerSelected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
