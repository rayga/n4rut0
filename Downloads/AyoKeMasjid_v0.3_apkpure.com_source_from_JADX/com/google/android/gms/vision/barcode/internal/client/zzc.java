package com.google.android.gms.vision.barcode.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.dynamic.zzd;

public interface zzc extends IInterface {

    public static abstract class zza extends Binder implements zzc {

        private static class zza implements zzc {
            private IBinder zznI;

            zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public zzb zza(zzd com_google_android_gms_dynamic_zzd, BarcodeDetectorOptions barcodeDetectorOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator");
                    obtain.writeStrongBinder(com_google_android_gms_dynamic_zzd != null ? com_google_android_gms_dynamic_zzd.asBinder() : null);
                    if (barcodeDetectorOptions != null) {
                        obtain.writeInt(1);
                        barcodeDetectorOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    zzb zzdJ = com.google.android.gms.vision.barcode.internal.client.zzb.zza.zzdJ(obtain2.readStrongBinder());
                    return zzdJ;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzc zzdK(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzc)) ? new zza(iBinder) : (zzc) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    data.enforceInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator");
                    zzb zza = zza(com.google.android.gms.dynamic.zzd.zza.zzbk(data.readStrongBinder()), data.readInt() != 0 ? BarcodeDetectorOptions.CREATOR.zzgz(data) : null);
                    reply.writeNoException();
                    if (zza != null) {
                        iBinder = zza.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    zzb zza(zzd com_google_android_gms_dynamic_zzd, BarcodeDetectorOptions barcodeDetectorOptions) throws RemoteException;
}
