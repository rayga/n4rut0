package com.google.android.gms.cast.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public interface zzi extends IInterface {

    public static abstract class zza extends Binder implements zzi {

        private static class zza implements zzi {
            private IBinder zznI;

            zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void disconnect() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    this.zznI.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(double d, double d2, boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeDouble(d);
                    obtain.writeDouble(d2);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.zznI.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(String str, LaunchOptions launchOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    if (launchOptions != null) {
                        obtain.writeInt(1);
                        launchOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(13, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(String str, String str2, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeLong(j);
                    this.zznI.transact(9, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(String str, byte[] bArr, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeLong(j);
                    this.zznI.transact(10, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(boolean z, double d, boolean z2) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeDouble(d);
                    if (!z2) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.zznI.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzbO(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    this.zznI.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzbP(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    this.zznI.transact(11, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzbQ(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    this.zznI.transact(12, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzf(String str, boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.zznI.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzmI() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    this.zznI.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzmx() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    this.zznI.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzt(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zznI.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzi zzaB(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzi)) ? new zza(iBinder) : (zzi) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            switch (code) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    disconnect();
                    return true;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    String readString = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zzf(readString, z);
                    return true;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    zzt(data.readString(), data.readString());
                    return true;
                case Barcode.PHONE /*4*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    zzmI();
                    return true;
                case Barcode.PRODUCT /*5*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    zzbO(data.readString());
                    return true;
                case Barcode.SMS /*6*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    zzmx();
                    return true;
                case Barcode.TEXT /*7*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    zza(data.readDouble(), data.readDouble(), data.readInt() != 0);
                    return true;
                case Barcode.URL /*8*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    boolean z2 = data.readInt() != 0;
                    double readDouble = data.readDouble();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zza(z2, readDouble, z);
                    return true;
                case Barcode.WIFI /*9*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    zza(data.readString(), data.readString(), data.readLong());
                    return true;
                case Barcode.GEO /*10*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    zza(data.readString(), data.createByteArray(), data.readLong());
                    return true;
                case Barcode.CALENDAR_EVENT /*11*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    zzbP(data.readString());
                    return true;
                case Barcode.DRIVER_LICENSE /*12*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    zzbQ(data.readString());
                    return true;
                case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
                    zza(data.readString(), data.readInt() != 0 ? (LaunchOptions) LaunchOptions.CREATOR.createFromParcel(data) : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.cast.internal.ICastDeviceController");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void disconnect() throws RemoteException;

    void zza(double d, double d2, boolean z) throws RemoteException;

    void zza(String str, LaunchOptions launchOptions) throws RemoteException;

    void zza(String str, String str2, long j) throws RemoteException;

    void zza(String str, byte[] bArr, long j) throws RemoteException;

    void zza(boolean z, double d, boolean z2) throws RemoteException;

    void zzbO(String str) throws RemoteException;

    void zzbP(String str) throws RemoteException;

    void zzbQ(String str) throws RemoteException;

    void zzf(String str, boolean z) throws RemoteException;

    void zzmI() throws RemoteException;

    void zzmx() throws RemoteException;

    void zzt(String str, String str2) throws RemoteException;
}
