package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzb implements Creator<FaceSettingsParcel> {
    static void zza(FaceSettingsParcel faceSettingsParcel, Parcel parcel, int i) {
        int zzak = com.google.android.gms.common.internal.safeparcel.zzb.zzak(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, faceSettingsParcel.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, faceSettingsParcel.mode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, faceSettingsParcel.zzaVQ);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, faceSettingsParcel.zzaVR);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, faceSettingsParcel.zzaVS);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, faceSettingsParcel.zzaVT);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgB(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjF(x0);
    }

    public FaceSettingsParcel zzgB(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i4 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    z2 = zza.zzc(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new FaceSettingsParcel(i4, i3, i2, i, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public FaceSettingsParcel[] zzjF(int i) {
        return new FaceSettingsParcel[i];
    }
}
