package info.emperinter.AndroidStudy;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ObjectAnimActivity extends AppCompatActivity {

    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_anim);

        tvTest = findViewById(R.id.tv);

        //沿Y移动距离，可谓负数
        //setDuration(毫秒) 时间
        //start() 启动
//        tvTest.animate().translationYBy(500).setDuration(2000).start();

        //到某距离
//        tvTest.animate().translationY(500).start();


        //缩放
//        tvTest.animate().scaleXBy(10).setDuration(2000).start();

        //透明度
//        tvTest.animate().alpha(0).setDuration(3000).start();

        //可动态实现动画？
//        ValueAnimator valueAnimator = ValueAnimator.ofInt(0,100);//从0到100变化
//        valueAnimator.setDuration(2000);
//        //动画监听器
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                //valueAnimator 实际的值
//                Log.d("监听器:",animation.getAnimatedValue()+"");
//                //动画的进度 0 - 1
//                Log.d("监听器",animation.getAnimatedFraction()+"");
//            }
//        });
//        valueAnimator.start();


//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tvTest,"translationY",0,500);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tvTest,"translationY",0,500,200,800);  //依次执行
        objectAnimator.setDuration(2000);
//        也可监听值的变化过程！
//        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//
//            }
//        });
        objectAnimator.start();

    }
}