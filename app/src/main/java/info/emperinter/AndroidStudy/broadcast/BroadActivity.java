package info.emperinter.AndroidStudy.broadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import info.emperinter.AndroidStudy.R;

public class BroadActivity extends AppCompatActivity {

    private Button mBtn1;
    private TextView mTvTest;
    private MyBroadcast mBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad);

        mBtn1 = (Button) findViewById(R.id.btn1);
        mTvTest = findViewById(R.id.tv_test);

        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BroadActivity.this,BrooadActivity2.class);
                startActivity(intent);
            }
        });

        //注册广播
        mBroadcast = new MyBroadcast();
        IntentFilter intentFilter = new IntentFilter();    //意图筛选
        intentFilter.addAction("info.emperinter.update");  //选择接收的广播,排除其它不需要的广播！
        LocalBroadcastManager.getInstance(this).registerReceiver(mBroadcast,intentFilter);
    }


    //接收广播
    private class MyBroadcast extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()){
                case "info.emperinter.update":
                    mTvTest.setText("123");
                    break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //页面销毁后，摧毁广播，避免内存泄漏！
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mBroadcast);
    }
}