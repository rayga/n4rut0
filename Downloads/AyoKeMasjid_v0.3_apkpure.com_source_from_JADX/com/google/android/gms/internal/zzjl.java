package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.events.CompletionEvent;

public interface zzjl extends IInterface {

    public static abstract class zza extends Binder implements zzjl {

        private static class zza implements zzjl {
            private IBinder zznI;

            zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void zza(zzjk com_google_android_gms_internal_zzjk, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appinvite.internal.IAppInviteService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzjk != null ? com_google_android_gms_internal_zzjk.asBinder() : null);
                    obtain.writeString(str);
                    this.zznI.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzjk com_google_android_gms_internal_zzjk, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appinvite.internal.IAppInviteService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzjk != null ? com_google_android_gms_internal_zzjk.asBinder() : null);
                    obtain.writeString(str);
                    this.zznI.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzjl zzak(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appinvite.internal.IAppInviteService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzjl)) ? new zza(iBinder) : (zzjl) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    data.enforceInterface("com.google.android.gms.appinvite.internal.IAppInviteService");
                    zzb(com.google.android.gms.internal.zzjk.zza.zzaj(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    data.enforceInterface("com.google.android.gms.appinvite.internal.IAppInviteService");
                    zza(com.google.android.gms.internal.zzjk.zza.zzaj(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.appinvite.internal.IAppInviteService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(zzjk com_google_android_gms_internal_zzjk, String str) throws RemoteException;

    void zzb(zzjk com_google_android_gms_internal_zzjk, String str) throws RemoteException;
}
