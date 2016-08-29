package org.bpmikc.akm.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import java.text.DecimalFormat;
import org.bpmikc.akm.C0615R;

public class QiblaCompassView extends View {
    private TextView bearingNorth;
    private String bearingNorthString;
    private TextView bearingQibla;
    private String bearingQiblaString;
    private float centre_x;
    private float centre_y;
    private Bitmap compassBackground;
    private Bitmap compassNeedle;
    private DecimalFormat df;
    private float directionNorth;
    private float directionQibla;
    private int height;
    private Paint paint;
    private Matrix rotateNeedle;
    private int width;

    public QiblaCompassView(Context context) {
        super(context);
        this.directionNorth = 0.0f;
        this.directionQibla = 0.0f;
        this.df = new DecimalFormat("0.000");
        this.rotateNeedle = new Matrix();
        this.width = 240;
        this.height = 240;
        this.centre_x = ((float) this.width) * 0.5f;
        this.centre_y = ((float) this.height) * 0.5f;
        this.paint = new Paint();
        initCompassView();
    }

    public QiblaCompassView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.directionNorth = 0.0f;
        this.directionQibla = 0.0f;
        this.df = new DecimalFormat("0.000");
        this.rotateNeedle = new Matrix();
        this.width = 240;
        this.height = 240;
        this.centre_x = ((float) this.width) * 0.5f;
        this.centre_y = ((float) this.height) * 0.5f;
        this.paint = new Paint();
        initCompassView();
    }

    public QiblaCompassView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.directionNorth = 0.0f;
        this.directionQibla = 0.0f;
        this.df = new DecimalFormat("0.000");
        this.rotateNeedle = new Matrix();
        this.width = 240;
        this.height = 240;
        this.centre_x = ((float) this.width) * 0.5f;
        this.centre_y = ((float) this.height) * 0.5f;
        this.paint = new Paint();
        initCompassView();
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(this.width, this.height);
    }

    private void initCompassView() {
        this.compassNeedle = BitmapFactory.decodeResource(getResources(), C0615R.drawable.compass_needle);
        this.compassBackground = BitmapFactory.decodeResource(getResources(), C0615R.drawable.compass_background);
        this.width = getWidth(this.compassBackground, 240);
        this.height = getHeight(this.compassBackground, 240);
        this.centre_x = ((float) this.width) * 0.5f;
        this.centre_y = ((float) this.height) * 0.5f;
        this.rotateNeedle.postTranslate((this.centre_x - ((float) getWidth(this.compassNeedle, 23))) + 10.0f, (this.centre_y - ((float) getHeight(this.compassNeedle, 142))) + 10.0f);
        invalidate();
    }

    public void setConstants(TextView bearingNorth, CharSequence bearingNorthString, TextView bearingQibla, CharSequence bearingQiblaString) {
        this.bearingNorth = bearingNorth;
        this.bearingNorthString = bearingNorthString.toString();
        this.bearingQibla = bearingQibla;
        this.bearingQiblaString = bearingQiblaString.toString();
        this.compassBackground = BitmapFactory.decodeResource(getResources(), C0615R.drawable.compass_background);
        this.compassNeedle = BitmapFactory.decodeResource(getResources(), C0615R.drawable.compass_needle);
    }

    public void setDirections(float directionNorth, float directionQibla) {
        this.directionNorth = directionNorth;
        this.directionQibla = directionQibla;
        this.rotateNeedle = new Matrix();
        this.rotateNeedle.postRotate(-directionQibla, ((float) getWidth(this.compassNeedle, 23)) * 0.5f, (float) getHeight(this.compassNeedle, 142));
        this.rotateNeedle.postTranslate(this.centre_x - ((float) getWidth(this.compassNeedle, 23)), (this.centre_y - ((float) getHeight(this.compassNeedle, 142))) + 5.0f);
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        this.bearingNorth.setText(this.bearingNorthString.replace("(1)", this.df.format((double) this.directionNorth)));
        this.bearingQibla.setText(this.bearingQiblaString.replace("(+/-)", this.directionQibla >= 0.0f ? " +" : " -").replace("(2)", this.df.format((double) Math.abs(this.directionQibla))).replace("(3)", this.df.format((double) (this.directionNorth + this.directionQibla))));
        canvas.rotate(-this.directionNorth, this.centre_x, this.centre_y);
        canvas.drawBitmap(this.compassBackground, 0.0f, 0.0f, this.paint);
        canvas.drawBitmap(this.compassNeedle, this.rotateNeedle, this.paint);
    }

    private int getHeight(Bitmap bitmap, int def) {
        return isInEditMode() ? def : bitmap.getHeight();
    }

    private int getWidth(Bitmap bitmap, int def) {
        return isInEditMode() ? def : bitmap.getWidth();
    }
}
