package info.emperinter.AndroidStudy.BackGround;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import info.emperinter.AndroidStudy.R;

public class BackGroundActivity extends AppCompatActivity {
    private Button startForBtn,StarForWithOutNotificationBtn,OnePxBtn,PlayNoSoundBtn;
    private Intent startFordIntent,StarForWithOutNotificationIntent,OnePxIntent,PlayNoSoundIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.background_activity);

        startFordIntent = new Intent(this,BackGround_StartForeGround.class);

        startForBtn = findViewById(R.id.start_ford_btn);

        startForBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    startForegroundService(startFordIntent);
                } else {
                    startService(startFordIntent);
                }

            }
        });

        StarForWithOutNotificationIntent = new Intent(this,BackGround_StartForeGround_WithOut_Notification_Bar.class);
        StarForWithOutNotificationBtn = findViewById(R.id.start_ford_without_notification_btn);
        StarForWithOutNotificationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    startForegroundService(StarForWithOutNotificationIntent);
                } else {
                    startService(StarForWithOutNotificationIntent);
                }

            }
        });


        OnePxIntent = new Intent(this,BackGround_StartForeGround_WithOut_Notification_Bar.class);
        OnePxBtn = findViewById(R.id.OnePxBtn);
        OnePxBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startService(OnePxIntent);
            }
        });
        Intent intent = new Intent(this, PlayerMusicService.class);
        startService(intent);

        PlayNoSoundIntent = new Intent(this,PlayerMusicService.class);
        PlayNoSoundBtn = findViewById(R.id.PlayNoSoundBtn);
        PlayNoSoundBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(PlayNoSoundIntent);
            }
        });
    }
}
