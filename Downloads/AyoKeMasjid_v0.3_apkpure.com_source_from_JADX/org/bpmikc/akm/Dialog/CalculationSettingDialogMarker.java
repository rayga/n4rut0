package org.bpmikc.akm.Dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import org.bpmikc.akm.BuildConfig;
import org.bpmikc.akm.C0615R;
import org.bpmikc.akm.Widget.Preferences;
import org.bpmikc.akm.Widget.Schedule;

public class CalculationSettingDialogMarker extends Dialog {
    private String latitude;
    private String longitude;
    private Spinner mCalculationMethods;
    private Context mContext;
    private EditText mLatitudeText;
    private EditText mLongitudeText;
    private SharedPreferences pref;

    /* renamed from: org.bpmikc.akm.Dialog.CalculationSettingDialogMarker.1 */
    class C04871 implements OnClickListener {
        final /* synthetic */ float[] val$latLong;
        final /* synthetic */ Preferences val$preferences;

        C04871(float[] fArr, Preferences preferences) {
            this.val$latLong = fArr;
            this.val$preferences = preferences;
        }

        public void onClick(View v) {
            float newLatitude = CalculationSettingDialogMarker.parseFloat(CalculationSettingDialogMarker.this.mLatitudeText, this.val$latLong[0]);
            float newLongitude = CalculationSettingDialogMarker.parseFloat(CalculationSettingDialogMarker.this.mLongitudeText, this.val$latLong[1]);
            if (!(newLatitude == this.val$latLong[0] && newLongitude == this.val$latLong[1])) {
                this.val$preferences.setLocation(newLatitude, newLongitude);
                Schedule.setSettingsDirty();
            }
            CalculationSettingDialogMarker.this.dismiss();
        }
    }

    /* renamed from: org.bpmikc.akm.Dialog.CalculationSettingDialogMarker.2 */
    class C04882 implements OnClickListener {
        C04882() {
        }

        public void onClick(View v) {
            CalculationSettingDialogMarker.this.dismiss();
        }
    }

    public CalculationSettingDialogMarker(Context context) {
        super(context);
        this.latitude = BuildConfig.FLAVOR;
        this.longitude = BuildConfig.FLAVOR;
        this.mContext = context;
        SharedPreferences pref = ((Activity) this.mContext).getSharedPreferences("MyPrefs", 0);
        this.latitude = pref.getString("slatitude", BuildConfig.FLAVOR);
        this.longitude = pref.getString("slongitude", BuildConfig.FLAVOR);
    }

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(C0615R.layout.settings_calculation);
        setTitle(C0615R.string.calculation);
        Preferences preferences = Preferences.getInstance(this.mContext);
        float[] latLong = preferences.getLocation();
        int calculationMethod = preferences.getCalculationMethodIndex();
        this.mLatitudeText = (EditText) findViewById(C0615R.id.latitude);
        this.mLatitudeText.setText(this.latitude);
        this.mLongitudeText = (EditText) findViewById(C0615R.id.longitude);
        this.mLongitudeText.setText(this.longitude);
        ((Button) findViewById(C0615R.id.save_settings)).setOnClickListener(new C04871(latLong, preferences));
        ((Button) findViewById(C0615R.id.reset_settings)).setOnClickListener(new C04882());
    }

    private static float parseFloat(EditText et, float defaultValue) {
        try {
            defaultValue = Float.parseFloat(et.getText().toString());
        } catch (NumberFormatException e) {
        }
        return defaultValue;
    }
}
