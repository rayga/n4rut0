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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.games.Games;
import org.bpmikc.akm.BuildConfig;
import org.bpmikc.akm.C0615R;

public class Frg_Detail_Marka extends Fragment {
    private static String activity_name;
    private static String alamat_masjid;
    private static String id_rec;
    private static String jenis_masjid;
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

    class myikc extends AsyncTask<String, String, String> {

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Detail_Marka.myikc.1 */
        class C05191 implements OnClickListener {
            final /* synthetic */ Bundle val$bundle2;

            C05191(Bundle bundle) {
                this.val$bundle2 = bundle;
            }

            public void onClick(View v) {
                Fragment mFragment = Frg_Cari_Marka_Map.newInstance(this.val$bundle2);
                mFragment.setArguments(this.val$bundle2);
                Frg_Detail_Marka.this.getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom, C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom).replace(C0615R.id.main_activity_content_frame, mFragment).addToBackStack(null).commit();
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Detail_Marka.myikc.2 */
        class C05202 implements OnClickListener {
            final /* synthetic */ Bundle val$bundle2;

            C05202(Bundle bundle) {
                this.val$bundle2 = bundle;
            }

            public void onClick(View v) {
                Toast.makeText(Frg_Detail_Marka.this.getActivity(), "Loading Informasi Masjid", 1).show();
                Fragment mFragment = Frg_Marka.newInstance(this.val$bundle2);
                mFragment.setArguments(this.val$bundle2);
                Frg_Detail_Marka.this.getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom, C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom).replace(C0615R.id.main_activity_content_frame, mFragment).addToBackStack(null).commit();
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Detail_Marka.myikc.3 */
        class C05213 implements OnClickListener {
            final /* synthetic */ Bundle val$bundle2;

            C05213(Bundle bundle) {
                this.val$bundle2 = bundle;
            }

            public void onClick(View v) {
                Fragment mFragment = Frg_Ganti_Marka.newInstance(this.val$bundle2);
                mFragment.setArguments(this.val$bundle2);
                Frg_Detail_Marka.this.getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom, C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom).replace(C0615R.id.main_activity_content_frame, mFragment).addToBackStack(null).commit();
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
            Bundle bundle = Frg_Detail_Marka.this.getArguments();
            Frg_Detail_Marka.nama_masjid = bundle.getString("nama_masjid");
            Frg_Detail_Marka.alamat_masjid = bundle.getString("alamat_masjid");
            Frg_Detail_Marka.nama_kota = bundle.getString("nama_kota");
            Frg_Detail_Marka.id_rec = bundle.getString("id_rec");
            Frg_Detail_Marka.latitude = bundle.getString("latitude");
            Frg_Detail_Marka.longitude = bundle.getString("longitude");
            Frg_Detail_Marka.status = bundle.getString(Games.EXTRA_STATUS);
            Frg_Detail_Marka.jenis_masjid = bundle.getString("jenis_masjid");
            ((AppCompatActivity) Frg_Detail_Marka.this.getActivity()).getSupportActionBar().setTitle((CharSequence) "Data Marka");
            ((EditText) Frg_Detail_Marka.this.getView().findViewById(C0615R.id.txtd_nama_masjid)).setText(Frg_Detail_Marka.nama_masjid);
            ((EditText) Frg_Detail_Marka.this.getView().findViewById(C0615R.id.txtd_alamat_masjid)).setText(Frg_Detail_Marka.alamat_masjid);
            ((EditText) Frg_Detail_Marka.this.getView().findViewById(C0615R.id.txtd_nama_kota)).setText(Frg_Detail_Marka.nama_kota);
            ((EditText) Frg_Detail_Marka.this.getView().findViewById(C0615R.id.txtd_latitude)).setText(Frg_Detail_Marka.latitude);
            ((EditText) Frg_Detail_Marka.this.getView().findViewById(C0615R.id.txtd_longitude)).setText(Frg_Detail_Marka.longitude);
            ((EditText) Frg_Detail_Marka.this.getView().findViewById(C0615R.id.txtd_status)).setText(Frg_Detail_Marka.status);
            ((EditText) Frg_Detail_Marka.this.getView().findViewById(C0615R.id.txtd_id_rec)).setText(Frg_Detail_Marka.id_rec);
            ((EditText) Frg_Detail_Marka.this.getView().findViewById(C0615R.id.txtd_jenis_masjid)).setText(Frg_Detail_Marka.jenis_masjid);
            Bundle bundle2 = new Bundle();
            bundle2.putString("id_rec", Frg_Detail_Marka.id_rec);
            bundle2.putString("nama_masjid", Frg_Detail_Marka.nama_masjid);
            bundle2.putString("alamat_masjid", Frg_Detail_Marka.alamat_masjid);
            bundle2.putString("nama_kota", Frg_Detail_Marka.nama_kota);
            bundle2.putString("latitude", Frg_Detail_Marka.latitude);
            bundle2.putString("longitude", Frg_Detail_Marka.longitude);
            bundle2.putString(Games.EXTRA_STATUS, Frg_Detail_Marka.status);
            bundle2.putString("jenis", Frg_Detail_Marka.jenis_masjid);
            ((Button) Frg_Detail_Marka.this.getView().findViewById(C0615R.id.btnGMap)).setOnClickListener(new C05191(bundle2));
            ((Button) Frg_Detail_Marka.this.getView().findViewById(C0615R.id.btnKegiatan)).setOnClickListener(new C05202(bundle2));
            ((Button) Frg_Detail_Marka.this.getView().findViewById(C0615R.id.btnEditMap)).setOnClickListener(new C05213(bundle2));
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
    }

    public static Frg_Detail_Marka newInstance(Bundle bundle) {
        Frg_Detail_Marka fragment = new Frg_Detail_Marka();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        new myikc().execute(new String[0]);
        return inflater.inflate(C0615R.layout.fragment_frg__detail__marka, container, false);
    }

    private void showToast(String message) {
        Toast.makeText(getActivity(), message, 0).show();
    }
}
