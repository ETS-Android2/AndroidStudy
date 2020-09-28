package info.emperinter.study211;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MixRecyclerAdapter extends RecyclerView.Adapter< RecyclerView.ViewHolder > {

    private Context mContext;
//    private List<String> list;
    private OnItemClickListener mListener;

    public MixRecyclerAdapter(Context context, OnItemClickListener listener){
        this.mContext = context;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == 0){
            return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item,parent,false));
        }else {
            return new LinearViewHolder2(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item_2,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(getItemViewType(position) == 0){
            ((LinearViewHolder)holder).textView.setText("Hello World!");

        }else {
            ((LinearViewHolder2)holder).textView.setText("emperinter");
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mContext,"click---"+position,Toast.LENGTH_SHORT).show();//法一
                mListener.onClick(position);
            }
        });

    }

    public  int getItemViewType(int postion){
        if(postion%2 == 0){
            return 0;
        }else {
            return 1;
        }
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

    class  LinearViewHolder2 extends RecyclerView.ViewHolder{

        private TextView textView;
        private ImageView imageView;

        public LinearViewHolder2(View itemView){
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
            imageView = itemView.findViewById(R.id.iv_image);
        }
    }

    //定义一个接口
    public interface OnItemClickListener{
        void onClick(int pos);
    }

}
