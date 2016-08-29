package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zza implements Creator<FaceParcel> {
    static void zza(FaceParcel faceParcel, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, faceParcel.versionCode);
        zzb.zzc(parcel, 2, faceParcel.id);
        zzb.zza(parcel, 3, faceParcel.centerX);
        zzb.zza(parcel, 4, faceParcel.centerY);
        zzb.zza(parcel, 5, faceParcel.width);
        zzb.zza(parcel, 6, faceParcel.height);
        zzb.zza(parcel, 7, faceParcel.zzaVK);
        zzb.zza(parcel, 8, faceParcel.zzaVL);
        zzb.zza(parcel, 9, faceParcel.zzaVM, i, false);
        zzb.zza(parcel, 10, faceParcel.zzaVN);
        zzb.zza(parcel, 11, faceParcel.zzaVO);
        zzb.zza(parcel, 12, faceParcel.zzaVP);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgA(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjE(x0);
    }

    public FaceParcel zzgA(Parcel parcel) {
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        int i2 = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        LandmarkParcel[] landmarkParcelArr = null;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    f = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    f2 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    f3 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    f4 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    f5 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzai);
                    break;
                case Barcode.URL /*8*/:
                    f6 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzai);
                    break;
                case Barcode.WIFI /*9*/:
                    landmarkParcelArr = (LandmarkParcel[]) com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai, LandmarkParcel.CREATOR);
                    break;
                case Barcode.GEO /*10*/:
                    f7 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzai);
                    break;
                case Barcode.CALENDAR_EVENT /*11*/:
                    f8 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzai);
                    break;
                case Barcode.DRIVER_LICENSE /*12*/:
                    f9 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzai);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new FaceParcel(i, i2, f, f2, f3, f4, f5, f6, landmarkParcelArr, f7, f8, f9);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public FaceParcel[] zzjE(int i) {
        return new FaceParcel[i];
    }
}
