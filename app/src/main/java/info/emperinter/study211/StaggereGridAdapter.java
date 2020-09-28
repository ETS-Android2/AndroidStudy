package info.emperinter.study211;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StaggereGridAdapter extends RecyclerView.Adapter<StaggereGridAdapter.LinearViewHolder> {

    private Context mContext;
//    private List<String> list;
    private OnItemClickListener mListener;

    public StaggereGridAdapter(Context context, OnItemClickListener listener){
        this.mContext = context;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public StaggereGridAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_staggered_grid_recyclerview_item,parent,false));
    }

    @Override
    public void onBindViewHolder(StaggereGridAdapter.LinearViewHolder holder, final int position) {
        if( position%2 != 0){
            holder.imageView.setImageResource(R.mipmap.niginl);
        }else {
            holder.imageView.setImageResource(R.mipmap.lover_foreground);
        }

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
        private ImageView imageView;

        public LinearViewHolder(View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.iv);
        }
    }

    //定义一个接口
    public interface OnItemClickListener{
        void onClick(int pos);
    }

}
