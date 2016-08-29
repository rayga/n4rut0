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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.android.gms.games.Games;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.bpmikc.akm.BuildConfig;
import org.bpmikc.akm.C0615R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Frg_Cari_Masjid extends Fragment {
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

    /* renamed from: org.bpmikc.akm.Fragment.Frg_Cari_Masjid.4 */
    class C05074 implements OnItemClickListener {
        C05074() {
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
            Fragment mFragment = Frg_Detail_Masjid.newInstance(bundle);
            mFragment.setArguments(bundle);
            Frg_Cari_Masjid.this.getActivity().getSupportFragmentManager().beginTransaction().replace(C0615R.id.main_activity_content_frame, mFragment).addToBackStack(null).commit();
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
            Glide.with(Frg_Cari_Masjid.this.getActivity()).load(Frg_Cari_Masjid.this.getActivity().getSharedPreferences("MyPrefs", 0).getString("server_path", BuildConfig.FLAVOR) + ((SearchResults) this.searchArrayList.get(position)).get_image_masjid()).into(holder.imgPhoto);
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

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Cari_Masjid.myikc.1 */
        class C05081 implements OnClickListener {
            C05081() {
            }

            public void onClick(View v) {
                Frg_Cari_Masjid.this.getDataMasjid();
            }
        }

        myikc() {
        }

        protected void onPreExecute() {
            super.onPreExecute();
            Frg_Cari_Masjid.this.pDialog = new ProgressDialog(Frg_Cari_Masjid.this.getActivity());
            Frg_Cari_Masjid.this.pDialog.setMessage("Proses Akses Server ...");
            Frg_Cari_Masjid.this.pDialog.setIndeterminate(false);
            Frg_Cari_Masjid.this.pDialog.setCancelable(true);
            Frg_Cari_Masjid.this.pDialog.show();
        }

        protected String doInBackground(String... args) {
            return null;
        }

        protected void onPostExecute(String file_url) {
            Bundle bundle = Frg_Cari_Masjid.this.getArguments();
            Frg_Cari_Masjid.slatitude = bundle.getString("latitude");
            Frg_Cari_Masjid.slongitude = bundle.getString("longitude");
            ((AppCompatActivity) Frg_Cari_Masjid.this.getActivity()).getSupportActionBar().setTitle((CharSequence) "Cari Masjid");
            Frg_Cari_Masjid.this.pDialog.dismiss();
            ((ImageButton) Frg_Cari_Masjid.this.getView().findViewById(C0615R.id.btn_cari_masjid)).setOnClickListener(new C05081());
        }
    }

    /* renamed from: org.bpmikc.akm.Fragment.Frg_Cari_Masjid.1 */
    class C08611 implements Listener<JSONObject> {
        C08611() {
        }

        public void onResponse(JSONObject response) {
            try {
                Frg_Cari_Masjid.istatus = Integer.valueOf(response.getInt("success"));
                JSONArray ja = response.getJSONArray("masjid");
                Frg_Cari_Masjid.results.clear();
                Frg_Cari_Masjid.this.nom = 0;
                for (int i = 0; i < ja.length(); i++) {
                    JSONObject c = ja.getJSONObject(i);
                    Frg_Cari_Masjid.this.nom = Frg_Cari_Masjid.this.nom + 1;
                    Frg_Cari_Masjid.id_rec = c.getString("id_rec");
                    Frg_Cari_Masjid.nama_masjid = c.getString("nama_masjid");
                    Frg_Cari_Masjid.alamat_masjid = c.getString("alamat_masjid");
                    Frg_Cari_Masjid.jenis_masjid = c.getString("jenis_masjid");
                    Frg_Cari_Masjid.nama_kota = c.getString("flag_01");
                    Frg_Cari_Masjid.image_masjid = c.getString("image_masjid");
                    Frg_Cari_Masjid.latitude = c.getString("latitude");
                    Frg_Cari_Masjid.longitude = c.getString("longitude");
                    Frg_Cari_Masjid.status = c.getString(Games.EXTRA_STATUS);
                    Frg_Cari_Masjid.this.sr1 = new SearchResults();
                    Frg_Cari_Masjid.this.sr1.set_id_rec(Frg_Cari_Masjid.id_rec);
                    Frg_Cari_Masjid.this.sr1.set_nama_masjid(Frg_Cari_Masjid.nama_masjid);
                    Frg_Cari_Masjid.this.sr1.set_alamat_masjid(Frg_Cari_Masjid.alamat_masjid);
                    Frg_Cari_Masjid.this.sr1.set_nama_kota(Frg_Cari_Masjid.nama_kota);
                    Frg_Cari_Masjid.this.sr1.set_image_masjid(Frg_Cari_Masjid.image_masjid);
                    Frg_Cari_Masjid.this.sr1.set_latitude(Frg_Cari_Masjid.latitude);
                    Frg_Cari_Masjid.this.sr1.set_longitude(Frg_Cari_Masjid.longitude);
                    Frg_Cari_Masjid.this.sr1.set_status(Frg_Cari_Masjid.status);
                    Frg_Cari_Masjid.this.sr1.set_jenis_masjid(Frg_Cari_Masjid.jenis_masjid);
                    Frg_Cari_Masjid.results.add(Frg_Cari_Masjid.this.sr1);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Frg_Cari_Masjid.this.pDialog.dismiss();
            if (Frg_Cari_Masjid.istatus.intValue() == 0) {
                Frg_Cari_Masjid.this.showToast("Data tidak ditemukan ...");
                Frg_Cari_Masjid.results.clear();
            }
            Frg_Cari_Masjid.this.TampilListPaper();
        }
    }

    /* renamed from: org.bpmikc.akm.Fragment.Frg_Cari_Masjid.2 */
    class C08622 implements ErrorListener {
        C08622() {
        }

        public void onErrorResponse(VolleyError error) {
            error.printStackTrace();
        }
    }

    /* renamed from: org.bpmikc.akm.Fragment.Frg_Cari_Masjid.3 */
    class C11863 extends JsonObjectRequest {
        C11863(int x0, String x1, JSONObject x2, Listener x3, ErrorListener x4) {
            super(x0, x1, x2, x3, x4);
        }

        protected Map<String, String> getParams() throws AuthFailureError {
            Map<String, String> parameters = new HashMap();
            parameters.put("process", "paper");
            parameters.put("bidang", "masjid");
            return parameters;
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

    public Frg_Cari_Masjid() {
        this.nom = 0;
        this.sr1 = new SearchResults();
    }

    public static Frg_Cari_Masjid newInstance(Bundle bundle) {
        Frg_Cari_Masjid fragment = new Frg_Cari_Masjid();
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
        Fragment mFragment;
        switch (item.getItemId()) {
            case C0615R.id.action_book:
                Bundle bundlez = new Bundle();
                mFragment = Frg_Book.newInstance(bundlez);
                mFragment.setArguments(bundlez);
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom, C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom).replace(C0615R.id.main_activity_content_frame, mFragment).addToBackStack(null).commit();
                break;
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
                mFragment = Frg_Detail_Masjid.newInstance(bundle3);
                mFragment.setArguments(bundle3);
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom, C0615R.anim.abc_slide_in_bottom, C0615R.anim.abc_slide_out_bottom).replace(C0615R.id.main_activity_content_frame, mFragment).addToBackStack(null).commit();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        new myikc().execute(new String[0]);
        return inflater.inflate(C0615R.layout.fragment_frg__cari__masjid, container, false);
    }

    private void getDataMasjid() {
        this.pDialog = new ProgressDialog(getActivity());
        this.pDialog.setMessage("Loading Data ...");
        this.pDialog.setIndeterminate(false);
        this.pDialog.setCancelable(true);
        this.pDialog.show();
        String kriteria = ((TextView) getActivity().findViewById(C0615R.id.txt_cari_masjid)).getText().toString();
        String url = getActivity().getSharedPreferences("MyPrefs", 0).getString("server_path", BuildConfig.FLAVOR) + "/app_mobiles/get_kriteria_masjid.php?kriteria=" + kriteria;
        if (kriteria.length() < 5) {
            showToast("Kriteria minimal 5 karakter ... ");
            this.pDialog.dismiss();
            return;
        }
        Volley.newRequestQueue(getActivity()).add(new C11863(0, url, null, new C08611(), new C08622()));
    }

    private void TampilListPaper() {
        ListView lv1 = (ListView) getView().findViewById(C0615R.id.Lvmasjid);
        lv1.setAdapter(new MyCustomBaseAdapter(getActivity(), results));
        lv1.setOnItemClickListener(new C05074());
    }

    private void showToast(String message) {
        Toast.makeText(getActivity(), message, 0).show();
    }
}
