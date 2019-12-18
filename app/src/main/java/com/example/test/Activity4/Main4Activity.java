package com.example.test.Activity4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.test.Activity5.Main5Activity;
import com.example.test.R;

public class Main4Activity extends AppCompatActivity {
private final static int ITEM = Menu.FIRST;
private NotificationManager notificationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {
        menu.add(0,ITEM,0,"我的学习生涯");
        menu.add(0,ITEM+1,0,"我的家庭");
        menu.add(0,ITEM+2,0,"天气预报");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case ITEM:
                Intent intent = new Intent(Main4Activity.this, Main5Activity.class);
                startActivity(intent);
                break;
            case ITEM+1:
                broadcastSend();
                break;
            case ITEM+2:
                displayWeather("晴","天气预报","晴空万里",R.mipmap.sunny);
                break;
        }
        return true;
    }
    protected void broadcastSend(){
        Intent intent = new Intent();
        intent.putExtra("home","我的父亲母亲***");
        intent.setAction("broadcast");
        sendBroadcast(intent);
    }
    private void displayWeather(String tickerText,String title,String content,int drawable){
        Notification.Builder builder = new Notification.Builder(Main4Activity.this);
        builder.setSmallIcon(drawable);
        builder.setTicker(tickerText);
        builder.setContentTitle(title);
        builder.setContentText(content);
        builder.setWhen(System.currentTimeMillis());
        builder.setDefaults(Notification.DEFAULT_ALL);
        builder.setAutoCancel(true);
        Intent intent = new Intent(this,Main4Activity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(Main4Activity.this,0,intent,0);
        builder.setContentIntent(pendingIntent);
        Notification notification1 = builder.build();
        notificationManager.notify(R.layout.activity_main4,notification1);
    }
}

