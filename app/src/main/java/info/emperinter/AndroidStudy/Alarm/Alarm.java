package info.emperinter.AndroidStudy.Alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import info.emperinter.AndroidStudy.R;

import java.util.Calendar;

public class Alarm extends AppCompatActivity implements View.OnClickListener{

    private Button btn_set;
    private Button btn_cancel;
    private AlarmManager alarmManager;
    private PendingIntent pi;
    private LayoutInflater mLayoutInflater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm);
        bindViews();
    }

    private void bindViews() {
        btn_set = (Button) findViewById(R.id.btn_set);
        btn_cancel = (Button) findViewById(R.id.btn_cancel);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        Intent intent = new Intent(this, ClockActivity.class);
        pi = PendingIntent.getActivity(this, 0, intent, 0);

        btn_set.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_set:
                Calendar currentTime = Calendar.getInstance();
                new TimePickerDialog(Alarm.this, 0,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view,
                                                  int hourOfDay, int minute) {
                                //设置当前时间
                                Calendar c = Calendar.getInstance();
                                c.setTimeInMillis(System.currentTimeMillis());
                                // 根据用户选择的时间来设置Calendar对象
                                c.set(Calendar.HOUR, hourOfDay);
                                c.set(Calendar.MINUTE, minute);
                                c.set(Calendar.SECOND,0);
                                // ②设置AlarmManager在Calendar对应的时间启动Activity
//                                alarmManager.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pi);
                                Log.v("getTime",c.getTimeInMillis()+"");
                                //版本适配 System.currentTimeMillis()
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {// 6.0及以上
                                    alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,
                                            c.getTimeInMillis(), pi);
                                    Log.v("tag:",1+"");
                                } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {// 4.4及以上
                                    alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(),
                                            pi);
                                    Log.v("tag:",2+"");

                                } else {
                                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                                            c.getTimeInMillis(),10000, pi);
                                    Log.v("tag:",3+"");
                                }

                                Toast.makeText(Alarm.this, "闹钟已设置\n"+c.getTimeInMillis(), Toast.LENGTH_SHORT)
                                        .show();

                                Log.e("HEHE",c.getTimeInMillis()+"");   //这里的时间是一个unix时间戳
                                // 提示闹钟设置完毕:
                                Toast.makeText(Alarm.this, "闹钟设置完毕~"+ c.getTimeInMillis(),
                                        Toast.LENGTH_SHORT).show();
                            }
                        }, currentTime.get(Calendar.HOUR_OF_DAY), currentTime
                        .get(Calendar.MINUTE), false).show();
                btn_cancel.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_cancel:
                alarmManager.cancel(pi);
                btn_cancel.setVisibility(View.GONE);
                Toast.makeText(Alarm.this, "闹钟已取消", Toast.LENGTH_SHORT)
                        .show();
                break;
        }
    }
}