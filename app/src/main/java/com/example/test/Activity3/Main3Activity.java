package com.example.test.Activity3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.test.Activity4.Main4Activity;
import com.example.test.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main3Activity extends AppCompatActivity {
private EditText acceptEdt;
private ListView lv;
private Button jumpBtn;
private String togo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
        initListView();
    }
    protected void initView(){
        acceptEdt = findViewById(R.id.acceptEdt);
        lv = findViewById(R.id.lv);
        jumpBtn = findViewById(R.id.jumpBtn);
        Intent intent = getIntent();
        if (intent.hasExtra("togo")){
            togo = intent.getStringExtra("togo");
            acceptEdt.setText(togo);
        }
    }
    protected void initListView(){
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,putData(),R.layout.listview,
                new String[] {"pic","name"},new int[] {R.id.imageView,R.id.textView});
        lv.setAdapter(simpleAdapter);
    }
    protected List<Map<String,Object>> putData(){
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        Map<String,Object> map1 = new HashMap<String, Object>();
        map1.put("pic",R.mipmap.yundong);
        map1.put("name","运动");
        list.add(map1);
        Map<String,Object> map2 = new HashMap<String, Object>();
        map2.put("pic",R.mipmap.dushu);
        map2.put("name","读书");
        list.add(map2);
        Map<String,Object> map3 = new HashMap<String, Object>();
        map3.put("pic",R.mipmap.jisuanji);
        map3.put("name","计算机");
        list.add(map3);
        Map<String,Object> map4 = new HashMap<String, Object>();
        map4.put("pic",R.mipmap.yinyuered);
        map4.put("name","音乐");
        list.add(map4);
        Map<String,Object> map5 = new HashMap<String, Object>();
        map5.put("pic",R.mipmap.kexue);
        map5.put("name","科学");
        list.add(map5);
        return list;
    }
    public void togo(View view){
        Intent intent = new Intent(Main3Activity.this, Main4Activity.class);
        startActivity(intent);
    }
}
