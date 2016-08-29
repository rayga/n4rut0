package com.google.android.gms.location.places.internal;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.NearbyAlertRequest;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.PlaceRequest;
import com.google.android.gms.location.places.UserDataType;
import com.google.android.gms.location.places.personalized.PlaceAlias;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.List;

public interface zzf extends IInterface {

    public static abstract class zza extends Binder implements zzf {

        private static class zza implements zzf {
            private IBinder zznI;

            zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void zza(AddPlaceRequest addPlaceRequest, PlacesParams placesParams, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    if (addPlaceRequest != null) {
                        obtain.writeInt(1);
                        addPlaceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_location_places_internal_zzh != null) {
                        iBinder = com_google_android_gms_location_places_internal_zzh.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(14, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(NearbyAlertRequest nearbyAlertRequest, PlacesParams placesParams, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
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
                    this.zznI.transact(11, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(PlaceReport placeReport, PlacesParams placesParams) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
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
                    this.zznI.transact(15, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(PlaceRequest placeRequest, PlacesParams placesParams, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
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
                    this.zznI.transact(9, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(UserDataType userDataType, LatLngBounds latLngBounds, List<String> list, PlacesParams placesParams, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    if (userDataType != null) {
                        obtain.writeInt(1);
                        userDataType.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (latLngBounds != null) {
                        obtain.writeInt(1);
                        latLngBounds.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringList(list);
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_location_places_internal_zzh != null) {
                        iBinder = com_google_android_gms_location_places_internal_zzh.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(PlacesParams placesParams, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
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
                    this.zznI.transact(10, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(PlaceAlias placeAlias, String str, String str2, PlacesParams placesParams, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    if (placeAlias != null) {
                        obtain.writeInt(1);
                        placeAlias.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_location_places_internal_zzh != null) {
                        iBinder = com_google_android_gms_location_places_internal_zzh.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(16, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(LatLng latLng, PlaceFilter placeFilter, PlacesParams placesParams, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    if (latLng != null) {
                        obtain.writeInt(1);
                        latLng.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
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
                    if (com_google_android_gms_location_places_internal_zzh != null) {
                        iBinder = com_google_android_gms_location_places_internal_zzh.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(LatLngBounds latLngBounds, int i, String str, PlaceFilter placeFilter, PlacesParams placesParams, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    if (latLngBounds != null) {
                        obtain.writeInt(1);
                        latLngBounds.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeString(str);
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
                    if (com_google_android_gms_location_places_internal_zzh != null) {
                        iBinder = com_google_android_gms_location_places_internal_zzh.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, int i2, int i3, PlacesParams placesParams, zzg com_google_android_gms_location_places_internal_zzg) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_location_places_internal_zzg != null) {
                        iBinder = com_google_android_gms_location_places_internal_zzg.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(20, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, PlacesParams placesParams, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_location_places_internal_zzh != null) {
                        iBinder = com_google_android_gms_location_places_internal_zzh.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(18, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(String str, PlacesParams placesParams, zzg com_google_android_gms_location_places_internal_zzg) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    obtain.writeString(str);
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_location_places_internal_zzg != null) {
                        iBinder = com_google_android_gms_location_places_internal_zzg.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(19, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(String str, PlacesParams placesParams, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    obtain.writeString(str);
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_location_places_internal_zzh != null) {
                        iBinder = com_google_android_gms_location_places_internal_zzh.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter, PlacesParams placesParams, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    obtain.writeString(str);
                    if (latLngBounds != null) {
                        obtain.writeInt(1);
                        latLngBounds.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (autocompleteFilter != null) {
                        obtain.writeInt(1);
                        autocompleteFilter.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_location_places_internal_zzh != null) {
                        iBinder = com_google_android_gms_location_places_internal_zzh.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(13, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(List<String> list, PlacesParams placesParams, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    obtain.writeStringList(list);
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_location_places_internal_zzh != null) {
                        iBinder = com_google_android_gms_location_places_internal_zzh.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzb(PlaceFilter placeFilter, PlacesParams placesParams, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
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
                    if (com_google_android_gms_location_places_internal_zzh != null) {
                        iBinder = com_google_android_gms_location_places_internal_zzh.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzb(PlacesParams placesParams, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
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
                    this.zznI.transact(12, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzb(String str, PlacesParams placesParams, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    obtain.writeString(str);
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_location_places_internal_zzh != null) {
                        iBinder = com_google_android_gms_location_places_internal_zzh.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzb(List<String> list, PlacesParams placesParams, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    obtain.writeStringList(list);
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_location_places_internal_zzh != null) {
                        iBinder = com_google_android_gms_location_places_internal_zzh.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(17, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzf zzce(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzf)) ? new zza(iBinder) : (zzf) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            PlacesParams placesParams = null;
            int readInt;
            String readString;
            List createStringArrayList;
            switch (code) {
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    LatLngBounds zzeZ = data.readInt() != 0 ? LatLngBounds.CREATOR.zzeZ(data) : null;
                    readInt = data.readInt();
                    String readString2 = data.readString();
                    PlaceFilter zzeD = data.readInt() != 0 ? PlaceFilter.CREATOR.zzeD(data) : null;
                    if (data.readInt() != 0) {
                        placesParams = PlacesParams.CREATOR.zzeN(data);
                    }
                    zza(zzeZ, readInt, readString2, zzeD, placesParams, com.google.android.gms.location.places.internal.zzh.zza.zzcg(data.readStrongBinder()));
                    return true;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        placesParams = PlacesParams.CREATOR.zzeN(data);
                    }
                    zza(readString, placesParams, com.google.android.gms.location.places.internal.zzh.zza.zzcg(data.readStrongBinder()));
                    return true;
                case Barcode.PHONE /*4*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    LatLng zzfa = data.readInt() != 0 ? LatLng.CREATOR.zzfa(data) : null;
                    PlaceFilter zzeD2 = data.readInt() != 0 ? PlaceFilter.CREATOR.zzeD(data) : null;
                    if (data.readInt() != 0) {
                        placesParams = PlacesParams.CREATOR.zzeN(data);
                    }
                    zza(zzfa, zzeD2, placesParams, com.google.android.gms.location.places.internal.zzh.zza.zzcg(data.readStrongBinder()));
                    return true;
                case Barcode.PRODUCT /*5*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    PlaceFilter zzeD3 = data.readInt() != 0 ? PlaceFilter.CREATOR.zzeD(data) : null;
                    if (data.readInt() != 0) {
                        placesParams = PlacesParams.CREATOR.zzeN(data);
                    }
                    zzb(zzeD3, placesParams, com.google.android.gms.location.places.internal.zzh.zza.zzcg(data.readStrongBinder()));
                    return true;
                case Barcode.SMS /*6*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        placesParams = PlacesParams.CREATOR.zzeN(data);
                    }
                    zzb(readString, placesParams, com.google.android.gms.location.places.internal.zzh.zza.zzcg(data.readStrongBinder()));
                    return true;
                case Barcode.TEXT /*7*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    createStringArrayList = data.createStringArrayList();
                    if (data.readInt() != 0) {
                        placesParams = PlacesParams.CREATOR.zzeN(data);
                    }
                    zza(createStringArrayList, placesParams, com.google.android.gms.location.places.internal.zzh.zza.zzcg(data.readStrongBinder()));
                    return true;
                case Barcode.URL /*8*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    zza(data.readInt() != 0 ? UserDataType.CREATOR.zzeI(data) : null, data.readInt() != 0 ? LatLngBounds.CREATOR.zzeZ(data) : null, data.createStringArrayList(), data.readInt() != 0 ? PlacesParams.CREATOR.zzeN(data) : null, com.google.android.gms.location.places.internal.zzh.zza.zzcg(data.readStrongBinder()));
                    return true;
                case Barcode.WIFI /*9*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    zza(data.readInt() != 0 ? (PlaceRequest) PlaceRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? PlacesParams.CREATOR.zzeN(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    return true;
                case Barcode.GEO /*10*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    zza(data.readInt() != 0 ? PlacesParams.CREATOR.zzeN(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    return true;
                case Barcode.CALENDAR_EVENT /*11*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    zza(data.readInt() != 0 ? NearbyAlertRequest.CREATOR.zzeC(data) : null, data.readInt() != 0 ? PlacesParams.CREATOR.zzeN(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    return true;
                case Barcode.DRIVER_LICENSE /*12*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    zzb(data.readInt() != 0 ? PlacesParams.CREATOR.zzeN(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    return true;
                case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    zza(data.readString(), data.readInt() != 0 ? LatLngBounds.CREATOR.zzeZ(data) : null, data.readInt() != 0 ? AutocompleteFilter.CREATOR.zzeA(data) : null, data.readInt() != 0 ? PlacesParams.CREATOR.zzeN(data) : null, com.google.android.gms.location.places.internal.zzh.zza.zzcg(data.readStrongBinder()));
                    return true;
                case Place.TYPE_BUS_STATION /*14*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    AddPlaceRequest addPlaceRequest = data.readInt() != 0 ? (AddPlaceRequest) AddPlaceRequest.CREATOR.createFromParcel(data) : null;
                    if (data.readInt() != 0) {
                        placesParams = PlacesParams.CREATOR.zzeN(data);
                    }
                    zza(addPlaceRequest, placesParams, com.google.android.gms.location.places.internal.zzh.zza.zzcg(data.readStrongBinder()));
                    return true;
                case Place.TYPE_CAFE /*15*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    PlaceReport placeReport = data.readInt() != 0 ? (PlaceReport) PlaceReport.CREATOR.createFromParcel(data) : null;
                    if (data.readInt() != 0) {
                        placesParams = PlacesParams.CREATOR.zzeN(data);
                    }
                    zza(placeReport, placesParams);
                    return true;
                case Barcode.DATA_MATRIX /*16*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    zza(data.readInt() != 0 ? PlaceAlias.CREATOR.zzeR(data) : null, data.readString(), data.readString(), data.readInt() != 0 ? PlacesParams.CREATOR.zzeN(data) : null, com.google.android.gms.location.places.internal.zzh.zza.zzcg(data.readStrongBinder()));
                    return true;
                case Place.TYPE_CAR_DEALER /*17*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    createStringArrayList = data.createStringArrayList();
                    if (data.readInt() != 0) {
                        placesParams = PlacesParams.CREATOR.zzeN(data);
                    }
                    zzb(createStringArrayList, placesParams, com.google.android.gms.location.places.internal.zzh.zza.zzcg(data.readStrongBinder()));
                    return true;
                case Place.TYPE_CAR_RENTAL /*18*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    readString = data.readString();
                    int readInt2 = data.readInt();
                    if (data.readInt() != 0) {
                        placesParams = PlacesParams.CREATOR.zzeN(data);
                    }
                    zza(readString, readInt2, placesParams, com.google.android.gms.location.places.internal.zzh.zza.zzcg(data.readStrongBinder()));
                    return true;
                case Place.TYPE_CAR_REPAIR /*19*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        placesParams = PlacesParams.CREATOR.zzeN(data);
                    }
                    zza(readString, placesParams, com.google.android.gms.location.places.internal.zzg.zza.zzcf(data.readStrongBinder()));
                    return true;
                case Place.TYPE_CAR_WASH /*20*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    String readString3 = data.readString();
                    readInt = data.readInt();
                    int readInt3 = data.readInt();
                    int readInt4 = data.readInt();
                    if (data.readInt() != 0) {
                        placesParams = PlacesParams.CREATOR.zzeN(data);
                    }
                    zza(readString3, readInt, readInt3, readInt4, placesParams, com.google.android.gms.location.places.internal.zzg.zza.zzcf(data.readStrongBinder()));
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(AddPlaceRequest addPlaceRequest, PlacesParams placesParams, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException;

    void zza(NearbyAlertRequest nearbyAlertRequest, PlacesParams placesParams, PendingIntent pendingIntent) throws RemoteException;

    void zza(PlaceReport placeReport, PlacesParams placesParams) throws RemoteException;

    void zza(PlaceRequest placeRequest, PlacesParams placesParams, PendingIntent pendingIntent) throws RemoteException;

    void zza(UserDataType userDataType, LatLngBounds latLngBounds, List<String> list, PlacesParams placesParams, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException;

    void zza(PlacesParams placesParams, PendingIntent pendingIntent) throws RemoteException;

    void zza(PlaceAlias placeAlias, String str, String str2, PlacesParams placesParams, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException;

    void zza(LatLng latLng, PlaceFilter placeFilter, PlacesParams placesParams, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException;

    void zza(LatLngBounds latLngBounds, int i, String str, PlaceFilter placeFilter, PlacesParams placesParams, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException;

    void zza(String str, int i, int i2, int i3, PlacesParams placesParams, zzg com_google_android_gms_location_places_internal_zzg) throws RemoteException;

    void zza(String str, int i, PlacesParams placesParams, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException;

    void zza(String str, PlacesParams placesParams, zzg com_google_android_gms_location_places_internal_zzg) throws RemoteException;

    void zza(String str, PlacesParams placesParams, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException;

    void zza(String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter, PlacesParams placesParams, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException;

    void zza(List<String> list, PlacesParams placesParams, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException;

    void zzb(PlaceFilter placeFilter, PlacesParams placesParams, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException;

    void zzb(PlacesParams placesParams, PendingIntent pendingIntent) throws RemoteException;

    void zzb(String str, PlacesParams placesParams, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException;

    void zzb(List<String> list, PlacesParams placesParams, zzh com_google_android_gms_location_places_internal_zzh) throws RemoteException;
}
