package info.emperinter.AndroidStudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckBoxAcitvity extends AppCompatActivity {

    private CheckBox mCb5,mCb6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box_acitvity);

        mCb5 = (CheckBox) findViewById(R.id.cb_5);
        mCb6 = (CheckBox) findViewById(R.id.cb_6);

        mCb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxAcitvity.this,isChecked?"5 选中":"5 未选中",Toast.LENGTH_SHORT).show();
            }
        });

        mCb6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxAcitvity.this,isChecked?"6 选中":"6 未选中",Toast.LENGTH_SHORT).show();
            }
        });
    }
}