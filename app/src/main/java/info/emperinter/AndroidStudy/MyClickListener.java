package info.emperinter.AndroidStudy;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import info.emperinter.AndroidStudy.util.ToastUtil;

public class MyClickListener implements View.OnClickListener {

    private  Activity mActivity;

    //构造方法
    public MyClickListener(Activity activity){
        this.mActivity = activity;
    }

    @Override
    public void onClick(View v) {
        Log.d("外部类实现","click\n\n\n");
        ToastUtil.showMsg(mActivity,"Click 。。。。");
    }
}
