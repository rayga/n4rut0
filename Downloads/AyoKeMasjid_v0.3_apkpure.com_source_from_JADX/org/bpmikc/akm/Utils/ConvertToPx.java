package org.bpmikc.akm.Utils;

import android.app.Activity;

public class ConvertToPx {
    public int convertToPx(int dp, Activity activity) {
        return (int) ((((float) dp) * activity.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
