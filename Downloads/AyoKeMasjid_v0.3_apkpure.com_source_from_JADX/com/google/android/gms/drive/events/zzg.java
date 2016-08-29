package com.google.android.gms.drive.events;

import com.google.android.gms.drive.DriveId;
import com.google.android.gms.vision.barcode.Barcode;

public class zzg {
    public static boolean zza(int i, DriveId driveId) {
        switch (i) {
            case CompletionEvent.STATUS_FAILURE /*1*/:
                return driveId != null;
            case Barcode.PHONE /*4*/:
                return driveId == null;
            case Barcode.PRODUCT /*5*/:
            case Barcode.SMS /*6*/:
                return driveId != null;
            default:
                return false;
        }
    }
}
