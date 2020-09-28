package info.emperinter.study211;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {
    private Button mBtn3;
    private TextView mTxt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        mBtn3 = (Button) findViewById(R.id.btn_3);
        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this,"Button 3 被点击了！",Toast.LENGTH_SHORT).show();
            }
        });

        mTxt1 = (TextView) findViewById(R.id.tv_1);

        mTxt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this,"TextView 1 被点击了！",Toast.LENGTH_SHORT).show();
            }
        });


    }

    public  void  showToast(View view){
        Toast.makeText(this,"Button 4 被点击了！",Toast.LENGTH_SHORT).show();//Toast.Len  代表长度
    }
}