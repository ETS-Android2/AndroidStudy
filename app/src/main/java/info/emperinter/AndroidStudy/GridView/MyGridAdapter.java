package info.emperinter.AndroidStudy.GridView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import info.emperinter.AndroidStudy.R;

public class MyGridAdapter extends BaseAdapter {
    private Context mContent;
    private LayoutInflater mLayoutInflater;

    public MyGridAdapter(Context context){
        this.mContent = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder{
        public ImageView imageView;
        public TextView textView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.layout_grid_item,null);
            holder = new ViewHolder();
            holder.imageView =(ImageView) convertView.findViewById(R.id.iv_grid);
            holder.textView =(TextView) convertView.findViewById(R.id.tv_title);
            convertView.setTag(holder);
        }else{
            holder =(ViewHolder) convertView.getTag();

        }

        //赋值
        holder.textView.setText("花");
        Glide.with(mContent).load("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3954276717,2722978206&fm=26&gp=0.jpg").into(holder.imageView);

        return convertView;
    }
}
