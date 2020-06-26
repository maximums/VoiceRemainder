package com.example.remainder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TimePicker;
import android.widget.Toast;

public class FinalPrep extends AppCompatActivity {

    private TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_prep);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        Intent intent = getIntent();
        String[] tmp = intent.getStringArrayExtra("year");
        Toast.makeText(this, String.valueOf(timePicker.getHour())+" "+String.valueOf(timePicker.getMinute()), Toast.LENGTH_SHORT).show();
    }
}