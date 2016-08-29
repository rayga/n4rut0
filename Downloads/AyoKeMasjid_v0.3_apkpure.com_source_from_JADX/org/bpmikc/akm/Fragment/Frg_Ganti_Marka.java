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
import com.google.android.gms.drive.events.CompletionEvent;
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
import com.google.android.gms.vision.barcode.Barcode;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.bpmikc.akm.BuildConfig;
import org.bpmikc.akm.C0615R;
import org.json.JSONArray;

public class Frg_Ganti_Marka extends Fragment implements OnMapClickListener, OnMarkerClickListener {
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
    private String jenis_marka;
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

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Ganti_Marka.myikc.1 */
        class C05541 implements OnClickListener {
            C05541() {
            }

            public void onClick(View v) {
                Toast.makeText(Frg_Ganti_Marka.this.getActivity(), "Google Map Normal ... ", 1).show();
                Frg_Ganti_Marka.this.googleMap.setMapType(1);
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Ganti_Marka.myikc.2 */
        class C05552 implements OnClickListener {
            C05552() {
            }

            public void onClick(View v) {
                Toast.makeText(Frg_Ganti_Marka.this.getActivity(), "Google Map Satellite ... ", 1).show();
                Frg_Ganti_Marka.this.googleMap.setMapType(2);
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Ganti_Marka.myikc.3 */
        class C05563 implements OnClickListener {
            C05563() {
            }

            public void onClick(View v) {
                Toast.makeText(Frg_Ganti_Marka.this.getActivity(), "Google Map Terrain ... ", 1).show();
                Frg_Ganti_Marka.this.googleMap.setMapType(3);
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Ganti_Marka.myikc.4 */
        class C05574 implements OnClickListener {
            C05574() {
            }

            public void onClick(View v) {
                Toast.makeText(Frg_Ganti_Marka.this.getActivity(), "Google Map Hybrid ... ", 1).show();
                Frg_Ganti_Marka.this.googleMap.setMapType(4);
            }
        }

        myikc() {
        }

        protected String doInBackground(String... args) {
            return null;
        }

        protected void onPostExecute(String file_url) {
            ((Button) Frg_Ganti_Marka.this.getView().findViewById(C0615R.id.btnNormal)).setOnClickListener(new C05541());
            ((Button) Frg_Ganti_Marka.this.getView().findViewById(C0615R.id.btnSatellite)).setOnClickListener(new C05552());
            ((Button) Frg_Ganti_Marka.this.getView().findViewById(C0615R.id.btnTerrain)).setOnClickListener(new C05563());
            ((Button) Frg_Ganti_Marka.this.getView().findViewById(C0615R.id.btnHybrid)).setOnClickListener(new C05574());
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

    public Frg_Ganti_Marka() {
        this.numMarkersInRainbow = new int[]{C0615R.drawable.masjid_kuning_marker, C0615R.drawable.masjid_marker};
        this.map = new HashMap();
        this.dataJsonArr = null;
        this.title = BuildConfig.FLAVOR;
        this.snippet = BuildConfig.FLAVOR;
        this.icon_marker = BuildConfig.FLAVOR;
        this.jenis_marka = BuildConfig.FLAVOR;
    }

    public static Frg_Ganti_Marka newInstance(Bundle bundle) {
        Frg_Ganti_Marka fragment = new Frg_Ganti_Marka();
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
        this.jenis_marka = bundle.getString("jenis");
        this.vGmap = inflater.inflate(C0615R.layout.fragment_frg__ganti__marka, container, false);
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
        String str = this.jenis_marka;
        boolean z = true;
        switch (str.hashCode()) {
            case -1897165425:
                if (str.equals("stasiun")) {
                    z = true;
                    break;
                }
                break;
            case -1766867402:
                if (str.equals("rumah_makan")) {
                    z = true;
                    break;
                }
                break;
            case -1290033282:
                if (str.equals("pom_bensin")) {
                    z = true;
                    break;
                }
                break;
            case -1181248900:
                if (str.equals("terminal")) {
                    z = true;
                    break;
                }
                break;
            case -982669550:
                if (str.equals("polisi")) {
                    z = true;
                    break;
                }
                break;
            case -703981192:
                if (str.equals("pelabuhan")) {
                    z = true;
                    break;
                }
                break;
            case -337261573:
                if (str.equals("bandara")) {
                    z = true;
                    break;
                }
                break;
            case -222646378:
                if (str.equals("bengkel")) {
                    z = true;
                    break;
                }
                break;
            case 96922:
                if (str.equals("atm")) {
                    z = false;
                    break;
                }
                break;
            case 65872687:
                if (str.equals("penginapan")) {
                    z = true;
                    break;
                }
                break;
            case 106437715:
                if (str.equals("pasar")) {
                    z = true;
                    break;
                }
                break;
            case 226569185:
                if (str.equals("pengobatan")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
                this.googleMap.addMarker(new MarkerOptions().position(new LatLng(this.dlatitude.doubleValue(), this.dlongitude.doubleValue())).title(this.title).snippet(id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.atm_marker)));
                break;
            case CompletionEvent.STATUS_FAILURE /*1*/:
                this.googleMap.addMarker(new MarkerOptions().position(new LatLng(this.dlatitude.doubleValue(), this.dlongitude.doubleValue())).title(this.title).snippet(id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.bandara_marker)));
                break;
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                this.googleMap.addMarker(new MarkerOptions().position(new LatLng(this.dlatitude.doubleValue(), this.dlongitude.doubleValue())).title(this.title).snippet(id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.bengkel_marker)));
                break;
            case CompletionEvent.STATUS_CANCELED /*3*/:
                this.googleMap.addMarker(new MarkerOptions().position(new LatLng(this.dlatitude.doubleValue(), this.dlongitude.doubleValue())).title(this.title).snippet(id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.pasar_marker)));
                break;
            case Barcode.PHONE /*4*/:
                this.googleMap.addMarker(new MarkerOptions().position(new LatLng(this.dlatitude.doubleValue(), this.dlongitude.doubleValue())).title(this.title).snippet(id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.pelabuhan_marker)));
                break;
            case Barcode.PRODUCT /*5*/:
                this.googleMap.addMarker(new MarkerOptions().position(new LatLng(this.dlatitude.doubleValue(), this.dlongitude.doubleValue())).title(this.title).snippet(id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.penginapan_marker)));
                break;
            case Barcode.SMS /*6*/:
                this.googleMap.addMarker(new MarkerOptions().position(new LatLng(this.dlatitude.doubleValue(), this.dlongitude.doubleValue())).title(this.title).snippet(id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.polisi_marker)));
                break;
            case Barcode.TEXT /*7*/:
                this.googleMap.addMarker(new MarkerOptions().position(new LatLng(this.dlatitude.doubleValue(), this.dlongitude.doubleValue())).title(this.title).snippet(id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.pombensin_marker)));
                break;
            case Barcode.URL /*8*/:
                this.googleMap.addMarker(new MarkerOptions().position(new LatLng(this.dlatitude.doubleValue(), this.dlongitude.doubleValue())).title(this.title).snippet(id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.rumahsakit_marker)));
                break;
            case Barcode.WIFI /*9*/:
                this.googleMap.addMarker(new MarkerOptions().position(new LatLng(this.dlatitude.doubleValue(), this.dlongitude.doubleValue())).title(this.title).snippet(id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.restoran_marker)));
                break;
            case Barcode.GEO /*10*/:
                this.googleMap.addMarker(new MarkerOptions().position(new LatLng(this.dlatitude.doubleValue(), this.dlongitude.doubleValue())).title(this.title).snippet(id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.stasiunkereta_marker)));
                break;
            case Barcode.CALENDAR_EVENT /*11*/:
                this.googleMap.addMarker(new MarkerOptions().position(new LatLng(this.dlatitude.doubleValue(), this.dlongitude.doubleValue())).title(this.title).snippet(id_rec).icon(BitmapDescriptorFactory.fromResource(C0615R.drawable.terminal_marker)));
                break;
        }
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
            Fragment mFragment = Frg_Edit_Marka.newInstance(bundle);
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
