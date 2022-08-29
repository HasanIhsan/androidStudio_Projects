package com.example.hassanihsan.quiz_app_for_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ActivityQuestions extends AppCompatActivity {

    private ImageButton butterflybtn;
    private ImageButton redpandabtn;
    private ImageButton wolfbtn;
    private ImageButton cheetabtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        butterflybtn = (ImageButton) findViewById(R.id.imagebuterfly);
        redpandabtn = (ImageButton) findViewById(R.id.imageredpanda);
        wolfbtn = (ImageButton) findViewById(R.id.imagewolf);
        cheetabtn = (ImageButton) findViewById(R.id.imagecheeta);

        butterflybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityRight();
            }
        });


        redpandabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityWrong();
            }
        });


        wolfbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityWrong();
            }
        });


        cheetabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityWrong();
            }
        });


    }



    public void openActivityRight()
    {
        Intent intent = new Intent(this, ActivityRightAnswer.class);
        startActivity(intent);
    }

    public void openActivityWrong()
    {
        Intent intent = new Intent(this, ActivityWrongAnswer.class);
        startActivity(intent);
    }
}