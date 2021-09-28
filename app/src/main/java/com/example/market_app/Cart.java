package com.example.market_app;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Cart extends AppCompatActivity  {

    private LinearLayout layout;
    private ArrayList<String> buttonName;
    private ArrayList<Integer> costs;
    private Button button;
    private TextView calcSum;
    int i=0;
    private int sum=0;
    public static final String INPUT_HAIRCUT="PriceMenu.INPUT_HAIRCUT";
    public static final String INPUT_COST="PriceMenu.INPUT_COST";
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        layout=findViewById(R.id.mainLayout);
        calcSum=findViewById(R.id.calcSum_Txt);
        Bundle extras=getIntent().getExtras();
        buttonName=new ArrayList<String>();
        costs=new ArrayList<Integer>();
        if(extras!=null)
        {
            buttonName=extras.getStringArrayList(INPUT_HAIRCUT);
            costs=extras.getIntegerArrayList(INPUT_COST);
        }
        for(Integer cost:costs)
        {
            sum=sum+cost;
        }
        for(String hairCut:buttonName)
        {
            Button button=new Button(this);
            button.setId(i+1);
            button.setText(hairCut);
            button.setTag(i);
            button.setBackgroundColor(R.color.dark_red);
            layout.addView(button);
        }
        calcSum.setText(Integer.toString(sum));
    }

}