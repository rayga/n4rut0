package org.bpmikc.akm.Fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import org.bpmikc.akm.BuildConfig;
import org.bpmikc.akm.C0615R;

public class Frg_Setting extends Fragment {
    private static String activity_name;
    private static String slatitude;
    private static String slongitude;
    private static String user_id;
    private static String workflow_name;
    private ProgressDialog pDialog;

    class myikc extends AsyncTask<String, String, String> {

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Setting.myikc.1 */
        class C05951 implements OnClickListener {
            C05951() {
            }

            public void onClick(View v) {
                try {
                    Editor edit = Frg_Setting.this.getActivity().getSharedPreferences("VALUES", 0).edit();
                    edit.putString("THEME", "INDIGOLIGHT");
                    edit.commit();
                    Toast.makeText(Frg_Setting.this.getActivity(), "Theme BLUE LIGHT Saved ...", 1).show();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
                Frg_Setting.this.restart_me();
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Setting.myikc.2 */
        class C05962 implements OnClickListener {
            C05962() {
            }

            public void onClick(View v) {
                try {
                    Editor edit = Frg_Setting.this.getActivity().getSharedPreferences("VALUES", 0).edit();
                    edit.putString("THEME", "REDLIGHT");
                    edit.commit();
                    Toast.makeText(Frg_Setting.this.getActivity(), "Theme RED LIGHT Saved ...", 1).show();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
                Frg_Setting.this.restart_me();
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Setting.myikc.3 */
        class C05973 implements OnClickListener {
            C05973() {
            }

            public void onClick(View v) {
                try {
                    Editor edit = Frg_Setting.this.getActivity().getSharedPreferences("VALUES", 0).edit();
                    edit.putString("THEME", "REDDARK");
                    edit.commit();
                    Toast.makeText(Frg_Setting.this.getActivity(), "Theme RED DARK Saved ...", 1).show();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
                Frg_Setting.this.restart_me();
            }
        }

        /* renamed from: org.bpmikc.akm.Fragment.Frg_Setting.myikc.4 */
        class C05984 implements OnClickListener {
            C05984() {
            }

            public void onClick(View v) {
                try {
                    Editor edit = Frg_Setting.this.getActivity().getSharedPreferences("VALUES", 0).edit();
                    edit.putString("THEME", "INDIGODARK");
                    edit.commit();
                    Toast.makeText(Frg_Setting.this.getActivity(), "Theme BLUE DARK Saved ...", 1).show();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
                Frg_Setting.this.restart_me();
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
            ((Button) Frg_Setting.this.getView().findViewById(C0615R.id.buttonBlueLight)).setOnClickListener(new C05951());
            ((Button) Frg_Setting.this.getView().findViewById(C0615R.id.buttonRedLight)).setOnClickListener(new C05962());
            ((Button) Frg_Setting.this.getView().findViewById(C0615R.id.buttonRedDark)).setOnClickListener(new C05973());
            ((Button) Frg_Setting.this.getView().findViewById(C0615R.id.buttonBlueDark)).setOnClickListener(new C05984());
        }
    }

    static {
        slatitude = BuildConfig.FLAVOR;
        slongitude = BuildConfig.FLAVOR;
        workflow_name = BuildConfig.FLAVOR;
        activity_name = BuildConfig.FLAVOR;
        user_id = BuildConfig.FLAVOR;
    }

    public static Frg_Setting newInstance(Bundle bundle) {
        Frg_Setting fragment = new Frg_Setting();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        new myikc().execute(new String[0]);
        return inflater.inflate(C0615R.layout.fragment_frg__setting, container, false);
    }

    public void restart_me() {
        Intent i = getActivity().getBaseContext().getPackageManager().getLaunchIntentForPackage(getActivity().getBaseContext().getPackageName());
        i.addFlags(67108864);
        startActivity(i);
    }
}
