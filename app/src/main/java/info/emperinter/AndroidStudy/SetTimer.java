package info.emperinter.AndroidStudy;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class SetTimer extends AppCompatActivity {
    static int count = 0;
    private TextView textView = null;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_timer);
        textView = findViewById(R.id.textView);
        showTimer();
    }

    public void showTimer() {

        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                ++count;
                System.out.println("时间=" + new Date() + " 执行了" + count + "次"); // 1次
                textView.setText("时间=" + new Date() + " 执行了" + count + "次");
            }
        };

        //设置执行时间
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);//每天
        //定制每天的21:09:00执行，
        calendar.set(year, month, day, 23, 03, 00);
        Date date = calendar.getTime();
        Timer timer = new Timer();
//        System.out.println(date);
        Log.v("timer",date + "\t");

        int period = 2 * 1000;
        //每天的date时刻执行task，每隔2秒重复执行
        timer.schedule(task, date, period);
        //每天的date时刻执行task, 仅执行一次
        //timer.schedule(task, date);
    }

}
