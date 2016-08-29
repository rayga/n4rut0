package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.search.SearchAuth.StatusCodes;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class zzo {
    private static final String TAG;
    private static final long zzaEN;
    private static zzo zzaEO;
    private final Context mContext;
    private final Handler mHandler;
    private final Runnable zzaEP;
    private ArrayList<String> zzaEQ;
    private ArrayList<String> zzaER;
    private final Object zzpc;

    private class zza implements Runnable {
        final /* synthetic */ zzo zzaES;

        private zza(zzo com_google_android_gms_location_places_internal_zzo) {
            this.zzaES = com_google_android_gms_location_places_internal_zzo;
        }

        public void run() {
            synchronized (this.zzaES.zzpc) {
                Intent intent = new Intent("com.google.android.location.places.METHOD_CALL");
                intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
                intent.putStringArrayListExtra("PLACE_IDS", this.zzaES.zzaEQ);
                intent.putStringArrayListExtra("METHOD_NAMES", this.zzaES.zzaER);
                intent.putExtra("PACKAGE_NAME", this.zzaES.mContext.getPackageName());
                intent.putExtra("CLIENT_VERSION", GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                this.zzaES.mContext.sendBroadcast(intent);
                this.zzaES.zzaEQ = null;
                this.zzaES.zzaER = null;
            }
        }
    }

    static {
        TAG = zzo.class.getSimpleName();
        zzaEN = TimeUnit.SECONDS.toMillis(1);
    }

    private zzo(Context context) {
        this((Context) zzx.zzv(context), new Handler(Looper.getMainLooper()));
    }

    zzo(Context context, Handler handler) {
        this.zzaEP = new zza();
        this.zzpc = new Object();
        this.zzaEQ = null;
        this.zzaER = null;
        this.mContext = context;
        this.mHandler = handler;
    }

    public static synchronized zzo zzaE(Context context) {
        zzo com_google_android_gms_location_places_internal_zzo;
        synchronized (zzo.class) {
            zzx.zzv(context);
            if (VERSION.SDK_INT < 14) {
                com_google_android_gms_location_places_internal_zzo = null;
            } else {
                if (zzaEO == null) {
                    zzaEO = new zzo(context.getApplicationContext());
                }
                com_google_android_gms_location_places_internal_zzo = zzaEO;
            }
        }
        return com_google_android_gms_location_places_internal_zzo;
    }

    public void zzC(String str, String str2) {
        synchronized (this.zzpc) {
            if (this.zzaEQ == null) {
                this.zzaEQ = new ArrayList();
                this.zzaER = new ArrayList();
                this.mHandler.postDelayed(this.zzaEP, zzaEN);
            }
            this.zzaEQ.add(str);
            this.zzaER.add(str2);
            if (this.zzaEQ.size() >= StatusCodes.AUTH_DISABLED) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Event buffer full, flushing");
                }
                this.zzaEP.run();
                this.mHandler.removeCallbacks(this.zzaEP);
                return;
            }
        }
    }
}
