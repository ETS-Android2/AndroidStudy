package info.emperinter.AndroidStudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import info.emperinter.AndroidStudy.GridView.GridViewActivity;
import info.emperinter.AndroidStudy.ListView.ListViewActivity;
import info.emperinter.AndroidStudy.RecyclerView.RecyclerViewActivity;
import info.emperinter.AndroidStudy.jump.AActivity;

public class UIActivity extends AppCompatActivity {

    private Button mBtnTextView;
    private Button nButton;
    private Button mBtnEditText;
    private Button mBtnRadionButton;
    private Button mBtnCheck;
    private Button mBtnImg;
    private Button mBtnListV;
    private Button mBtnGridV;
    private Button mBtnRecycleV;
    private Button mBtnWebV;
    private Button mBtnToast;
    private Button mBtnDialog;
    private Button mBtnProgress;
    private Button mBtnCustomeDialog;
    private Button mBtnPopUpWindow;
    private Button mBtnLifeCycle;
    private Button mBtnJump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);

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
        mBtnWebV = (Button) findViewById(R.id.mbtn_webview);
        mBtnToast = (Button) findViewById(R.id.mbtn_toast);
        mBtnDialog = findViewById(R.id.mbtn_dialog);
        mBtnProgress = findViewById(R.id.mbtn_progress);
        mBtnCustomeDialog = findViewById(R.id.mbtn_custome_dialog);
        mBtnPopUpWindow = findViewById(R.id.mbtn_popup_window);
        mBtnLifeCycle = findViewById(R.id.mbtn_lifecycle);
        mBtnJump = findViewById(R.id.mbtn_jump);
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
        mBtnWebV.setOnClickListener(onClick);
        mBtnToast.setOnClickListener(onClick);
        mBtnDialog.setOnClickListener(onClick);
        mBtnProgress.setOnClickListener(onClick);
        mBtnCustomeDialog.setOnClickListener(onClick);
        mBtnPopUpWindow.setOnClickListener(onClick);
        mBtnLifeCycle.setOnClickListener(onClick);
        mBtnJump.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener{
        public void onClick(View v){
            Intent intent = null;
            switch (v.getId()){
                case R.id.mbtn_edittext:
                    intent = new Intent(UIActivity.this, TextViewActivity.class);
                    break;
                case R.id.btn_button:
                    intent = new Intent(UIActivity.this, ButtonActivity.class);
                    break;
                case R.id.mbtn_textview:
                    intent = new Intent(UIActivity.this,TextViewActivity.class);
                    break;
                case R.id.mbtn_radiobutton:
                    intent = new Intent(UIActivity.this,RadioButtonActivity.class);
                    break;
                case R.id.mbtn_checkboxbutton:
                    intent = new Intent(UIActivity.this, CheckBoxAcitvity.class);
                    break;
                case R.id.mbtn_imageviewbutton:
                    intent = new Intent(UIActivity.this, ImageViewActivity.class);
                    break;
                case R.id.mbtn_listview:
                    intent = new Intent(UIActivity.this, ListViewActivity.class);
                    break;
                case R.id.mbtn_gridview:
                    intent = new Intent(UIActivity.this, GridViewActivity.class);
                    break;
                case R.id.mbtn_recyclerview:
                    intent = new Intent(UIActivity.this, RecyclerViewActivity.class);
                    break;
                case R.id.mbtn_webview:
                    intent = new Intent(UIActivity.this, WebViewActivity.class);
                    break;
                case R.id.mbtn_toast:
                    intent = new Intent(UIActivity.this, ToastActivity.class);
                    break;
                case R.id.mbtn_dialog:
                    intent = new Intent(UIActivity.this, DialogActivity.class);
                    break;
                case R.id.mbtn_progress:
                    intent = new Intent(UIActivity.this,ProgressActivity.class);
                    break;
                case R.id.mbtn_custome_dialog:
                    intent = new Intent(UIActivity.this,CustomDialogActivity.class);
                    break;
                case R.id.mbtn_popup_window:
                    intent = new Intent(UIActivity.this,PopupWindowActivity.class);
                    break;
                case R.id.mbtn_lifecycle:
                    intent = new Intent(UIActivity.this,LifeCycleActivity.class);
                    break;
                case R.id.mbtn_jump:
                    intent = new Intent(UIActivity.this, AActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}