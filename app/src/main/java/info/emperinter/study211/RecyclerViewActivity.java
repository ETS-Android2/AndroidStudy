package info.emperinter.study211;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;

public class RecyclerViewActivity extends AppCompatActivity {

    private Button mBtnLinear,mBtnHor,mBtnGrid,mBtnPu,mBtnDifferent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        mBtnLinear = (Button) findViewById(R.id.btn_linear);
        mBtnHor = (Button) findViewById(R.id.btn_hor);
        mBtnGrid = findViewById(R.id.btn_grid);
        mBtnPu = findViewById(R.id.btn_pu);
        mBtnDifferent = findViewById(R.id.btn_different);


        mBtnLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this,LinearRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        mBtnHor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this, HorRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        mBtnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this,GridRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        mBtnPu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this,PuRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        mBtnDifferent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this,MixRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
    }
}