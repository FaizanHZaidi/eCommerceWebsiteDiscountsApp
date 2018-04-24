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

        //User Input
        customerDropdown = findViewById(R.id.customer_types);
        totalBill = findViewById(R.id.total_bill);
        groceryBill = findViewById(R.id.grocery_discount);

        // Button to calculate discount and bill
        btnCalculate = findViewById(R.id.calculate_btn);

        //To display
        displayDiscount = findViewById(R.id.discount_availed);
        displayBill = findViewById(R.id.payable_bill);

        // Refresh page
        btnRefresh = findViewById(R.id.refresh_btn);


        getCustomer(); // gets customer selected

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

    public void getInformation(){

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

        if (totalBill.getText().toString().isEmpty()){
            Toast.makeText(getBaseContext(), "Please enter bill amount", Toast.LENGTH_SHORT).show();
            return;
        }

        float f = Float.parseFloat(totalBill.getText().toString());
        float g;


        if (groceryBill.getText().toString().isEmpty()) {
                g = 0;
        } else {
            g = Float.valueOf(groceryBill.getText().toString());
        }

        if (f<g){
            Toast.makeText(getBaseContext(), "Total bill cannot be less than groceries", Toast.LENGTH_SHORT).show();
            return;
        }

        Log.i("message", String.valueOf(g));


        bill = new Bill(customer,  f, g);

        discount = String.valueOf(bill.totalDiscount());
        finalBill = String.valueOf(f - bill.totalDiscount());
        displayBill.setText(finalBill);
        displayDiscount.setText(discount);


    }

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
