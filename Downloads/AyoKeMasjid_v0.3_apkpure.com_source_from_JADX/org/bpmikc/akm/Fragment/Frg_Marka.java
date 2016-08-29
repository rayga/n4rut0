package org.bpmikc.akm.Fragment;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebSettings.ZoomDensity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.games.Games;
import org.bpmikc.akm.BuildConfig;
import org.bpmikc.akm.C0615R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Frg_Marka extends Fragment {
    private static String activity_name;
    private static String alamat_masjid;
    private static String id_rec;
    private static String jenis_masjid;
    private static String jenis_object;
    private static String latitude;
    private static String longitude;
    private static String nama_kota;
    private static String nama_masjid;
    private static String slatitude;
    private static String slongitude;
    private static String status;
    private static String user_id;
    private static String workflow_name;
    private ProgressDialog pDialog;
    private String server_path;
    private String url;
    private WebView wv;

    class myikc extends AsyncTask<String, String, String> {

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Marka.myikc.1 */
        class C05851 extends WebViewClient {
            C05851() {
            }

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Marka.myikc.2 */
        class C05872 implements OnClickListener {
            final /* synthetic */ WebView val$wv;

            /* renamed from: org.bpmikc.akm.Fragment.Frg_Marka.myikc.2.1 */
            class C05861 extends WebViewClient {
                C05861() {
                }

                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            }

            C05872(WebView webView) {
                this.val$wv = webView;
            }

            public void onClick(View v) {
                Toast.makeText(Frg_Marka.this.getActivity(), "Loading Info Marka", 1).show();
                Frg_Marka.this.url = Frg_Marka.this.server_path + "/app_mobiles/get_kmo_menu.php?menu=info_marka&idrec=" + Frg_Marka.id_rec;
                this.val$wv.loadUrl(Frg_Marka.this.url);
                this.val$wv.setWebViewClient(new C05861());
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Marka.myikc.3 */
        class C05883 implements OnClickListener {
            C05883() {
            }

            public void onClick(View v) {
                Bundle bundlePhoto = new Bundle();
                bundlePhoto.putString("id_rec", Frg_Marka.id_rec);
                bundlePhoto.putString("id_proses", "marka");
                bundlePhoto.putString("id_rec_master", Frg_Marka.id_rec);
                Fragment mFragment = Frg_Upload_Marka.newInstance(bundlePhoto);
                mFragment.setArguments(bundlePhoto);
                Frg_Marka.this.getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom, C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom).replace(C0615R.id.main_activity_content_frame, mFragment).addToBackStack(null).commit();
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Marka.myikc.4 */
        class C05894 implements OnClickListener {

            /* renamed from: org.bpmikc.akm.Fragment.Frg_Marka.myikc.4.1 */
            class C08751 implements Listener<JSONObject> {
                C08751() {
                }

                public void onResponse(JSONObject response) {
                    try {
                        JSONArray ja = response.getJSONArray("masjid");
                        for (int i = 0; i < ja.length(); i++) {
                            JSONObject c = ja.getJSONObject(i);
                            Frg_Marka.latitude = c.getString("latitude");
                            Frg_Marka.longitude = c.getString("longitude");
                            Frg_Marka.nama_masjid = c.getString("nama_masjid");
                            Frg_Marka.alamat_masjid = c.getString("alamat_masjid");
                            Frg_Marka.status = c.getString(Games.EXTRA_STATUS);
                            Frg_Marka.id_rec = c.getString("id_rec");
                            Frg_Marka.nama_kota = c.getString("flag_01");
                            Frg_Marka.jenis_masjid = c.getString("jenis_masjid");
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString("nama_masjid", Frg_Marka.nama_masjid);
                        bundle.putString("alamat_masjid", Frg_Marka.alamat_masjid);
                        bundle.putString("nama_kota", Frg_Marka.nama_kota);
                        bundle.putString("id_rec", Frg_Marka.id_rec);
                        bundle.putString("latitude", Frg_Marka.latitude);
                        bundle.putString("longitude", Frg_Marka.longitude);
                        bundle.putString(Games.EXTRA_STATUS, Frg_Marka.status);
                        bundle.putString("jenis_masjid", Frg_Marka.jenis_masjid);
                        Fragment mFragment = Frg_Detail_Marka.newInstance(bundle);
                        mFragment.setArguments(bundle);
                        Frg_Marka.this.getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom, C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom).replace(C0615R.id.main_activity_content_frame, mFragment).addToBackStack(null).commit();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            /* renamed from: org.bpmikc.akm.Fragment.Frg_Marka.myikc.4.2 */
            class C08762 implements ErrorListener {
                C08762() {
                }

                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            }

            C05894() {
            }

            public void onClick(View v) {
                String server_path = Frg_Marka.this.getActivity().getSharedPreferences("MyPrefs", 0).getString("server_path", BuildConfig.FLAVOR);
                Frg_Marka.id_rec = Frg_Marka.this.getArguments().getString("id_rec");
                Volley.newRequestQueue(Frg_Marka.this.getActivity()).add(new JsonObjectRequest(0, server_path + "/app_mobiles/get_idrec_marka.php?id_rec=" + Frg_Marka.id_rec, null, new C08751(), new C08762()));
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Marka.myikc.5 */
        class C05905 extends WebViewClient {
            final /* synthetic */ WebView val$wv;

            C05905(WebView webView) {
                this.val$wv = webView;
            }

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(Frg_Marka.this.getActivity(), "Mohon periksa koneksi data internet anda ...", 0).show();
                this.val$wv.loadDataWithBaseURL("file:///android_asset/", "<img src=\"file:///android_res/drawable/kesalahan.png\"/>", "text/html", "utf-8", null);
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
            Bundle bundle = Frg_Marka.this.getArguments();
            Frg_Marka.id_rec = bundle.getString("id_rec");
            Frg_Marka.nama_masjid = bundle.getString("nama_masjid");
            Frg_Marka.jenis_object = bundle.getString("jenis");
            Toast.makeText(Frg_Marka.this.getActivity(), Frg_Marka.jenis_object, 0).show();
            TextView txtMasjid = (TextView) Frg_Marka.this.getView().findViewById(C0615R.id.txtNamaMasjid);
            txtMasjid.setText(Frg_Marka.nama_masjid + " (" + Frg_Marka.id_rec + ")");
            txtMasjid.setGravity(17);
            ((AppCompatActivity) Frg_Marka.this.getActivity()).getSupportActionBar().setTitle((CharSequence) "Informasi Marka");
            Frg_Marka.this.server_path = Frg_Marka.this.getActivity().getSharedPreferences("MyPrefs", 0).getString("server_path", BuildConfig.FLAVOR);
            Frg_Marka.this.url = Frg_Marka.this.server_path + "/app_mobiles/get_kmo_menu.php?menu=info_marka&idrec=" + Frg_Marka.id_rec;
            WebView wv = (WebView) Frg_Marka.this.getView().findViewById(C0615R.id.webview);
            wv.getSettings().setJavaScriptEnabled(true);
            wv.getSettings().setDefaultZoom(ZoomDensity.FAR);
            wv.loadUrl(Frg_Marka.this.url);
            wv.setWebViewClient(new C05851());
            ((Button) Frg_Marka.this.getView().findViewById(C0615R.id.btnInfoMasjid)).setOnClickListener(new C05872(wv));
            ((Button) Frg_Marka.this.getView().findViewById(C0615R.id.btnUploadPhoto)).setOnClickListener(new C05883());
            ((Button) Frg_Marka.this.getView().findViewById(C0615R.id.btnEntry)).setOnClickListener(new C05894());
            wv.setWebViewClient(new C05905(wv));
        }
    }

    static {
        slatitude = BuildConfig.FLAVOR;
        slongitude = BuildConfig.FLAVOR;
        workflow_name = BuildConfig.FLAVOR;
        activity_name = BuildConfig.FLAVOR;
        user_id = BuildConfig.FLAVOR;
        nama_masjid = BuildConfig.FLAVOR;
        alamat_masjid = BuildConfig.FLAVOR;
        nama_kota = BuildConfig.FLAVOR;
        id_rec = BuildConfig.FLAVOR;
        latitude = BuildConfig.FLAVOR;
        longitude = BuildConfig.FLAVOR;
        status = BuildConfig.FLAVOR;
        jenis_masjid = BuildConfig.FLAVOR;
        jenis_object = BuildConfig.FLAVOR;
    }

    public Frg_Marka() {
        this.url = BuildConfig.FLAVOR;
        this.server_path = BuildConfig.FLAVOR;
    }

    public static Frg_Marka newInstance(Bundle bundle) {
        Frg_Marka fragment = new Frg_Marka();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        new myikc().execute(new String[0]);
        return inflater.inflate(C0615R.layout.fragment_frg__marka, container, false);
    }
}
