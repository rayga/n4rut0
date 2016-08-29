package org.bpmikc.akm.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import org.bpmikc.akm.C0615R;
import org.bpmikc.akm.Widget.Preferences;
import org.bpmikc.akm.Widget.Schedule;

public class CalculationSettingsDialog extends Dialog {
    private Spinner mCalculationMethods;
    private Context mContext;
    private EditText mLatitudeText;
    private EditText mLongitudeText;

    /* renamed from: org.bpmikc.akm.Dialog.CalculationSettingsDialog.1 */
    class C04891 implements OnClickListener {
        final /* synthetic */ Preferences val$preferences;

        C04891(Preferences preferences) {
            this.val$preferences = preferences;
        }

        public void onClick(View v) {
            Location currentLocation = this.val$preferences.getCurrentLocation(CalculationSettingsDialog.this.mContext);
            if (currentLocation != null) {
                CalculationSettingsDialog.this.mLatitudeText.setText(Double.toString(currentLocation.getLatitude()));
                CalculationSettingsDialog.this.mLongitudeText.setText(Double.toString(currentLocation.getLongitude()));
                return;
            }
            CalculationSettingsDialog.this.mLatitudeText.setText(null);
            CalculationSettingsDialog.this.mLongitudeText.setText(null);
        }
    }

    /* renamed from: org.bpmikc.akm.Dialog.CalculationSettingsDialog.2 */
    class C04902 implements OnClickListener {
        final /* synthetic */ float[] val$latLong;
        final /* synthetic */ Preferences val$preferences;

        C04902(float[] fArr, Preferences preferences) {
            this.val$latLong = fArr;
            this.val$preferences = preferences;
        }

        public void onClick(View v) {
            float newLatitude = CalculationSettingsDialog.parseFloat(CalculationSettingsDialog.this.mLatitudeText, this.val$latLong[0]);
            float newLongitude = CalculationSettingsDialog.parseFloat(CalculationSettingsDialog.this.mLongitudeText, this.val$latLong[1]);
            if (!(newLatitude == this.val$latLong[0] && newLongitude == this.val$latLong[1])) {
                this.val$preferences.setLocation(newLatitude, newLongitude);
                Schedule.setSettingsDirty();
            }
            CalculationSettingsDialog.this.dismiss();
        }
    }

    /* renamed from: org.bpmikc.akm.Dialog.CalculationSettingsDialog.3 */
    class C04913 implements OnClickListener {
        C04913() {
        }

        public void onClick(View v) {
            CalculationSettingsDialog.this.dismiss();
        }
    }

    public CalculationSettingsDialog(Context context) {
        super(context);
        this.mContext = context;
    }

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(C0615R.layout.settings_calculation);
        setTitle(C0615R.string.calculation);
        Preferences preferences = Preferences.getInstance(this.mContext);
        float[] latLong = preferences.getLocation();
        int calculationMethod = preferences.getCalculationMethodIndex();
        this.mLatitudeText = (EditText) findViewById(C0615R.id.latitude);
        this.mLatitudeText.setText(Float.toString(latLong[0]));
        this.mLongitudeText = (EditText) findViewById(C0615R.id.longitude);
        this.mLongitudeText.setText(Float.toString(latLong[1]));
        ((ImageButton) findViewById(C0615R.id.lookup_gps)).setOnClickListener(new C04891(preferences));
        ((Button) findViewById(C0615R.id.save_settings)).setOnClickListener(new C04902(latLong, preferences));
        ((Button) findViewById(C0615R.id.reset_settings)).setOnClickListener(new C04913());
    }

    private static float parseFloat(EditText et, float defaultValue) {
        try {
            defaultValue = Float.parseFloat(et.getText().toString());
        } catch (NumberFormatException e) {
        }
        return defaultValue;
    }
}
