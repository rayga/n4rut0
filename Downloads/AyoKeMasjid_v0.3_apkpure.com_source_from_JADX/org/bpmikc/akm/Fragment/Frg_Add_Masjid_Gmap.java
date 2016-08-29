package org.bpmikc.akm.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
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
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.vision.barcode.Barcode;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.bpmikc.akm.BuildConfig;
import org.bpmikc.akm.C0615R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Frg_Add_Masjid_Gmap extends Fragment implements OnMapClickListener, OnMarkerClickListener {
    private static String bundle_nama = null;
    private static String idrec_alamat = null;
    private static String idrec_snippet = null;
    private static String password = null;
    public static final String sARGUMENT_IMAGE_CODE = "image";
    private static String userid;
    private Boolean b_add_marker;
    private String cek_title;
    JSONArray dataJsonArr;
    private Double dlatitude;
    private Double dlongitude;
    private GoogleMap googleMap;
    private String icon_marker;
    private String id_rec;
    private String jenis_marka;
    private String latitude;
    private String longitude;
    private Location mCurrentLocation;
    private GoogleApiClient mGoogleApiClient;
    MapView mMapView;
    Map<String, String> map;
    private String marker;
    private String nama_kota;
    private int[] numMarkersInRainbow;
    private ProgressDialog pDialog;
    RequestQueue queue;
    JsonObjectRequest request;
    private String snippet;
    private String title;
    public View vGmap;

    class myikc extends AsyncTask<String, String, String> {

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Add_Masjid_Gmap.myikc.1 */
        class C04941 implements OnClickListener {
            C04941() {
            }

            public void onClick(View v) {
                Toast.makeText(Frg_Add_Masjid_Gmap.this.getActivity(), "Google Map Normal ... ", 1).show();
                Frg_Add_Masjid_Gmap.this.googleMap.setMapType(1);
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Add_Masjid_Gmap.myikc.2 */
        class C04952 implements OnClickListener {
            C04952() {
            }

            public void onClick(View v) {
                Toast.makeText(Frg_Add_Masjid_Gmap.this.getActivity(), "Google Map Satellite ... ", 1).show();
                Frg_Add_Masjid_Gmap.this.googleMap.setMapType(2);
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Add_Masjid_Gmap.myikc.3 */
        class C04963 implements OnClickListener {
            C04963() {
            }

            public void onClick(View v) {
                Toast.makeText(Frg_Add_Masjid_Gmap.this.getActivity(), "Google Map Terrain ... ", 1).show();
                Frg_Add_Masjid_Gmap.this.googleMap.setMapType(3);
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Add_Masjid_Gmap.myikc.4 */
        class C04974 implements OnClickListener {
            C04974() {
            }

            public void onClick(View v) {
                Toast.makeText(Frg_Add_Masjid_Gmap.this.getActivity(), "Google Map Hybrid ... ", 1).show();
                Frg_Add_Masjid_Gmap.this.googleMap.setMapType(4);
            }
        }

        myikc() {
        }

        protected String doInBackground(String... args) {
            return null;
        }

        protected void onPostExecute(String file_url) {
            ((Button) Frg_Add_Masjid_Gmap.this.getView().findViewById(C0615R.id.btnNormal)).setOnClickListener(new C04941());
            ((Button) Frg_Add_Masjid_Gmap.this.getView().findViewById(C0615R.id.btnSatellite)).setOnClickListener(new C04952());
            ((Button) Frg_Add_Masjid_Gmap.this.getView().findViewById(C0615R.id.btnTerrain)).setOnClickListener(new C04963());
            ((Button) Frg_Add_Masjid_Gmap.this.getView().findViewById(C0615R.id.btnHybrid)).setOnClickListener(new C04974());
        }
    }

    /* renamed from: org.bpmikc.akm.Fragment.Frg_Add_Masjid_Gmap.1 */
    class C08491 implements OnInfoWindowClickListener {
        C08491() {
        }

        public void onInfoWindowClick(Marker marker) {
            Frg_Add_Masjid_Gmap.idrec_snippet = marker.getSnippet();
            Frg_Add_Masjid_Gmap.bundle_nama = marker.getTitle().split("di:")[0];
            Frg_Add_Masjid_Gmap.bundle_nama = Frg_Add_Masjid_Gmap.bundle_nama.trim();
            Bundle bundle2 = new Bundle();
            bundle2.putString("id_rec", Frg_Add_Masjid_Gmap.idrec_snippet);
            bundle2.putString("nama_masjid", Frg_Add_Masjid_Gmap.bundle_nama);
            Fragment mFragment = Frg_Kegiatan.newInstance(bundle2);
            mFragment.setArguments(bundle2);
            Frg_Add_Masjid_Gmap.this.getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom, C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom).replace(C0615R.id.main_activity_content_frame, mFragment).addToBackStack(null).commit();
        }
    }

    /* renamed from: org.bpmikc.akm.Fragment.Frg_Add_Masjid_Gmap.2 */
    class C08502 implements InfoWindowAdapter {
        C08502() {
        }

        public View getInfoWindow(Marker arg0) {
            return null;
        }

        public View getInfoContents(Marker marker) {
            Context context = Frg_Add_Masjid_Gmap.this.getActivity();
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

    /* renamed from: org.bpmikc.akm.Fragment.Frg_Add_Masjid_Gmap.3 */
    class C08513 implements Listener<JSONObject> {
        C08513() {
        }

        public void onResponse(JSONObject response) {
            try {
                JSONArray ja = response.getJSONArray("masjid");
                for (int i = 0; i < ja.length(); i++) {
                    JSONObject c = ja.getJSONObject(i);
                    Frg_Add_Masjid_Gmap.this.latitude = c.getString("latitude");
                    Frg_Add_Masjid_Gmap.this.longitude = c.getString("longitude");
                    Frg_Add_Masjid_Gmap.this.title = c.getString("nama_masjid");
                    Frg_Add_Masjid_Gmap.this.snippet = c.getString("alamat_masjid");
                    Frg_Add_Masjid_Gmap.this.icon_marker = c.getString(Games.EXTRA_STATUS);
                    Frg_Add_Masjid_Gmap.this.id_rec = c.getString("id_rec");
                    Frg_Add_Masjid_Gmap.this.nama_kota = c.getString("flag_01");
                    Frg_Add_Masjid_Gmap.idrec_alamat = BuildConfig.FLAVOR + Frg_Add_Masjid_Gmap.this.title + "\n" + "di: " + Frg_Add_Masjid_Gmap.this.snippet + "\n" + Frg_Add_Masjid_Gmap.this.nama_kota;
                    Frg_Add_Masjid_Gmap.this.dlatitude = Double.valueOf(Double.parseDouble(Frg_Add_Masjid_Gmap.this.latitude));
                    Frg_Add_Masjid_Gmap.this.dlongitude = Double.valueOf(Double.parseDouble(Frg_Add_Masjid_Gmap.this.longitude));
                    if (Frg_Add_Masjid_Gmap.this.icon_marker.equals("valid")) {
                        Frg_Add_Masjid_Gmap.this.googleMap.addMarker(new MarkerOptions().position(new LatLng(Frg_Add_Masjid_Gmap.this.dlatitude.doubleValue(), Frg_Add_Masjid_Gmap.this.dlongitude.doubleValue())).title(Frg_Add_Masjid_Gmap.idrec_alamat).snippet(Frg_Add_Masjid_Gmap.this.snippet).icon(BitmapDescriptorFactory.fromResource(Frg_Add_Masjid_Gmap.this.numMarkersInRainbow[0])));
                    } else {
                        Frg_Add_Masjid_Gmap.this.googleMap.addMarker(new MarkerOptions().position(new LatLng(Frg_Add_Masjid_Gmap.this.dlatitude.doubleValue(), Frg_Add_Masjid_Gmap.this.dlongitude.doubleValue())).title(Frg_Add_Masjid_Gmap.idrec_alamat).snippet(Frg_Add_Masjid_Gmap.this.snippet).icon(BitmapDescriptorFactory.fromResource(Frg_Add_Masjid_Gmap.this.numMarkersInRainbow[1])));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: org.bpmikc.akm.Fragment.Frg_Add_Masjid_Gmap.4 */
    class C08524 implements ErrorListener {
        C08524() {
        }

        public void onErrorResponse(VolleyError error) {
            error.printStackTrace();
        }
    }

    /* renamed from: org.bpmikc.akm.Fragment.Frg_Add_Masjid_Gmap.5 */
    class C08535 implements Listener<JSONObject> {
        final /* synthetic */ SharedPreferences val$pref_marka;

        C08535(SharedPreferences sharedPreferences) {
            this.val$pref_marka = sharedPreferences;
        }

        public void onResponse(JSONObject response) {
            try {
                JSONArray ja = response.getJSONArray("marka");
                for (int i = 0; i < ja.length(); i++) {
                    JSONObject c = ja.getJSONObject(i);
                    Frg_Add_Masjid_Gmap.this.latitude = c.getString("latitude");
                    Frg_Add_Masjid_Gmap.this.longitude = c.getString("longitude");
                    Frg_Add_Masjid_Gmap.this.title = c.getString("nama_masjid");
                    Frg_Add_Masjid_Gmap.this.snippet = c.getString("alamat_masjid");
                    Frg_Add_Masjid_Gmap.this.icon_marker = c.getString(Games.EXTRA_STATUS);
                    Frg_Add_Masjid_Gmap.this.id_rec = c.getString("id_rec");
                    Frg_Add_Masjid_Gmap.this.nama_kota = c.getString("flag_01");
                    Frg_Add_Masjid_Gmap.this.jenis_marka = c.getString("jenis_marka");
                    Frg_Add_Masjid_Gmap.idrec_alamat = BuildConfig.FLAVOR + Frg_Add_Masjid_Gmap.this.title + "\n" + " posisi: " + Frg_Add_Masjid_Gmap.this.snippet + "\n" + Frg_Add_Masjid_Gmap.this.nama_kota;
                    Frg_Add_Masjid_Gmap.this.dlatitude = Double.valueOf(Double.parseDouble(Frg_Add_Masjid_Gmap.this.latitude));
                    Frg_Add_Masjid_Gmap.this.dlongitude = Double.valueOf(Double.parseDouble(Frg_Add_Masjid_Gmap.this.longitude));
                    String access$1400 = Frg_Add_Masjid_Gmap.this.jenis_marka;
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
                                Frg_Add_Masjid_Gmap.this.b_add_marker = Boolean.valueOf(false);
                                break;
                            }
                            Frg_Add_Masjid_Gmap.this.b_add_marker = Boolean.valueOf(true);
                            Frg_Add_Masjid_Gmap.this.googleMap.addMarker(new MarkerOptions().position(new LatLng(Frg_Add_Masjid_Gmap.this.dlatitude.doubleValue(), Frg_Add_Masjid_Gmap.this.dlongitude.doubleValue())).title(Frg_Add_Masjid_Gmap.idrec_alamat).snippet(Frg_Add_Masjid_Gmap.this.id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.atm_marker)));
                            break;
                        case CompletionEvent.STATUS_FAILURE /*1*/:
                            if (!this.val$pref_marka.getString("bandara", BuildConfig.FLAVOR).equals("checked")) {
                                Frg_Add_Masjid_Gmap.this.b_add_marker = Boolean.valueOf(false);
                                break;
                            }
                            Frg_Add_Masjid_Gmap.this.b_add_marker = Boolean.valueOf(true);
                            Frg_Add_Masjid_Gmap.this.googleMap.addMarker(new MarkerOptions().position(new LatLng(Frg_Add_Masjid_Gmap.this.dlatitude.doubleValue(), Frg_Add_Masjid_Gmap.this.dlongitude.doubleValue())).title(Frg_Add_Masjid_Gmap.idrec_alamat).snippet(Frg_Add_Masjid_Gmap.this.id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.bandara_marker)));
                            break;
                        case CompletionEvent.STATUS_CONFLICT /*2*/:
                            if (!this.val$pref_marka.getString("bengkel", BuildConfig.FLAVOR).equals("checked")) {
                                Frg_Add_Masjid_Gmap.this.b_add_marker = Boolean.valueOf(false);
                                break;
                            }
                            Frg_Add_Masjid_Gmap.this.b_add_marker = Boolean.valueOf(true);
                            Frg_Add_Masjid_Gmap.this.googleMap.addMarker(new MarkerOptions().position(new LatLng(Frg_Add_Masjid_Gmap.this.dlatitude.doubleValue(), Frg_Add_Masjid_Gmap.this.dlongitude.doubleValue())).title(Frg_Add_Masjid_Gmap.idrec_alamat).snippet(Frg_Add_Masjid_Gmap.this.id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.bengkel_marker)));
                            break;
                        case CompletionEvent.STATUS_CANCELED /*3*/:
                            if (!this.val$pref_marka.getString("pasar", BuildConfig.FLAVOR).equals("checked")) {
                                Frg_Add_Masjid_Gmap.this.b_add_marker = Boolean.valueOf(false);
                                break;
                            }
                            Frg_Add_Masjid_Gmap.this.b_add_marker = Boolean.valueOf(true);
                            Frg_Add_Masjid_Gmap.this.googleMap.addMarker(new MarkerOptions().position(new LatLng(Frg_Add_Masjid_Gmap.this.dlatitude.doubleValue(), Frg_Add_Masjid_Gmap.this.dlongitude.doubleValue())).title(Frg_Add_Masjid_Gmap.idrec_alamat).snippet(Frg_Add_Masjid_Gmap.this.id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.pasar_marker)));
                            break;
                        case Barcode.PHONE /*4*/:
                            if (!this.val$pref_marka.getString("pelabuhan", BuildConfig.FLAVOR).equals("checked")) {
                                Frg_Add_Masjid_Gmap.this.b_add_marker = Boolean.valueOf(false);
                                break;
                            }
                            Frg_Add_Masjid_Gmap.this.b_add_marker = Boolean.valueOf(true);
                            Frg_Add_Masjid_Gmap.this.googleMap.addMarker(new MarkerOptions().position(new LatLng(Frg_Add_Masjid_Gmap.this.dlatitude.doubleValue(), Frg_Add_Masjid_Gmap.this.dlongitude.doubleValue())).title(Frg_Add_Masjid_Gmap.idrec_alamat).snippet(Frg_Add_Masjid_Gmap.this.id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.pelabuhan_marker)));
                            break;
                        case Barcode.PRODUCT /*5*/:
                            if (!this.val$pref_marka.getString("penginapan", BuildConfig.FLAVOR).equals("checked")) {
                                Frg_Add_Masjid_Gmap.this.b_add_marker = Boolean.valueOf(false);
                                break;
                            }
                            Frg_Add_Masjid_Gmap.this.b_add_marker = Boolean.valueOf(true);
                            Frg_Add_Masjid_Gmap.this.googleMap.addMarker(new MarkerOptions().position(new LatLng(Frg_Add_Masjid_Gmap.this.dlatitude.doubleValue(), Frg_Add_Masjid_Gmap.this.dlongitude.doubleValue())).title(Frg_Add_Masjid_Gmap.idrec_alamat).snippet(Frg_Add_Masjid_Gmap.this.id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.penginapan_marker)));
                            break;
                        case Barcode.SMS /*6*/:
                            if (!this.val$pref_marka.getString("polisi", BuildConfig.FLAVOR).equals("checked")) {
                                Frg_Add_Masjid_Gmap.this.b_add_marker = Boolean.valueOf(false);
                                break;
                            }
                            Frg_Add_Masjid_Gmap.this.b_add_marker = Boolean.valueOf(true);
                            Frg_Add_Masjid_Gmap.this.googleMap.addMarker(new MarkerOptions().position(new LatLng(Frg_Add_Masjid_Gmap.this.dlatitude.doubleValue(), Frg_Add_Masjid_Gmap.this.dlongitude.doubleValue())).title(Frg_Add_Masjid_Gmap.idrec_alamat).snippet(Frg_Add_Masjid_Gmap.this.id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.polisi_marker)));
                            break;
                        case Barcode.TEXT /*7*/:
                            if (!this.val$pref_marka.getString("pombensin", BuildConfig.FLAVOR).equals("checked")) {
                                Frg_Add_Masjid_Gmap.this.b_add_marker = Boolean.valueOf(false);
                                break;
                            }
                            Frg_Add_Masjid_Gmap.this.b_add_marker = Boolean.valueOf(true);
                            Frg_Add_Masjid_Gmap.this.googleMap.addMarker(new MarkerOptions().position(new LatLng(Frg_Add_Masjid_Gmap.this.dlatitude.doubleValue(), Frg_Add_Masjid_Gmap.this.dlongitude.doubleValue())).title(Frg_Add_Masjid_Gmap.idrec_alamat).snippet(Frg_Add_Masjid_Gmap.this.id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.pombensin_marker)));
                            break;
                        case Barcode.URL /*8*/:
                            if (!this.val$pref_marka.getString("pengobatan", BuildConfig.FLAVOR).equals("checked")) {
                                Frg_Add_Masjid_Gmap.this.b_add_marker = Boolean.valueOf(false);
                                break;
                            }
                            Frg_Add_Masjid_Gmap.this.b_add_marker = Boolean.valueOf(true);
                            Frg_Add_Masjid_Gmap.this.googleMap.addMarker(new MarkerOptions().position(new LatLng(Frg_Add_Masjid_Gmap.this.dlatitude.doubleValue(), Frg_Add_Masjid_Gmap.this.dlongitude.doubleValue())).title(Frg_Add_Masjid_Gmap.idrec_alamat).snippet(Frg_Add_Masjid_Gmap.this.id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.rumahsakit_marker)));
                            break;
                        case Barcode.WIFI /*9*/:
                            if (!this.val$pref_marka.getString("rumahmakan", BuildConfig.FLAVOR).equals("checked")) {
                                Frg_Add_Masjid_Gmap.this.b_add_marker = Boolean.valueOf(false);
                                break;
                            }
                            Frg_Add_Masjid_Gmap.this.b_add_marker = Boolean.valueOf(true);
                            Frg_Add_Masjid_Gmap.this.googleMap.addMarker(new MarkerOptions().position(new LatLng(Frg_Add_Masjid_Gmap.this.dlatitude.doubleValue(), Frg_Add_Masjid_Gmap.this.dlongitude.doubleValue())).title(Frg_Add_Masjid_Gmap.idrec_alamat).snippet(Frg_Add_Masjid_Gmap.this.id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.restoran_marker)));
                            break;
                        case Barcode.GEO /*10*/:
                            if (!this.val$pref_marka.getString("stasiun", BuildConfig.FLAVOR).equals("checked")) {
                                Frg_Add_Masjid_Gmap.this.b_add_marker = Boolean.valueOf(false);
                                break;
                            }
                            Frg_Add_Masjid_Gmap.this.b_add_marker = Boolean.valueOf(true);
                            Frg_Add_Masjid_Gmap.this.googleMap.addMarker(new MarkerOptions().position(new LatLng(Frg_Add_Masjid_Gmap.this.dlatitude.doubleValue(), Frg_Add_Masjid_Gmap.this.dlongitude.doubleValue())).title(Frg_Add_Masjid_Gmap.idrec_alamat).snippet(Frg_Add_Masjid_Gmap.this.id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.stasiunkereta_marker)));
                            break;
                        case Barcode.CALENDAR_EVENT /*11*/:
                            if (!this.val$pref_marka.getString("terminal", BuildConfig.FLAVOR).equals("checked")) {
                                Frg_Add_Masjid_Gmap.this.b_add_marker = Boolean.valueOf(false);
                                break;
                            }
                            Frg_Add_Masjid_Gmap.this.b_add_marker = Boolean.valueOf(true);
                            Frg_Add_Masjid_Gmap.this.googleMap.addMarker(new MarkerOptions().position(new LatLng(Frg_Add_Masjid_Gmap.this.dlatitude.doubleValue(), Frg_Add_Masjid_Gmap.this.dlongitude.doubleValue())).title(Frg_Add_Masjid_Gmap.idrec_alamat).snippet(Frg_Add_Masjid_Gmap.this.id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.terminal_marker)));
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

    /* renamed from: org.bpmikc.akm.Fragment.Frg_Add_Masjid_Gmap.6 */
    class C08546 implements ErrorListener {
        C08546() {
        }

        public void onErrorResponse(VolleyError error) {
            error.printStackTrace();
        }
    }

    static {
        userid = BuildConfig.FLAVOR;
        password = BuildConfig.FLAVOR;
        idrec_snippet = BuildConfig.FLAVOR;
        idrec_alamat = BuildConfig.FLAVOR;
        bundle_nama = BuildConfig.FLAVOR;
    }

    public Frg_Add_Masjid_Gmap() {
        this.numMarkersInRainbow = new int[]{C0615R.drawable.masjid_hijau_marker, C0615R.drawable.masjid_marker};
        this.map = new HashMap();
        this.dataJsonArr = null;
        this.latitude = BuildConfig.FLAVOR;
        this.longitude = BuildConfig.FLAVOR;
        this.title = BuildConfig.FLAVOR;
        this.snippet = BuildConfig.FLAVOR;
        this.icon_marker = BuildConfig.FLAVOR;
        this.id_rec = BuildConfig.FLAVOR;
        this.nama_kota = BuildConfig.FLAVOR;
        this.marker = BuildConfig.FLAVOR;
        this.cek_title = BuildConfig.FLAVOR;
        this.jenis_marka = BuildConfig.FLAVOR;
        this.b_add_marker = Boolean.valueOf(false);
    }

    public static Frg_Add_Masjid_Gmap newInstance(Bundle bundle) {
        Frg_Add_Masjid_Gmap fragment = new Frg_Add_Masjid_Gmap();
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
        this.mMapView.getMap().setOnMapClickListener(this);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.vGmap = inflater.inflate(C0615R.layout.fragment_frg__add__masjid__gmap, container, false);
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
        this.googleMap.setOnInfoWindowClickListener(new C08491());
        this.googleMap.setInfoWindowAdapter(new C08502());
        String server_path = getActivity().getSharedPreferences("MyPrefs", 0).getString("server_path", BuildConfig.FLAVOR);
        Volley.newRequestQueue(getActivity()).add(new JsonObjectRequest(0, server_path + "/app_mobiles/get_all_masjid.php", null, new C08513(), new C08524()));
        String str = server_path + "/app_mobiles/get_all_marka.php";
        Volley.newRequestQueue(getActivity()).add(new JsonObjectRequest(0, url, null, new C08535(getActivity().getSharedPreferences("MyMarka", 0)), new C08546()));
        this.googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(new LatLng(-6.387305d, 106.787932d)).zoom(7.0f).bearing(0.0f).tilt(45.0f).build()));
        new myikc().execute(new String[0]);
        return this.vGmap;
    }

    public void onMapClick(LatLng latLng) {
        MarkerOptions options = new MarkerOptions().position(latLng);
        options.title(getAddressFromLatLng(latLng));
        options.icon(BitmapDescriptorFactory.defaultMarker());
        this.mMapView.getMap().addMarker(options);
        this.googleMap.setMapType(4);
        this.googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(latLng).zoom(20.0f).bearing(0.0f).tilt(45.0f).build()));
    }

    public boolean onMarkerClick(Marker marker) {
        marker.showInfoWindow();
        if (marker.getSnippet() == null) {
            showToast("Marker belum ada ...");
            String posisi = marker.getPosition().toString();
            String[] posarray = posisi.substring(10, posisi.length() - 1).split(",");
            showToast("lat:" + posarray[0] + "dan long:" + posarray[1]);
            Bundle bundle = new Bundle();
            bundle.putString("latitude", posarray[0]);
            bundle.putString("longitude", posarray[1]);
            Fragment mFragment = Frg_Add_Masjid.newInstance(11);
            mFragment.setArguments(bundle);
            getActivity().getSupportFragmentManager().beginTransaction().replace(C0615R.id.main_activity_content_frame, mFragment).addToBackStack(null).commit();
        } else {
            showToast("Marker sudah ada : " + marker.getTitle());
        }
        return true;
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

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 16908332:
                getActivity().onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private String getAddressFromLatLng(LatLng latLng) {
        Geocoder geocoder = new Geocoder(getActivity());
        String address = BuildConfig.FLAVOR;
        try {
            address = ((Address) geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1).get(0)).getAddressLine(0);
        } catch (IOException e) {
        }
        return address;
    }

    private void showToast(String message) {
        Toast.makeText(getActivity(), message, 0).show();
    }
}
