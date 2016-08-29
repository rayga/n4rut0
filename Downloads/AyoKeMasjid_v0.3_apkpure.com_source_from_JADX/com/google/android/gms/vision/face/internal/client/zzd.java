package com.google.android.gms.vision.face.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.events.CompletionEvent;

public interface zzd extends IInterface {

    public static abstract class zza extends Binder implements zzd {

        private static class zza implements zzd {
            private IBinder zznI;

            zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public zzc zza(com.google.android.gms.dynamic.zzd com_google_android_gms_dynamic_zzd, FaceSettingsParcel faceSettingsParcel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.vision.face.internal.client.INativeFaceDetectorCreator");
                    obtain.writeStrongBinder(com_google_android_gms_dynamic_zzd != null ? com_google_android_gms_dynamic_zzd.asBinder() : null);
                    if (faceSettingsParcel != null) {
                        obtain.writeInt(1);
                        faceSettingsParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    zzc zzdM = com.google.android.gms.vision.face.internal.client.zzc.zza.zzdM(obtain2.readStrongBinder());
                    return zzdM;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzd zzdN(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetectorCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzd)) ? new zza(iBinder) : (zzd) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    data.enforceInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetectorCreator");
                    zzc zza = zza(com.google.android.gms.dynamic.zzd.zza.zzbk(data.readStrongBinder()), data.readInt() != 0 ? FaceSettingsParcel.CREATOR.zzgB(data) : null);
                    reply.writeNoException();
                    if (zza != null) {
                        iBinder = zza.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.vision.face.internal.client.INativeFaceDetectorCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    zzc zza(com.google.android.gms.dynamic.zzd com_google_android_gms_dynamic_zzd, FaceSettingsParcel faceSettingsParcel) throws RemoteException;
}
