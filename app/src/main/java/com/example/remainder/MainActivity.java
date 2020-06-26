package com.example.remainder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManager;
    private EditText subject, content;
    private  int Year, Month, Day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = NotificationManagerCompat.from(this);
        subject = (EditText) findViewById(R.id.subject);
//        content = (EditText) findViewById(R.id.content);
        CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                    Year = year;
                    Month = month;
                    Day = dayOfMonth;
            }
        });

    }

    public void sendOnChannel(View view) {
        String subj = subject.getText().toString();

        Intent activityIntent = new Intent(this, MainActivity.class);//tmp MainActivity,should open calendar in future
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, activityIntent, 0);

        Intent broadcastIntent = new Intent(this, NotificationReceiver.class);
//        broadcastIntent.putExtra("message", cont);

        Notification notification = new NotificationCompat.Builder(this, WakeUpB.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle(subj)
                .setVibrate(new long[] {2000L})
                .setColor(Color.BLACK)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .build();
        notificationManager.notify(1, notification);

        Intent intent = new Intent(this, FinalPrep.class);
        intent.putExtra("year", new String[] {String.valueOf(Year), String.valueOf(Month), String.valueOf(Day)});
        startActivity(intent);
    }
}