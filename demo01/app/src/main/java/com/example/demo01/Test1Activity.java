package com.example.demo01;

    import androidx.annotation.Nullable;
    import androidx.appcompat.app.AppCompatActivity;

    import android.content.Intent;
    import android.os.Bundle;
    import android.util.Log;
    import android.view.View;
    import android.widget.Button;

    public class Test1Activity extends AppCompatActivity {

        private final static String TAG="AppCompatActivity";
        private Button button4;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_test1);
            initView();
        }
        private void initView() {
            button4=findViewById(R.id.button4);
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(Test1Activity.this,SecondActivity.class);
                    intent.putExtra("name1","你好我是传值");
                    //跳转
                    startActivity(intent);
                    //设置返回值
                    startActivityForResult(intent,1);
                }
            });

        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            String result = data.getExtras().getString("result");//得到新Activity 关闭后返回的数据
            button4.setText(result);
            Log.i(TAG, "onActivityResult: "+result);

        }
    }