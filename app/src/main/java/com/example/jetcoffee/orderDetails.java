package com.example.jetcoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class orderDetails extends AppCompatActivity {

    private EditText etCustomerName;
    private EditText etCustomerCell;
    private EditText etAddress;
    private TextView placeOrder;
    private String orderedValue;
    private ImageView orderedBev;
    private FloatingActionButton fab;
    private  Orders order;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        order = new Orders();
        fab = findViewById(R.id.fab_order);
        placeOrder = findViewById(R.id.placeholder);
        etCustomerName = findViewById(R.id.name);
        etCustomerCell = findViewById(R.id.cell);
        etAddress = findViewById(R.id.address);
        orderedBev = findViewById(R.id.beverage);

        orderedValue = getIntent().getStringExtra("order");
        placeOrder.setText(orderedValue);

        fab.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentHelper.shareIntent(orderDetails.this, orderedValue);
            }
        });

        switch (orderedValue){
            case "PRIME HIDRATION":
                orderedBev.setImageResource(R.drawable.prime);
                break;
            case "DR PEPPER":
                orderedBev.setImageResource(R.drawable.drpepper);
                break;
            case "CALYPSO CUCUMBER LEMONADE":
                orderedBev.setImageResource(R.drawable.cucumber);
                break;
            case "Arizona Fruit Punch":
                orderedBev.setImageResource(R.drawable.arizona);
                break;
            case "Barr Bubble Gum":
                orderedBev.setImageResource(R.drawable.barr);
                break;
            case "Fanta Berry":
                orderedBev.setImageResource(R.drawable.fanta);
                break;
            case "Warheads Sour lemon soda":
                orderedBev.setImageResource(R.drawable.warheads);
                break;
        }

    }
}