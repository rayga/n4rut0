package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.FitnessStatusCodes;

public interface zzjp extends IInterface {

    public static abstract class zza extends Binder implements zzjp {

        private static class zza implements zzjp {
            private IBinder zznI;

            zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void zza(zzjo com_google_android_gms_internal_zzjo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzjo != null ? com_google_android_gms_internal_zzjo.asBinder() : null);
                    this.zznI.transact(FitnessStatusCodes.UNKNOWN_AUTH_ERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzjo com_google_android_gms_internal_zzjo, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzjo != null ? com_google_android_gms_internal_zzjo.asBinder() : null);
                    obtain.writeInt(i);
                    this.zznI.transact(FitnessStatusCodes.APP_MISMATCH, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzjo com_google_android_gms_internal_zzjo, int i, String str, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzjo != null ? com_google_android_gms_internal_zzjo.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    this.zznI.transact(FitnessStatusCodes.MISSING_BLE_PERMISSION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzjo com_google_android_gms_internal_zzjo, int i, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzjo != null ? com_google_android_gms_internal_zzjo.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    this.zznI.transact(FitnessStatusCodes.DATA_TYPE_NOT_FOUND, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzjo com_google_android_gms_internal_zzjo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzjo != null ? com_google_android_gms_internal_zzjo.asBinder() : null);
                    this.zznI.transact(FitnessStatusCodes.TRANSIENT_ERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzjo com_google_android_gms_internal_zzjo, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzjo != null ? com_google_android_gms_internal_zzjo.asBinder() : null);
                    obtain.writeInt(i);
                    this.zznI.transact(FitnessStatusCodes.UNSUPPORTED_PLATFORM, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzjo com_google_android_gms_internal_zzjo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzjo != null ? com_google_android_gms_internal_zzjo.asBinder() : null);
                    this.zznI.transact(FitnessStatusCodes.EQUIVALENT_SESSION_ENDED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int zzln() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    this.zznI.transact(FitnessStatusCodes.CONFLICTING_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int zzlo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    this.zznI.transact(FitnessStatusCodes.INCONSISTENT_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzjp zzan(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appstate.internal.IAppStateService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzjp)) ? new zza(iBinder) : (zzjp) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int zzln;
            switch (code) {
                case FitnessStatusCodes.CONFLICTING_DATA_TYPE /*5001*/:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zzln = zzln();
                    reply.writeNoException();
                    reply.writeInt(zzln);
                    return true;
                case FitnessStatusCodes.INCONSISTENT_DATA_TYPE /*5002*/:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zzln = zzlo();
                    reply.writeNoException();
                    reply.writeInt(zzln);
                    return true;
                case FitnessStatusCodes.DATA_TYPE_NOT_FOUND /*5003*/:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zza(com.google.android.gms.internal.zzjo.zza.zzam(data.readStrongBinder()), data.readInt(), data.createByteArray());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.APP_MISMATCH /*5004*/:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zza(com.google.android.gms.internal.zzjo.zza.zzam(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.UNKNOWN_AUTH_ERROR /*5005*/:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zza(com.google.android.gms.internal.zzjo.zza.zzam(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.MISSING_BLE_PERMISSION /*5006*/:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zza(com.google.android.gms.internal.zzjo.zza.zzam(data.readStrongBinder()), data.readInt(), data.readString(), data.createByteArray());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.UNSUPPORTED_PLATFORM /*5007*/:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zzb(com.google.android.gms.internal.zzjo.zza.zzam(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.TRANSIENT_ERROR /*5008*/:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zzb(com.google.android.gms.internal.zzjo.zza.zzam(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.EQUIVALENT_SESSION_ENDED /*5009*/:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    zzc(com.google.android.gms.internal.zzjo.zza.zzam(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.appstate.internal.IAppStateService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(zzjo com_google_android_gms_internal_zzjo) throws RemoteException;

    void zza(zzjo com_google_android_gms_internal_zzjo, int i) throws RemoteException;

    void zza(zzjo com_google_android_gms_internal_zzjo, int i, String str, byte[] bArr) throws RemoteException;

    void zza(zzjo com_google_android_gms_internal_zzjo, int i, byte[] bArr) throws RemoteException;

    void zzb(zzjo com_google_android_gms_internal_zzjo) throws RemoteException;

    void zzb(zzjo com_google_android_gms_internal_zzjo, int i) throws RemoteException;

    void zzc(zzjo com_google_android_gms_internal_zzjo) throws RemoteException;

    int zzln() throws RemoteException;

    int zzlo() throws RemoteException;
}
