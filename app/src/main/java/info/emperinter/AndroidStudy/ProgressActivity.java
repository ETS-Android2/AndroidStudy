package info.emperinter.AndroidStudy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ProgressBar;

import info.emperinter.AndroidStudy.util.ToastUtil;

public class ProgressActivity extends AppCompatActivity {

    private ProgressBar mPb3;
    private Button mBtnStart,mBtnProgressDialog1,mBtnProgressDialog2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        mPb3 = (ProgressBar) findViewById(R.id.pb3);
        mPb3.setProgress(30); //进度
        mBtnStart = (Button) findViewById(R.id.btn_start);
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int m = 0;
//                while (m <= 100){
//                    mPb3.setProgress(m);
//                    m++;
//                }
                handler.sendEmptyMessage(0);
            }
        });

        mBtnProgressDialog1 = (Button) findViewById(R.id.mbtn_progress_dialog1);
        mBtnProgressDialog2 = (Button) findViewById(R.id.mbtn_progress_dialog2);

        mBtnProgressDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);
                progressDialog.setTitle("提示:");
                progressDialog.setMessage("正在加载！");
                progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        ToastUtil.showMsg(ProgressActivity.this,"cancel...");
                    }
                });
                progressDialog.setCancelable(false);  //是否可取消？
                progressDialog.show();
            }
        });

        mBtnProgressDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setTitle("提示！");
                progressDialog.setMessage("正在下载...");
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE,"棒！",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //
                    }
                });
                progressDialog.show();
            }
        });

    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(mPb3.getProgress() < 100){
//                mPb3.setProgress(mPb3.getProgress()+5);
                handler.postDelayed(runnable,500);  //延迟发送消息给runnable执行，单位ms
            }else {
                ToastUtil.showMsg(ProgressActivity.this,"加载完成！");
            }
        }
    };

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mPb3.setSecondaryProgress(mPb3.getSecondaryProgress()+2);
            mPb3.setProgress(mPb3.getProgress()+5);
            handler.sendEmptyMessage(0);
        }
    };
}