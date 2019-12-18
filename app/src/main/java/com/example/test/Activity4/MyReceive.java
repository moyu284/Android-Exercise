package com.example.test.Activity4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceive extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("broadcast".equals(action)){
            String home = intent.getStringExtra("home");
            Toast.makeText(context,home,Toast.LENGTH_SHORT).show();
        }
    }
}
