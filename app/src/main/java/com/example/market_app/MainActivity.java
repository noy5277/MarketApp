package com.example.market_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private String location="duhifat 15 gedera";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openLocation(View view)
    {
        Uri locationUri= Uri.parse("geo:0,0?q="+location);
        Intent intent=new Intent(Intent.ACTION_VIEW,locationUri);
        if(intent.resolveActivity(getPackageManager())!=null)
        {
            startActivity(intent);
        }
        else
        {
            Log.d("geoLocationError","no app that can VIEW a geolocation Uri");
        }
    }
}