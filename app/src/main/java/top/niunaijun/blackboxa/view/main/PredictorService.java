package top.niunaijun.blackboxa.view.main;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.Gravity;
import android.view.WindowManager;
import android.content.Context;

public class PredictorService extends Service {
    private WindowManager windowManager;
    private PredictorView predictorView;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

        // Създаваме нашето платно за чертане
        predictorView = new PredictorView(this);

        // Настройки за Overlay (важно за Android 12)
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                PixelFormat.TRANSLUCENT);

        params.gravity = Gravity.TOP | Gravity.LEFT;
        windowManager.addView(predictorView, params);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (predictorView != null) windowManager.removeView(predictorView);
    }
}

