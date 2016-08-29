package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zzf implements Creator<AdOverlayInfoParcel> {
    static void zza(AdOverlayInfoParcel adOverlayInfoParcel, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, adOverlayInfoParcel.versionCode);
        zzb.zza(parcel, 2, adOverlayInfoParcel.zzAO, i, false);
        zzb.zza(parcel, 3, adOverlayInfoParcel.zzeE(), false);
        zzb.zza(parcel, 4, adOverlayInfoParcel.zzeF(), false);
        zzb.zza(parcel, 5, adOverlayInfoParcel.zzeG(), false);
        zzb.zza(parcel, 6, adOverlayInfoParcel.zzeH(), false);
        zzb.zza(parcel, 7, adOverlayInfoParcel.zzAT, false);
        zzb.zza(parcel, 8, adOverlayInfoParcel.zzAU);
        zzb.zza(parcel, 9, adOverlayInfoParcel.zzAV, false);
        zzb.zza(parcel, 10, adOverlayInfoParcel.zzeJ(), false);
        zzb.zzc(parcel, 11, adOverlayInfoParcel.orientation);
        zzb.zzc(parcel, 12, adOverlayInfoParcel.zzAX);
        zzb.zza(parcel, 13, adOverlayInfoParcel.url, false);
        zzb.zza(parcel, 14, adOverlayInfoParcel.zzqb, i, false);
        zzb.zza(parcel, 15, adOverlayInfoParcel.zzeI(), false);
        zzb.zza(parcel, 17, adOverlayInfoParcel.zzBa, i, false);
        zzb.zza(parcel, 16, adOverlayInfoParcel.zzAZ, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzh(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzw(x0);
    }

    public AdOverlayInfoParcel zzh(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        AdLauncherIntentInfoParcel adLauncherIntentInfoParcel = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i2 = 0;
        int i3 = 0;
        String str3 = null;
        VersionInfoParcel versionInfoParcel = null;
        IBinder iBinder6 = null;
        String str4 = null;
        InterstitialAdParameterParcel interstitialAdParameterParcel = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    adLauncherIntentInfoParcel = (AdLauncherIntentInfoParcel) zza.zza(parcel, zzai, AdLauncherIntentInfoParcel.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    iBinder2 = zza.zzp(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    iBinder3 = zza.zzp(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    iBinder4 = zza.zzp(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case Barcode.URL /*8*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                case Barcode.WIFI /*9*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.GEO /*10*/:
                    iBinder5 = zza.zzp(parcel, zzai);
                    break;
                case Barcode.CALENDAR_EVENT /*11*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.DRIVER_LICENSE /*12*/:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case Place.TYPE_BUS_STATION /*14*/:
                    versionInfoParcel = (VersionInfoParcel) zza.zza(parcel, zzai, VersionInfoParcel.CREATOR);
                    break;
                case Place.TYPE_CAFE /*15*/:
                    iBinder6 = zza.zzp(parcel, zzai);
                    break;
                case Barcode.DATA_MATRIX /*16*/:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case Place.TYPE_CAR_DEALER /*17*/:
                    interstitialAdParameterParcel = (InterstitialAdParameterParcel) zza.zza(parcel, zzai, InterstitialAdParameterParcel.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new AdOverlayInfoParcel(i, adLauncherIntentInfoParcel, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i2, i3, str3, versionInfoParcel, iBinder6, str4, interstitialAdParameterParcel);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public AdOverlayInfoParcel[] zzw(int i) {
        return new AdOverlayInfoParcel[i];
    }
}
