package com.example.hassanihsan.quiz_app_for_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityWrongAnswer extends AppCompatActivity {

    private Button TryAgainbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong_answer);

        TryAgainbtn = (Button) findViewById(R.id.TryAgainbtn);
        TryAgainbtn.setOnClickListener(new View.OnClickListener() {
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