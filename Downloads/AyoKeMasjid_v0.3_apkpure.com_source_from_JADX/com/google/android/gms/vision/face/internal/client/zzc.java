package com.google.android.gms.vision.face.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;

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

            public void zzCf() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
                    this.zznI.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public FaceParcel[] zzc(zzd com_google_android_gms_dynamic_zzd, FrameMetadataParcel frameMetadataParcel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
                    obtain.writeStrongBinder(com_google_android_gms_dynamic_zzd != null ? com_google_android_gms_dynamic_zzd.asBinder() : null);
                    if (frameMetadataParcel != null) {
                        obtain.writeInt(1);
                        frameMetadataParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    FaceParcel[] faceParcelArr = (FaceParcel[]) obtain2.createTypedArray(FaceParcel.CREATOR);
                    return faceParcelArr;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean zzjG(int i) throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
                    obtain.writeInt(i);
                    this.zznI.transact(2, obtain, obtain2, 0);
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

        public static zzc zzdM(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzc)) ? new zza(iBinder) : (zzc) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    data.enforceInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
                    Parcelable[] zzc = zzc(com.google.android.gms.dynamic.zzd.zza.zzbk(data.readStrongBinder()), data.readInt() != 0 ? FrameMetadataParcel.CREATOR.zzgD(data) : null);
                    reply.writeNoException();
                    reply.writeTypedArray(zzc, 1);
                    return true;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    data.enforceInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
                    boolean zzjG = zzjG(data.readInt());
                    reply.writeNoException();
                    reply.writeInt(zzjG ? 1 : 0);
                    return true;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    data.enforceInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
                    zzCf();
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zzCf() throws RemoteException;

    FaceParcel[] zzc(zzd com_google_android_gms_dynamic_zzd, FrameMetadataParcel frameMetadataParcel) throws RemoteException;

    boolean zzjG(int i) throws RemoteException;
}
