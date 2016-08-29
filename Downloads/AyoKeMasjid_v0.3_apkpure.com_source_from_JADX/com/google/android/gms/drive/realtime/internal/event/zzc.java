package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.List;

public class zzc implements Creator<ParcelableEvent> {
    static void zza(ParcelableEvent parcelableEvent, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, parcelableEvent.mVersionCode);
        zzb.zza(parcel, 2, parcelableEvent.zzGY, false);
        zzb.zza(parcel, 3, parcelableEvent.zzGh, false);
        zzb.zzb(parcel, 4, parcelableEvent.zzamh, false);
        zzb.zza(parcel, 5, parcelableEvent.zzami);
        zzb.zza(parcel, 6, parcelableEvent.zzamb, false);
        zzb.zza(parcel, 7, parcelableEvent.zzaml, false);
        zzb.zza(parcel, 8, parcelableEvent.zzamm, i, false);
        zzb.zza(parcel, 9, parcelableEvent.zzamn, i, false);
        zzb.zza(parcel, 10, parcelableEvent.zzamo, i, false);
        zzb.zza(parcel, 11, parcelableEvent.zzamp, i, false);
        zzb.zza(parcel, 12, parcelableEvent.zzamq, i, false);
        zzb.zza(parcel, 13, parcelableEvent.zzamr, i, false);
        zzb.zza(parcel, 14, parcelableEvent.zzams, i, false);
        zzb.zza(parcel, 15, parcelableEvent.zzamt, i, false);
        zzb.zza(parcel, 17, parcelableEvent.zzamk);
        zzb.zza(parcel, 16, parcelableEvent.zzamj);
        zzb.zza(parcel, 18, parcelableEvent.zzamu, i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzck(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdZ(x0);
    }

    public ParcelableEvent zzck(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        List list = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String str3 = null;
        String str4 = null;
        TextInsertedDetails textInsertedDetails = null;
        TextDeletedDetails textDeletedDetails = null;
        ValuesAddedDetails valuesAddedDetails = null;
        ValuesRemovedDetails valuesRemovedDetails = null;
        ValuesSetDetails valuesSetDetails = null;
        ValueChangedDetails valueChangedDetails = null;
        ReferenceShiftedDetails referenceShiftedDetails = null;
        ObjectChangedDetails objectChangedDetails = null;
        FieldChangedDetails fieldChangedDetails = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    list = zza.zzC(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.URL /*8*/:
                    textInsertedDetails = (TextInsertedDetails) zza.zza(parcel, zzai, TextInsertedDetails.CREATOR);
                    break;
                case Barcode.WIFI /*9*/:
                    textDeletedDetails = (TextDeletedDetails) zza.zza(parcel, zzai, TextDeletedDetails.CREATOR);
                    break;
                case Barcode.GEO /*10*/:
                    valuesAddedDetails = (ValuesAddedDetails) zza.zza(parcel, zzai, ValuesAddedDetails.CREATOR);
                    break;
                case Barcode.CALENDAR_EVENT /*11*/:
                    valuesRemovedDetails = (ValuesRemovedDetails) zza.zza(parcel, zzai, ValuesRemovedDetails.CREATOR);
                    break;
                case Barcode.DRIVER_LICENSE /*12*/:
                    valuesSetDetails = (ValuesSetDetails) zza.zza(parcel, zzai, ValuesSetDetails.CREATOR);
                    break;
                case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                    valueChangedDetails = (ValueChangedDetails) zza.zza(parcel, zzai, ValueChangedDetails.CREATOR);
                    break;
                case Place.TYPE_BUS_STATION /*14*/:
                    referenceShiftedDetails = (ReferenceShiftedDetails) zza.zza(parcel, zzai, ReferenceShiftedDetails.CREATOR);
                    break;
                case Place.TYPE_CAFE /*15*/:
                    objectChangedDetails = (ObjectChangedDetails) zza.zza(parcel, zzai, ObjectChangedDetails.CREATOR);
                    break;
                case Barcode.DATA_MATRIX /*16*/:
                    z2 = zza.zzc(parcel, zzai);
                    break;
                case Place.TYPE_CAR_DEALER /*17*/:
                    z3 = zza.zzc(parcel, zzai);
                    break;
                case Place.TYPE_CAR_RENTAL /*18*/:
                    fieldChangedDetails = (FieldChangedDetails) zza.zza(parcel, zzai, FieldChangedDetails.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ParcelableEvent(i, str, str2, list, z, z2, z3, str3, str4, textInsertedDetails, textDeletedDetails, valuesAddedDetails, valuesRemovedDetails, valuesSetDetails, valueChangedDetails, referenceShiftedDetails, objectChangedDetails, fieldChangedDetails);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ParcelableEvent[] zzdZ(int i) {
        return new ParcelableEvent[i];
    }
}
