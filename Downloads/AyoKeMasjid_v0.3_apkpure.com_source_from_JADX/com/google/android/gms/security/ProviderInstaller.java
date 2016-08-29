package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import java.lang.reflect.Method;

public class ProviderInstaller {
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    private static Method zzaNV;
    private static final Object zzpm;

    /* renamed from: com.google.android.gms.security.ProviderInstaller.1 */
    static class C04321 extends AsyncTask<Void, Void, Integer> {
        final /* synthetic */ ProviderInstallListener zzaNW;
        final /* synthetic */ Context zzrn;

        C04321(Context context, ProviderInstallListener providerInstallListener) {
            this.zzrn = context;
            this.zzaNW = providerInstallListener;
        }

        protected /* synthetic */ Object doInBackground(Object[] x0) {
            return zzc((Void[]) x0);
        }

        protected /* synthetic */ void onPostExecute(Object x0) {
            zze((Integer) x0);
        }

        protected Integer zzc(Void... voidArr) {
            try {
                ProviderInstaller.installIfNeeded(this.zzrn);
                return Integer.valueOf(0);
            } catch (GooglePlayServicesRepairableException e) {
                return Integer.valueOf(e.getConnectionStatusCode());
            } catch (GooglePlayServicesNotAvailableException e2) {
                return Integer.valueOf(e2.errorCode);
            }
        }

        protected void zze(Integer num) {
            if (num.intValue() == 0) {
                this.zzaNW.onProviderInstalled();
                return;
            }
            this.zzaNW.onProviderInstallFailed(num.intValue(), GooglePlayServicesUtil.zzbc(num.intValue()));
        }
    }

    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i, Intent intent);

        void onProviderInstalled();
    }

    static {
        zzpm = new Object();
        zzaNV = null;
    }

    public static void installIfNeeded(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        zzx.zzb((Object) context, (Object) "Context must not be null");
        GooglePlayServicesUtil.zzaa(context);
        Context remoteContext = GooglePlayServicesUtil.getRemoteContext(context);
        if (remoteContext == null) {
            Log.e("ProviderInstaller", "Failed to get remote context");
            throw new GooglePlayServicesNotAvailableException(8);
        }
        synchronized (zzpm) {
            try {
                if (zzaNV == null) {
                    zzaK(remoteContext);
                }
                zzaNV.invoke(null, new Object[]{remoteContext});
            } catch (Exception e) {
                Log.e("ProviderInstaller", "Failed to install provider: " + e.getMessage());
                throw new GooglePlayServicesNotAvailableException(8);
            }
        }
    }

    public static void installIfNeededAsync(Context context, ProviderInstallListener listener) {
        zzx.zzb((Object) context, (Object) "Context must not be null");
        zzx.zzb((Object) listener, (Object) "Listener must not be null");
        zzx.zzch("Must be called on the UI thread");
        new C04321(context, listener).execute(new Void[0]);
    }

    private static void zzaK(Context context) throws ClassNotFoundException, NoSuchMethodException {
        zzaNV = context.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", new Class[]{Context.class});
    }
}
