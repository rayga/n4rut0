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
import android.widget.Toast;
import org.bpmikc.akm.BuildConfig;
import org.bpmikc.akm.C0615R;

public class Frg_Transaksi_Online extends Fragment {
    private static String activity_name;
    private static String slatitude;
    private static String slongitude;
    private static String user_id;
    private static String workflow_name;
    private ProgressDialog pDialog;
    private WebView wv;

    class myikc extends AsyncTask<String, String, String> {

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Transaksi_Online.myikc.1 */
        class C05991 extends WebViewClient {
            C05991() {
            }

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Transaksi_Online.myikc.2 */
        class C06002 extends WebViewClient {
            final /* synthetic */ WebView val$wv;

            C06002(WebView webView) {
                this.val$wv = webView;
            }

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(Frg_Transaksi_Online.this.getActivity(), "Mohon periksa koneksi data internet anda ...", 0).show();
                this.val$wv.loadDataWithBaseURL("file:///android_asset/", "<img src=\"file:///android_res/drawable/kesalahan.png\"/>", "text/html", "utf-8", null);
            }
        }

        myikc() {
        }

        protected void onPreExecute() {
            super.onPreExecute();
            Frg_Transaksi_Online.this.pDialog = new ProgressDialog(Frg_Transaksi_Online.this.getActivity());
            Frg_Transaksi_Online.this.pDialog.setMessage("Proses Akses Data BAM ...");
            Frg_Transaksi_Online.this.pDialog.setIndeterminate(false);
            Frg_Transaksi_Online.this.pDialog.setCancelable(true);
            Frg_Transaksi_Online.this.pDialog.show();
        }

        protected String doInBackground(String... args) {
            return null;
        }

        protected void onPostExecute(String file_url) {
            Bundle bundle = Frg_Transaksi_Online.this.getArguments();
            Frg_Transaksi_Online.slatitude = bundle.getString("latitude");
            Frg_Transaksi_Online.slongitude = bundle.getString("longitude");
            String url = Frg_Transaksi_Online.this.getActivity().getSharedPreferences("MyPrefs", 0).getString("server_path", BuildConfig.FLAVOR) + "/app_mobiles/get_kmo_menu.php?menu=transaksi_online";
            WebView wv = (WebView) Frg_Transaksi_Online.this.getView().findViewById(C0615R.id.webview);
            wv.getSettings().setJavaScriptEnabled(true);
            wv.getSettings().setDefaultZoom(ZoomDensity.FAR);
            wv.loadUrl(url);
            wv.setWebViewClient(new C05991());
            Frg_Transaksi_Online.this.pDialog.dismiss();
            wv.setWebViewClient(new C06002(wv));
        }
    }

    static {
        slatitude = BuildConfig.FLAVOR;
        slongitude = BuildConfig.FLAVOR;
        workflow_name = BuildConfig.FLAVOR;
        activity_name = BuildConfig.FLAVOR;
        user_id = BuildConfig.FLAVOR;
    }

    public static Frg_Transaksi_Online newInstance(Bundle bundle) {
        Frg_Transaksi_Online fragment = new Frg_Transaksi_Online();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        new myikc().execute(new String[0]);
        return inflater.inflate(C0615R.layout.fragment_frg__transaksi__online, container, false);
    }
}
