package info.emperinter.AndroidStudy.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import info.emperinter.AndroidStudy.R;

public class ContainerActivity extends AppCompatActivity {

    private AFragment aFragment;
    private Button mBtnChange;
    private BFragment bFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        mBtnChange = (Button) findViewById(R.id.btn_change);
        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bFragment == null){
                    bFragment = new BFragment();
                }
//                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,bFragment).commitAllowingStateLoss();
                getFragmentManager().beginTransaction().replace(R.id.fl_container,bFragment).commitAllowingStateLoss();
            }
        });

        //实例化AFragment
//        aFragment = new AFragment();  //默认形式
//        aFragment.newInstance("我是参数");//为啥传递不了参数？


        aFragment = new AFragment().newInstance("我是参数"); //传参

        //把AFragment添加到Activity中，记得调用commit;
        getFragmentManager().beginTransaction().add(R.id.fl_container,aFragment).commitAllowingStateLoss();
        //getSupportFragmentManager().beginTransaction().add(R.id.fl_container,aFragment).commitAllowingStateLoss();

    }

}