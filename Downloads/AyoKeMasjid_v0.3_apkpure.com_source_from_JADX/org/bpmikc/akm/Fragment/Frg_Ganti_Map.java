package org.bpmikc.akm.Fragment;

import android.app.ProgressDialog;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
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
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.bpmikc.akm.BuildConfig;
import org.bpmikc.akm.C0615R;
import org.json.JSONArray;

public class Frg_Ganti_Map extends Fragment implements OnMapClickListener, OnMarkerClickListener {
    private static String alamat_masjid = null;
    private static String id_rec = null;
    private static String jenis_masjid = null;
    private static String latitude = null;
    private static String longitude = null;
    private static String nama_kota = null;
    private static String nama_masjid = null;
    private static String password = null;
    public static final String sARGUMENT_IMAGE_CODE = "image";
    private static String status;
    private static String userid;
    JSONArray dataJsonArr;
    private Double dlatitude;
    private Double dlongitude;
    private GoogleMap googleMap;
    private String icon_marker;
    private Location mCurrentLocation;
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

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Ganti_Map.myikc.1 */
        class C05501 implements OnClickListener {
            C05501() {
            }

            public void onClick(View v) {
                Toast.makeText(Frg_Ganti_Map.this.getActivity(), "Google Map Normal ... ", 1).show();
                Frg_Ganti_Map.this.googleMap.setMapType(1);
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Ganti_Map.myikc.2 */
        class C05512 implements OnClickListener {
            C05512() {
            }

            public void onClick(View v) {
                Toast.makeText(Frg_Ganti_Map.this.getActivity(), "Google Map Satellite ... ", 1).show();
                Frg_Ganti_Map.this.googleMap.setMapType(2);
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Ganti_Map.myikc.3 */
        class C05523 implements OnClickListener {
            C05523() {
            }

            public void onClick(View v) {
                Toast.makeText(Frg_Ganti_Map.this.getActivity(), "Google Map Terrain ... ", 1).show();
                Frg_Ganti_Map.this.googleMap.setMapType(3);
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Ganti_Map.myikc.4 */
        class C05534 implements OnClickListener {
            C05534() {
            }

            public void onClick(View v) {
                Toast.makeText(Frg_Ganti_Map.this.getActivity(), "Google Map Hybrid ... ", 1).show();
                Frg_Ganti_Map.this.googleMap.setMapType(4);
            }
        }

        myikc() {
        }

        protected String doInBackground(String... args) {
            return null;
        }

        protected void onPostExecute(String file_url) {
            ((Button) Frg_Ganti_Map.this.getView().findViewById(C0615R.id.btnNormal)).setOnClickListener(new C05501());
            ((Button) Frg_Ganti_Map.this.getView().findViewById(C0615R.id.btnSatellite)).setOnClickListener(new C05512());
            ((Button) Frg_Ganti_Map.this.getView().findViewById(C0615R.id.btnTerrain)).setOnClickListener(new C05523());
            ((Button) Frg_Ganti_Map.this.getView().findViewById(C0615R.id.btnHybrid)).setOnClickListener(new C05534());
        }
    }

    static {
        userid = BuildConfig.FLAVOR;
        password = BuildConfig.FLAVOR;
        nama_masjid = BuildConfig.FLAVOR;
        alamat_masjid = BuildConfig.FLAVOR;
        nama_kota = BuildConfig.FLAVOR;
        id_rec = BuildConfig.FLAVOR;
        latitude = BuildConfig.FLAVOR;
        longitude = BuildConfig.FLAVOR;
        status = BuildConfig.FLAVOR;
        jenis_masjid = BuildConfig.FLAVOR;
    }

    public Frg_Ganti_Map() {
        this.numMarkersInRainbow = new int[]{C0615R.drawable.masjid_kuning_marker, C0615R.drawable.masjid_marker};
        this.map = new HashMap();
        this.dataJsonArr = null;
        this.title = BuildConfig.FLAVOR;
        this.snippet = BuildConfig.FLAVOR;
        this.icon_marker = BuildConfig.FLAVOR;
    }

    public static Frg_Ganti_Map newInstance(Bundle bundle) {
        Frg_Ganti_Map fragment = new Frg_Ganti_Map();
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
        Bundle bundle = getArguments();
        id_rec = bundle.getString("id_rec");
        nama_masjid = bundle.getString("nama_masjid");
        latitude = bundle.getString("latitude");
        longitude = bundle.getString("longitude");
        this.vGmap = inflater.inflate(C0615R.layout.fragment_frg__ganti__map, container, false);
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
        this.dlatitude = Double.valueOf(Double.parseDouble(latitude));
        this.dlongitude = Double.valueOf(Double.parseDouble(longitude));
        this.googleMap.addMarker(new MarkerOptions().position(new LatLng(this.dlatitude.doubleValue(), this.dlongitude.doubleValue())).title(this.title).snippet(this.snippet).icon(BitmapDescriptorFactory.fromResource(this.numMarkersInRainbow[0])));
        this.googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(new LatLng(this.dlatitude.doubleValue(), this.dlongitude.doubleValue())).zoom(20.0f).bearing(0.0f).tilt(45.0f).build()));
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
            bundle.putString("id_rec", id_rec);
            Fragment mFragment = Frg_Edit_Masjid.newInstance(bundle);
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
