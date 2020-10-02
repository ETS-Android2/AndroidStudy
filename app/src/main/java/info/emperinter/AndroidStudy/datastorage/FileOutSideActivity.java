package info.emperinter.AndroidStudy.datastorage;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import info.emperinter.AndroidStudy.R;

public class FileOutSideActivity extends AppCompatActivity {

    private EditText mEtName;
    private Button mBtnSave;
    private Button mBtnShow;
    private TextView mTvContent;
    private final String mFileName = "test.txt";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_outside);

        mEtName = findViewById(R.id.et_name);
        mBtnSave = findViewById(R.id.btn_save);
        mBtnShow = findViewById(R.id.btn_show);
        mTvContent = findViewById(R.id.tv_content);

        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(mEtName.getText().toString());
            }
        });

        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvContent.setText(read());
            }
        });

    }

    //存储数据
    private void save(String content){
        FileOutputStream fileOutputStream = null;
        try{
//            fileOutputStream = openFileOutput(mFileName,MODE_PRIVATE);
            File dir = new File(Environment.getExternalStorageDirectory(),"emperinter");
            if(!dir.exists()){
                dir.mkdir();//建一个文件
//                dir.mkdirs()//  若为emperinter/a/b/c 则建立4个文件夹
            }
            File file = new File(dir,mFileName);//文件名
            if(!file.exists()){
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(content.getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //读取数据
    private String read(){
        FileInputStream fileInputStream = null;
        try {
//            fileInputStream = openFileInput(mFileName);  //一段一段读取

            //在该路径下有该txt文件
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"emperinter",mFileName);
            fileInputStream = new FileInputStream(file);
            byte[] buff = new byte[1024];  //每次读1024字节
            StringBuilder sb = new StringBuilder("");//实现字符串拼接
            int len = 0;

            while ((len = fileInputStream.read(buff)) > 0){
                sb.append(new String(buff,0,len));
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return  null;
    }
}