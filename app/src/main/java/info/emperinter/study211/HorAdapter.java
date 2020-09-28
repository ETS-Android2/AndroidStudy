package info.emperinter.study211;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HorAdapter extends RecyclerView.Adapter<HorAdapter.LinearViewHolder> {

    private Context mContext;
//    private List<String> list;
    private OnItemClickListener mListener;

    public HorAdapter(Context context, OnItemClickListener listener){
        this.mContext = context;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public HorAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_hor_item,parent,false));
    }

    @Override
    public void onBindViewHolder(HorAdapter.LinearViewHolder holder, final int position) {
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
