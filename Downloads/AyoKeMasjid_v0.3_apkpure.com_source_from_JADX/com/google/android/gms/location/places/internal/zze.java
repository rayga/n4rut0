package com.google.android.gms.location.places.internal;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.NearbyAlertRequest;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.PlaceRequest;
import com.google.android.gms.vision.barcode.Barcode;

public interface zze extends IInterface {

    public static abstract class zza extends Binder implements zze {

        private static class zza implements zze {
            private IBinder zznI;

            zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void zza(NearbyAlertRequest nearbyAlertRequest, PlacesParams placesParams, PendingIntent pendingIntent, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
                    if (nearbyAlertRequest != null) {
                        obtain.writeInt(1);
                        nearbyAlertRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_location_places_internal_zzh != null ? com_google_android_gms_location_places_internal_zzh.asBinder() : null);
                    this.zznI.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(PlaceFilter placeFilter, PlacesParams placesParams, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
                    if (placeFilter != null) {
                        obtain.writeInt(1);
                        placeFilter.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_location_places_internal_zzh != null ? com_google_android_gms_location_places_internal_zzh.asBinder() : null);
                    this.zznI.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(PlaceReport placeReport, PlacesParams placesParams, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
                    if (placeReport != null) {
                        obtain.writeInt(1);
                        placeReport.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_location_places_internal_zzh != null ? com_google_android_gms_location_places_internal_zzh.asBinder() : null);
                    this.zznI.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(PlaceRequest placeRequest, PlacesParams placesParams, PendingIntent pendingIntent, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
                    if (placeRequest != null) {
                        obtain.writeInt(1);
                        placeRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_location_places_internal_zzh != null ? com_google_android_gms_location_places_internal_zzh.asBinder() : null);
                    this.zznI.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(PlacesParams placesParams, PendingIntent pendingIntent, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_location_places_internal_zzh != null ? com_google_android_gms_location_places_internal_zzh.asBinder() : null);
                    this.zznI.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(PlacesParams placesParams, PendingIntent pendingIntent, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_location_places_internal_zzh != null ? com_google_android_gms_location_places_internal_zzh.asBinder() : null);
                    this.zznI.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zze zzcd(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zze)) ? new zza(iBinder) : (zze) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            PlacesParams placesParams = null;
            switch (code) {
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
                    zza(data.readInt() != 0 ? (PlaceRequest) PlaceRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? PlacesParams.CREATOR.zzeN(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null, com.google.android.gms.location.places.internal.zzh.zza.zzcg(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
                    zza(data.readInt() != 0 ? PlacesParams.CREATOR.zzeN(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null, com.google.android.gms.location.places.internal.zzh.zza.zzcg(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Barcode.PHONE /*4*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
                    zza(data.readInt() != 0 ? NearbyAlertRequest.CREATOR.zzeC(data) : null, data.readInt() != 0 ? PlacesParams.CREATOR.zzeN(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null, com.google.android.gms.location.places.internal.zzh.zza.zzcg(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Barcode.PRODUCT /*5*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
                    zzb(data.readInt() != 0 ? PlacesParams.CREATOR.zzeN(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null, com.google.android.gms.location.places.internal.zzh.zza.zzcg(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Barcode.SMS /*6*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
                    PlaceFilter zzeD = data.readInt() != 0 ? PlaceFilter.CREATOR.zzeD(data) : null;
                    if (data.readInt() != 0) {
                        placesParams = PlacesParams.CREATOR.zzeN(data);
                    }
                    zza(zzeD, placesParams, com.google.android.gms.location.places.internal.zzh.zza.zzcg(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Barcode.TEXT /*7*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
                    PlaceReport placeReport = data.readInt() != 0 ? (PlaceReport) PlaceReport.CREATOR.createFromParcel(data) : null;
                    if (data.readInt() != 0) {
                        placesParams = PlacesParams.CREATOR.zzeN(data);
                    }
                    zza(placeReport, placesParams, com.google.android.gms.location.places.internal.zzh.zza.zzcg(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(NearbyAlertRequest nearbyAlertRequest, PlacesParams placesParams, PendingIntent pendingIntent, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException;

    void zza(PlaceFilter placeFilter, PlacesParams placesParams, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException;

    void zza(PlaceReport placeReport, PlacesParams placesParams, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException;

    void zza(PlaceRequest placeRequest, PlacesParams placesParams, PendingIntent pendingIntent, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException;

    void zza(PlacesParams placesParams, PendingIntent pendingIntent, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException;

    void zzb(PlacesParams placesParams, PendingIntent pendingIntent, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException;
}
