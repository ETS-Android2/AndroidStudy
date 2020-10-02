package info.emperinter.AndroidStudy.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import info.emperinter.AndroidStudy.R;

public class DataStorageActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnSharedPreferences,mBtnFile,mBtnFileOutSide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);

        mBtnSharedPreferences = (Button) findViewById(R.id.btn_sharedpreferences);
        mBtnFile = (Button) findViewById(R.id.btn_file);
        mBtnFileOutSide = (Button) findViewById(R.id.btn_file_outside);

        mBtnSharedPreferences.setOnClickListener(this);
        mBtnFile.setOnClickListener(this);
        mBtnFileOutSide.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.btn_sharedpreferences:
                intent = new Intent(DataStorageActivity.this,SharedPreferencesActivity.class);
                break;
            case R.id.btn_file:
                intent = new Intent(DataStorageActivity.this,FileActivity.class);
                break;
            case R.id.btn_file_outside:
                intent = new Intent(DataStorageActivity.this,FileOutSideActivity.class);
                break;
        }

        startActivity(intent);
    }
}