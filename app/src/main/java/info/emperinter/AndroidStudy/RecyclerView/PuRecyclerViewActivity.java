package info.emperinter.AndroidStudy.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.View;
import android.widget.Toast;

import info.emperinter.AndroidStudy.R;

public class PuRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRvPu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pu_recycler_view);
        mRvPu = findViewById(R.id.rv_pu);
        mRvPu.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        mRvPu.addItemDecoration(new MyDecoration());
        mRvPu.setAdapter(new MixRecyclerAdapter.StaggereGridAdapter(PuRecyclerViewActivity.this, new MixRecyclerAdapter.StaggereGridAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(PuRecyclerViewActivity.this,"Click"+pos,Toast.LENGTH_SHORT).show();
            }
        }));

    }

    class  MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int gap = getResources().getDimensionPixelOffset(R.dimen.divideHeight1);
            outRect.set(gap,gap,gap,gap);
        }
    }
}