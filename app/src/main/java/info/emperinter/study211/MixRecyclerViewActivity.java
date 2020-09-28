package info.emperinter.study211;

import android.graphics.Rect;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Toast;

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

}