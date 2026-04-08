package top.niunaijun.blackboxa.view.main;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class PredictorView extends View {
    private Paint paint;

    public PredictorView(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.CYAN); // Синият цвят на Samurai
        paint.setStrokeWidth(8f);   // Дебелина на линията
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        
        // ТОВА СА ТЕСТОВИТЕ ЛИНИИ
        // По-късно ще ги свържем с координатите от играта
        canvas.drawLine(100, 500, 500, 500, paint); // Хоризонтална
        canvas.drawLine(500, 500, 800, 200, paint); // Отскок
    }
}

