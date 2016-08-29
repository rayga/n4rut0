package org.bpmikc.akm.Fragment;

import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import net.sourceforge.jitl.Jitl;
import net.sourceforge.jitl.astro.Direction;
import net.sourceforge.jitl.astro.Dms;
import net.sourceforge.jitl.astro.Location;
import org.bpmikc.akm.C0615R;
import org.bpmikc.akm.Dialog.CalculationSettingsDialog;
import org.bpmikc.akm.View.QiblaCompassView;
import org.bpmikc.akm.Widget.Preferences;

public class Frg_Kompas_Muazzin extends Fragment {
    private static final String PATTERN = "#.###";
    private static final String TAG;
    private static float dlat;
    private static float dlon;
    private static boolean isTrackingOrientation;
    private static double kiblat;
    private static DecimalFormat sDecimalFormat;
    private static SensorListener sOrientationListener;
    private static float sQiblaDirection;
    private static SensorManager sSensorManager;

    /* renamed from: org.bpmikc.akm.Fragment.Frg_Kompas_Muazzin.1 */
    class C05771 implements SensorListener {
        final /* synthetic */ QiblaCompassView val$qiblaCompassView;

        C05771(QiblaCompassView qiblaCompassView) {
            this.val$qiblaCompassView = qiblaCompassView;
        }

        public void onSensorChanged(int s, float[] v) {
            this.val$qiblaCompassView.setDirections(v[0], Frg_Kompas_Muazzin.sQiblaDirection);
        }

        public void onAccuracyChanged(int s, int a) {
        }
    }

    class myikc extends AsyncTask<String, String, String> {

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Kompas_Muazzin.myikc.1 */
        class C05781 implements OnClickListener {
            C05781() {
            }

            public void onClick(View v) {
                new CalculationSettingsDialog(Frg_Kompas_Muazzin.this.getActivity()).show();
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Kompas_Muazzin.myikc.2 */
        class C05792 implements OnClickListener {
            C05792() {
            }

            public void onClick(View v) {
                Bundle bundle = new Bundle();
                FragmentTransaction transaction = Frg_Kompas_Muazzin.this.getFragmentManager().beginTransaction();
                transaction.replace(C0615R.id.main_activity_content_frame, Frg_Kompas_Muazzin.newInstance(bundle));
                transaction.addToBackStack(null);
                transaction.commit();
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Kompas_Muazzin.myikc.3 */
        class C05803 implements OnClickListener {
            C05803() {
            }

            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("latitude", Float.toString(Frg_Kompas_Muazzin.dlat));
                bundle.putString("longitude", Float.toString(Frg_Kompas_Muazzin.dlon));
                bundle.putString("qiblat", Double.toString(Frg_Kompas_Muazzin.kiblat));
                bundle.putString("qiblat_360", Double.toString(360.0d - Frg_Kompas_Muazzin.kiblat));
                Frg_Kompas_Muazzin.this.showToast(Double.toString((double) Frg_Kompas_Muazzin.dlat) + "-" + Double.toString((double) Frg_Kompas_Muazzin.dlon));
                Fragment mFragment = Frg_Qiblat_Map.newInstance(bundle);
                mFragment.setArguments(bundle);
                Frg_Kompas_Muazzin.this.getActivity().getSupportFragmentManager().beginTransaction().replace(C0615R.id.main_activity_content_frame, mFragment).addToBackStack(null).commit();
            }
        }

        myikc() {
        }

        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected String doInBackground(String... args) {
            return null;
        }

        protected void onPostExecute(String file_url) {
            ((Button) Frg_Kompas_Muazzin.this.getView().findViewById(C0615R.id.btnLokasiAnda)).setOnClickListener(new C05781());
            ((Button) Frg_Kompas_Muazzin.this.getView().findViewById(C0615R.id.btnRefreshCompass)).setOnClickListener(new C05792());
            ((Button) Frg_Kompas_Muazzin.this.getView().findViewById(C0615R.id.btnShowMap)).setOnClickListener(new C05803());
        }
    }

    static {
        TAG = Frg_Kompas_Muazzin.class.getSimpleName();
        sQiblaDirection = 0.0f;
        isTrackingOrientation = false;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        sSensorManager = (SensorManager) getActivity().getSystemService("sensor");
        try {
            sDecimalFormat = new DecimalFormat(PATTERN);
        } catch (AssertionError ae) {
            Log.wtf(TAG, "Could not construct DecimalFormat", ae);
            Log.d(TAG, "Will try with Locale.US");
            NumberFormat format = NumberFormat.getInstance(Locale.US);
            if (format instanceof DecimalFormat) {
                sDecimalFormat = (DecimalFormat) format;
                sDecimalFormat.applyPattern(PATTERN);
            }
        }
    }

    public static Frg_Kompas_Muazzin newInstance(Bundle bundle) {
        Frg_Kompas_Muazzin fragment = new Frg_Kompas_Muazzin();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(C0615R.menu.menu_muazzin, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case C0615R.id.action_compass_refresh:
                Bundle bundle = new Bundle();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(C0615R.id.main_activity_content_frame, newInstance(bundle));
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case C0615R.id.action_set_location:
                showToast("Klik Button REFRESH setelah SAVE setting lokasi ...");
                new CalculationSettingsDialog(getActivity()).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(C0615R.layout.fragment_frg__kompas__muazzin, container, false);
        QiblaCompassView qiblaCompassView = (QiblaCompassView) rootView.findViewById(C0615R.id.qibla_compass);
        qiblaCompassView.setConstants((TextView) rootView.findViewById(C0615R.id.bearing_north), getText(C0615R.string.bearing_north), (TextView) rootView.findViewById(C0615R.id.bearing_qibla), getText(C0615R.string.bearing_qibla));
        sOrientationListener = new C05771(qiblaCompassView);
        new myikc().execute(new String[0]);
        return rootView;
    }

    public void onResume() {
        super.onResume();
        updateDms();
        if (!isTrackingOrientation) {
            isTrackingOrientation = sSensorManager.registerListener(sOrientationListener, 1);
        }
    }

    public void onPause() {
        super.onPause();
        if (isTrackingOrientation) {
            sSensorManager.unregisterListener(sOrientationListener);
            isTrackingOrientation = false;
        }
    }

    private void updateDms() {
        float[] latLong = Preferences.getInstance(getActivity()).getLocation();
        Location location = Preferences.getInstance(getActivity()).getJitlLocation();
        Dms latitude = new Dms(location.getDegreeLat());
        Dms longitude = new Dms(location.getDegreeLong());
        Dms qibla = Jitl.getNorthQibla(location);
        sQiblaDirection = (float) qibla.getDecimalValue(Direction.NORTH);
        View rootView = getView();
        ((TextView) rootView.findViewById(C0615R.id.current_latitude)).setText(Float.toString(latLong[0]));
        ((TextView) rootView.findViewById(C0615R.id.current_longitude)).setText(Float.toString(latLong[1]));
        TextView tv = (TextView) rootView.findViewById(C0615R.id.current_qibla);
        dlat = latLong[0];
        dlon = latLong[1];
        kiblat = ((double) Math.signum((float) qibla.getDegree())) * ((((double) Math.abs(qibla.getDegree())) + (((double) qibla.getMinute()) / 60.0d)) + (qibla.getSecond() / 3600.0d));
        tv.setText(sDecimalFormat.format(kiblat) + "\u00b0");
        ((TextView) rootView.findViewById(C0615R.id.current_qibla2)).setText(sDecimalFormat.format(360.0d - kiblat) + "\u00b0");
    }

    private void showToast(String message) {
        Toast.makeText(getActivity(), message, 0).show();
    }
}
