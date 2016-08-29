package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.safetynet.AttestationData;
import com.google.android.gms.safetynet.SafeBrowsingData;
import com.google.android.gms.vision.barcode.Barcode;

public interface zzpu extends IInterface {

    public static abstract class zza extends Binder implements zzpu {

        private static class zza implements zzpu {
            private IBinder zznI;

            zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void zza(Status status, AttestationData attestationData) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (attestationData != null) {
                        obtain.writeInt(1);
                        attestationData.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(Status status, SafeBrowsingData safeBrowsingData) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (safeBrowsingData != null) {
                        obtain.writeInt(1);
                        safeBrowsingData.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzap(boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.zznI.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzel(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    obtain.writeString(str);
                    this.zznI.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
        }

        public static zzpu zzdA(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzpu)) ? new zza(iBinder) : (zzpu) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    data.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    zza(data.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (AttestationData) AttestationData.CREATOR.createFromParcel(data) : null);
                    return true;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    data.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    zzel(data.readString());
                    return true;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    data.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    zza(data.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (SafeBrowsingData) SafeBrowsingData.CREATOR.createFromParcel(data) : null);
                    return true;
                case Barcode.PHONE /*4*/:
                    data.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    zzap(data.readInt() != 0);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(Status status, AttestationData attestationData) throws RemoteException;

    void zza(Status status, SafeBrowsingData safeBrowsingData) throws RemoteException;

    void zzap(boolean z) throws RemoteException;

    void zzel(String str) throws RemoteException;
}
