package com.example.demo01;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "你猜我是不是个小可爱";
    private Button button1;
    private Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    //初始化试图
    public void initView(){

        button3=findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                button3.setText("我是新来的测试");
//                Toast.makeText(MainActivity.this, "你好呀", Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(MainActivity.this,Test1Activity.class);
                intent.putExtra("name","你可以猜猜看我是谁呀");
//                startActivityForResult(intent,2);
                startActivity(intent);

            }
        });

        button1=findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Toast.makeText(MainActivity.this,"黑啮合你好呀",Toast.LENGTH_LONG).show();
                //跳转到另外一个intent
                // Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                //startActivity(intent);
                // Intent intent =new Intent("com.demomainActivity.START");
                //startActivity(intent);

                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("data","hell n你好第二个界面");
                //直接拨号
                //intent.setAction(Intent.ACTION_CALL);
                //点击确定后拨号
                //intent.setAction(Intent.ACTION_DIAL);
                //intent.setAction("android.settings.SETTINGS");
                // intent.setData(Uri.parse("tel:13263702589"));
                //startActivity(intent);
                startActivityForResult(intent,1);
            }
        });


    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        switch (requestCode) {
//            case 1:
//                if (requestCode == RESULT_OK) {
//
//                    String resultData = data.getStringExtra("date-return");
//                    Log.d("MainActivity", resultData);
//                }
//            case 2: {
//                if (requestCode == 333) {
//                    String TestResultCode = data.getStringExtra("TestActivity");
//                    Log.d("MainActivity", TestResultCode);
//                    button3.setText(TestResultCode);
//                }
//            }
//            break;
//        }
//    }
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    switch (requestCode) {
        case 1:
            if (resultCode == 333) {
                String resultData = data.getStringExtra("TestActivity");
                Log.i(TAG, "onActivityResult: " + resultData);
//                Log.i(TAG, "onActivityResult: " + resultData);
            }
            break;
        default:
    }
}
    //选项菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;

    }
    //选项菜单点击后的操作

    @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this, "ADD添加", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "REMOVE移除", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    //接收回传值
//    @SuppressLint("MissingSuperCall")
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//
//        switch (requestCode){
//            case  1:
//                if (requestCode==RESULT_OK){
//
//                    String resultData=data.getStringExtra("date-return");
//                    Log.d("MainActivity",resultData);
//                }
//            case 2:{
//                if (requestCode==333){
//                    String TestResultCode=data.getStringExtra("TestActivity");
//                    Log.d("MainActivity",TestResultCode);
//                    button3.setText(TestResultCode);
//                }
//            }
//                break;
//        }
//
//
//
//    }


}
