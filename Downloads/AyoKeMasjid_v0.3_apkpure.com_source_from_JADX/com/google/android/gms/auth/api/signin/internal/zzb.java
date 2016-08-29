package com.google.android.gms.auth.api.signin.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.events.CompletionEvent;

public interface zzb extends IInterface {

    public static abstract class zza extends Binder implements zzb {

        private static class zza implements zzb {
            private IBinder zznI;

            zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void zza(zza com_google_android_gms_auth_api_signin_internal_zza, SignInConfiguration signInConfiguration) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    obtain.writeStrongBinder(com_google_android_gms_auth_api_signin_internal_zza != null ? com_google_android_gms_auth_api_signin_internal_zza.asBinder() : null);
                    if (signInConfiguration != null) {
                        obtain.writeInt(1);
                        signInConfiguration.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zza com_google_android_gms_auth_api_signin_internal_zza, SignInConfiguration signInConfiguration) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    obtain.writeStrongBinder(com_google_android_gms_auth_api_signin_internal_zza != null ? com_google_android_gms_auth_api_signin_internal_zza.asBinder() : null);
                    if (signInConfiguration != null) {
                        obtain.writeInt(1);
                        signInConfiguration.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzb zzay(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzb)) ? new zza(iBinder) : (zzb) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            SignInConfiguration signInConfiguration = null;
            zza zzax;
            switch (code) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    data.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    zzax = com.google.android.gms.auth.api.signin.internal.zza.zza.zzax(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        signInConfiguration = (SignInConfiguration) SignInConfiguration.CREATOR.createFromParcel(data);
                    }
                    zza(zzax, signInConfiguration);
                    reply.writeNoException();
                    return true;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    data.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    zzax = com.google.android.gms.auth.api.signin.internal.zza.zza.zzax(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        signInConfiguration = (SignInConfiguration) SignInConfiguration.CREATOR.createFromParcel(data);
                    }
                    zzb(zzax, signInConfiguration);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(zza com_google_android_gms_auth_api_signin_internal_zza, SignInConfiguration signInConfiguration) throws RemoteException;

    void zzb(zza com_google_android_gms_auth_api_signin_internal_zza, SignInConfiguration signInConfiguration) throws RemoteException;
}
