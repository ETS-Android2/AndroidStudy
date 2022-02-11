package info.emperinter.AndroidStudy;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import info.emperinter.AndroidStudy.util.ToastUtil;

public class DialogActivity extends AppCompatActivity {

    private Button mBtnDialog1,mBtnDialog2,mBtnDialog3,mBtnDialog4,mBtnDialog5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        mBtnDialog1 = findViewById(R.id.btn_dialog1);
        mBtnDialog2 = findViewById(R.id.btn_dialog2);
        mBtnDialog3 = findViewById(R.id.btn_dialog3);
        mBtnDialog4 = findViewById(R.id.btn_dialog4);
        mBtnDialog5 = findViewById(R.id.btn_dialog5);
        OnClick onClick = new OnClick();
        mBtnDialog1.setOnClickListener(onClick);
        mBtnDialog2.setOnClickListener(onClick);
        mBtnDialog3.setOnClickListener(onClick);
        mBtnDialog4.setOnClickListener(onClick);
        mBtnDialog5.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_dialog1:               //默认样式
                    AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
                    builder.setTitle("请回答!").setMessage("你觉得课程如何")
                            .setIcon(R.drawable.smile)
                    .setPositiveButton("棒！", new DialogInterface.OnClickListener() {  //积极
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this,"您很诚实！");
                        }
                    }).setNeutralButton("还行！", new DialogInterface.OnClickListener() {  //中性
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this,"您再瞅瞅~");
                        }
                    }).setNegativeButton("不好!", new DialogInterface.OnClickListener() {  //消极
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this,"睁眼说瞎话！");
                        }
                    }).show();
//                    builder.setMessage("你觉得课程如何？");
                    break;
                case R.id.btn_dialog2:  //单选
                    final String[] array2 = new String[]{"男","女"};
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(DialogActivity.this);
                    builder2.setTitle("选择性别").setItems(array2, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {  //which 数组索引
                            ToastUtil.showMsg(DialogActivity.this,array2[which]);
                        }
                    }).show();
                    break;
                case R.id.btn_dialog3:
                    final String[] array3 = new String[]{"男","女"};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(DialogActivity.this);
                    builder3.setTitle("性别").setIcon(R.drawable.smile)
                            .setSingleChoiceItems(array3, 0, new DialogInterface.OnClickListener() {  //0 默认
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this,array3[which]);
                            dialog.dismiss();
                        }
                    }).setCancelable(false).show();  //setCancelable选择旁边不会小时
                    break;
                case R.id.btn_dialog4:  //多选
                    final String[] array4 = new String[]{"唱歌","跳舞","写代码"};
                    boolean[] isSelected = new boolean[]{false,false,true};
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(DialogActivity.this);
                    builder4.setTitle("选择兴趣").setMultiChoiceItems(array4, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            ToastUtil.showMsg(DialogActivity.this,array4[which] + " : " + isChecked);
                        }
                    }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //确定后的
                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //取消后的样式
                        }
                    }).show();
                    break;
                case R.id.btn_dialog5:  //自定义样式
                        AlertDialog.Builder builder5 = new AlertDialog.Builder(DialogActivity.this);
                        View view = LayoutInflater.from(DialogActivity.this).inflate(R.layout.layout_dialog,null);
                        final EditText eTUserName = view.findViewById(R.id.et_username);
                        EditText eTPassWord = view.findViewById(R.id.et_password);
                        Button btnLogin = view.findViewById(R.id.btn_login);
                        final AlertDialog dialog = builder5.setTitle("登录").setView(view).show();
                        btnLogin.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //
                                dialog.dismiss();
    //                            eTUserName.setText("Click !");
                            }
                        });
    //                    builder5.setTitle("登录").setView(view).show();
                        break;
            }
        }
    }

}

