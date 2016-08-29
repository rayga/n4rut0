package com.google.android.gms.internal;

import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

final class zzkg {
    protected static final int zzaR(int i) {
        switch (i) {
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                return 5;
            case CompletionEvent.STATUS_CANCELED /*3*/:
                return 1;
            case Barcode.PHONE /*4*/:
                return 2;
            case Barcode.PRODUCT /*5*/:
                return 3;
            case Barcode.SMS /*6*/:
                return 4;
            default:
                return 0;
        }
    }
}
