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
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class Cart extends AppCompatActivity  {

    private LinearLayout layout;
    private ListView listView;
    private ArrayList<String> haircuts;
    private ArrayList<Integer> costs;
    private ArrayList<Integer> pictures;
    private Button button;
    private TextView calcSum;
    int i=0;
    private int sum=0;
    public static final String INPUT_PICTURE="PriceMenu.INPUT_PICTURE";
    public static final String INPUT_HAIRCUT="PriceMenu.INPUT_HAIRCUT";
    public static final String INPUT_COST="PriceMenu.INPUT_COST";
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        listView=findViewById(R.id.list);
        layout=findViewById(R.id.mainLayout);
        calcSum=findViewById(R.id.calcSum_Txt);
        Bundle extras=getIntent().getExtras();
        haircuts=new ArrayList<String>();
        costs=new ArrayList<Integer>();
        pictures=new ArrayList<Integer>();
        if(extras!=null)
        {
            pictures=extras.getIntegerArrayList(INPUT_PICTURE);
            haircuts=extras.getStringArrayList(INPUT_HAIRCUT);
            costs=extras.getIntegerArrayList(INPUT_COST);
        }
        for(Integer cost:costs)
        {
            sum=sum+cost;
        }
        calcSum.setText(Integer.toString(sum));
        ItemAdapter itemAdapter=new ItemAdapter(this,haircuts,costs,pictures);
        listView.setAdapter(itemAdapter);
    }

}