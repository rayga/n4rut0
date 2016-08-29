package org.bpmikc.akm.Dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import org.bpmikc.akm.BuildConfig;
import org.bpmikc.akm.C0615R;
import org.bpmikc.akm.Widget.Preferences;

public class AdditionalDialogMarka extends Dialog {
    private String catm;
    private String cbandara;
    private String cbengkel;
    private String cpasar;
    private String cpelabuhan;
    private String cpenginapan;
    private String cpengobatan;
    private String cpolisi;
    private String cpombensin;
    private String crumahmakan;
    private String cstasiun;
    private String cterminal;
    private String latitude;
    private String longitude;
    private Spinner mCalculationMethods;
    private Context mContext;
    private EditText mLatitudeText;
    private EditText mLongitudeText;
    private SharedPreferences pref;

    /* renamed from: org.bpmikc.akm.Dialog.AdditionalDialogMarka.1 */
    class C04861 implements OnClickListener {
        final /* synthetic */ CheckBox val$cbxAtm;
        final /* synthetic */ CheckBox val$cbxBandara;
        final /* synthetic */ CheckBox val$cbxBengkel;
        final /* synthetic */ CheckBox val$cbxPasar;
        final /* synthetic */ CheckBox val$cbxPelabuhan;
        final /* synthetic */ CheckBox val$cbxPenginapan;
        final /* synthetic */ CheckBox val$cbxPengobatan;
        final /* synthetic */ CheckBox val$cbxPolisi;
        final /* synthetic */ CheckBox val$cbxPomBensin;
        final /* synthetic */ CheckBox val$cbxRumahMakan;
        final /* synthetic */ CheckBox val$cbxStasiun;
        final /* synthetic */ CheckBox val$cbxTerminal;

        C04861(CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6, CheckBox checkBox7, CheckBox checkBox8, CheckBox checkBox9, CheckBox checkBox10, CheckBox checkBox11, CheckBox checkBox12) {
            this.val$cbxAtm = checkBox;
            this.val$cbxBandara = checkBox2;
            this.val$cbxBengkel = checkBox3;
            this.val$cbxPasar = checkBox4;
            this.val$cbxPelabuhan = checkBox5;
            this.val$cbxPenginapan = checkBox6;
            this.val$cbxPolisi = checkBox7;
            this.val$cbxPomBensin = checkBox8;
            this.val$cbxPengobatan = checkBox9;
            this.val$cbxRumahMakan = checkBox10;
            this.val$cbxStasiun = checkBox11;
            this.val$cbxTerminal = checkBox12;
        }

        public void onClick(View v) {
            Editor edit = ((Activity) AdditionalDialogMarka.this.mContext).getSharedPreferences("MyMarka", 0).edit();
            if (this.val$cbxAtm.isChecked()) {
                AdditionalDialogMarka.this.catm = "checked";
            } else {
                AdditionalDialogMarka.this.catm = "unchecked";
            }
            if (this.val$cbxBandara.isChecked()) {
                AdditionalDialogMarka.this.cbandara = "checked";
            } else {
                AdditionalDialogMarka.this.cbandara = "unchecked";
            }
            if (this.val$cbxBengkel.isChecked()) {
                AdditionalDialogMarka.this.cbengkel = "checked";
            } else {
                AdditionalDialogMarka.this.cbengkel = "unchecked";
            }
            if (this.val$cbxPasar.isChecked()) {
                AdditionalDialogMarka.this.cpasar = "checked";
            } else {
                AdditionalDialogMarka.this.cpasar = "unchecked";
            }
            if (this.val$cbxPelabuhan.isChecked()) {
                AdditionalDialogMarka.this.cpelabuhan = "checked";
            } else {
                AdditionalDialogMarka.this.cpelabuhan = "unchecked";
            }
            if (this.val$cbxPenginapan.isChecked()) {
                AdditionalDialogMarka.this.cpenginapan = "checked";
            } else {
                AdditionalDialogMarka.this.cpenginapan = "unchecked";
            }
            if (this.val$cbxPolisi.isChecked()) {
                AdditionalDialogMarka.this.cpolisi = "checked";
            } else {
                AdditionalDialogMarka.this.cpolisi = "unchecked";
            }
            if (this.val$cbxPomBensin.isChecked()) {
                AdditionalDialogMarka.this.cpombensin = "checked";
            } else {
                AdditionalDialogMarka.this.cpombensin = "unchecked";
            }
            if (this.val$cbxPengobatan.isChecked()) {
                AdditionalDialogMarka.this.cpengobatan = "checked";
            } else {
                AdditionalDialogMarka.this.cpengobatan = "unchecked";
            }
            if (this.val$cbxRumahMakan.isChecked()) {
                AdditionalDialogMarka.this.crumahmakan = "checked";
            } else {
                AdditionalDialogMarka.this.crumahmakan = "unchecked";
            }
            if (this.val$cbxStasiun.isChecked()) {
                AdditionalDialogMarka.this.cstasiun = "checked";
            } else {
                AdditionalDialogMarka.this.cstasiun = "unchecked";
            }
            if (this.val$cbxTerminal.isChecked()) {
                AdditionalDialogMarka.this.cterminal = "checked";
            } else {
                AdditionalDialogMarka.this.cterminal = "unchecked";
            }
            edit.putString("atm", AdditionalDialogMarka.this.catm);
            edit.putString("bandara", AdditionalDialogMarka.this.cbandara);
            edit.putString("bengkel", AdditionalDialogMarka.this.cbengkel);
            edit.putString("pasar", AdditionalDialogMarka.this.cpasar);
            edit.putString("pelabuhan", AdditionalDialogMarka.this.cpelabuhan);
            edit.putString("penginapan", AdditionalDialogMarka.this.cpenginapan);
            edit.putString("polisi", AdditionalDialogMarka.this.cpolisi);
            edit.putString("pombensin", AdditionalDialogMarka.this.cpombensin);
            edit.putString("pengobatan", AdditionalDialogMarka.this.cpengobatan);
            edit.putString("rumahmakan", AdditionalDialogMarka.this.crumahmakan);
            edit.putString("stasiun", AdditionalDialogMarka.this.cstasiun);
            edit.putString("terminal", AdditionalDialogMarka.this.cterminal);
            edit.commit();
            AdditionalDialogMarka.this.dismiss();
        }
    }

    public AdditionalDialogMarka(Context context) {
        super(context);
        this.latitude = BuildConfig.FLAVOR;
        this.longitude = BuildConfig.FLAVOR;
        this.catm = BuildConfig.FLAVOR;
        this.cbandara = BuildConfig.FLAVOR;
        this.cbengkel = BuildConfig.FLAVOR;
        this.cpasar = BuildConfig.FLAVOR;
        this.cpelabuhan = BuildConfig.FLAVOR;
        this.cpenginapan = BuildConfig.FLAVOR;
        this.cpolisi = BuildConfig.FLAVOR;
        this.cpombensin = BuildConfig.FLAVOR;
        this.cpengobatan = BuildConfig.FLAVOR;
        this.crumahmakan = BuildConfig.FLAVOR;
        this.cstasiun = BuildConfig.FLAVOR;
        this.cterminal = BuildConfig.FLAVOR;
        this.mContext = context;
        SharedPreferences pref = ((Activity) this.mContext).getSharedPreferences("MyPrefs", 0);
        this.latitude = pref.getString("slatitude", BuildConfig.FLAVOR);
        this.longitude = pref.getString("slongitude", BuildConfig.FLAVOR);
    }

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(C0615R.layout.layout_dialog_marka);
        setTitle(C0615R.string.additionalMarker);
        Preferences preferences = Preferences.getInstance(this.mContext);
        float[] latLong = preferences.getLocation();
        int calculationMethod = preferences.getCalculationMethodIndex();
        SharedPreferences prefMyMarka = ((Activity) this.mContext).getSharedPreferences("MyMarka", 0);
        CheckBox cbxAtm = (CheckBox) findViewById(C0615R.id.cbxAtm);
        if (prefMyMarka.getString("atm", BuildConfig.FLAVOR).equals("checked")) {
            cbxAtm.setChecked(true);
        }
        CheckBox cbxBandara = (CheckBox) findViewById(C0615R.id.cbxBandara);
        if (prefMyMarka.getString("bandara", BuildConfig.FLAVOR).equals("checked")) {
            cbxBandara.setChecked(true);
        }
        CheckBox cbxBengkel = (CheckBox) findViewById(C0615R.id.cbxBengkel);
        if (prefMyMarka.getString("bengkel", BuildConfig.FLAVOR).equals("checked")) {
            cbxBengkel.setChecked(true);
        }
        CheckBox cbxPasar = (CheckBox) findViewById(C0615R.id.cbxPasar);
        if (prefMyMarka.getString("pasar", BuildConfig.FLAVOR).equals("checked")) {
            cbxPasar.setChecked(true);
        }
        CheckBox cbxPelabuhan = (CheckBox) findViewById(C0615R.id.cbxPelabuhan);
        if (prefMyMarka.getString("pelabuhan", BuildConfig.FLAVOR).equals("checked")) {
            cbxPelabuhan.setChecked(true);
        }
        CheckBox cbxPenginapan = (CheckBox) findViewById(C0615R.id.cbxPenginapan);
        if (prefMyMarka.getString("penginapan", BuildConfig.FLAVOR).equals("checked")) {
            cbxPenginapan.setChecked(true);
        }
        CheckBox cbxPolisi = (CheckBox) findViewById(C0615R.id.cbxPolisi);
        if (prefMyMarka.getString("polisi", BuildConfig.FLAVOR).equals("checked")) {
            cbxPolisi.setChecked(true);
        }
        CheckBox cbxPomBensin = (CheckBox) findViewById(C0615R.id.cbxPomBensin);
        if (prefMyMarka.getString("pombensin", BuildConfig.FLAVOR).equals("checked")) {
            cbxPomBensin.setChecked(true);
        }
        CheckBox cbxPengobatan = (CheckBox) findViewById(C0615R.id.cbxPengobatan);
        if (prefMyMarka.getString("pengobatan", BuildConfig.FLAVOR).equals("checked")) {
            cbxPengobatan.setChecked(true);
        }
        CheckBox cbxRumahMakan = (CheckBox) findViewById(C0615R.id.cbxRestoran);
        if (prefMyMarka.getString("rumahmakan", BuildConfig.FLAVOR).equals("checked")) {
            cbxRumahMakan.setChecked(true);
        }
        CheckBox cbxTerminal = (CheckBox) findViewById(C0615R.id.cbxTerminal);
        if (prefMyMarka.getString("terminal", BuildConfig.FLAVOR).equals("checked")) {
            cbxTerminal.setChecked(true);
        }
        CheckBox cbxStasiun = (CheckBox) findViewById(C0615R.id.cbxStasiun);
        if (prefMyMarka.getString("stasiun", BuildConfig.FLAVOR).equals("checked")) {
            cbxStasiun.setChecked(true);
        }
        Button button = (Button) findViewById(C0615R.id.btnTampil);
        r31.setOnClickListener(new C04861(cbxAtm, cbxBandara, cbxBengkel, cbxPasar, cbxPelabuhan, cbxPenginapan, cbxPolisi, cbxPomBensin, cbxPengobatan, cbxRumahMakan, cbxStasiun, cbxTerminal));
    }

    private static float parseFloat(EditText et, float defaultValue) {
        try {
            defaultValue = Float.parseFloat(et.getText().toString());
        } catch (NumberFormatException e) {
        }
        return defaultValue;
    }
}
