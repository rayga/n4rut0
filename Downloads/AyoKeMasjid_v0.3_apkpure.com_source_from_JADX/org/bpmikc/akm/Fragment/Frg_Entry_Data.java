package org.bpmikc.akm.Fragment;

import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import org.bpmikc.akm.BuildConfig;
import org.bpmikc.akm.C0615R;

public class Frg_Entry_Data extends Fragment {
    private static String activity_name;
    private static String alamat_masjid;
    private static String id_rec;
    private static String latitude;
    private static String longitude;
    private static String nama_kota;
    private static String nama_masjid;
    private static String slatitude;
    private static String slongitude;
    private static String status;
    private static String user_id;
    private static String workflow_name;
    Bundle bundle;
    private ProgressDialog pDialog;
    private String server_path;
    private String url;
    private WebView wv;

    public class WebAppInterface {
        Context mContext;

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Entry_Data.WebAppInterface.1 */
        class C05401 implements OnClickListener {
            C05401() {
            }

            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                }
            }
        }

        WebAppInterface(Context c) {
            this.mContext = c;
        }

        @JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(this.mContext, toast, 0).show();
        }

        @JavascriptInterface
        public void showUploadImage(String id_rec, String id_rec_master, String id_proses) {
            Bundle bundlez = new Bundle();
            bundlez.putString("id_rec", id_rec);
            bundlez.putString("id_rec_master", id_rec_master);
            bundlez.putString("id_proses", id_proses);
            Fragment mFragment = Frg_Upload_Html.newInstance(bundlez);
            mFragment.setArguments(bundlez);
            Frg_Entry_Data.this.getActivity().getSupportFragmentManager().beginTransaction().replace(C0615R.id.main_activity_content_frame, mFragment).addToBackStack(null).commit();
        }

        @JavascriptInterface
        public void showDialog(String pesan, String judul) {
            new Builder(Frg_Entry_Data.this.getActivity()).setMessage(pesan).setCancelable(false).setTitle(judul).setPositiveButton("Ya", new C05401()).show();
        }
    }

    class myikc extends AsyncTask<String, String, String> {

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Entry_Data.myikc.1 */
        class C05421 implements View.OnClickListener {
            final /* synthetic */ WebView val$wv;

            /* renamed from: org.bpmikc.akm.Fragment.Frg_Entry_Data.myikc.1.1 */
            class C05411 extends WebViewClient {
                C05411() {
                }

                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            }

            C05421(WebView webView) {
                this.val$wv = webView;
            }

            public void onClick(View v) {
                Toast.makeText(Frg_Entry_Data.this.getActivity(), "Loading Info Masjid", 1).show();
                Frg_Entry_Data.this.url = Frg_Entry_Data.this.server_path + "/app_mobiles/get_kmo_menu.php?menu=entry_info_masjid&idrec=" + Frg_Entry_Data.id_rec;
                this.val$wv.loadUrl(Frg_Entry_Data.this.url);
                this.val$wv.setWebViewClient(new C05411());
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Entry_Data.myikc.2 */
        class C05442 implements View.OnClickListener {
            final /* synthetic */ WebView val$wv;

            /* renamed from: org.bpmikc.akm.Fragment.Frg_Entry_Data.myikc.2.1 */
            class C05431 extends WebViewClient {
                C05431() {
                }

                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            }

            C05442(WebView webView) {
                this.val$wv = webView;
            }

            public void onClick(View v) {
                Toast.makeText(Frg_Entry_Data.this.getActivity(), "Loading Kegiatan", 1).show();
                Frg_Entry_Data.this.url = Frg_Entry_Data.this.server_path + "/app_mobiles/get_kmo_menu.php?menu=entry_kegiatan&idrec=" + Frg_Entry_Data.id_rec;
                this.val$wv.loadUrl(Frg_Entry_Data.this.url);
                this.val$wv.setWebViewClient(new C05431());
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Entry_Data.myikc.3 */
        class C05453 implements View.OnClickListener {
            C05453() {
            }

            public void onClick(View v) {
                Fragment mFragment = Frg_Upload_Image.newInstance(Frg_Entry_Data.this.bundle);
                mFragment.setArguments(Frg_Entry_Data.this.bundle);
                Frg_Entry_Data.this.getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom, C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom).replace(C0615R.id.main_activity_content_frame, mFragment).addToBackStack(null).commit();
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Entry_Data.myikc.4 */
        class C05464 implements View.OnClickListener {
            C05464() {
            }

            public void onClick(View v) {
                Frg_Entry_Data.this.getFragmentManager().popBackStack();
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Entry_Data.myikc.5 */
        class C05475 extends WebViewClient {
            final /* synthetic */ WebView val$wv;

            C05475(WebView webView) {
                this.val$wv = webView;
            }

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(Frg_Entry_Data.this.getActivity(), "Mohon periksa koneksi data internet anda ...", 0).show();
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
            Frg_Entry_Data.this.bundle = Frg_Entry_Data.this.getArguments();
            Frg_Entry_Data.id_rec = Frg_Entry_Data.this.bundle.getString("id_rec");
            Frg_Entry_Data.nama_masjid = Frg_Entry_Data.this.bundle.getString("nama_masjid");
            TextView txtMasjid = (TextView) Frg_Entry_Data.this.getView().findViewById(C0615R.id.txtNamaMasjid2);
            txtMasjid.setText(Frg_Entry_Data.nama_masjid + " (" + Frg_Entry_Data.id_rec + ")");
            txtMasjid.setGravity(17);
            ((AppCompatActivity) Frg_Entry_Data.this.getActivity()).getSupportActionBar().setTitle((CharSequence) "Entry Data");
            Frg_Entry_Data.this.server_path = Frg_Entry_Data.this.getActivity().getSharedPreferences("MyPrefs", 0).getString("server_path", BuildConfig.FLAVOR);
            Frg_Entry_Data.this.url = Frg_Entry_Data.this.server_path + "/app_mobiles/get_kmo_menu.php?menu=entry_info_masjid&idrec=" + Frg_Entry_Data.id_rec;
            WebView wv = (WebView) Frg_Entry_Data.this.getView().findViewById(C0615R.id.webview);
            WebSettings webSettings = wv.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webSettings.setBuiltInZoomControls(true);
            wv.requestFocusFromTouch();
            wv.setWebViewClient(new WebViewClient());
            wv.setWebChromeClient(new WebChromeClient());
            wv.addJavascriptInterface(new WebAppInterface(Frg_Entry_Data.this.getActivity()), "Android");
            wv.loadUrl(Frg_Entry_Data.this.url);
            ((Button) Frg_Entry_Data.this.getView().findViewById(C0615R.id.ebtnInfoMasjid)).setOnClickListener(new C05421(wv));
            ((Button) Frg_Entry_Data.this.getView().findViewById(C0615R.id.ebtnKegiatan)).setOnClickListener(new C05442(wv));
            ((Button) Frg_Entry_Data.this.getView().findViewById(C0615R.id.ebtnPhoto)).setOnClickListener(new C05453());
            ((Button) Frg_Entry_Data.this.getView().findViewById(C0615R.id.ebtnBackMap)).setOnClickListener(new C05464());
            wv.setWebViewClient(new C05475(wv));
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
    }

    public Frg_Entry_Data() {
        this.url = BuildConfig.FLAVOR;
        this.server_path = BuildConfig.FLAVOR;
    }

    public static Frg_Entry_Data newInstance(Bundle bundle) {
        Frg_Entry_Data fragment = new Frg_Entry_Data();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        new myikc().execute(new String[0]);
        return inflater.inflate(C0615R.layout.fragment_frg__entry__data, container, false);
    }
}
