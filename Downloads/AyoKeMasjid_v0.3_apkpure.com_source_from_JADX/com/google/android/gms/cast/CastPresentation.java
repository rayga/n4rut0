package com.google.android.gms.cast;

import android.app.Presentation;
import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.Display;
import android.view.Window;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.vision.barcode.Barcode;

public abstract class CastPresentation extends Presentation {
    public CastPresentation(Context serviceContext, Display display) {
        super(serviceContext, display);
        zzlN();
    }

    public CastPresentation(Context serviceContext, Display display, int theme) {
        super(serviceContext, display, theme);
        zzlN();
    }

    private void zzlN() {
        Window window = getWindow();
        if (window != null) {
            window.setType(2030);
            window.addFlags(DriveFile.MODE_READ_ONLY);
            window.addFlags(ViewCompat.MEASURED_STATE_TOO_SMALL);
            window.addFlags(Barcode.UPC_E);
        }
    }
}
