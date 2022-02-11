package info.emperinter.AndroidStudy.BackGround;

import android.annotation.SuppressLint;
import android.app.*;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import info.emperinter.AndroidStudy.R;

public class BackGround_StartForeGround extends Service {

    public static final int NOTICE_ID = 100;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("LongLogTag")
    @Override
    public void onCreate() {
        super.onCreate();

        Log.v("BackGround_StartForeGround", "DaemonService---->onCreate被调用，启动前台service");
        //如果API大于18，需要弹出一个可见通知
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            String CHANNEL_ONE_ID = "info.emperinter.info";
            String CHANNEL_ONE_NAME = "Channel One";
            NotificationChannel notificationChannel = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                notificationChannel = new NotificationChannel(CHANNEL_ONE_ID,
                        CHANNEL_ONE_NAME, NotificationManager.IMPORTANCE_HIGH);
                notificationChannel.enableLights(true);
                notificationChannel.setLightColor(Color.RED);
                notificationChannel.setShowBadge(true);
                notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                manager.createNotificationChannel(notificationChannel);
            }

            Intent intent = new Intent(this, BackGroundActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            Notification notification = new Notification.Builder(this).setChannelId(CHANNEL_ONE_ID)
                    .setSmallIcon(R.drawable.smile)
                    .setContentTitle("BackGround_StartForeGround")
                    .setContentIntent(pendingIntent)
                    .getNotification();
                    notification.flags |= Notification.FLAG_NO_CLEAR;
            startForeground(NOTICE_ID, notification);
        } else {
            startForeground(NOTICE_ID, new Notification());
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 如果Service被终止，当资源允许情况下，重启service
        return START_STICKY;
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onDestroy() {
        super.onDestroy();

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
//            NotificationManager mManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//            mManager.cancel(NOTICE_ID);
//        }

        Log.v("BackGround_StartForeGround", "DaemonService---->onDestroy，前台service被杀死");
        // 重启自己
        Intent intent = new Intent(getApplicationContext(), BackGround_StartForeGround.class);
        startService(intent);
    }

    public void ShowNotification(){

    }
}
