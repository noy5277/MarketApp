package com.example.market_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class About extends AppCompatActivity {
    public static final String INPUT_COMMENT="About.INPUT_COMMENT";
    private EditText commentFromUser;
    private RatingBar ratingBar;
    private Button sendButton;
    private Button emailButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ratingBar=findViewById(R.id.ratingBar);
        commentFromUser=findViewById(R.id.editComment);
        sendButton=findViewById(R.id.sendComment_Btn);
        emailButton=findViewById(R.id.email_button);

    }

    public void sendComment(View view) {
        String comment=commentFromUser.getText().toString();
        Intent firstIntent=new Intent(this,MainActivity.class);
        firstIntent.putExtra(INPUT_COMMENT,comment+"\nStars:"+ratingBar.getRating());
        startActivity(firstIntent);
    }

    public void sendEmail(View view)
    {
        String comment=commentFromUser.getText().toString();
        Intent emailIntent=new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"noy5277@gmail.com"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Customer Comment-Barbershop");
        emailIntent.putExtra(Intent.EXTRA_TEXT,comment+"\nStars:"+ratingBar.getRating());
        emailIntent.setType("message/rfc822");
        startActivity(emailIntent);
    }

    public void setButtonEnabled(View view) {
        sendButton.setEnabled(true);
    }

    public void openWebsite(View view) {
        Uri webpage = Uri.parse("https://www.barbershop.com");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(webIntent);
    }


    public void CreateContact(View view) {
        Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
        intent.putExtra(ContactsContract.Intents.Insert.EMAIL,"noy5277@BarberShop.com" );
        intent.putExtra(ContactsContract.Intents.Insert.PHONE, "089380377");
        intent.putExtra(ContactsContract.Intents.Insert.NAME,"BarberShop");
        startActivity(intent);
    }
}