package info.emperinter.AndroidStudy;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LifeCycleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Log.d("LifeCycle:","-----onCreate-----");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle:","-----onStart-----");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle:","-----onRestart-----");
    }

    @Override
    protected void onResume() {   //数据的刷新
        super.onResume();
        Log.d("LifeCycle:","-----onResume-----");
    }

    @Override
    protected void onPause() {  // 退到后台，游戏暂停等
        super.onPause();
        Log.d("LifeCycle:","-----onPause-----");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle:","-----onStop-----");
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle:","-----onDestroy-----");
    }
}
