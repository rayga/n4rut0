package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.search.GoogleNowAuthState;

public interface zzpz extends IInterface {

    public static abstract class zza extends Binder implements zzpz {

        private static class zza implements zzpz {
            private IBinder zznI;

            zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void zza(Status status, GoogleNowAuthState googleNowAuthState) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.search.internal.ISearchAuthCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (googleNowAuthState != null) {
                        obtain.writeInt(1);
                        googleNowAuthState.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzbc(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.search.internal.ISearchAuthCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.search.internal.ISearchAuthCallbacks");
        }

        public static zzpz zzdD(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.search.internal.ISearchAuthCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzpz)) ? new zza(iBinder) : (zzpz) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    data.enforceInterface("com.google.android.gms.search.internal.ISearchAuthCallbacks");
                    zza(data.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (GoogleNowAuthState) GoogleNowAuthState.CREATOR.createFromParcel(data) : null);
                    return true;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    data.enforceInterface("com.google.android.gms.search.internal.ISearchAuthCallbacks");
                    zzbc(data.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(data) : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.search.internal.ISearchAuthCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(Status status, GoogleNowAuthState googleNowAuthState) throws RemoteException;

    void zzbc(Status status) throws RemoteException;
}
