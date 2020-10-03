package info.emperinter.AndroidStudy.broadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.PrintWriter;

import info.emperinter.AndroidStudy.R;
import info.emperinter.AndroidStudy.util.ToastUtil;

public class BrooadActivity2 extends AppCompatActivity {

    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brooad2);


        mBtn = findViewById(R.id.btn_click);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("info.emperinter.update");

                // 发送广告
                // 广告行为名字：info.emperinter.update
                LocalBroadcastManager.getInstance(BrooadActivity2.this).sendBroadcast(intent);

                ToastUtil.showMsg(BrooadActivity2.this,"广播发送成功");
            }
        });
    }
}