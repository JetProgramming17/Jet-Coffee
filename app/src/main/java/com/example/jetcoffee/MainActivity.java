package com.example.jetcoffee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        NavigationView.OnNavigationItemSelectedListener
{

    private ImageView prime;
    private ImageView drpepper;
    private ImageView cucumber;
    private ImageView arizona;
    private ImageView barr;
    private ImageView fanta;
    private ImageView lemonsoda;
    private Orders order;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggleOnOff;
    private NavigationView navigationView;

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.prime:
                order.setProductName("PRIME HIDRATION");
                break;
            case R.id.drpepper:
                order.setProductName("DR PEPPER");
                break;
            case R.id.cucumber:
                order.setProductName("CALYPSO CUCUMBER LEMONADE");
                break;
            case R.id.arizona:
                order.setProductName("Arizona Fruit Punch");
                break;
            case R.id.barr:
                order.setProductName("Barr Bubble Gum");
                break;
            case R.id.fanta:
                order.setProductName("Fanta Berry");
                break;
            case R.id.lemon:
                order.setProductName("Warheads Sour lemon soda");
                break;
        }
        Toast.makeText(this, "MMM " +
                order.getProductName(), Toast.LENGTH_SHORT).show();
        IntentHelper.openIntent(this,
                order.getProductName(), orderDetails.class);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.nav_main:
                IntentHelper.openIntent(this,"", Tracker.class);
                break;
            case R.id.nav_home:
                IntentHelper.openIntent(this,"", MainActivity.class);
                break;
            case R.id.nav_camera:
                IntentHelper.openIntent(this,"", camera.class);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_with_nav_drawer);

        toolbar =findViewById(R.id.nav_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerLayout = findViewById(R.id.drawer_layout);
        toggleOnOff = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggleOnOff);
        toggleOnOff.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);

        order = new Orders();
        prime = findViewById(R.id.prime);
        drpepper = findViewById(R.id.drpepper);
        cucumber = findViewById(R.id.cucumber);
        arizona = findViewById(R.id.arizona);
        barr = findViewById(R.id.barr);
        fanta = findViewById(R.id.fanta);
        lemonsoda = findViewById(R.id.lemon);

        prime.setOnClickListener(this);
        drpepper.setOnClickListener(this);
        cucumber.setOnClickListener(this);
        arizona.setOnClickListener(this);
        barr.setOnClickListener(this);
        fanta.setOnClickListener(this);
        lemonsoda.setOnClickListener(this);

    }
    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else{
            super.onBackPressed();
        }
    }
}
