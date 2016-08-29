package org.bpmikc.akm.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.google.android.gms.games.Games;
import java.util.ArrayList;
import org.bpmikc.akm.BuildConfig;
import org.bpmikc.akm.C0615R;
import org.bpmikc.akm.Database.Book;
import org.bpmikc.akm.Database.MySQLiteHelper;

public class Frg_Book extends Fragment {
    private static String activity_name;
    private static String alamat_masjid;
    private static String id_rec;
    private static String image_masjid;
    private static Integer istatus;
    private static String jenis_masjid;
    private static String latitude;
    private static String longitude;
    private static String nama_kota;
    private static String nama_masjid;
    private static ArrayList<SearchResults> results;
    private static ArrayList<SearchResults> results2;
    private static String slatitude;
    private static String slongitude;
    private static String status;
    private static String user_id;
    private int nom;
    private ProgressDialog pDialog;
    private SearchResults sr1;

    /* renamed from: org.bpmikc.akm.Fragment.Frg_Book.1 */
    class C05021 implements OnItemClickListener {
        C05021() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            String nama_masjid = ((TextView) view.findViewById(C0615R.id.txt_nama_masjid)).getText().toString();
            String alamat_masjid = ((TextView) view.findViewById(C0615R.id.txt_alamat_masjid)).getText().toString();
            String nama_kota = ((TextView) view.findViewById(C0615R.id.txt_nama_kota)).getText().toString();
            String id_rec = ((TextView) view.findViewById(C0615R.id.txt_id_rec)).getText().toString();
            String latitude = ((TextView) view.findViewById(C0615R.id.txt_latitude)).getText().toString();
            String longitude = ((TextView) view.findViewById(C0615R.id.txt_longitude)).getText().toString();
            String status = ((TextView) view.findViewById(C0615R.id.txt_status)).getText().toString();
            String jenis_masjid = ((TextView) view.findViewById(C0615R.id.txt_jenis_masjid)).getText().toString();
            Bundle bundle = new Bundle();
            bundle.putString("nama_masjid", nama_masjid);
            bundle.putString("alamat_masjid", alamat_masjid);
            bundle.putString("nama_kota", nama_kota);
            bundle.putString("id_rec", id_rec);
            bundle.putString("latitude", latitude);
            bundle.putString("longitude", longitude);
            bundle.putString(Games.EXTRA_STATUS, status);
            bundle.putString("jenis_masjid", jenis_masjid);
            Fragment mFragment = Frg_Detail_Bookmark.newInstance(bundle);
            mFragment.setArguments(bundle);
            Frg_Book.this.getActivity().getSupportFragmentManager().beginTransaction().replace(C0615R.id.main_activity_content_frame, mFragment).addToBackStack(null).commit();
        }
    }

    public class MyCustomBaseAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        private ArrayList<SearchResults> searchArrayList;

        class ViewHolder {
            ImageView imgPhoto;
            TextView txt_alamat_masjid;
            TextView txt_id_rec;
            TextView txt_jenis_masjid;
            TextView txt_latitude;
            TextView txt_longitude;
            TextView txt_nama_kota;
            TextView txt_nama_masjid;
            TextView txt_status;

            ViewHolder() {
            }
        }

        public MyCustomBaseAdapter(Context context, ArrayList<SearchResults> results) {
            this.searchArrayList = results;
            this.mInflater = LayoutInflater.from(context);
        }

        public int getCount() {
            return this.searchArrayList.size();
        }

        public Object getItem(int position) {
            return this.searchArrayList.get(position);
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = this.mInflater.inflate(C0615R.layout.masjid_list_view, null);
                holder = new ViewHolder();
                holder.txt_id_rec = (TextView) convertView.findViewById(C0615R.id.txt_id_rec);
                holder.txt_nama_masjid = (TextView) convertView.findViewById(C0615R.id.txt_nama_masjid);
                holder.txt_alamat_masjid = (TextView) convertView.findViewById(C0615R.id.txt_alamat_masjid);
                holder.txt_nama_kota = (TextView) convertView.findViewById(C0615R.id.txt_nama_kota);
                holder.txt_latitude = (TextView) convertView.findViewById(C0615R.id.txt_latitude);
                holder.txt_longitude = (TextView) convertView.findViewById(C0615R.id.txt_longitude);
                holder.txt_status = (TextView) convertView.findViewById(C0615R.id.txt_status);
                holder.txt_jenis_masjid = (TextView) convertView.findViewById(C0615R.id.txt_jenis_masjid);
                holder.imgPhoto = (ImageView) convertView.findViewById(C0615R.id.photo);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.txt_id_rec.setText(((SearchResults) this.searchArrayList.get(position)).get_id_rec());
            holder.txt_nama_masjid.setText(((SearchResults) this.searchArrayList.get(position)).get_nama_masjid());
            holder.txt_alamat_masjid.setText(((SearchResults) this.searchArrayList.get(position)).get_alamat_masjid());
            holder.txt_nama_kota.setText(((SearchResults) this.searchArrayList.get(position)).get_nama_kota());
            holder.txt_latitude.setText(((SearchResults) this.searchArrayList.get(position)).get_latitude());
            holder.txt_longitude.setText(((SearchResults) this.searchArrayList.get(position)).get_longitude());
            holder.txt_status.setText(((SearchResults) this.searchArrayList.get(position)).get_status());
            holder.txt_jenis_masjid.setText(((SearchResults) this.searchArrayList.get(position)).get_jenis_masjid());
            Glide.with(Frg_Book.this.getActivity()).load(Frg_Book.this.getActivity().getSharedPreferences("MyPrefs", 0).getString("server_path", BuildConfig.FLAVOR) + ((SearchResults) this.searchArrayList.get(position)).get_image_masjid()).into(holder.imgPhoto);
            return convertView;
        }
    }

    public class SearchResults {
        private String alamat_masjid;
        private String id_rec;
        private String image_masjid;
        private String jenis_masjid;
        private String latitude;
        private String longitude;
        private String nama_kota;
        private String nama_masjid;
        private String status;

        public SearchResults() {
            this.id_rec = BuildConfig.FLAVOR;
            this.nama_masjid = BuildConfig.FLAVOR;
            this.alamat_masjid = BuildConfig.FLAVOR;
            this.nama_kota = BuildConfig.FLAVOR;
            this.image_masjid = BuildConfig.FLAVOR;
            this.latitude = BuildConfig.FLAVOR;
            this.longitude = BuildConfig.FLAVOR;
            this.status = BuildConfig.FLAVOR;
            this.jenis_masjid = BuildConfig.FLAVOR;
        }

        public void set_id_rec(String id_rec) {
            this.id_rec = id_rec;
        }

        public String get_id_rec() {
            return this.id_rec;
        }

        public void set_nama_masjid(String nama_masjid) {
            this.nama_masjid = nama_masjid;
        }

        public String get_nama_masjid() {
            return this.nama_masjid;
        }

        public void set_alamat_masjid(String alamat_masjid) {
            this.alamat_masjid = alamat_masjid;
        }

        public String get_alamat_masjid() {
            return this.alamat_masjid;
        }

        public void set_nama_kota(String nama_kota) {
            this.nama_kota = nama_kota;
        }

        public String get_nama_kota() {
            return this.nama_kota;
        }

        public void set_image_masjid(String image_masjid) {
            this.image_masjid = image_masjid;
        }

        public String get_image_masjid() {
            return this.image_masjid;
        }

        public void set_latitude(String latitude) {
            this.latitude = latitude;
        }

        public String get_latitude() {
            return this.latitude;
        }

        public void set_longitude(String longitude) {
            this.longitude = longitude;
        }

        public String get_longitude() {
            return this.longitude;
        }

        public void set_status(String status) {
            this.status = status;
        }

        public String get_status() {
            return this.status;
        }

        public void set_jenis_masjid(String jenis_masjid) {
            this.jenis_masjid = jenis_masjid;
        }

        public String get_jenis_masjid() {
            return this.jenis_masjid;
        }
    }

    class myikc extends AsyncTask<String, String, String> {
        myikc() {
        }

        protected void onPreExecute() {
            super.onPreExecute();
            Frg_Book.this.pDialog = new ProgressDialog(Frg_Book.this.getActivity());
            Frg_Book.this.pDialog.setMessage("Proses Akses Server ...");
            Frg_Book.this.pDialog.setIndeterminate(false);
            Frg_Book.this.pDialog.setCancelable(true);
            Frg_Book.this.pDialog.show();
        }

        protected String doInBackground(String... args) {
            return null;
        }

        protected void onPostExecute(String file_url) {
            Bundle bundle = Frg_Book.this.getArguments();
            Frg_Book.slatitude = bundle.getString("latitude");
            Frg_Book.slongitude = bundle.getString("longitude");
            ((AppCompatActivity) Frg_Book.this.getActivity()).getSupportActionBar().setTitle((CharSequence) "Bookmark Masjid");
            Frg_Book.this.pDialog.dismiss();
            Frg_Book.this.getDataMasjid();
        }
    }

    static {
        slatitude = BuildConfig.FLAVOR;
        slongitude = BuildConfig.FLAVOR;
        activity_name = BuildConfig.FLAVOR;
        user_id = BuildConfig.FLAVOR;
        id_rec = BuildConfig.FLAVOR;
        nama_masjid = BuildConfig.FLAVOR;
        alamat_masjid = BuildConfig.FLAVOR;
        nama_kota = BuildConfig.FLAVOR;
        image_masjid = BuildConfig.FLAVOR;
        latitude = BuildConfig.FLAVOR;
        longitude = BuildConfig.FLAVOR;
        status = BuildConfig.FLAVOR;
        jenis_masjid = BuildConfig.FLAVOR;
        results = new ArrayList();
        results2 = new ArrayList();
    }

    public Frg_Book() {
        this.nom = 0;
        this.sr1 = new SearchResults();
    }

    public static Frg_Book newInstance(Bundle bundle) {
        Frg_Book fragment = new Frg_Book();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(C0615R.menu.menu_masjidku, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case C0615R.id.action_cari_masjidku:
                SharedPreferences pref = getActivity().getSharedPreferences("MyMasjid", 0);
                Bundle bundle3 = new Bundle();
                bundle3.putString("id_rec", pref.getString("id_rec", BuildConfig.FLAVOR));
                bundle3.putString("nama_masjid", pref.getString("nama_masjid", BuildConfig.FLAVOR));
                bundle3.putString("alamat_masjid", pref.getString("alamat_masjid", BuildConfig.FLAVOR));
                bundle3.putString("nama_kota", pref.getString("nama_kota", BuildConfig.FLAVOR));
                bundle3.putString("latitude", pref.getString("latitude", BuildConfig.FLAVOR));
                bundle3.putString("longitude", pref.getString("longitude", BuildConfig.FLAVOR));
                bundle3.putString(Games.EXTRA_STATUS, pref.getString(Games.EXTRA_STATUS, BuildConfig.FLAVOR));
                bundle3.putString("jenis_masjid", pref.getString("jenis_masjid", BuildConfig.FLAVOR));
                Fragment mFragment = Frg_Detail_Masjid.newInstance(bundle3);
                mFragment.setArguments(bundle3);
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom, C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom).replace(C0615R.id.main_activity_content_frame, mFragment).addToBackStack(null).commit();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        new myikc().execute(new String[0]);
        return inflater.inflate(C0615R.layout.fragment_frg__book, container, false);
    }

    private void getDataMasjid() {
        results.clear();
        for (Book cn : new MySQLiteHelper(getActivity()).getAllBooks()) {
            id_rec = cn.get_id_rec();
            nama_masjid = cn.get_nama_masjid();
            alamat_masjid = cn.get_alamat_masjid();
            jenis_masjid = cn.get_jenis_masjid();
            nama_kota = cn.get_nama_kota();
            image_masjid = "/app_upload/masjidoke.png";
            latitude = cn.get_latitude();
            longitude = cn.get_longitude();
            status = cn.get_status();
            this.sr1 = new SearchResults();
            this.sr1.set_id_rec(id_rec);
            this.sr1.set_nama_masjid(nama_masjid);
            this.sr1.set_alamat_masjid(alamat_masjid);
            this.sr1.set_nama_kota(nama_kota);
            this.sr1.set_image_masjid(image_masjid);
            this.sr1.set_latitude(latitude);
            this.sr1.set_longitude(longitude);
            this.sr1.set_status(status);
            this.sr1.set_jenis_masjid(jenis_masjid);
            results.add(this.sr1);
        }
        TampilListPaper();
    }

    private void TampilListPaper() {
        ListView lv1 = (ListView) getView().findViewById(C0615R.id.Lvmasjid);
        lv1.setAdapter(new MyCustomBaseAdapter(getActivity(), results));
        lv1.setOnItemClickListener(new C05021());
    }

    private void showToast(String message) {
        Toast.makeText(getActivity(), message, 0).show();
    }
}
