package info.emperinter.study211;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {
    private ImageView mIv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        mIv4 = (ImageView) findViewById(R.id.iv_4);

        Glide.with(this).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1601287681007&di=0c9fcf089ff4709ed2b81c7d65f549ba&imgtype=0&src=http%3A%2F%2Fimgo.zjjjtg.com%2Fimg2020%2F9%2F28%2F13%2F2020092810520733.jpg").into(mIv4);

    }


}