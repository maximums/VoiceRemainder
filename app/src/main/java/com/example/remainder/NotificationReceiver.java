package com.example.remainder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

public class NotificationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String message = intent.getStringExtra("message");
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.anime);
        mediaPlayer.start(); // no need to call prepare(); create() does that for you
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
