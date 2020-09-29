package info.emperinter.AndroidStudy.RecyclerView;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import info.emperinter.AndroidStudy.R;

public class MixRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mix_recycler_view);

        mRvMain = (RecyclerView) findViewById(R.id.rv_main);

        mRvMain.setLayoutManager(new LinearLayoutManager(MixRecyclerViewActivity.this));
        mRvMain.addItemDecoration(new MyDecoration());//用来实现分隔线；
//        mRvMain.setAdapter(new LinearAdapter(LinearRecyclerViewActivity.this));//法一
        mRvMain.setAdapter(new MixRecyclerAdapter(MixRecyclerViewActivity.this, new MixRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(MixRecyclerViewActivity.this,"click"+pos,Toast.LENGTH_SHORT).show();
            }
        }));
    }

    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.divideHeight));//1dp高度分隔线
        }
    }

    public static class HorAdapter extends RecyclerView.Adapter<HorAdapter.LinearViewHolder> {

        private Context mContext;
    //    private List<String> list;
        private OnItemClickListener mListener;

        public HorAdapter(Context context, OnItemClickListener listener){
            this.mContext = context;
            this.mListener = listener;
        }

        @NonNull
        @Override
        public LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_hor_item,parent,false));
        }

        @Override
        public void onBindViewHolder(LinearViewHolder holder, final int position) {
            holder.textView.setText("Hello");
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
    //                Toast.makeText(mContext,"click---"+position,Toast.LENGTH_SHORT).show();//法一
                    mListener.onClick(position);
                }
            });
        }

        @Override
        public int getItemCount() {   //列表长度
            return 30;
        }

        class  LinearViewHolder extends RecyclerView.ViewHolder{

            private TextView textView;

            public LinearViewHolder(View itemView){
                super(itemView);
                textView = itemView.findViewById(R.id.tv_title);
            }
        }

        //定义一个接口
        public interface OnItemClickListener{
            void onClick(int pos);
        }

    }

    public static class HorRecyclerViewActivity extends AppCompatActivity {

        private RecyclerView mRvHor;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_hor_recycler_view);
            mRvHor = findViewById(R.id.rv_hor);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HorRecyclerViewActivity.this);
            mRvHor.addItemDecoration(new MyDecoration());//用来实现分隔线；
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);//水平的
            mRvHor.setLayoutManager(linearLayoutManager);
            mRvHor.setAdapter(new HorAdapter(HorRecyclerViewActivity.this, new HorAdapter.OnItemClickListener() {
                @Override
                public void onClick(int pos) {
                    Toast.makeText(HorRecyclerViewActivity.this,"Click:" + pos,Toast.LENGTH_SHORT).show();
                }
            }));
        }

        class MyDecoration extends RecyclerView.ItemDecoration{
            //撑开间距，露出底色！
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(0,0,getResources().getDimensionPixelOffset(R.dimen.divideHeight),0);//1dp高度分隔线
            }
        }
    }
}