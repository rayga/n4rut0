package org.bpmikc.akm.Fragment;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings.ZoomDensity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import org.bpmikc.akm.BuildConfig;
import org.bpmikc.akm.C0615R;

public class Frg_Jadwal_Sholat extends Fragment {
    private static String activity_name;
    private static String slatitude;
    private static String slongitude;
    private static String user_id;
    private static String workflow_name;
    private ProgressDialog pDialog;

    class myikc extends AsyncTask<String, String, String> {

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Jadwal_Sholat.myikc.1 */
        class C05641 extends WebViewClient {
            C05641() {
            }

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        }

        myikc() {
        }

        protected void onPreExecute() {
            super.onPreExecute();
            Frg_Jadwal_Sholat.this.pDialog = new ProgressDialog(Frg_Jadwal_Sholat.this.getActivity());
            Frg_Jadwal_Sholat.this.pDialog.setMessage("Proses Akses Data BAM ...");
            Frg_Jadwal_Sholat.this.pDialog.setIndeterminate(false);
            Frg_Jadwal_Sholat.this.pDialog.setCancelable(true);
            Frg_Jadwal_Sholat.this.pDialog.show();
        }

        protected String doInBackground(String... args) {
            return null;
        }

        protected void onPostExecute(String file_url) {
            Bundle bundle = Frg_Jadwal_Sholat.this.getArguments();
            Frg_Jadwal_Sholat.slatitude = bundle.getString("latitude");
            Frg_Jadwal_Sholat.slongitude = bundle.getString("longitude");
            String url = Frg_Jadwal_Sholat.this.getActivity().getSharedPreferences("MyPrefs", 0).getString("server_path", BuildConfig.FLAVOR) + "/app_mobiles/get_jadwal_sholat.php";
            WebView wv = (WebView) Frg_Jadwal_Sholat.this.getView().findViewById(C0615R.id.webview);
            wv.getSettings().setJavaScriptEnabled(true);
            wv.getSettings().setDefaultZoom(ZoomDensity.FAR);
            wv.loadUrl(url);
            wv.setWebViewClient(new C05641());
            Frg_Jadwal_Sholat.this.pDialog.dismiss();
        }
    }

    static {
        slatitude = BuildConfig.FLAVOR;
        slongitude = BuildConfig.FLAVOR;
        workflow_name = BuildConfig.FLAVOR;
        activity_name = BuildConfig.FLAVOR;
        user_id = BuildConfig.FLAVOR;
    }

    public static Frg_Jadwal_Sholat newInstance(Bundle bundle) {
        Frg_Jadwal_Sholat fragment = new Frg_Jadwal_Sholat();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        new myikc().execute(new String[0]);
        return inflater.inflate(C0615R.layout.fragment_frg__jadwal__sholat, container, false);
    }
}
