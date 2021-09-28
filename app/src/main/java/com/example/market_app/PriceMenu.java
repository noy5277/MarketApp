package com.example.market_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class PriceMenu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_menu);
    }

    public void AddChildToCart(View view) {
        Toast.makeText(this, "HairCut Added to cart", Toast.LENGTH_SHORT).show();
    }

    public void AddManToCart(View view) {
        Toast.makeText(this, "HairCut Added to cart", Toast.LENGTH_SHORT).show();
    }

    public void AddWomanToCart(View view) {
        Toast.makeText(this, "HairCut Added to cart", Toast.LENGTH_SHORT).show();
    }
}