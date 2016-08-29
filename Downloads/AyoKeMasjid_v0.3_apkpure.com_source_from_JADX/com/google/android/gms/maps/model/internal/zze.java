package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public interface zze extends IInterface {

    public static abstract class zza extends Binder implements zze {

        private static class zza implements zze {
            private IBinder zznI;

            zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public void activate() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
                    this.zznI.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public String getName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
                    this.zznI.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getShortName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
                    this.zznI.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int hashCodeRemote() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
                    this.zznI.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean zza(zze com_google_android_gms_maps_model_internal_zze) throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
                    obtain.writeStrongBinder(com_google_android_gms_maps_model_internal_zze != null ? com_google_android_gms_maps_model_internal_zze.asBinder() : null);
                    this.zznI.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zze zzcS(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zze)) ? new zza(iBinder) : (zze) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String name;
            switch (code) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
                    name = getName();
                    reply.writeNoException();
                    reply.writeString(name);
                    return true;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
                    name = getShortName();
                    reply.writeNoException();
                    reply.writeString(name);
                    return true;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
                    activate();
                    reply.writeNoException();
                    return true;
                case Barcode.PHONE /*4*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
                    boolean zza = zza(zzcS(data.readStrongBinder()));
                    reply.writeNoException();
                    reply.writeInt(zza ? 1 : 0);
                    return true;
                case Barcode.PRODUCT /*5*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
                    int hashCodeRemote = hashCodeRemote();
                    reply.writeNoException();
                    reply.writeInt(hashCodeRemote);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void activate() throws RemoteException;

    String getName() throws RemoteException;

    String getShortName() throws RemoteException;

    int hashCodeRemote() throws RemoteException;

    boolean zza(zze com_google_android_gms_maps_model_internal_zze) throws RemoteException;
}
