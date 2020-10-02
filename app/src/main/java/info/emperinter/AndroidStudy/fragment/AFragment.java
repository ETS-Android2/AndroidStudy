package info.emperinter.AndroidStudy.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import info.emperinter.AndroidStudy.R;

public class AFragment extends Fragment{

    private TextView mTvTitle;
    private Activity mActivity;
    private Button mBtnChange,mBtnReset,mBtnMessage;
    private BFragment bFragment;
    private  IOnMessageClick listener;//申明接口

    //传参
    public static  AFragment newInstance(String title){
        AFragment fragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title",title);
        fragment.setArguments(bundle);
        return fragment;
    }

    //声明接口，给Activity传参！在ContainerActivity实现该接口！
    public interface IOnMessageClick{
        void onClick(String text);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a,container,false);  //设置布局文件
//        return super.onCreateView(inflater, container, savedInstanceState);
        Log.d("AFragment","-----onCreateView-----");
        return  view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTvTitle = (TextView) view.findViewById(R.id.tv_title);
//        if(getActivity() != null){
//                //To Do
//        }else {
//
//        }

        mBtnChange = (Button) view.findViewById(R.id.btn_change);
        mBtnReset = (Button) view.findViewById(R.id.btn_reset);
        mBtnMessage = (Button) view.findViewById(R.id.btn_message);


        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bFragment == null){
                    bFragment = new BFragment();
                }
//                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,bFragment).commitAllowingStateLoss();
//                getFragmentManager().beginTransaction().replace(R.id.fl_container,bFragment).commitAllowingStateLoss();


                //按返回键不直接跳到上一个Activity，回退栈
                //getFragmentManager().beginTransaction().replace(R.id.fl_container,bFragment).addToBackStack(null).commitAllowingStateLoss();

                //按返回键上一个状态保持原样！Tag:"a"在ContainerActivity中设置;
                Fragment fragment = getFragmentManager().findFragmentByTag("a");
                if(fragment != null){
                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_container,bFragment).addToBackStack(null).commitAllowingStateLoss();
                }else {
                    getFragmentManager().beginTransaction().replace(R.id.fl_container,bFragment).addToBackStack(null).commitAllowingStateLoss();
                }

            }
        });

        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvTitle.setText("I'm New One!");
            }
        });


        mBtnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //给Activity传参！
                // 不推荐
//                ((ContainerActivity) getActivity()).setData("你好！");

                listener.onClick("你好！");//调用接口！
            }
        });

        if(getArguments() != null){
            mTvTitle.setText(getArguments().getString("title"));  //获取传递的参数；
        }



    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        mActivity = (Activity) context;
        try{
            listener = (IOnMessageClick) context;   //给Activity传参
        }catch (ClassCastException ex){
            throw  new ClassCastException("Activity 必须实现IOnMessageClick 接口!");
        }

    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //取消异步
    }
}
