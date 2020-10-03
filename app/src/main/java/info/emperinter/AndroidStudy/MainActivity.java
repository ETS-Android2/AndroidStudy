package info.emperinter.AndroidStudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import info.emperinter.AndroidStudy.broadcast.BroadActivity;
import info.emperinter.AndroidStudy.datastorage.DataStorageActivity;

public class MainActivity extends AppCompatActivity {

    private Button mBtnUI;
    private Button mBtnEvent,mBtnHandler,mBtnData,mBtnBroadCast,mBtnAnima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnUI = findViewById(R.id.btn_ui);
        mBtnEvent = findViewById(R.id.btn_event);
        mBtnHandler = findViewById(R.id.btn_handler);
        mBtnData = findViewById(R.id.btn_data);
        mBtnBroadCast = findViewById(R.id.btn_broadcast);
        mBtnAnima = findViewById(R.id.btn_anim);

        OnClick onClick = new OnClick();

        mBtnUI.setOnClickListener(onClick);
        mBtnEvent.setOnClickListener(onClick);
        mBtnHandler.setOnClickListener(onClick);
        mBtnData.setOnClickListener(onClick);
        mBtnBroadCast.setOnClickListener(onClick);
        mBtnAnima.setOnClickListener(onClick);

        //动态请求存储权限
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
    }


    //按键监听事件
    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_ui:
                    intent = new Intent(MainActivity.this, UIActivity.class);
                    break;
                case R.id.btn_event:
                    intent = new Intent(MainActivity.this, EventActivity.class);
                    break;
                case R.id.btn_handler:
                    intent = new Intent(MainActivity.this,HandlerActivity.class);
                    break;
                case R.id.btn_data:
                    intent = new Intent(MainActivity.this, DataStorageActivity.class);
                    break;
                case R.id.btn_broadcast:
                    intent = new Intent(MainActivity.this, BroadActivity.class);
                    break;
                case R.id.btn_anim:
                    intent = new Intent(MainActivity.this, ObjectAnimActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }

}