package info.emperinter.AndroidStudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import info.emperinter.AndroidStudy.util.ToastUtil;
import info.emperinter.AndroidStudy.widget.MyButton;

public class EventActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnEvent;
    private MyButton btnMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        mBtnEvent = (Button) findViewById(R.id.btn_event);
        btnMy = (MyButton) findViewById(R.id.btn_my); //基于回调的方法

        btnMy.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.d("Listener","---OnTouch---");
                        break;
                }
                return false;
            }
        });


        btnMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Listener","---onTouch---");
            }
        });

        btnMy.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;  //还会接着触发OnClick监听器
//                return true;// 不会长按事件消费掉，则不会出发OnClick监听器
            }
        });

        //通过内部类实现
//        mBtnEvent.setOnClickListener(new Onclick());


        //匿名内部类
//        mBtnEvent.setOnClickListener(new View.OnClickListener() {
//        Log.d("匿名内部类实现","click\n\n\n");
//            @Override
//            public void onClick(View v) {
//                ToastUtil.showMsg(EventActivity.this,"Click---");
//            }
//        });

//        通过事件源所在类   |   implements View.OnclickListener
//        mBtnEvent.setOnClickListener(EventActivity.this);

        //通过外部类实现 | MyClickListener.java
        mBtnEvent.setOnClickListener(new MyClickListener(EventActivity.this));


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_event:
                ToastUtil.showMsg(EventActivity.this,"Click---");
                break;
        }
    }


    //内部类实现
    class Onclick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Log.d("内部类实现","click\n\n\n");
            switch (v.getId()){
                case R.id.btn_event:
                    ToastUtil.showMsg(EventActivity.this,"Click---");
                    break;
            }
        }
    }


    //XML调用
    public void show(View v){
        Log.d("XML实现","click\n\n\n");
        switch (v.getId()){
            case R.id.btn_event_xml:
                ToastUtil.showMsg(EventActivity.this,"XML | Click---");
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("Activity","-----OnTouchEvent------");
                break;
        }
        return  false;
    }

}