package com.example.hassanihsan.hihsanmidterm2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class REPORT extends AppCompatActivity {

    TextView webstite_view, website_descp;
    Button Button_return;

    String website_name, website_desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        webstite_view = findViewById(R.id.textView2);
        website_descp = findViewById(R.id.textView);
        Button_return = (Button)findViewById(R.id.button_returnMain);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        website_name = sp.getString("website", "");
        website_desc = sp.getString("desc", "");

        webstite_view.setText( "Website: " +website_name);
        website_descp.setText("Description: "+ website_desc);

        Button_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(REPORT.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}