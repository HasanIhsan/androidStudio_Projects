package com.example.hassanihsan.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button strbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        strbtn = (Button) findViewById(R.id.strbtn);
        strbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDog();
            }
        });

    }

    public void addDog()
    {
        Intent intent = new Intent(this, AddNewDogActivity.class);
        startActivity(intent);
    }
}