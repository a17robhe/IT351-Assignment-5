package com.example.it351_assignment_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ViewContactView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contact_view);
        Contact passedContact = (Contact) getIntent().getSerializableExtra("Contact");

        TextView name = (TextView) findViewById(R.id.name);
        name.setText(passedContact.getName());
        TextView company = (TextView) findViewById(R.id.company);
        company.setText(passedContact.getCompany());
        TextView address = (TextView) findViewById(R.id.address);
        address.setText(passedContact.getAddress());
        address.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("geo:0,0?q=" + Uri.encode(passedContact.getAddress()));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        TextView phoneNumber = (TextView) findViewById(R.id.phone_number);
        phoneNumber.setText(passedContact.getPhoneNumber());
        phoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:"+passedContact.getPhoneNumber().toString());
                Intent intent = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(intent);
            }
        });
    }
}