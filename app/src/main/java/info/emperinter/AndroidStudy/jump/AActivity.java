package info.emperinter.AndroidStudy.jump;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import info.emperinter.AndroidStudy.R;
import info.emperinter.AndroidStudy.util.ToastUtil;

public class AActivity extends AppCompatActivity {

    private Button mBtnJump;
    private Button mBtnJump2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        Log.d("AAcitivity","-----onCreate----\n\n\n");
        Log.d("AAcitivity","taskid:" + getTaskId() + ",hash:" + hashCode());
        logtaskName();

        mBtnJump = (Button) findViewById(R.id.jump);

        mBtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显式跳转 1
                Intent intent = new Intent(AActivity.this,BActivity.class);
                //数据传递
                Bundle bundle = new Bundle();
                bundle.putString("name","emperinter");
                bundle.putInt("number",88);
                intent.putExtras(bundle);
                startActivity(intent);
                //回调数据
//                startActivityForResult(intent,0);

                //显式跳转  2
//                Intent intent = new Intent();
//                intent.setClass(AActivity.this,BActivity.class);
//                startActivity(intent);

                //显式跳转  3
//                Intent intent = new Intent();
//                intent.setClassName(AActivity.this,"info.emperinter.AndroidStudy.jump.BActivity");
//                startActivity(intent);

                //显式跳转 4
//                Intent intent = new Intent();
//                intent.setComponent(new ComponentName(AActivity.this,"info.emperinter.AndroidStudy.jump.BActivity"));
//                startActivity(intent);

//
//               隐式跳转
//

//                Intent intent = new Intent();
//                intent.setAction("info.emperinter.test.BActivity");  //info.emperinter.test.BActivity 在AndroidManifest.xml中设置的
//                startActivity(intent);
//
//        <activity android:name=".jump.BActivity">
//            <intent-filter>
//                <action android:name="info.emperinter.test.BActivity" />
//                <category android:name="android.intent.category.DEFAULT" />
//            </intent-filter>
//        </activity>

            }
        });


        mBtnJump2 = (Button) findViewById(R.id.jump2);
        mBtnJump2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(AActivity.this,AActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(AActivity.this,data.getExtras().getString("title"),Toast.LENGTH_LONG).show();  //获取回调返回的值！
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        //复用
        Log.d("AAcitivity","-----onNewIntent----\n\n\n");
        Log.d("AAcitivity","taskid:" + getTaskId() + ",hash:" + hashCode());
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