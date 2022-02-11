package info.emperinter.AndroidStudy.BackGround;


import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.Nullable;
import info.emperinter.AndroidStudy.R;

public class PlayerMusicService extends Service {
    private final static String TAG = PlayerMusicService.class.getSimpleName();
    private MediaPlayer mMediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.v(TAG, TAG + "---->onCreate,启动服务");
        //无声音乐
        mMediaPlayer = MediaPlayer.create(getApplicationContext(), R.id.aa);
        mMediaPlayer.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                startPlayMusic();
            }
        }).start();
        return START_STICKY;
    }

    private void startPlayMusic() {
        if (mMediaPlayer != null) {
            Log.v(TAG, "启动后台播放音乐");
            mMediaPlayer.start();
        }
    }

    private void stopPlayMusic() {
        if (mMediaPlayer != null) {
            Log.v(TAG, "关闭后台播放音乐");
            mMediaPlayer.stop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopPlayMusic();
        Log.v(TAG, TAG + "---->onCreate,停止服务");
        // 重启
        Intent intent = new Intent(getApplicationContext(), PlayerMusicService.class);
        startService(intent);
    }
}
