package com.example.demo01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    private Button btnStartNormalActivity,btnStartDialogActivity;
    private static final String TAG="Main2Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        Log.d(TAG, "onCreate: 创建");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: 开始");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: 准备开始交互");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: 暂停");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: 停止");
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        Log.d(TAG, "onDestroy: 销毁");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onReStart: 重新开始");
    }
    public void initView() {

        btnStartNormalActivity=findViewById(R.id.btn_start_normal_activity);
        btnStartDialogActivity=findViewById(R.id.btn_start_dialog_activity);
        //常规Activity点击事件
        btnStartNormalActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,NormalActivity.class);
                startActivity(intent);
            }
        });
        //对话框点击事件
        btnStartDialogActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,DialogActivity.class);
                startActivity(intent);
            }
        });

    }
}