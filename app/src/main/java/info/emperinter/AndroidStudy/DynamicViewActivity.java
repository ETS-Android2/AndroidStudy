package info.emperinter.AndroidStudy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import info.emperinter.AndroidStudy.util.ToastUtil;

public class DynamicViewActivity extends AppCompatActivity {

    private LayoutInflater layoutInflater;
    private LinearLayout dynamiView;
    private int m; //用来设置id

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_view);


        //获取layoutInflater
        layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        dynamiView = (LinearLayout) findViewById(R.id.content_dynamic_view);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    final TextView textView = (TextView) layoutInflater.inflate(R.layout.dynamic_text_view,null);
                    textView.setText("动态布局生成！\n");
                    textView.setText(String.format("%s::hashCode %s\nID:%s", textView.getText(), textView.toString(), m));
                    textView.setId(m);
                    dynamiView.addView(textView);
                    m++;
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    public void DynamicShow(final View view){
        ToastUtil.showMsg(DynamicViewActivity.this,"Oppos~"+view.getId());
        try{
            dynamiView.removeView(view);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}