package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    int quantity=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void increment(View view) {
        if(quantity==100){
            Toast.makeText(this,"You cannot order more than 100 coffees",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity++;
        display(quantity);
    }
    public void decrement(View view) {
        if(quantity == 1){
            Toast.makeText(this,"You cannot order less than 1 coffee",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity--;
        display(quantity);
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCream = (CheckBox) findViewById(R.id.whipped_cream);
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate_checkbox);
        EditText text = (EditText) findViewById(R.id.name_field);
        String value = text.getText().toString();
        boolean hasChocolate = chocolate.isChecked();
        boolean hasWhippedCream = whippedCream.isChecked();
        int price=calculatePrice(hasWhippedCream,hasChocolate);
        String priceMessage=createOrderSummary(price,hasWhippedCream,hasChocolate,value);
        //displayMessage(priceMessage);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        intent.putExtra(Intent.EXTRA_SUBJECT,"Coffee for: "+value);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    private int calculatePrice(boolean whippedCream,boolean chocolate){
        int price=5;
        if(whippedCream){
            price=price+1;
        }
        if(chocolate){
            price+=2;
        }
        return price*quantity;
    }
    private String createOrderSummary(int price,boolean whippedCream,boolean chocolate,String text){
        String priceMessage="Name: "+text;
        priceMessage +="\nAdd whipped Cream?: "+whippedCream;
        priceMessage +="\nAdd Chocolate?: "+chocolate;
        priceMessage=priceMessage+"\nQuantity: "+quantity;
        priceMessage=priceMessage+"\nTotal :$"+price;
        priceMessage = priceMessage + "\nThank you!";
        return priceMessage;
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}