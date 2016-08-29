package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzq implements Creator<ParcelableCollaborator> {
    static void zza(ParcelableCollaborator parcelableCollaborator, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, parcelableCollaborator.mVersionCode);
        zzb.zza(parcel, 2, parcelableCollaborator.zzalX);
        zzb.zza(parcel, 3, parcelableCollaborator.zzalY);
        zzb.zza(parcel, 4, parcelableCollaborator.zzGY, false);
        zzb.zza(parcel, 5, parcelableCollaborator.zzGh, false);
        zzb.zza(parcel, 6, parcelableCollaborator.zzahh, false);
        zzb.zza(parcel, 7, parcelableCollaborator.zzalZ, false);
        zzb.zza(parcel, 8, parcelableCollaborator.zzama, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcg(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdV(x0);
    }

    public ParcelableCollaborator zzcg(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    z2 = zza.zzc(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    str5 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.URL /*8*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ParcelableCollaborator(i, z2, z, str5, str4, str3, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ParcelableCollaborator[] zzdV(int i) {
        return new ParcelableCollaborator[i];
    }
}
