package com.example.test.Activity2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.test.Activity3.Main3Activity;
import com.example.test.R;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
private Button toastBtn;
private Button alertDialogBtn;
private Button togoBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }
    protected void initView(){
        toastBtn = findViewById(R.id.toastBtn);
        alertDialogBtn = findViewById(R.id.alertDialogBtn);
        togoBtn = findViewById(R.id.togoBtn);
        toastBtn.setOnClickListener(this);
        alertDialogBtn.setOnClickListener(this);
        togoBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.toastBtn:
                Toast.makeText(this,"显示Toast",Toast.LENGTH_LONG).show();
                break;
            case R.id.alertDialogBtn:
                AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
                builder.setMessage("显示AlertDialog");
                builder.create().show();
                break;
            case R.id.togoBtn:
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                intent.putExtra("togo",togoBtn.getText().toString());
                startActivity(intent);
                break;
        }
    }
}
