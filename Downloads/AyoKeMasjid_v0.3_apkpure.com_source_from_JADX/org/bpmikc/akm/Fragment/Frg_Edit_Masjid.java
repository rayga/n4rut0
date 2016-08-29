package org.bpmikc.akm.Fragment;

import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;
import org.bpmikc.akm.BuildConfig;
import org.bpmikc.akm.C0615R;

public class Frg_Edit_Masjid extends Fragment {
    private static String activity_name;
    private static String sidrec;
    private static String slatitude;
    private static String slongitude;
    private static String user_id;
    private ProgressDialog pDialog;

    public class WebAppInterface {
        Context mContext;

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Edit_Masjid.WebAppInterface.1 */
        class C05381 implements OnClickListener {
            C05381() {
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
        public void showDialog(String pesan, String judul) {
            new Builder(Frg_Edit_Masjid.this.getActivity()).setMessage(pesan).setCancelable(false).setTitle(judul).setPositiveButton("Ya", new C05381()).show();
        }

        @JavascriptInterface
        public void TampilMap(String zid_rec, String znama_masjid, String zalamat_masjid, String znama_kota, String zlatitude, String zlongitude) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("id_rec", zid_rec);
            bundle2.putString("nama_masjid", znama_masjid);
            bundle2.putString("alamat_masjid", zalamat_masjid);
            bundle2.putString("nama_kota", znama_kota);
            bundle2.putString("latitude", zlatitude);
            bundle2.putString("longitude", zlongitude);
            Fragment mFragment = Frg_Cari_Masjid_Map.newInstance(bundle2);
            mFragment.setArguments(bundle2);
            Frg_Edit_Masjid.this.getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom, C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom).replace(C0615R.id.main_activity_content_frame, mFragment).addToBackStack(null).commit();
        }
    }

    class myikc extends AsyncTask<String, String, String> {

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Edit_Masjid.myikc.1 */
        class C05391 implements View.OnClickListener {
            C05391() {
            }

            public void onClick(View v) {
                Toast.makeText(Frg_Edit_Masjid.this.getActivity(), "Loading Form Edit Masjid", 1).show();
                new myikc().execute(new String[0]);
            }
        }

        myikc() {
        }

        protected void onPreExecute() {
            super.onPreExecute();
            Frg_Edit_Masjid.this.pDialog = new ProgressDialog(Frg_Edit_Masjid.this.getActivity());
            Frg_Edit_Masjid.this.pDialog.setMessage("Proses Akses Data BAM ...");
            Frg_Edit_Masjid.this.pDialog.setIndeterminate(false);
            Frg_Edit_Masjid.this.pDialog.setCancelable(true);
            Frg_Edit_Masjid.this.pDialog.show();
        }

        protected String doInBackground(String... args) {
            return null;
        }

        protected void onPostExecute(String file_url) {
            Bundle bundle = Frg_Edit_Masjid.this.getArguments();
            Frg_Edit_Masjid.slatitude = bundle.getString("latitude");
            Frg_Edit_Masjid.slongitude = bundle.getString("longitude");
            Frg_Edit_Masjid.sidrec = bundle.getString("id_rec");
            String url = Frg_Edit_Masjid.this.getActivity().getSharedPreferences("MyPrefs", 0).getString("server_path", BuildConfig.FLAVOR) + "/app_rep/fc_a_tbl_master_masjid_latlng.php?id_rec=" + Frg_Edit_Masjid.sidrec + "&lat=" + Frg_Edit_Masjid.slatitude + "&long=" + Frg_Edit_Masjid.slongitude;
            ((Button) Frg_Edit_Masjid.this.getView().findViewById(C0615R.id.btnWfNameBam)).setText("Reload Form Entry");
            WebView wv = (WebView) Frg_Edit_Masjid.this.getView().findViewById(C0615R.id.webview);
            WebSettings webSettings = wv.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webSettings.setBuiltInZoomControls(true);
            wv.requestFocusFromTouch();
            wv.setWebViewClient(new WebViewClient());
            wv.setWebChromeClient(new WebChromeClient());
            wv.addJavascriptInterface(new WebAppInterface(Frg_Edit_Masjid.this.getActivity()), "Android");
            wv.loadUrl(url);
            Frg_Edit_Masjid.this.pDialog.dismiss();
            ((Button) Frg_Edit_Masjid.this.getView().findViewById(C0615R.id.btnWfNameBam)).setOnClickListener(new C05391());
        }
    }

    static {
        slatitude = BuildConfig.FLAVOR;
        slongitude = BuildConfig.FLAVOR;
        sidrec = BuildConfig.FLAVOR;
        activity_name = BuildConfig.FLAVOR;
        user_id = BuildConfig.FLAVOR;
    }

    public static Frg_Edit_Masjid newInstance(Bundle bundle) {
        Frg_Edit_Masjid fragment = new Frg_Edit_Masjid();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        new myikc().execute(new String[0]);
        return inflater.inflate(C0615R.layout.fragment_frg__edit__masjid, container, false);
    }
}
