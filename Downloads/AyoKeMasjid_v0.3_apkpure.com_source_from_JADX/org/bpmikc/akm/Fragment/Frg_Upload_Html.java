package org.bpmikc.akm.Fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.support.v4.app.Fragment;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import org.bpmikc.akm.BuildConfig;
import org.bpmikc.akm.C0615R;

public class Frg_Upload_Html extends Fragment {
    private String KEY_IMAGE;
    private String KEY_NAME;
    private int PICK_IMAGE_REQUEST;
    private String UPLOAD_URL;
    private Bitmap bitmap;
    Bundle bundle;
    private Button buttonChoose;
    private Button buttonUpload;
    private EditText editTextName;
    private String id_proses;
    private String id_rec;
    private String id_rec_master;
    private ImageView imageView;
    private String server_path;

    class myikc extends AsyncTask<String, String, String> {

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Upload_Html.myikc.1 */
        class C06011 implements OnClickListener {
            C06011() {
            }

            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction("android.intent.action.GET_CONTENT");
                Frg_Upload_Html.this.startActivityForResult(Intent.createChooser(intent, "Select Picture"), Frg_Upload_Html.this.PICK_IMAGE_REQUEST);
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Upload_Html.myikc.2 */
        class C06022 implements OnClickListener {
            C06022() {
            }

            public void onClick(View v) {
                Frg_Upload_Html.this.uploadImage();
            }
        }

        myikc() {
        }

        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected String doInBackground(String... args) {
            Frg_Upload_Html.this.bundle = Frg_Upload_Html.this.getArguments();
            Frg_Upload_Html.this.id_rec = Frg_Upload_Html.this.bundle.getString("id_rec");
            Frg_Upload_Html.this.id_rec_master = Frg_Upload_Html.this.bundle.getString("id_rec_master");
            Frg_Upload_Html.this.id_proses = Frg_Upload_Html.this.bundle.getString("id_proses");
            return null;
        }

        protected void onPostExecute(String file_url) {
            ((AppCompatActivity) Frg_Upload_Html.this.getActivity()).getSupportActionBar().setTitle((CharSequence) "Upload Gallery");
            TextView txtMasjid = (TextView) Frg_Upload_Html.this.getView().findViewById(C0615R.id.txtNamaMasjid3);
            txtMasjid.setText(Frg_Upload_Html.this.id_rec_master + " (" + Frg_Upload_Html.this.id_proses + ")");
            txtMasjid.setGravity(17);
            Frg_Upload_Html.this.editTextName = (EditText) Frg_Upload_Html.this.getView().findViewById(C0615R.id.editText);
            Frg_Upload_Html.this.imageView = (ImageView) Frg_Upload_Html.this.getView().findViewById(C0615R.id.imageView);
            ((Button) Frg_Upload_Html.this.getView().findViewById(C0615R.id.buttonChoose)).setOnClickListener(new C06011());
            ((Button) Frg_Upload_Html.this.getView().findViewById(C0615R.id.buttonUpload)).setOnClickListener(new C06022());
        }
    }

    /* renamed from: org.bpmikc.akm.Fragment.Frg_Upload_Html.1 */
    class C08771 implements Listener<String> {
        final /* synthetic */ ProgressDialog val$loading;

        C08771(ProgressDialog progressDialog) {
            this.val$loading = progressDialog;
        }

        public void onResponse(String s) {
            this.val$loading.dismiss();
            Toast.makeText(Frg_Upload_Html.this.getActivity(), s, 1).show();
        }
    }

    /* renamed from: org.bpmikc.akm.Fragment.Frg_Upload_Html.2 */
    class C08782 implements ErrorListener {
        final /* synthetic */ ProgressDialog val$loading;

        C08782(ProgressDialog progressDialog) {
            this.val$loading = progressDialog;
        }

        public void onErrorResponse(VolleyError volleyError) {
            this.val$loading.dismiss();
            Toast.makeText(Frg_Upload_Html.this.getActivity(), "File telah diuplaod ...", 1).show();
        }
    }

    /* renamed from: org.bpmikc.akm.Fragment.Frg_Upload_Html.3 */
    class C11723 extends StringRequest {
        C11723(int x0, String x1, Listener x2, ErrorListener x3) {
            super(x0, x1, x2, x3);
        }

        protected Map<String, String> getParams() throws AuthFailureError {
            String image = Frg_Upload_Html.this.getStringImage(Frg_Upload_Html.this.bitmap);
            String name = Frg_Upload_Html.this.editTextName.getText().toString().trim();
            Map<String, String> params = new Hashtable();
            params.put(Frg_Upload_Html.this.KEY_IMAGE, image);
            params.put(Frg_Upload_Html.this.KEY_NAME, name);
            params.put("id_rec_master", Frg_Upload_Html.this.id_rec_master);
            params.put("id_rec_proses", Frg_Upload_Html.this.id_rec);
            params.put("id_proses", Frg_Upload_Html.this.id_proses);
            return params;
        }
    }

    public Frg_Upload_Html() {
        this.PICK_IMAGE_REQUEST = 1;
        this.id_rec = BuildConfig.FLAVOR;
        this.id_rec_master = BuildConfig.FLAVOR;
        this.id_proses = BuildConfig.FLAVOR;
        this.KEY_IMAGE = Frg_Qiblat_Map.sARGUMENT_IMAGE_CODE;
        this.KEY_NAME = "name";
        this.server_path = BuildConfig.FLAVOR;
        this.UPLOAD_URL = BuildConfig.FLAVOR;
    }

    public static Frg_Upload_Html newInstance(Bundle bundle) {
        Frg_Upload_Html fragment = new Frg_Upload_Html();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(C0615R.menu.menu_upload, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case C0615R.id.action_back:
                getFragmentManager().popBackStack();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        new myikc().execute(new String[0]);
        return inflater.inflate(C0615R.layout.fragment_frg__upload__html, container, false);
    }

    private void showToast(String message) {
        Toast.makeText(getActivity(), message, 0).show();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == this.PICK_IMAGE_REQUEST) {
            getActivity();
            if (resultCode == -1 && data != null && data.getData() != null) {
                try {
                    this.bitmap = Media.getBitmap(getActivity().getContentResolver(), data.getData());
                    this.imageView.setImageBitmap(this.bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getStringImage(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(CompressFormat.JPEG, 100, baos);
        return Base64.encodeToString(baos.toByteArray(), 0);
    }

    private void uploadImage() {
        if (this.bitmap.getByteCount() / AccessibilityNodeInfoCompat.ACTION_COPY > 600) {
            Toast.makeText(getActivity(), "Ukuran File Gambar terlalu besar, gunakan ScreenShots Gadget untuk memperkecil ....", 1).show();
            return;
        }
        this.server_path = getActivity().getSharedPreferences("MyPrefs", 0).getString("server_path", BuildConfig.FLAVOR);
        this.UPLOAD_URL = this.server_path + "/app_upload/upload_kegiatan.php";
        ProgressDialog loading = ProgressDialog.show(getActivity(), "Uploading...", "Please wait...", false, false);
        Volley.newRequestQueue(getActivity()).add(new C11723(1, this.UPLOAD_URL, new C08771(loading), new C08782(loading)));
    }

    public static int calculateInSampleSize(Options options, int reqWidth, int reqHeight) {
        int height = options.outHeight;
        int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            int halfHeight = height / 2;
            int halfWidth = width / 2;
            while (halfHeight / inSampleSize > reqHeight && halfWidth / inSampleSize > reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }
}
