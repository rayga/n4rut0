package org.bpmikc.akm.Fragment;

import android.app.ProgressDialog;
import android.content.SharedPreferences.Editor;
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
import org.bpmikc.akm.Database.Book;
import org.bpmikc.akm.Database.MySQLiteHelper;

public class Frg_Detail_Masjid_Lokasi extends Fragment {
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

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Detail_Masjid_Lokasi.myikc.1 */
        class C05281 implements OnClickListener {
            final /* synthetic */ Bundle val$bundle2;

            C05281(Bundle bundle) {
                this.val$bundle2 = bundle;
            }

            public void onClick(View v) {
                Fragment mFragment = Frg_Cari_Masjid_Map.newInstance(this.val$bundle2);
                mFragment.setArguments(this.val$bundle2);
                Frg_Detail_Masjid_Lokasi.this.getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom, C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom).replace(C0615R.id.main_activity_content_frame, mFragment).addToBackStack(null).commit();
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Detail_Masjid_Lokasi.myikc.2 */
        class C05292 implements OnClickListener {
            final /* synthetic */ Bundle val$bundle2;

            C05292(Bundle bundle) {
                this.val$bundle2 = bundle;
            }

            public void onClick(View v) {
                Toast.makeText(Frg_Detail_Masjid_Lokasi.this.getActivity(), "Loading Informasi Masjid", 1).show();
                Fragment mFragment = Frg_Kegiatan.newInstance(this.val$bundle2);
                mFragment.setArguments(this.val$bundle2);
                Frg_Detail_Masjid_Lokasi.this.getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom, C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom).replace(C0615R.id.main_activity_content_frame, mFragment).addToBackStack(null).commit();
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Detail_Masjid_Lokasi.myikc.3 */
        class C05303 implements OnClickListener {
            final /* synthetic */ Bundle val$bundle2;

            C05303(Bundle bundle) {
                this.val$bundle2 = bundle;
            }

            public void onClick(View v) {
                Fragment mFragment = Frg_Entry_Data.newInstance(this.val$bundle2);
                mFragment.setArguments(this.val$bundle2);
                Frg_Detail_Masjid_Lokasi.this.getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom, C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom).replace(C0615R.id.main_activity_content_frame, mFragment).addToBackStack(null).commit();
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Detail_Masjid_Lokasi.myikc.4 */
        class C05314 implements OnClickListener {
            C05314() {
            }

            public void onClick(View v) {
                Toast.makeText(Frg_Detail_Masjid_Lokasi.this.getActivity(), Frg_Detail_Masjid_Lokasi.nama_masjid + " telah ditambahkan sebagai Bookmark Masjid", 1).show();
                new MySQLiteHelper(Frg_Detail_Masjid_Lokasi.this.getActivity()).addBook(new Book(Frg_Detail_Masjid_Lokasi.id_rec, Frg_Detail_Masjid_Lokasi.nama_masjid, Frg_Detail_Masjid_Lokasi.alamat_masjid, Frg_Detail_Masjid_Lokasi.nama_kota, Frg_Detail_Masjid_Lokasi.jenis_masjid, Frg_Detail_Masjid_Lokasi.latitude, Frg_Detail_Masjid_Lokasi.longitude, Frg_Detail_Masjid_Lokasi.status));
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Detail_Masjid_Lokasi.myikc.5 */
        class C05325 implements OnClickListener {
            C05325() {
            }

            public void onClick(View v) {
                Toast.makeText(Frg_Detail_Masjid_Lokasi.this.getActivity(), Frg_Detail_Masjid_Lokasi.nama_masjid + " telah dijadikan sebagai Shorcut Marker ...", 1).show();
                Editor edit = Frg_Detail_Masjid_Lokasi.this.getActivity().getSharedPreferences("MyMasjid", 0).edit();
                edit.putString("id_rec", Frg_Detail_Masjid_Lokasi.id_rec);
                edit.putString("nama_masjid", Frg_Detail_Masjid_Lokasi.nama_masjid);
                edit.putString("alamat_masjid", Frg_Detail_Masjid_Lokasi.alamat_masjid);
                edit.putString("latitude", Frg_Detail_Masjid_Lokasi.latitude);
                edit.putString("longitude", Frg_Detail_Masjid_Lokasi.longitude);
                edit.putString("nama_kota", Frg_Detail_Masjid_Lokasi.nama_kota);
                edit.putString(Games.EXTRA_STATUS, Frg_Detail_Masjid_Lokasi.status);
                edit.putString("jenis_masjid", Frg_Detail_Masjid_Lokasi.jenis_masjid);
                edit.commit();
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Detail_Masjid_Lokasi.myikc.6 */
        class C05336 implements OnClickListener {
            final /* synthetic */ Bundle val$bundle2;

            C05336(Bundle bundle) {
                this.val$bundle2 = bundle;
            }

            public void onClick(View v) {
                Fragment mFragment = Frg_Ganti_Map.newInstance(this.val$bundle2);
                mFragment.setArguments(this.val$bundle2);
                Frg_Detail_Masjid_Lokasi.this.getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom, C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom).replace(C0615R.id.main_activity_content_frame, mFragment).addToBackStack(null).commit();
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
            Bundle bundle = Frg_Detail_Masjid_Lokasi.this.getArguments();
            Frg_Detail_Masjid_Lokasi.nama_masjid = bundle.getString("nama_masjid");
            Frg_Detail_Masjid_Lokasi.alamat_masjid = bundle.getString("alamat_masjid");
            Frg_Detail_Masjid_Lokasi.nama_kota = bundle.getString("nama_kota");
            Frg_Detail_Masjid_Lokasi.id_rec = bundle.getString("id_rec");
            Frg_Detail_Masjid_Lokasi.latitude = bundle.getString("latitude");
            Frg_Detail_Masjid_Lokasi.longitude = bundle.getString("longitude");
            Frg_Detail_Masjid_Lokasi.status = bundle.getString(Games.EXTRA_STATUS);
            Frg_Detail_Masjid_Lokasi.jenis_masjid = bundle.getString("jenis_masjid");
            ((AppCompatActivity) Frg_Detail_Masjid_Lokasi.this.getActivity()).getSupportActionBar().setTitle((CharSequence) "Data Masjid");
            ((EditText) Frg_Detail_Masjid_Lokasi.this.getView().findViewById(C0615R.id.txtd_nama_masjid)).setText(Frg_Detail_Masjid_Lokasi.nama_masjid);
            Frg_Detail_Masjid_Lokasi frg_Detail_Masjid_Lokasi = Frg_Detail_Masjid_Lokasi.this;
            ((EditText) r0.getView().findViewById(C0615R.id.txtd_alamat_masjid)).setText(Frg_Detail_Masjid_Lokasi.alamat_masjid);
            frg_Detail_Masjid_Lokasi = Frg_Detail_Masjid_Lokasi.this;
            ((EditText) r0.getView().findViewById(C0615R.id.txtd_nama_kota)).setText(Frg_Detail_Masjid_Lokasi.nama_kota);
            frg_Detail_Masjid_Lokasi = Frg_Detail_Masjid_Lokasi.this;
            ((EditText) r0.getView().findViewById(C0615R.id.txtd_latitude)).setText(Frg_Detail_Masjid_Lokasi.latitude);
            frg_Detail_Masjid_Lokasi = Frg_Detail_Masjid_Lokasi.this;
            ((EditText) r0.getView().findViewById(C0615R.id.txtd_longitude)).setText(Frg_Detail_Masjid_Lokasi.longitude);
            ((EditText) Frg_Detail_Masjid_Lokasi.this.getView().findViewById(C0615R.id.txtd_status)).setText(Frg_Detail_Masjid_Lokasi.status);
            frg_Detail_Masjid_Lokasi = Frg_Detail_Masjid_Lokasi.this;
            ((EditText) r0.getView().findViewById(C0615R.id.txtd_id_rec)).setText(Frg_Detail_Masjid_Lokasi.id_rec);
            frg_Detail_Masjid_Lokasi = Frg_Detail_Masjid_Lokasi.this;
            ((EditText) r0.getView().findViewById(C0615R.id.txtd_jenis_masjid)).setText(Frg_Detail_Masjid_Lokasi.jenis_masjid);
            Bundle bundle2 = new Bundle();
            bundle2.putString("id_rec", Frg_Detail_Masjid_Lokasi.id_rec);
            bundle2.putString("nama_masjid", Frg_Detail_Masjid_Lokasi.nama_masjid);
            bundle2.putString("alamat_masjid", Frg_Detail_Masjid_Lokasi.alamat_masjid);
            bundle2.putString("nama_kota", Frg_Detail_Masjid_Lokasi.nama_kota);
            bundle2.putString("latitude", Frg_Detail_Masjid_Lokasi.latitude);
            bundle2.putString("longitude", Frg_Detail_Masjid_Lokasi.longitude);
            bundle2.putString(Games.EXTRA_STATUS, Frg_Detail_Masjid_Lokasi.status);
            frg_Detail_Masjid_Lokasi = Frg_Detail_Masjid_Lokasi.this;
            ((Button) r0.getView().findViewById(C0615R.id.btnGMap)).setOnClickListener(new C05281(bundle2));
            frg_Detail_Masjid_Lokasi = Frg_Detail_Masjid_Lokasi.this;
            ((Button) r0.getView().findViewById(C0615R.id.btnKegiatan)).setOnClickListener(new C05292(bundle2));
            frg_Detail_Masjid_Lokasi = Frg_Detail_Masjid_Lokasi.this;
            ((Button) r0.getView().findViewById(C0615R.id.btnEntri)).setOnClickListener(new C05303(bundle2));
            frg_Detail_Masjid_Lokasi = Frg_Detail_Masjid_Lokasi.this;
            ((Button) r0.getView().findViewById(C0615R.id.btnBookmark)).setOnClickListener(new C05314());
            frg_Detail_Masjid_Lokasi = Frg_Detail_Masjid_Lokasi.this;
            ((Button) r0.getView().findViewById(C0615R.id.btnShortCut)).setOnClickListener(new C05325());
            frg_Detail_Masjid_Lokasi = Frg_Detail_Masjid_Lokasi.this;
            ((Button) r0.getView().findViewById(C0615R.id.btnEditMap)).setOnClickListener(new C05336(bundle2));
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

    public static Frg_Detail_Masjid_Lokasi newInstance(Bundle bundle) {
        Frg_Detail_Masjid_Lokasi fragment = new Frg_Detail_Masjid_Lokasi();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        new myikc().execute(new String[0]);
        return inflater.inflate(C0615R.layout.fragment_frg__detail__masjid__lokasi, container, false);
    }

    private void showToast(String message) {
        Toast.makeText(getActivity(), message, 0).show();
    }
}
