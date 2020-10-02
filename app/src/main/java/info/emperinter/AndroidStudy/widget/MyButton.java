package info.emperinter.AndroidStudy.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

@SuppressLint("AppCompatCustomView")
public class MyButton extends Button {
    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {  //一个控件的触摸事件都是从dispatchTouchEvent往下分发的;入口方法！
        Log.d("MyButton:","---dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        super.onTouchEvent(event);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:   //过滤事件
                Log.d("MyButton","------OnTouchEvent------");
                break;
        }
//        return false;//会继续回调Activity里面的方法
//        return true; //不会继续回调Acitivity
        return super.onTouchEvent(event);
    }


}
