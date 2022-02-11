package info.emperinter.AndroidStudy.Alarm;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import info.emperinter.AndroidStudy.R;

/**
 * Created by Jay on 2015/10/25 0025.
 */
public class ClockActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
//        mediaPlayer = mediaPlayer.create(this,R.raw.pig);
//        mediaPlayer.start();
        //创建一个闹钟提醒的对话框,点击确定关闭铃声与页面
        Log.v("Colck","OJBK!");
        new AlertDialog.Builder(ClockActivity.this).setTitle("闹钟").setMessage("小猪小猪快起床~")
                .setPositiveButton("关闭闹铃", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        mediaPlayer.stop();
                        Log.v("Colck","Yes");
                        ClockActivity.this.finish();
                    }
                }).show();
    }
}