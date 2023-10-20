package com.example.jetcoffee;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class IntentHelper {
    public static void openIntent(Context context, String order, Class passTo){

        Intent i = new Intent(context, passTo);

        i.putExtra("order", order);
        context.startActivity(i);

    }
    public static void shareIntent(Context context, String productName,
                                   String customerName, String customerCell,
                                   String address){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);

        Bundle shareOrderDetails = new Bundle();
        shareOrderDetails.putString("ProductName", productName);
        shareOrderDetails.putString("CustomerName", customerName);
        shareOrderDetails.putString("CustomerCell", customerCell);
        shareOrderDetails.putString("Address", address);

        sendIntent.putExtra(Intent.EXTRA_TEXT, shareOrderDetails);
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        context.startActivity(shareIntent);
    }

    public static void shareIntent(Context context, String order) {
        Intent sendIntent = new Intent();

        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, order);

        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        context.startActivity(shareIntent);
    }
}
