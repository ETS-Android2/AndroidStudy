package info.emperinter.study211;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    private Button mBtnTextView;
    private Button nButton;
    private Button mBtnEditText;
    private Button mBtnRadionButton;
    private Button mBtnCheck;
    private Button mBtnImg;
    private Button mBtnListV;
    private Button mBtnGridV;
    private Button mBtnRecycleV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnTextView = (Button) findViewById(R.id.mbtn_textview);
//        mBtnTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,TextViewActivity.class);
//                startActivity(intent);
//            }
//        });
//
        nButton = (Button) findViewById(R.id.btn_button);
        mBtnEditText = (Button) findViewById(R.id.mbtn_edittext);
        mBtnRadionButton = (Button) findViewById(R.id.mbtn_radiobutton);
        mBtnCheck = (Button) findViewById(R.id.mbtn_checkboxbutton);
        mBtnImg = (Button) findViewById(R.id.mbtn_imageviewbutton);
        mBtnListV = (Button) findViewById(R.id.mbtn_listview);
        mBtnGridV = (Button) findViewById(R.id.mbtn_gridview);
        mBtnRecycleV = (Button) findViewById(R.id.mbtn_recyclerview);
        setListensers();
    }

    private void setListensers(){
        OnClick onClick = new OnClick();
        mBtnTextView.setOnClickListener(onClick);
        mBtnEditText.setOnClickListener(onClick);
        nButton.setOnClickListener(onClick);
        mBtnRadionButton.setOnClickListener(onClick);
        mBtnImg.setOnClickListener(onClick);
        mBtnCheck.setOnClickListener(onClick);
        mBtnListV.setOnClickListener(onClick);
        mBtnGridV.setOnClickListener(onClick);
        mBtnRecycleV.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener{
        public void onClick(View v){
            Intent intent = null;
            switch (v.getId()){
                case R.id.mbtn_edittext:
                    intent = new Intent(MainActivity.this,TextViewActivity.class);
                    break;
                case R.id.btn_button:
                    intent = new Intent(MainActivity.this,ButtonActivity.class);
                    break;
                case R.id.mbtn_textview:
                    intent = new Intent(MainActivity.this,TextViewActivity.class);
                    break;
                case R.id.mbtn_radiobutton:
                    intent = new Intent(MainActivity.this,RadioButtonActivity.class);
                    break;
                case R.id.mbtn_checkboxbutton:
                    intent = new Intent(MainActivity.this,CheckBoxAcitvity.class);
                    break;
                case R.id.mbtn_imageviewbutton:
                    intent = new Intent(MainActivity.this, ImageViewActivity.class);
                    break;
                case R.id.mbtn_listview:
                    intent = new Intent(MainActivity.this, ListViewActivity.class);
                    break;
                case R.id.mbtn_gridview:
                    intent = new Intent(MainActivity.this, GridViewActivity.class);
                    break;
                case R.id.mbtn_recyclerview:
                    intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}