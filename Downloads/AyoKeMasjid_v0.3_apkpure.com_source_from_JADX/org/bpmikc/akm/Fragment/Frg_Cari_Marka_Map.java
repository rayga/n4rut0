package org.bpmikc.akm.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.games.Games;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.HashMap;
import java.util.Map;
import org.bpmikc.akm.BuildConfig;
import org.bpmikc.akm.C0615R;
import org.bpmikc.akm.Dialog.AdditionalDialogMarka;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Frg_Cari_Marka_Map extends Fragment implements OnMarkerClickListener {
    private static String alamat_masjid = null;
    private static String bundle_nama = null;
    private static String cek_title = null;
    private static String id_rec = null;
    private static String id_rec_cari = null;
    private static String latitude = null;
    private static String longitude = null;
    private static String nama_kota = null;
    private static String nama_masjid = null;
    public static final String sARGUMENT_IMAGE_CODE = "image";
    private static String status;
    private static String userid;
    private Boolean b_add_marker;
    protected Context context;
    JSONArray dataJsonArr;
    private Double dlatitude;
    private Double dlongitude;
    private GoogleMap googleMap;
    private String icon_marker;
    private String idrec_alamat;
    private String jenis_marka;
    private LatLng loc;
    protected LocationListener locationListener;
    protected LocationManager locationManager;
    private GoogleApiClient mGoogleApiClient;
    MapView mMapView;
    Map<String, String> map;
    private int[] numMarkersInRainbow;
    private ProgressDialog pDialog;
    RequestQueue queue;
    JsonObjectRequest request;
    private String snippet;
    private String title;
    public View vGmap;

    class myikc extends AsyncTask<String, String, String> {

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Cari_Marka_Map.myikc.1 */
        class C05031 implements OnClickListener {
            C05031() {
            }

            public void onClick(View v) {
                Toast.makeText(Frg_Cari_Marka_Map.this.getActivity(), "Google Map Normal ... ", 1).show();
                Frg_Cari_Marka_Map.this.googleMap.setMapType(1);
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Cari_Marka_Map.myikc.2 */
        class C05042 implements OnClickListener {
            C05042() {
            }

            public void onClick(View v) {
                Toast.makeText(Frg_Cari_Marka_Map.this.getActivity(), "Google Map Satellite ... ", 1).show();
                Frg_Cari_Marka_Map.this.googleMap.setMapType(2);
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Cari_Marka_Map.myikc.3 */
        class C05053 implements OnClickListener {
            C05053() {
            }

            public void onClick(View v) {
                Toast.makeText(Frg_Cari_Marka_Map.this.getActivity(), "Google Map Terrain ... ", 1).show();
                Frg_Cari_Marka_Map.this.googleMap.setMapType(3);
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Cari_Marka_Map.myikc.4 */
        class C05064 implements OnClickListener {
            C05064() {
            }

            public void onClick(View v) {
                Toast.makeText(Frg_Cari_Marka_Map.this.getActivity(), "Google Map Hybrid ... ", 1).show();
                Frg_Cari_Marka_Map.this.googleMap.setMapType(4);
            }
        }

        myikc() {
        }

        protected String doInBackground(String... args) {
            return null;
        }

        protected void onPostExecute(String file_url) {
            ((Button) Frg_Cari_Marka_Map.this.getView().findViewById(C0615R.id.btnNormal)).setOnClickListener(new C05031());
            ((Button) Frg_Cari_Marka_Map.this.getView().findViewById(C0615R.id.btnSatellite)).setOnClickListener(new C05042());
            ((Button) Frg_Cari_Marka_Map.this.getView().findViewById(C0615R.id.btnTerrain)).setOnClickListener(new C05053());
            ((Button) Frg_Cari_Marka_Map.this.getView().findViewById(C0615R.id.btnHybrid)).setOnClickListener(new C05064());
        }
    }

    /* renamed from: org.bpmikc.akm.Fragment.Frg_Cari_Marka_Map.1 */
    class C08551 implements OnInfoWindowClickListener {
        C08551() {
        }

        public void onInfoWindowClick(Marker marker) {
            Frg_Cari_Marka_Map.bundle_nama = marker.getTitle().split("posisi:")[0];
            Frg_Cari_Marka_Map.bundle_nama = Frg_Cari_Marka_Map.bundle_nama.trim();
            Bundle bundle2 = new Bundle();
            bundle2.putString("id_rec", marker.getSnippet());
            bundle2.putString("nama_masjid", Frg_Cari_Marka_Map.bundle_nama);
            bundle2.putString("jenis", "marka");
            Fragment mFragment = Frg_Marka.newInstance(bundle2);
            mFragment.setArguments(bundle2);
            Frg_Cari_Marka_Map.this.getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom, C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom).replace(C0615R.id.main_activity_content_frame, mFragment).addToBackStack(null).commit();
        }
    }

    /* renamed from: org.bpmikc.akm.Fragment.Frg_Cari_Marka_Map.2 */
    class C08562 implements InfoWindowAdapter {
        C08562() {
        }

        public View getInfoWindow(Marker arg0) {
            return null;
        }

        public View getInfoContents(Marker marker) {
            Context context = Frg_Cari_Marka_Map.this.getActivity();
            LinearLayout info = new LinearLayout(context);
            info.setOrientation(1);
            TextView title = new TextView(context);
            title.setTextColor(-16776961);
            title.setGravity(17);
            title.setTypeface(null, 1);
            title.setText(marker.getTitle());
            TextView snippet = new TextView(context);
            snippet.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            snippet.setText(marker.getSnippet());
            info.addView(title);
            return info;
        }
    }

    /* renamed from: org.bpmikc.akm.Fragment.Frg_Cari_Marka_Map.3 */
    class C08573 implements Listener<JSONObject> {
        C08573() {
        }

        public void onResponse(JSONObject response) {
            try {
                JSONArray ja = response.getJSONArray("masjid");
                for (int i = 0; i < ja.length(); i++) {
                    JSONObject c = ja.getJSONObject(i);
                    Frg_Cari_Marka_Map.latitude = c.getString("latitude");
                    Frg_Cari_Marka_Map.longitude = c.getString("longitude");
                    Frg_Cari_Marka_Map.this.title = c.getString("nama_masjid");
                    Frg_Cari_Marka_Map.this.snippet = c.getString("alamat_masjid");
                    Frg_Cari_Marka_Map.this.icon_marker = c.getString(Games.EXTRA_STATUS);
                    Frg_Cari_Marka_Map.id_rec = c.getString("id_rec");
                    Frg_Cari_Marka_Map.nama_kota = c.getString("flag_01");
                    Frg_Cari_Marka_Map.this.idrec_alamat = BuildConfig.FLAVOR + Frg_Cari_Marka_Map.this.title + "\n" + "di: " + Frg_Cari_Marka_Map.this.snippet + "\n" + Frg_Cari_Marka_Map.nama_kota;
                    Frg_Cari_Marka_Map.this.dlatitude = Double.valueOf(Double.parseDouble(Frg_Cari_Marka_Map.latitude));
                    Frg_Cari_Marka_Map.this.dlongitude = Double.valueOf(Double.parseDouble(Frg_Cari_Marka_Map.longitude));
                    if (Frg_Cari_Marka_Map.id_rec_cari.equals(Frg_Cari_Marka_Map.id_rec)) {
                        Frg_Cari_Marka_Map.this.googleMap.addMarker(new MarkerOptions().position(new LatLng(Frg_Cari_Marka_Map.this.dlatitude.doubleValue(), Frg_Cari_Marka_Map.this.dlongitude.doubleValue())).title(Frg_Cari_Marka_Map.this.idrec_alamat).snippet(Frg_Cari_Marka_Map.id_rec).icon(BitmapDescriptorFactory.fromResource(Frg_Cari_Marka_Map.this.numMarkersInRainbow[2])));
                    } else if (Frg_Cari_Marka_Map.this.icon_marker.equals("valid")) {
                        Frg_Cari_Marka_Map.this.googleMap.addMarker(new MarkerOptions().position(new LatLng(Frg_Cari_Marka_Map.this.dlatitude.doubleValue(), Frg_Cari_Marka_Map.this.dlongitude.doubleValue())).title(Frg_Cari_Marka_Map.this.idrec_alamat).snippet(Frg_Cari_Marka_Map.id_rec).icon(BitmapDescriptorFactory.fromResource(Frg_Cari_Marka_Map.this.numMarkersInRainbow[0])));
                    } else {
                        Frg_Cari_Marka_Map.this.googleMap.addMarker(new MarkerOptions().position(new LatLng(Frg_Cari_Marka_Map.this.dlatitude.doubleValue(), Frg_Cari_Marka_Map.this.dlongitude.doubleValue())).title(Frg_Cari_Marka_Map.this.idrec_alamat).snippet(Frg_Cari_Marka_Map.id_rec).icon(BitmapDescriptorFactory.fromResource(Frg_Cari_Marka_Map.this.numMarkersInRainbow[1])));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: org.bpmikc.akm.Fragment.Frg_Cari_Marka_Map.4 */
    class C08584 implements ErrorListener {
        C08584() {
        }

        public void onErrorResponse(VolleyError error) {
            error.printStackTrace();
        }
    }

    /* renamed from: org.bpmikc.akm.Fragment.Frg_Cari_Marka_Map.5 */
    class C08595 implements Listener<JSONObject> {
        final /* synthetic */ SharedPreferences val$pref_marka;

        C08595(SharedPreferences sharedPreferences) {
            this.val$pref_marka = sharedPreferences;
        }

        public void onResponse(JSONObject response) {
            try {
                JSONArray ja = response.getJSONArray("marka");
                for (int i = 0; i < ja.length(); i++) {
                    JSONObject c = ja.getJSONObject(i);
                    Frg_Cari_Marka_Map.latitude = c.getString("latitude");
                    Frg_Cari_Marka_Map.longitude = c.getString("longitude");
                    Frg_Cari_Marka_Map.this.title = c.getString("nama_masjid");
                    Frg_Cari_Marka_Map.this.snippet = c.getString("alamat_masjid");
                    Frg_Cari_Marka_Map.this.icon_marker = c.getString(Games.EXTRA_STATUS);
                    Frg_Cari_Marka_Map.id_rec = c.getString("id_rec");
                    Frg_Cari_Marka_Map.nama_kota = c.getString("flag_01");
                    Frg_Cari_Marka_Map.this.jenis_marka = c.getString("jenis_marka");
                    Frg_Cari_Marka_Map.this.idrec_alamat = BuildConfig.FLAVOR + Frg_Cari_Marka_Map.this.title + "\n" + " posisi: " + Frg_Cari_Marka_Map.this.snippet + "\n" + Frg_Cari_Marka_Map.nama_kota;
                    Frg_Cari_Marka_Map.this.dlatitude = Double.valueOf(Double.parseDouble(Frg_Cari_Marka_Map.latitude));
                    Frg_Cari_Marka_Map.this.dlongitude = Double.valueOf(Double.parseDouble(Frg_Cari_Marka_Map.longitude));
                    String access$1400 = Frg_Cari_Marka_Map.this.jenis_marka;
                    Object obj = -1;
                    switch (access$1400.hashCode()) {
                        case -1897165425:
                            if (access$1400.equals("stasiun")) {
                                obj = 10;
                                break;
                            }
                            break;
                        case -1766867402:
                            if (access$1400.equals("rumah_makan")) {
                                obj = 9;
                                break;
                            }
                            break;
                        case -1290033282:
                            if (access$1400.equals("pom_bensin")) {
                                obj = 7;
                                break;
                            }
                            break;
                        case -1181248900:
                            if (access$1400.equals("terminal")) {
                                obj = 11;
                                break;
                            }
                            break;
                        case -982669550:
                            if (access$1400.equals("polisi")) {
                                obj = 6;
                                break;
                            }
                            break;
                        case -703981192:
                            if (access$1400.equals("pelabuhan")) {
                                obj = 4;
                                break;
                            }
                            break;
                        case -337261573:
                            if (access$1400.equals("bandara")) {
                                obj = 1;
                                break;
                            }
                            break;
                        case -222646378:
                            if (access$1400.equals("bengkel")) {
                                obj = 2;
                                break;
                            }
                            break;
                        case 96922:
                            if (access$1400.equals("atm")) {
                                obj = null;
                                break;
                            }
                            break;
                        case 65872687:
                            if (access$1400.equals("penginapan")) {
                                obj = 5;
                                break;
                            }
                            break;
                        case 106437715:
                            if (access$1400.equals("pasar")) {
                                obj = 3;
                                break;
                            }
                            break;
                        case 226569185:
                            if (access$1400.equals("pengobatan")) {
                                obj = 8;
                                break;
                            }
                            break;
                    }
                    switch (obj) {
                        case SpinnerCompat.MODE_DIALOG /*0*/:
                            if (!this.val$pref_marka.getString("atm", BuildConfig.FLAVOR).equals("checked")) {
                                Frg_Cari_Marka_Map.this.b_add_marker = Boolean.valueOf(false);
                                break;
                            }
                            Frg_Cari_Marka_Map.this.b_add_marker = Boolean.valueOf(true);
                            Frg_Cari_Marka_Map.this.googleMap.addMarker(new MarkerOptions().position(new LatLng(Frg_Cari_Marka_Map.this.dlatitude.doubleValue(), Frg_Cari_Marka_Map.this.dlongitude.doubleValue())).title(Frg_Cari_Marka_Map.this.idrec_alamat).snippet(Frg_Cari_Marka_Map.id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.atm_marker)));
                            break;
                        case CompletionEvent.STATUS_FAILURE /*1*/:
                            if (!this.val$pref_marka.getString("bandara", BuildConfig.FLAVOR).equals("checked")) {
                                Frg_Cari_Marka_Map.this.b_add_marker = Boolean.valueOf(false);
                                break;
                            }
                            Frg_Cari_Marka_Map.this.b_add_marker = Boolean.valueOf(true);
                            Frg_Cari_Marka_Map.this.googleMap.addMarker(new MarkerOptions().position(new LatLng(Frg_Cari_Marka_Map.this.dlatitude.doubleValue(), Frg_Cari_Marka_Map.this.dlongitude.doubleValue())).title(Frg_Cari_Marka_Map.this.idrec_alamat).snippet(Frg_Cari_Marka_Map.id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.bandara_marker)));
                            break;
                        case CompletionEvent.STATUS_CONFLICT /*2*/:
                            if (!this.val$pref_marka.getString("bengkel", BuildConfig.FLAVOR).equals("checked")) {
                                Frg_Cari_Marka_Map.this.b_add_marker = Boolean.valueOf(false);
                                break;
                            }
                            Frg_Cari_Marka_Map.this.b_add_marker = Boolean.valueOf(true);
                            Frg_Cari_Marka_Map.this.googleMap.addMarker(new MarkerOptions().position(new LatLng(Frg_Cari_Marka_Map.this.dlatitude.doubleValue(), Frg_Cari_Marka_Map.this.dlongitude.doubleValue())).title(Frg_Cari_Marka_Map.this.idrec_alamat).snippet(Frg_Cari_Marka_Map.id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.bengkel_marker)));
                            break;
                        case CompletionEvent.STATUS_CANCELED /*3*/:
                            if (!this.val$pref_marka.getString("pasar", BuildConfig.FLAVOR).equals("checked")) {
                                Frg_Cari_Marka_Map.this.b_add_marker = Boolean.valueOf(false);
                                break;
                            }
                            Frg_Cari_Marka_Map.this.b_add_marker = Boolean.valueOf(true);
                            Frg_Cari_Marka_Map.this.googleMap.addMarker(new MarkerOptions().position(new LatLng(Frg_Cari_Marka_Map.this.dlatitude.doubleValue(), Frg_Cari_Marka_Map.this.dlongitude.doubleValue())).title(Frg_Cari_Marka_Map.this.idrec_alamat).snippet(Frg_Cari_Marka_Map.id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.pasar_marker)));
                            break;
                        case Barcode.PHONE /*4*/:
                            if (!this.val$pref_marka.getString("pelabuhan", BuildConfig.FLAVOR).equals("checked")) {
                                Frg_Cari_Marka_Map.this.b_add_marker = Boolean.valueOf(false);
                                break;
                            }
                            Frg_Cari_Marka_Map.this.b_add_marker = Boolean.valueOf(true);
                            Frg_Cari_Marka_Map.this.googleMap.addMarker(new MarkerOptions().position(new LatLng(Frg_Cari_Marka_Map.this.dlatitude.doubleValue(), Frg_Cari_Marka_Map.this.dlongitude.doubleValue())).title(Frg_Cari_Marka_Map.this.idrec_alamat).snippet(Frg_Cari_Marka_Map.id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.pelabuhan_marker)));
                            break;
                        case Barcode.PRODUCT /*5*/:
                            if (!this.val$pref_marka.getString("penginapan", BuildConfig.FLAVOR).equals("checked")) {
                                Frg_Cari_Marka_Map.this.b_add_marker = Boolean.valueOf(false);
                                break;
                            }
                            Frg_Cari_Marka_Map.this.b_add_marker = Boolean.valueOf(true);
                            Frg_Cari_Marka_Map.this.googleMap.addMarker(new MarkerOptions().position(new LatLng(Frg_Cari_Marka_Map.this.dlatitude.doubleValue(), Frg_Cari_Marka_Map.this.dlongitude.doubleValue())).title(Frg_Cari_Marka_Map.this.idrec_alamat).snippet(Frg_Cari_Marka_Map.id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.penginapan_marker)));
                            break;
                        case Barcode.SMS /*6*/:
                            if (!this.val$pref_marka.getString("polisi", BuildConfig.FLAVOR).equals("checked")) {
                                Frg_Cari_Marka_Map.this.b_add_marker = Boolean.valueOf(false);
                                break;
                            }
                            Frg_Cari_Marka_Map.this.b_add_marker = Boolean.valueOf(true);
                            Frg_Cari_Marka_Map.this.googleMap.addMarker(new MarkerOptions().position(new LatLng(Frg_Cari_Marka_Map.this.dlatitude.doubleValue(), Frg_Cari_Marka_Map.this.dlongitude.doubleValue())).title(Frg_Cari_Marka_Map.this.idrec_alamat).snippet(Frg_Cari_Marka_Map.id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.polisi_marker)));
                            break;
                        case Barcode.TEXT /*7*/:
                            if (!this.val$pref_marka.getString("pombensin", BuildConfig.FLAVOR).equals("checked")) {
                                Frg_Cari_Marka_Map.this.b_add_marker = Boolean.valueOf(false);
                                break;
                            }
                            Frg_Cari_Marka_Map.this.b_add_marker = Boolean.valueOf(true);
                            Frg_Cari_Marka_Map.this.googleMap.addMarker(new MarkerOptions().position(new LatLng(Frg_Cari_Marka_Map.this.dlatitude.doubleValue(), Frg_Cari_Marka_Map.this.dlongitude.doubleValue())).title(Frg_Cari_Marka_Map.this.idrec_alamat).snippet(Frg_Cari_Marka_Map.id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.pombensin_marker)));
                            break;
                        case Barcode.URL /*8*/:
                            if (!this.val$pref_marka.getString("pengobatan", BuildConfig.FLAVOR).equals("checked")) {
                                Frg_Cari_Marka_Map.this.b_add_marker = Boolean.valueOf(false);
                                break;
                            }
                            Frg_Cari_Marka_Map.this.b_add_marker = Boolean.valueOf(true);
                            Frg_Cari_Marka_Map.this.googleMap.addMarker(new MarkerOptions().position(new LatLng(Frg_Cari_Marka_Map.this.dlatitude.doubleValue(), Frg_Cari_Marka_Map.this.dlongitude.doubleValue())).title(Frg_Cari_Marka_Map.this.idrec_alamat).snippet(Frg_Cari_Marka_Map.id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.rumahsakit_marker)));
                            break;
                        case Barcode.WIFI /*9*/:
                            if (!this.val$pref_marka.getString("rumahmakan", BuildConfig.FLAVOR).equals("checked")) {
                                Frg_Cari_Marka_Map.this.b_add_marker = Boolean.valueOf(false);
                                break;
                            }
                            Frg_Cari_Marka_Map.this.b_add_marker = Boolean.valueOf(true);
                            Frg_Cari_Marka_Map.this.googleMap.addMarker(new MarkerOptions().position(new LatLng(Frg_Cari_Marka_Map.this.dlatitude.doubleValue(), Frg_Cari_Marka_Map.this.dlongitude.doubleValue())).title(Frg_Cari_Marka_Map.this.idrec_alamat).snippet(Frg_Cari_Marka_Map.id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.restoran_marker)));
                            break;
                        case Barcode.GEO /*10*/:
                            if (!this.val$pref_marka.getString("stasiun", BuildConfig.FLAVOR).equals("checked")) {
                                Frg_Cari_Marka_Map.this.b_add_marker = Boolean.valueOf(false);
                                break;
                            }
                            Frg_Cari_Marka_Map.this.b_add_marker = Boolean.valueOf(true);
                            Frg_Cari_Marka_Map.this.googleMap.addMarker(new MarkerOptions().position(new LatLng(Frg_Cari_Marka_Map.this.dlatitude.doubleValue(), Frg_Cari_Marka_Map.this.dlongitude.doubleValue())).title(Frg_Cari_Marka_Map.this.idrec_alamat).snippet(Frg_Cari_Marka_Map.id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.stasiunkereta_marker)));
                            break;
                        case Barcode.CALENDAR_EVENT /*11*/:
                            if (!this.val$pref_marka.getString("terminal", BuildConfig.FLAVOR).equals("checked")) {
                                Frg_Cari_Marka_Map.this.b_add_marker = Boolean.valueOf(false);
                                break;
                            }
                            Frg_Cari_Marka_Map.this.b_add_marker = Boolean.valueOf(true);
                            Frg_Cari_Marka_Map.this.googleMap.addMarker(new MarkerOptions().position(new LatLng(Frg_Cari_Marka_Map.this.dlatitude.doubleValue(), Frg_Cari_Marka_Map.this.dlongitude.doubleValue())).title(Frg_Cari_Marka_Map.this.idrec_alamat).snippet(Frg_Cari_Marka_Map.id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.terminal_marker)));
                            break;
                        default:
                            break;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: org.bpmikc.akm.Fragment.Frg_Cari_Marka_Map.6 */
    class C08606 implements ErrorListener {
        C08606() {
        }

        public void onErrorResponse(VolleyError error) {
            error.printStackTrace();
        }
    }

    static {
        userid = BuildConfig.FLAVOR;
        bundle_nama = BuildConfig.FLAVOR;
        nama_masjid = BuildConfig.FLAVOR;
        alamat_masjid = BuildConfig.FLAVOR;
        nama_kota = BuildConfig.FLAVOR;
        id_rec = BuildConfig.FLAVOR;
        id_rec_cari = BuildConfig.FLAVOR;
        latitude = BuildConfig.FLAVOR;
        longitude = BuildConfig.FLAVOR;
        status = BuildConfig.FLAVOR;
        cek_title = BuildConfig.FLAVOR;
    }

    public Frg_Cari_Marka_Map() {
        this.numMarkersInRainbow = new int[]{C0615R.drawable.masjid_hijau_marker, C0615R.drawable.masjid_marker, C0615R.drawable.masjid_biru_marker};
        this.map = new HashMap();
        this.dataJsonArr = null;
        this.title = BuildConfig.FLAVOR;
        this.snippet = BuildConfig.FLAVOR;
        this.icon_marker = BuildConfig.FLAVOR;
        this.idrec_alamat = BuildConfig.FLAVOR;
        this.jenis_marka = BuildConfig.FLAVOR;
        this.b_add_marker = Boolean.valueOf(false);
    }

    public static Frg_Cari_Marka_Map newInstance(Bundle bundle) {
        Frg_Cari_Marka_Map fragment = new Frg_Cari_Marka_Map();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.mGoogleApiClient = new Builder(getActivity()).addApi(LocationServices.API).build();
        initListeners();
    }

    private void initListeners() {
        this.mMapView.getMap().setOnMarkerClickListener(this);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(C0615R.menu.menu_lokasi_masjid, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case C0615R.id.action_cari_masjid:
                Bundle bundle = new Bundle();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(C0615R.id.main_activity_content_frame, Frg_Cari_Masjid.newInstance(bundle));
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case C0615R.id.action_marka:
                new AdditionalDialogMarka(getActivity()).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.vGmap = inflater.inflate(C0615R.layout.fragment_frg__cari__marka__map, container, false);
        this.mMapView = (MapView) this.vGmap.findViewById(C0615R.id.mapView);
        this.mMapView.onCreate(savedInstanceState);
        this.mMapView.onResume();
        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.googleMap = this.mMapView.getMap();
        this.googleMap.setMyLocationEnabled(true);
        this.googleMap.setMapType(1);
        this.googleMap.getUiSettings().setZoomControlsEnabled(true);
        this.googleMap.getUiSettings().setCompassEnabled(true);
        this.googleMap.getUiSettings().setMapToolbarEnabled(true);
        this.googleMap.setBuildingsEnabled(true);
        this.googleMap.setOnInfoWindowClickListener(new C08551());
        this.googleMap.setInfoWindowAdapter(new C08562());
        Bundle bundle = getArguments();
        nama_masjid = bundle.getString("nama_masjid");
        alamat_masjid = bundle.getString("alamat_masjid");
        nama_kota = bundle.getString("nama_kota");
        id_rec_cari = bundle.getString("id_rec");
        latitude = bundle.getString("latitude");
        longitude = bundle.getString("longitude");
        status = bundle.getString(Games.EXTRA_STATUS);
        this.dlatitude = Double.valueOf(Double.parseDouble(latitude));
        this.dlongitude = Double.valueOf(Double.parseDouble(longitude));
        String server_path = getActivity().getSharedPreferences("MyPrefs", 0).getString("server_path", BuildConfig.FLAVOR);
        Volley.newRequestQueue(getActivity()).add(new JsonObjectRequest(0, server_path + "/app_mobiles/get_all_masjid.php", null, new C08573(), new C08584()));
        String str = server_path + "/app_mobiles/get_all_marka.php";
        Volley.newRequestQueue(getActivity()).add(new JsonObjectRequest(0, url, null, new C08595(getActivity().getSharedPreferences("MyMarka", 0)), new C08606()));
        this.googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(new LatLng(this.dlatitude.doubleValue(), this.dlongitude.doubleValue())).zoom(17.0f).bearing(0.0f).tilt(45.0f).build()));
        new myikc().execute(new String[0]);
        return this.vGmap;
    }

    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    public void onBackPressed() {
        getActivity().getSupportFragmentManager().popBackStack();
    }

    public void onResume() {
        super.onResume();
        this.mMapView.onResume();
    }

    public void onPause() {
        super.onPause();
        this.mMapView.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mMapView.onDestroy();
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mMapView.onLowMemory();
    }

    private void showToast(String message) {
        Toast.makeText(getActivity(), message, 0).show();
    }
}
