package info.emperinter.AndroidStudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import info.emperinter.AndroidStudy.util.ToastUtil;

public class PopupWindowActivity extends AppCompatActivity {

    private Button mBtnPop;
    private PopupWindow mPop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);

        mBtnPop = (Button) findViewById(R.id.btn_pop);

        mBtnPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.layout_pop,null);
                TextView textView = view.findViewById(R.id.tv_good);

                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPop.dismiss();//消失
                        ToastUtil.showMsg(PopupWindowActivity.this,"好！");
                    }
                });
                //其它点击事件同上

                mPop = new PopupWindow(view,mBtnPop.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
                mPop.setOutsideTouchable(true);   //点击外部收回pop
                mPop.setFocusable(true); //再次点击消失
                //可以设置动画,动画文件xml
//                mPop.setAnimationStyle();
                mPop.showAsDropDown(mBtnPop);
//                mPop.showAtLocation();
            }
        });
    }
}