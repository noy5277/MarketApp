package com.example.market_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PriceMenu extends AppCompatActivity {

    private Intent cartIntent;
    public static final String INPUT_PICTURE="PriceMenu.INPUT_PICTURE";
    public static final String INPUT_HAIRCUT="PriceMenu.INPUT_HAIRCUT";
    public static final String INPUT_COST="PriceMenu.INPUT_COST";
    private ArrayList<Integer> pic;
    private ArrayList<String> haircut;
    private ArrayList<Integer> cost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_menu);
        cartIntent=new Intent(this,Cart.class);
        haircut=new ArrayList<String>();
        cost=new ArrayList<Integer>();
        pic=new ArrayList<Integer>();
    }

    public void AddChildToCart(View view) {
        Toast.makeText(this, "HairCut Added to cart", Toast.LENGTH_SHORT).show();
        pic.add(R.drawable.child);
        haircut.add("Child HairCut");
        cost.add(40);
    }

    public void AddManToCart(View view) {
        Toast.makeText(this, "HairCut Added to cart", Toast.LENGTH_SHORT).show();
        pic.add(R.drawable.man);
        haircut.add("Man HairCut");
        cost.add(60);

    }

    public void AddWomanToCart(View view) {
        Toast.makeText(this, "HairCut Added to cart", Toast.LENGTH_SHORT).show();
        pic.add(R.drawable.woman);
        haircut.add("Woman HairCut");
        cost.add(80);
    }

    public void OpenCartActivity(View view) {
        cartIntent.putExtra(INPUT_HAIRCUT,haircut);
        cartIntent.putExtra(INPUT_COST,cost);
        cartIntent.putExtra(INPUT_PICTURE,pic);
        startActivity(cartIntent);
    }
}