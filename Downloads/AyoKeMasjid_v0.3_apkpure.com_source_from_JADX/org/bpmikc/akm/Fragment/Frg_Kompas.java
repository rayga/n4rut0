package org.bpmikc.akm.Fragment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.internal.view.SupportMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import org.bpmikc.akm.C0615R;

public class Frg_Kompas extends Fragment {
    private static final String TAG = "Compass";
    Handler handler;
    private SampleView kiblat;
    private double latMosque;
    private LocationManager lm;
    private LocationListener locListenD;
    private double lonMosque;
    private float[] mGravity;
    private final SensorEventListener mListener;
    private Sensor mSensor;
    private SensorManager mSensorManager;
    private float[] mValues;
    Runnable timedTask;

    /* renamed from: org.bpmikc.akm.Fragment.Frg_Kompas.1 */
    class C05751 implements SensorEventListener {
        C05751() {
        }

        public void onSensorChanged(SensorEvent event) {
            if (event.accuracy == 3) {
                Frg_Kompas.this.mValues = event.values;
                Frg_Kompas.this.mGravity = Frg_Kompas.this.mValues;
            } else {
                Frg_Kompas.this.mValues = Frg_Kompas.this.mGravity;
            }
            if (Frg_Kompas.this.kiblat != null) {
                Frg_Kompas.this.kiblat.invalidate();
            }
        }

        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    }

    /* renamed from: org.bpmikc.akm.Fragment.Frg_Kompas.2 */
    class C05762 implements Runnable {
        C05762() {
        }

        public void run() {
            Toast.makeText(Frg_Kompas.this.getActivity(), "Refresh Kompas", 1).show();
            Frg_Kompas.this.handler.postDelayed(Frg_Kompas.this.timedTask, 10000);
        }
    }

    private class DispLocListener implements LocationListener {
        private DispLocListener() {
        }

        public void onLocationChanged(Location loc) {
            Frg_Kompas.this.latMosque = loc.getLatitude();
            Frg_Kompas.this.lonMosque = loc.getLongitude();
        }

        public void onProviderDisabled(String provider) {
        }

        public void onProviderEnabled(String provider) {
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
        }
    }

    private class SampleView extends View {
        private boolean mAnimate;
        private Paint mPaint;
        private Path mPath;

        public SampleView(Context context) {
            super(context);
            this.mPaint = new Paint();
            this.mPath = new Path();
            this.mPath.moveTo(0.0f, -100.0f);
            this.mPath.lineTo(20.0f, BitmapDescriptorFactory.HUE_GREEN);
            this.mPath.lineTo(0.0f, 100.0f);
            this.mPath.lineTo(-20.0f, BitmapDescriptorFactory.HUE_GREEN);
            this.mPath.close();
        }

        protected void onDraw(Canvas canvas) {
            Paint paint = this.mPaint;
            setBackgroundResource(C0615R.drawable.compass);
            paint.setAntiAlias(true);
            paint.setColor(SupportMenu.CATEGORY_MASK);
            paint.setStyle(Style.FILL_AND_STROKE);
            float Qibla = (float) Frg_Kompas.this.QiblaCount(Frg_Kompas.this.lonMosque, Frg_Kompas.this.latMosque);
            canvas.translate((float) (canvas.getWidth() / 2), (float) (canvas.getHeight() / 2));
            if (Frg_Kompas.this.mValues != null) {
                canvas.rotate(-(Frg_Kompas.this.mValues[0] + Qibla));
            }
            canvas.drawPath(this.mPath, this.mPaint);
        }

        protected void onAttachedToWindow() {
            this.mAnimate = true;
            super.onAttachedToWindow();
        }

        protected void onDetachedFromWindow() {
            this.mAnimate = false;
            super.onDetachedFromWindow();
        }
    }

    class myikc extends AsyncTask<String, String, String> {
        myikc() {
        }

        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected String doInBackground(String... args) {
            return null;
        }

        protected void onPostExecute(String file_url) {
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(C0615R.menu.menu_compass, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Bundle bundle;
        FragmentTransaction transaction;
        switch (item.getItemId()) {
            case C0615R.id.action_compass_refresh:
                bundle = new Bundle();
                transaction = getFragmentManager().beginTransaction();
                transaction.replace(C0615R.id.main_activity_content_frame, newInstance(bundle));
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case C0615R.id.action_compass_muazzin:
                bundle = new Bundle();
                transaction = getFragmentManager().beginTransaction();
                transaction.replace(C0615R.id.main_activity_content_frame, Frg_Kompas_Muazzin.newInstance(bundle));
                transaction.addToBackStack(null);
                transaction.commit();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private double QiblaCount(double lngMasjid, double latMasjid) {
        double lKlM = 39.82616111d - lngMasjid;
        double sinLKLM = Math.sin(((2.0d * lKlM) * 3.141592653589793d) / 360.0d);
        double cosLKLM = Math.cos(((2.0d * lKlM) * 3.141592653589793d) / 360.0d);
        double d = sinLKLM;
        double Qibla = (Math.atan2(d, (Math.cos(((2.0d * latMasjid) * 3.141592653589793d) / 360.0d) * Math.tan(((2.0d * 21.42250833d) * 3.141592653589793d) / 360.0d)) - (Math.sin(((2.0d * latMasjid) * 3.141592653589793d) / 360.0d) * cosLKLM)) * 180.0d) / 3.141592653589793d;
        if (Qibla < 0.0d) {
            return Qibla + 360.0d;
        }
        return Qibla;
    }

    public void onResume() {
        super.onResume();
        this.mSensorManager.registerListener(this.mListener, this.mSensor, 1);
    }

    public void onStop() {
        this.mSensorManager.unregisterListener(this.mListener);
        super.onStop();
    }

    public Frg_Kompas() {
        this.handler = new Handler();
        this.mListener = new C05751();
        this.timedTask = new C05762();
    }

    public static Frg_Kompas newInstance(Bundle bundle) {
        Frg_Kompas fragment = new Frg_Kompas();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle icicle) {
        super.onCreate(icicle);
        this.mSensorManager = (SensorManager) getActivity().getSystemService("sensor");
        this.mSensor = this.mSensorManager.getDefaultSensor(3);
        this.kiblat = new SampleView(getActivity());
        LocationManager lm = (LocationManager) getActivity().getSystemService("location");
        Location loc = lm.getLastKnownLocation("gps");
        this.locListenD = new DispLocListener();
        lm.requestLocationUpdates("gps", 30000, 10.0f, this.locListenD);
        this.locListenD = new DispLocListener();
        lm.requestLocationUpdates("gps", 30000, 10.0f, this.locListenD);
        return this.kiblat;
    }
}
