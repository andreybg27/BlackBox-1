package top.niunaijun.blackboxa.view.main;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import top.niunaijun.blackboxa.R;

public class PredictorService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        String CHANNEL_ID = "blackbox_predictor";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,
                    "Predictor Service", NotificationManager.IMPORTANCE_LOW);
            getSystemService(NotificationManager.class).createNotificationChannel(channel);
            Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setContentTitle("BlackBox Aim")
                    .setContentText("Lines are active")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .build();
            startForeground(1, notification);
        }
        
        // Тук се добавя визуалната част
        PredictorView predictorView = new PredictorView(this);
        predictorView.addToWindowManager();
    }

    @Override
    public IBinder onBind(Intent intent) { return null; }
}
