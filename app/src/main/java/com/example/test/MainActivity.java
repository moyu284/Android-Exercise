package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.test.Activity2.Main2Activity;


public class MainActivity extends AppCompatActivity{
private EditText nameEdt;
private EditText passwordEdt;
private Button logBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    protected void initView(){
        nameEdt = findViewById(R.id.nameEdt);
        passwordEdt = findViewById(R.id.passwordEdt);
        logBtn = findViewById(R.id.logBtn);
        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEdt.getText().toString();
                String password = passwordEdt.getText().toString();
                if (name.equals("admin")&&password.equals("1")){
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
//                    finish();
                }
                else{
                    finish();
                }
            }
        });
    }

}
