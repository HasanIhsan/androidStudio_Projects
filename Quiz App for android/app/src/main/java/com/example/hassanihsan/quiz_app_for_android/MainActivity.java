package com.example.hassanihsan.quiz_app_for_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  {

    private Button strBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        strBtn = (Button) findViewById(R.id.StrBtn);
        strBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityQuestion();
            }
        });
    }


    public void openActivityQuestion() {
        Intent intent = new Intent(this, ActivityQuestions.class);
        startActivity(intent);
    }


}