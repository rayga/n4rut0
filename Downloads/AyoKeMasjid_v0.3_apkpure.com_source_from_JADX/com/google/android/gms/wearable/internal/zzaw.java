package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.ConnectionConfiguration;
import com.google.android.gms.wearable.PutDataRequest;

public interface zzaw extends IInterface {

    public static abstract class zza extends Binder implements zzaw {

        private static class zza implements zzaw {
            private IBinder zznI;

            zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    this.zznI.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, byte b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    obtain.writeByte(b);
                    this.zznI.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    obtain.writeInt(i);
                    this.zznI.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, Uri uri, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.zznI.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, Asset asset) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    if (asset != null) {
                        obtain.writeInt(1);
                        asset.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, ConnectionConfiguration connectionConfiguration) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    if (connectionConfiguration != null) {
                        obtain.writeInt(1);
                        connectionConfiguration.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, PutDataRequest putDataRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    if (putDataRequest != null) {
                        obtain.writeInt(1);
                        putDataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, AddListenerRequest addListenerRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    if (addListenerRequest != null) {
                        obtain.writeInt(1);
                        addListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, AncsNotificationParcelable ancsNotificationParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    if (ancsNotificationParcelable != null) {
                        obtain.writeInt(1);
                        ancsNotificationParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, RemoveListenerRequest removeListenerRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    if (removeListenerRequest != null) {
                        obtain.writeInt(1);
                        removeListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, zzat com_google_android_gms_wearable_internal_zzat, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    if (com_google_android_gms_wearable_internal_zzat != null) {
                        iBinder = com_google_android_gms_wearable_internal_zzat.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.zznI.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    obtain.writeString(str);
                    this.zznI.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zznI.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, String str, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    obtain.writeString(str);
                    if (parcelFileDescriptor != null) {
                        obtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, String str, ParcelFileDescriptor parcelFileDescriptor, long j, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    obtain.writeString(str);
                    if (parcelFileDescriptor != null) {
                        obtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.zznI.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zznI.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, String str, String str2, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeByteArray(bArr);
                    this.zznI.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau com_google_android_gms_wearable_internal_zzau, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zznI.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    this.zznI.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzau com_google_android_gms_wearable_internal_zzau, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    obtain.writeInt(i);
                    this.zznI.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzau com_google_android_gms_wearable_internal_zzau, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzau com_google_android_gms_wearable_internal_zzau, Uri uri, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.zznI.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzau com_google_android_gms_wearable_internal_zzau, ConnectionConfiguration connectionConfiguration) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    if (connectionConfiguration != null) {
                        obtain.writeInt(1);
                        connectionConfiguration.writeToParcel(obtain, 0);
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

            public void zzb(zzau com_google_android_gms_wearable_internal_zzau, zzat com_google_android_gms_wearable_internal_zzat, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    if (com_google_android_gms_wearable_internal_zzat != null) {
                        iBinder = com_google_android_gms_wearable_internal_zzat.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.zznI.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzau com_google_android_gms_wearable_internal_zzau, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    obtain.writeString(str);
                    this.zznI.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzau com_google_android_gms_wearable_internal_zzau, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zznI.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzau com_google_android_gms_wearable_internal_zzau, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zznI.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    this.zznI.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzau com_google_android_gms_wearable_internal_zzau, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    obtain.writeInt(i);
                    this.zznI.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzau com_google_android_gms_wearable_internal_zzau, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzau com_google_android_gms_wearable_internal_zzau, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    obtain.writeString(str);
                    this.zznI.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    this.zznI.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzau com_google_android_gms_wearable_internal_zzau, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    obtain.writeString(str);
                    this.zznI.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    this.zznI.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(zzau com_google_android_gms_wearable_internal_zzau, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    obtain.writeString(str);
                    this.zznI.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    this.zznI.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(zzau com_google_android_gms_wearable_internal_zzau, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    obtain.writeString(str);
                    this.zznI.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzg(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    this.zznI.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzh(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    this.zznI.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzi(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    this.zznI.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzj(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    this.zznI.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzk(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    this.zznI.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzl(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    this.zznI.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzm(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    this.zznI.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzn(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    this.zznI.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzo(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    this.zznI.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzp(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzau != null ? com_google_android_gms_wearable_internal_zzau.asBinder() : null);
                    this.zznI.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzaw zzea(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzaw)) ? new zza(iBinder) : (zzaw) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            ConnectionConfiguration connectionConfiguration = null;
            zzau zzdY;
            Uri uri;
            switch (code) {
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdY = com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        connectionConfiguration = (ConnectionConfiguration) ConnectionConfiguration.CREATOR.createFromParcel(data);
                    }
                    zzb(zzdY, connectionConfiguration);
                    reply.writeNoException();
                    return true;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzn(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Barcode.PHONE /*4*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzo(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Barcode.PRODUCT /*5*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzp(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Barcode.SMS /*6*/:
                    PutDataRequest putDataRequest;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdY = com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        putDataRequest = (PutDataRequest) PutDataRequest.CREATOR.createFromParcel(data);
                    }
                    zza(zzdY, putDataRequest);
                    reply.writeNoException();
                    return true;
                case Barcode.TEXT /*7*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdY = com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    zza(zzdY, uri);
                    reply.writeNoException();
                    return true;
                case Barcode.URL /*8*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Barcode.WIFI /*9*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdY = com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    zzb(zzdY, uri);
                    reply.writeNoException();
                    return true;
                case Barcode.CALENDAR_EVENT /*11*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdY = com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    zzc(zzdY, uri);
                    reply.writeNoException();
                    return true;
                case Barcode.DRIVER_LICENSE /*12*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()), data.readString(), data.readString(), data.createByteArray());
                    reply.writeNoException();
                    return true;
                case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                    Asset asset;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdY = com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        asset = (Asset) Asset.CREATOR.createFromParcel(data);
                    }
                    zza(zzdY, asset);
                    reply.writeNoException();
                    return true;
                case Place.TYPE_BUS_STATION /*14*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzc(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_CAFE /*15*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzd(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Barcode.DATA_MATRIX /*16*/:
                    AddListenerRequest addListenerRequest;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdY = com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        addListenerRequest = (AddListenerRequest) AddListenerRequest.CREATOR.createFromParcel(data);
                    }
                    zza(zzdY, addListenerRequest);
                    reply.writeNoException();
                    return true;
                case Place.TYPE_CAR_DEALER /*17*/:
                    RemoveListenerRequest removeListenerRequest;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdY = com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        removeListenerRequest = (RemoveListenerRequest) RemoveListenerRequest.CREATOR.createFromParcel(data);
                    }
                    zza(zzdY, removeListenerRequest);
                    reply.writeNoException();
                    return true;
                case Place.TYPE_CAR_RENTAL /*18*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zze(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_CAR_REPAIR /*19*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzf(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_CAR_WASH /*20*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdY = com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        connectionConfiguration = (ConnectionConfiguration) ConnectionConfiguration.CREATOR.createFromParcel(data);
                    }
                    zza(zzdY, connectionConfiguration);
                    reply.writeNoException();
                    return true;
                case Place.TYPE_CASINO /*21*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_CEMETERY /*22*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_CHURCH /*23*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_CITY_HALL /*24*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzc(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_CLOTHING_STORE /*25*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzg(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_CONVENIENCE_STORE /*26*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzh(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_COURTHOUSE /*27*/:
                    AncsNotificationParcelable ancsNotificationParcelable;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdY = com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        ancsNotificationParcelable = (AncsNotificationParcelable) AncsNotificationParcelable.CREATOR.createFromParcel(data);
                    }
                    zza(zzdY, ancsNotificationParcelable);
                    reply.writeNoException();
                    return true;
                case Place.TYPE_DENTIST /*28*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_DEPARTMENT_STORE /*29*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzc(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_DOCTOR /*30*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzi(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_ELECTRICIAN /*31*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case Barcode.EAN_13 /*32*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzf(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_EMBASSY /*33*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()), data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_ESTABLISHMENT /*34*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()), com.google.android.gms.wearable.internal.zzat.zza.zzdX(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_FINANCE /*35*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()), com.google.android.gms.wearable.internal.zzat.zza.zzdX(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_FLORIST /*37*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzj(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_FOOD /*38*/:
                    ParcelFileDescriptor parcelFileDescriptor;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdY = com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder());
                    String readString = data.readString();
                    if (data.readInt() != 0) {
                        parcelFileDescriptor = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(data);
                    }
                    zza(zzdY, readString, parcelFileDescriptor);
                    reply.writeNoException();
                    return true;
                case Place.TYPE_FUNERAL_HOME /*39*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()), data.readString(), data.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(data) : null, data.readLong(), data.readLong());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_FURNITURE_STORE /*40*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdY = com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    zza(zzdY, uri, data.readInt());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_GAS_STATION /*41*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdY = com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    zzb(zzdY, uri, data.readInt());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_GENERAL_CONTRACTOR /*42*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()), data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_GROCERY_OR_SUPERMARKET /*43*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_HARDWARE_STORE /*46*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzd(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_HEALTH /*47*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zze(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_HINDU_TEMPLE /*48*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case Place.TYPE_HOME_GOODS_STORE /*49*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzk(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_HOSPITAL /*50*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzau zzdY2 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zzb(zzdY2, z);
                    reply.writeNoException();
                    return true;
                case Place.TYPE_INSURANCE_AGENCY /*51*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzl(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_JEWELRY_STORE /*52*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzm(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_LAUNDRY /*53*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzau.zza.zzdY(data.readStrongBinder()), data.readByte());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wearable.internal.IWearableService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, byte b) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, int i) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, Uri uri) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, Uri uri, int i) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, Asset asset) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, ConnectionConfiguration connectionConfiguration) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, PutDataRequest putDataRequest) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, AddListenerRequest addListenerRequest) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, AncsNotificationParcelable ancsNotificationParcelable) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, RemoveListenerRequest removeListenerRequest) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, zzat com_google_android_gms_wearable_internal_zzat, String str) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, String str) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, String str, int i) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, String str, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, String str, ParcelFileDescriptor parcelFileDescriptor, long j, long j2) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, String str, String str2) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, String str, String str2, byte[] bArr) throws RemoteException;

    void zza(zzau com_google_android_gms_wearable_internal_zzau, boolean z) throws RemoteException;

    void zzb(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException;

    void zzb(zzau com_google_android_gms_wearable_internal_zzau, int i) throws RemoteException;

    void zzb(zzau com_google_android_gms_wearable_internal_zzau, Uri uri) throws RemoteException;

    void zzb(zzau com_google_android_gms_wearable_internal_zzau, Uri uri, int i) throws RemoteException;

    void zzb(zzau com_google_android_gms_wearable_internal_zzau, ConnectionConfiguration connectionConfiguration) throws RemoteException;

    void zzb(zzau com_google_android_gms_wearable_internal_zzau, zzat com_google_android_gms_wearable_internal_zzat, String str) throws RemoteException;

    void zzb(zzau com_google_android_gms_wearable_internal_zzau, String str) throws RemoteException;

    void zzb(zzau com_google_android_gms_wearable_internal_zzau, String str, int i) throws RemoteException;

    void zzb(zzau com_google_android_gms_wearable_internal_zzau, boolean z) throws RemoteException;

    void zzc(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException;

    void zzc(zzau com_google_android_gms_wearable_internal_zzau, int i) throws RemoteException;

    void zzc(zzau com_google_android_gms_wearable_internal_zzau, Uri uri) throws RemoteException;

    void zzc(zzau com_google_android_gms_wearable_internal_zzau, String str) throws RemoteException;

    void zzd(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException;

    void zzd(zzau com_google_android_gms_wearable_internal_zzau, String str) throws RemoteException;

    void zze(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException;

    void zze(zzau com_google_android_gms_wearable_internal_zzau, String str) throws RemoteException;

    void zzf(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException;

    void zzf(zzau com_google_android_gms_wearable_internal_zzau, String str) throws RemoteException;

    void zzg(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException;

    void zzh(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException;

    void zzi(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException;

    void zzj(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException;

    void zzk(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException;

    void zzl(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException;

    void zzm(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException;

    void zzn(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException;

    void zzo(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException;

    void zzp(zzau com_google_android_gms_wearable_internal_zzau) throws RemoteException;
}
