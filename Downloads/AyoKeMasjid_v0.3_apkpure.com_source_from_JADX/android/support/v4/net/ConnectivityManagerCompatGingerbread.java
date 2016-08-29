package android.support.v4.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

class ConnectivityManagerCompatGingerbread {
    ConnectivityManagerCompatGingerbread() {
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager cm) {
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null) {
            return true;
        }
        switch (info.getType()) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
            case CompletionEvent.STATUS_CONFLICT /*2*/:
            case CompletionEvent.STATUS_CANCELED /*3*/:
            case Barcode.PHONE /*4*/:
            case Barcode.PRODUCT /*5*/:
            case Barcode.SMS /*6*/:
                return true;
            case CompletionEvent.STATUS_FAILURE /*1*/:
                return false;
            default:
                return true;
        }
    }
}
