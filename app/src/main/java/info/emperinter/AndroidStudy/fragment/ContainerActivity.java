package info.emperinter.AndroidStudy.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import info.emperinter.AndroidStudy.R;

public class ContainerActivity extends AppCompatActivity implements AFragment.IOnMessageClick{

    private AFragment aFragment;
//    private Button mBtnChange;
    private BFragment bFragment;

    private TextView mTvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        mTvTitle = (TextView) findViewById(R.id.tv_title);

//        mBtnChange = (Button) findViewById(R.id.btn_change);
//        mBtnChange.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(bFragment == null){
//                    bFragment = new BFragment();
//                }
////                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,bFragment).commitAllowingStateLoss();
//                getFragmentManager().beginTransaction().replace(R.id.fl_container,bFragment).commitAllowingStateLoss();
//            }
//        });

        //实例化AFragment
//        aFragment = new AFragment();  //默认形式
//        aFragment.newInstance("我是参数");//为啥传递不了参数？


        aFragment = new AFragment().newInstance("我是参数"); //传参

        //把AFragment添加到Activity中，记得调用commit;"a"是在按返回键上一个状态保持原样！方便后续可以找到！
        getFragmentManager().beginTransaction().add(R.id.fl_container,aFragment,"a").commitAllowingStateLoss();
        //getSupportFragmentManager().beginTransaction().add(R.id.fl_container,aFragment).commitAllowingStateLoss();

    }

    //不推荐
    public  void setData(String message){
        mTvTitle.setText(message);
    }


    //推荐给Activity传参的方法
    //实现接口！
    @Override
    public void onClick(String text) {
        mTvTitle.setText(text);
    }
}