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

public class Frg_Kegiatan extends Fragment {
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

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Kegiatan.myikc.1 */
        class C05651 extends WebViewClient {
            C05651() {
            }

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Kegiatan.myikc.2 */
        class C05672 implements OnClickListener {
            final /* synthetic */ WebView val$wv;

            /* renamed from: org.bpmikc.akm.Fragment.Frg_Kegiatan.myikc.2.1 */
            class C05661 extends WebViewClient {
                C05661() {
                }

                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            }

            C05672(WebView webView) {
                this.val$wv = webView;
            }

            public void onClick(View v) {
                Toast.makeText(Frg_Kegiatan.this.getActivity(), "Loading Info Masjid", 1).show();
                Frg_Kegiatan.this.url = Frg_Kegiatan.this.server_path + "/app_mobiles/get_kmo_menu.php?menu=info_masjid&idrec=" + Frg_Kegiatan.id_rec;
                this.val$wv.loadUrl(Frg_Kegiatan.this.url);
                this.val$wv.setWebViewClient(new C05661());
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Kegiatan.myikc.3 */
        class C05693 implements OnClickListener {
            final /* synthetic */ WebView val$wv;

            /* renamed from: org.bpmikc.akm.Fragment.Frg_Kegiatan.myikc.3.1 */
            class C05681 extends WebViewClient {
                C05681() {
                }

                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            }

            C05693(WebView webView) {
                this.val$wv = webView;
            }

            public void onClick(View v) {
                Toast.makeText(Frg_Kegiatan.this.getActivity(), "Loading Kegiatan", 1).show();
                Frg_Kegiatan.this.url = Frg_Kegiatan.this.server_path + "/app_mobiles/get_kmo_menu.php?menu=kegiatan&idrec=" + Frg_Kegiatan.id_rec;
                this.val$wv.loadUrl(Frg_Kegiatan.this.url);
                this.val$wv.setWebViewClient(new C05681());
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Kegiatan.myikc.4 */
        class C05704 implements OnClickListener {

            /* renamed from: org.bpmikc.akm.Fragment.Frg_Kegiatan.myikc.4.1 */
            class C08671 implements Listener<JSONObject> {
                C08671() {
                }

                public void onResponse(JSONObject response) {
                    try {
                        JSONArray ja = response.getJSONArray("masjid");
                        for (int i = 0; i < ja.length(); i++) {
                            JSONObject c = ja.getJSONObject(i);
                            Frg_Kegiatan.latitude = c.getString("latitude");
                            Frg_Kegiatan.longitude = c.getString("longitude");
                            Frg_Kegiatan.nama_masjid = c.getString("nama_masjid");
                            Frg_Kegiatan.alamat_masjid = c.getString("alamat_masjid");
                            Frg_Kegiatan.status = c.getString(Games.EXTRA_STATUS);
                            Frg_Kegiatan.id_rec = c.getString("id_rec");
                            Frg_Kegiatan.nama_kota = c.getString("flag_01");
                            Frg_Kegiatan.jenis_masjid = c.getString("jenis_masjid");
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString("nama_masjid", Frg_Kegiatan.nama_masjid);
                        bundle.putString("alamat_masjid", Frg_Kegiatan.alamat_masjid);
                        bundle.putString("nama_kota", Frg_Kegiatan.nama_kota);
                        bundle.putString("id_rec", Frg_Kegiatan.id_rec);
                        bundle.putString("latitude", Frg_Kegiatan.latitude);
                        bundle.putString("longitude", Frg_Kegiatan.longitude);
                        bundle.putString(Games.EXTRA_STATUS, Frg_Kegiatan.status);
                        bundle.putString("jenis_masjid", Frg_Kegiatan.jenis_masjid);
                        Fragment mFragment = Frg_Detail_Masjid_Lokasi.newInstance(bundle);
                        mFragment.setArguments(bundle);
                        Frg_Kegiatan.this.getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom, C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom).replace(C0615R.id.main_activity_content_frame, mFragment).addToBackStack(null).commit();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            /* renamed from: org.bpmikc.akm.Fragment.Frg_Kegiatan.myikc.4.2 */
            class C08682 implements ErrorListener {
                C08682() {
                }

                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            }

            C05704() {
            }

            public void onClick(View v) {
                String server_path = Frg_Kegiatan.this.getActivity().getSharedPreferences("MyPrefs", 0).getString("server_path", BuildConfig.FLAVOR);
                Frg_Kegiatan.id_rec = Frg_Kegiatan.this.getArguments().getString("id_rec");
                Volley.newRequestQueue(Frg_Kegiatan.this.getActivity()).add(new JsonObjectRequest(0, server_path + "/app_mobiles/get_idrec_masjid.php?id_rec=" + Frg_Kegiatan.id_rec, null, new C08671(), new C08682()));
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Kegiatan.myikc.5 */
        class C05715 implements OnClickListener {
            C05715() {
            }

            public void onClick(View v) {
                Frg_Kegiatan.this.getFragmentManager().popBackStack();
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Kegiatan.myikc.6 */
        class C05726 extends WebViewClient {
            final /* synthetic */ WebView val$wv;

            C05726(WebView webView) {
                this.val$wv = webView;
            }

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(Frg_Kegiatan.this.getActivity(), "Mohon periksa koneksi data internet anda ...", 0).show();
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
            Bundle bundle = Frg_Kegiatan.this.getArguments();
            Frg_Kegiatan.id_rec = bundle.getString("id_rec");
            Frg_Kegiatan.nama_masjid = bundle.getString("nama_masjid");
            Frg_Kegiatan.jenis_object = bundle.getString("jenis");
            TextView txtMasjid = (TextView) Frg_Kegiatan.this.getView().findViewById(C0615R.id.txtNamaMasjid);
            txtMasjid.setText(Frg_Kegiatan.nama_masjid + " (" + Frg_Kegiatan.id_rec + ")");
            txtMasjid.setGravity(17);
            ((AppCompatActivity) Frg_Kegiatan.this.getActivity()).getSupportActionBar().setTitle((CharSequence) "Informasi Masjid");
            Frg_Kegiatan.this.server_path = Frg_Kegiatan.this.getActivity().getSharedPreferences("MyPrefs", 0).getString("server_path", BuildConfig.FLAVOR);
            if (Frg_Kegiatan.jenis_object.equals("masjid")) {
                Frg_Kegiatan.this.url = Frg_Kegiatan.this.server_path + "/app_mobiles/get_kmo_menu.php?menu=info_masjid&idrec=" + Frg_Kegiatan.id_rec;
            } else {
                Frg_Kegiatan.this.url = Frg_Kegiatan.this.server_path + "/app_mobiles/get_kmo_menu.php?menu=info_marka&idrec=" + Frg_Kegiatan.id_rec;
            }
            WebView wv = (WebView) Frg_Kegiatan.this.getView().findViewById(C0615R.id.webview);
            wv.getSettings().setJavaScriptEnabled(true);
            wv.getSettings().setDefaultZoom(ZoomDensity.FAR);
            wv.loadUrl(Frg_Kegiatan.this.url);
            wv.setWebViewClient(new C05651());
            ((Button) Frg_Kegiatan.this.getView().findViewById(C0615R.id.btnInfoMasjid)).setOnClickListener(new C05672(wv));
            ((Button) Frg_Kegiatan.this.getView().findViewById(C0615R.id.btnKegiatan)).setOnClickListener(new C05693(wv));
            ((Button) Frg_Kegiatan.this.getView().findViewById(C0615R.id.btnEntry)).setOnClickListener(new C05704());
            ((Button) Frg_Kegiatan.this.getView().findViewById(C0615R.id.btnBackMap)).setOnClickListener(new C05715());
            wv.setWebViewClient(new C05726(wv));
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

    public Frg_Kegiatan() {
        this.url = BuildConfig.FLAVOR;
        this.server_path = BuildConfig.FLAVOR;
    }

    public static Frg_Kegiatan newInstance(Bundle bundle) {
        Frg_Kegiatan fragment = new Frg_Kegiatan();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        new myikc().execute(new String[0]);
        return inflater.inflate(C0615R.layout.fragment_frg__kegiatan, container, false);
    }
}
