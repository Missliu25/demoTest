package com.example.demo01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private Button button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();

    }
    public void initView(){
        button3=findViewById(R.id.button2);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =getIntent();
                String data=intent.getStringExtra("name1");
                Log.d("main", "onClick: "+data);
                button3.setText(data);
                //数据是使用Intent返回
                String text =button3.getText().toString();
                //把返回数据存入Intent
                intent.putExtra("result", "我是回传值"+text);

                //设置返回数据
                SecondActivity.this.setResult(RESULT_OK, intent);

                //关闭Activity
                SecondActivity.this.finish();

            }
        });

    }
}
