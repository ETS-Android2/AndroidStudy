package info.emperinter.AndroidStudy.jump;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import info.emperinter.AndroidStudy.R;

public class BActivity extends AppCompatActivity {

    private TextView mTvTitle;
    private Button mBtnFinish;
    private Button mBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        Log.d("BAcitivity","-----onCreat----");
        Log.d("BAcitivity","taskid:" + getTaskId() + ",hash:" + hashCode());
        logtaskName();

        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mBtnFinish = (Button) findViewById(R.id.btn_finish);

//        Bundle bundle = new Bundle();
        final Bundle bundle = getIntent().getExtras();
        final String name = bundle.getString("name");
        int number = bundle.getInt("number");

        mTvTitle.setText(name + "," +  number);

        mBtnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle1 = new Bundle();
                bundle1.putString("title","B:我回来了");
                intent.putExtras(bundle1);
                setResult(AActivity.RESULT_OK,intent);
                finish();  //关闭当前页面
            }
        });

        mBtn2 = (Button) findViewById(R.id.btn_2);
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BActivity.this,AActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        //复用
        Log.d("BAcitivity","-----onNewIntent----\n\n\n");
        Log.d("BAcitivity","taskid:" + getTaskId() + ",hash:" + hashCode());
        logtaskName();

    }

    //任务栈名字
    private  void logtaskName(){
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("AActivity",info.taskAffinity);//当前Activity在任务栈中的名称！
        }catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
        }
    }
}