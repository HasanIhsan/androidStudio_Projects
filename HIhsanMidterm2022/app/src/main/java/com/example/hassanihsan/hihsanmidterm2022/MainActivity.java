package com.example.hassanihsan.hihsanmidterm2022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button Button_Send_Notfication, Button_report;
    EditText EditText_website, EditText_Desc;
    SharedPreferences sp;

    String webstie_name, website_desp, website_name1, website_descp1;

    public static final int NOTIFICATION_ID = 1;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    public static final String CHANNEL_ID = "channel_01";
    public static final String CHANNEL_NAME = "INFO3136_CHANNEL";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button_report = (Button) findViewById(R.id.button_report);
        Button_Send_Notfication = (Button)findViewById(R.id.button_noti);
        EditText_website = (EditText) findViewById(R.id.EditText_Website_name);
        EditText_Desc = (EditText) findViewById(R.id.EditText_Website_desc);

        sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);


        Button_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webstie_name = EditText_website.getText().toString();
                website_desp = EditText_Desc.getText().toString();

                SharedPreferences.Editor editor = sp.edit();

                editor.putString("website", webstie_name);
                editor.putString("desc", website_desp);
                editor.commit();

                Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, REPORT.class);
                startActivity(intent);
            }
        });


        createNotificationChannel();

        Button_Send_Notfication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webstie_name = EditText_website.getText().toString();
                website_desp = EditText_Desc.getText().toString();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("website", webstie_name);
                editor.putString("desc", website_desp);
                editor.commit();

                sendNotification();
            }
        });

    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,
                    CHANNEL_NAME, importance);
            channel.setDescription("INFO3136 Notifications");

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }


    public void sendNotification() {

        SharedPreferences sp = getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        website_name1 = sp.getString("website", "");
        website_descp1 = sp.getString("desc", "");

        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse(website_name1));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANNEL_ID);

        builder.setSmallIcon(R.drawable.android_12);


        builder.setContentIntent(pendingIntent);


        builder.setAutoCancel(true);

        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.android));


        builder.setContentTitle("INFO 3136 Midterm");
        builder.setContentText(website_descp1);



        NotificationManager notificationManager = (NotificationManager) getSystemService(
                NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, builder.build());

    }


}