package org.bpmikc.akm.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.internal.view.SupportMenu;
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
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import org.bpmikc.akm.BuildConfig;
import org.bpmikc.akm.C0615R;
import org.bpmikc.akm.Dialog.CalculationSettingDialogMarker;
import org.bpmikc.akm.Dialog.CalculationSettingsDialog;
import org.json.JSONArray;

public class Frg_Qiblat_Map extends Fragment implements OnMapClickListener, OnMarkerClickListener {
    private static final String PATTERN = "#.###";
    private static String password = null;
    public static final String sARGUMENT_IMAGE_CODE = "image";
    private static DecimalFormat sDecimalFormat;
    private static String userid;
    protected Context context;
    JSONArray dataJsonArr;
    private Double dlatitude;
    private Double dlongitude;
    private Double dmLatitude;
    private Double dmLongitude;
    private Double dqiblat;
    private Double dqiblat_360;
    private GoogleMap googleMap;
    private String icon_marker;
    private double latKabah;
    private String latitude;
    private double lngKabah;
    protected LocationListener locationListener;
    protected LocationManager locationManager;
    private String longitude;
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

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Qiblat_Map.myikc.1 */
        class C05911 implements OnClickListener {
            C05911() {
            }

            public void onClick(View v) {
                Toast.makeText(Frg_Qiblat_Map.this.getActivity(), "Google Map Normal ... ", 1).show();
                Frg_Qiblat_Map.this.googleMap.setMapType(1);
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Qiblat_Map.myikc.2 */
        class C05922 implements OnClickListener {
            C05922() {
            }

            public void onClick(View v) {
                Toast.makeText(Frg_Qiblat_Map.this.getActivity(), "Google Map Satellite ... ", 1).show();
                Frg_Qiblat_Map.this.googleMap.setMapType(2);
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Qiblat_Map.myikc.3 */
        class C05933 implements OnClickListener {
            C05933() {
            }

            public void onClick(View v) {
                Toast.makeText(Frg_Qiblat_Map.this.getActivity(), "Google Map Terrain ... ", 1).show();
                Frg_Qiblat_Map.this.googleMap.setMapType(3);
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Qiblat_Map.myikc.4 */
        class C05944 implements OnClickListener {
            C05944() {
            }

            public void onClick(View v) {
                Toast.makeText(Frg_Qiblat_Map.this.getActivity(), "Google Map Hybrid ... ", 1).show();
                Frg_Qiblat_Map.this.googleMap.setMapType(4);
            }
        }

        myikc() {
        }

        protected String doInBackground(String... args) {
            return null;
        }

        protected void onPostExecute(String file_url) {
            Frg_Qiblat_Map.sDecimalFormat = new DecimalFormat(Frg_Qiblat_Map.PATTERN);
            ((TextView) Frg_Qiblat_Map.this.getView().findViewById(C0615R.id.line_qiblat_degree)).setText(Frg_Qiblat_Map.sDecimalFormat.format(Frg_Qiblat_Map.this.dqiblat) + "\u00b0" + " atau " + Frg_Qiblat_Map.sDecimalFormat.format(Frg_Qiblat_Map.this.dqiblat_360) + "\u00b0");
            ((Button) Frg_Qiblat_Map.this.getView().findViewById(C0615R.id.btnNormal)).setOnClickListener(new C05911());
            ((Button) Frg_Qiblat_Map.this.getView().findViewById(C0615R.id.btnSatellite)).setOnClickListener(new C05922());
            ((Button) Frg_Qiblat_Map.this.getView().findViewById(C0615R.id.btnTerrain)).setOnClickListener(new C05933());
            ((Button) Frg_Qiblat_Map.this.getView().findViewById(C0615R.id.btnHybrid)).setOnClickListener(new C05944());
        }
    }

    static {
        userid = BuildConfig.FLAVOR;
        password = BuildConfig.FLAVOR;
    }

    public Frg_Qiblat_Map() {
        this.numMarkersInRainbow = new int[]{C0615R.drawable.masjid_biru_marker, C0615R.drawable.masjid_marker};
        this.map = new HashMap();
        this.dataJsonArr = null;
        this.latitude = BuildConfig.FLAVOR;
        this.longitude = BuildConfig.FLAVOR;
        this.title = BuildConfig.FLAVOR;
        this.snippet = BuildConfig.FLAVOR;
        this.icon_marker = BuildConfig.FLAVOR;
        this.latKabah = 21.42250833d;
        this.lngKabah = 39.82616111d;
    }

    public static Frg_Qiblat_Map newInstance(Bundle bundle) {
        Frg_Qiblat_Map fragment = new Frg_Qiblat_Map();
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

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(C0615R.menu.menu_muazzin, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case C0615R.id.action_compass_refresh:
                Bundle bundle = new Bundle();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(C0615R.id.main_activity_content_frame, Frg_Kompas_Muazzin.newInstance(bundle));
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
        this.vGmap = inflater.inflate(C0615R.layout.fragment_frg__qiblat__map, container, false);
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
        Bundle bundle = getArguments();
        this.latitude = bundle.getString("latitude");
        this.longitude = bundle.getString("longitude");
        this.dlatitude = Double.valueOf(Double.parseDouble(this.latitude));
        this.dlongitude = Double.valueOf(Double.parseDouble(this.longitude));
        this.dqiblat = Double.valueOf(Double.parseDouble(bundle.getString("qiblat")));
        this.dqiblat_360 = Double.valueOf(Double.parseDouble(bundle.getString("qiblat_360")));
        this.googleMap.addMarker(new MarkerOptions().position(new LatLng(this.dlatitude.doubleValue(), this.dlongitude.doubleValue())).title(this.title).snippet(this.snippet).icon(BitmapDescriptorFactory.fromResource(this.numMarkersInRainbow[0])));
        this.googleMap.addMarker(new MarkerOptions().position(new LatLng(this.latKabah, this.lngKabah)).title(this.title).snippet(this.snippet).icon(BitmapDescriptorFactory.fromResource(this.numMarkersInRainbow[0])));
        this.googleMap.addPolyline(new PolylineOptions().add(new LatLng(this.dlatitude.doubleValue(), this.dlongitude.doubleValue()), new LatLng(this.latKabah, this.lngKabah)).width(5.0f).color(SupportMenu.CATEGORY_MASK));
        this.googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(new LatLng(this.dlatitude.doubleValue(), this.dlongitude.doubleValue())).zoom(17.0f).bearing(0.0f).tilt(0.0f).build()));
        new myikc().execute(new String[0]);
        return this.vGmap;
    }

    public void onMapClick(LatLng latLng) {
        MarkerOptions options = new MarkerOptions().position(latLng);
        options.icon(BitmapDescriptorFactory.defaultMarker());
        this.mMapView.getMap().addMarker(options);
        String posisi = latLng.toString();
        String[] posarray = posisi.substring(10, posisi.length() - 1).split(",");
        showToast("lat:" + posarray[0] + " dan long:" + posarray[1]);
        Bundle bundle = new Bundle();
        bundle.putString("latitude", posarray[0]);
        bundle.putString("longitude", posarray[1]);
        this.dmLatitude = Double.valueOf(Double.parseDouble(posarray[0]));
        this.dmLongitude = Double.valueOf(Double.parseDouble(posarray[1]));
        GoogleMap googleMap = this.googleMap;
        PolylineOptions polylineOptions = new PolylineOptions();
        r10 = new LatLng[2];
        r10[0] = new LatLng(this.dmLatitude.doubleValue(), this.dmLongitude.doubleValue());
        r10[1] = new LatLng(this.latKabah, this.lngKabah);
        googleMap.addPolyline(polylineOptions.add(r10).width(5.0f).color(SupportMenu.CATEGORY_MASK));
        this.googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(new LatLng(this.dmLatitude.doubleValue(), this.dmLongitude.doubleValue())).zoom(20.0f).bearing(0.0f).tilt(45.0f).build()));
    }

    public boolean onMarkerClick(Marker marker) {
        marker.showInfoWindow();
        String posisi = marker.getPosition().toString();
        String[] posarray = posisi.substring(10, posisi.length() - 1).split(",");
        showToast("lat:" + posarray[0] + " dan long:" + posarray[1]);
        Editor edit = getActivity().getSharedPreferences("MyPrefs", 0).edit();
        edit.putString("slatitude", posarray[0]);
        edit.putString("slongitude", posarray[1]);
        edit.commit();
        showToast("Klik Button REFRESH setelah SAVE setting lokasi ...");
        new CalculationSettingDialogMarker(getActivity()).show();
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

    private void showToast(String message) {
        Toast.makeText(getActivity(), message, 0).show();
    }
}
