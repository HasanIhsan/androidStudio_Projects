package com.example.hassanihsan.quiz_app_for_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ActivityRightAnswer extends AppCompatActivity {

    private Button Homebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right_answer);

        Homebtn = (Button) findViewById(R.id.HomebuttonRight);
        Homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityHome();
            }
        });
    }

    public void openActivityHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}