package com.example.market_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int AFTER_COMMENT=1;
    private static final int SIGN_IN_FROM_CREATE=2;
    public static final String INPUT_COMMENT="About.INPUT_COMMENT";
    private static final String location="Duhifat 15 Gedera";
    private static final String phoneNumber="039380377";
    private Intent aboutIntent;
    private ArrayList<String> comments = new ArrayList<String>();
    private ArrayAdapter arrayAdapter;
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview=findViewById(R.id.listview);
        if(FirebaseAuth.getInstance().getCurrentUser()==null)
        {
            Intent signInUp = AuthUI.getInstance().createSignInIntentBuilder().build();
            startActivityForResult(signInUp,SIGN_IN_FROM_CREATE);
        }
        Bundle extras=getIntent().getExtras();
        if(extras!=null)
        {
            Toast popup = Toast.makeText(this, R.string.Pop_up, Toast.LENGTH_LONG);
            popup.show();
            String msgFromAbout=extras.getString(INPUT_COMMENT);
            comments.add(msgFromAbout+"\n"+FirebaseAuth.getInstance().getCurrentUser().getEmail());
            comments.add(msgFromAbout+"\n"+FirebaseAuth.getInstance().getCurrentUser().getEmail());
        }
        ShowCommentsLayout();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode==AFTER_COMMENT)
        {
            if(resultCode==RESULT_OK)
            {
                Toast popup = Toast.makeText(this, R.string.Pop_up, Toast.LENGTH_LONG);
                popup.show();
                Bundle extras=getIntent().getExtras();
                if(extras!=null)
                {
                    String msgFromAbout=extras.getString(INPUT_COMMENT);
                    comments.add(msgFromAbout+"\n"+FirebaseAuth.getInstance().getCurrentUser().getEmail());
                    comments.add(msgFromAbout+"\n"+FirebaseAuth.getInstance().getCurrentUser().getEmail());
                }
                ShowCommentsLayout();
            }
        }
        if(requestCode==SIGN_IN_FROM_CREATE)
        {
            if(resultCode!=RESULT_OK)
            {
                finish();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.about_item:
                aboutIntent=new Intent(this,About.class);
                startActivityForResult(aboutIntent,AFTER_COMMENT);
                return true;
            case R.id.logout_item:
                FirebaseAuth.getInstance().signOut();

        }
        return(super.onOptionsItemSelected(item));
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

    public void getCall(View view)
    {
        Uri callUri=Uri.parse("tel:"+phoneNumber);
        Intent intent=new Intent(Intent.ACTION_DIAL,callUri);
        if(intent.resolveActivity(getPackageManager())!=null)
        {
            startActivity(intent);
        }
        else
        {
            Log.d("CallError","no app that can CALL a CALL Uri");
        }
    }

    public void createEvent(View view)
    {
        Intent intent=new Intent(this,activity_calender.class);
        startActivity(intent);
    }

    public void ShowCommentsLayout()
    {
        arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,comments);
        listview.setAdapter(arrayAdapter);
    }


    public void OpenMenu(View view) {
        Intent menuIntent=new Intent(this ,PriceMenu.class);
        startActivity(menuIntent);
    }
}