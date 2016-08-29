package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.internal.zzli;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.wallet.wobs.LabelValueRow;
import com.google.android.gms.wallet.wobs.LoyaltyPoints;
import com.google.android.gms.wallet.wobs.TextModuleData;
import com.google.android.gms.wallet.wobs.TimeInterval;
import com.google.android.gms.wallet.wobs.UriData;
import com.google.android.gms.wallet.wobs.WalletObjectMessage;
import java.util.ArrayList;

public class zzj implements Creator<LoyaltyWalletObject> {
    static void zza(LoyaltyWalletObject loyaltyWalletObject, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, loyaltyWalletObject.getVersionCode());
        zzb.zza(parcel, 2, loyaltyWalletObject.zzhL, false);
        zzb.zza(parcel, 3, loyaltyWalletObject.zzaWI, false);
        zzb.zza(parcel, 4, loyaltyWalletObject.zzaWJ, false);
        zzb.zza(parcel, 5, loyaltyWalletObject.zzaWK, false);
        zzb.zza(parcel, 6, loyaltyWalletObject.zzaFb, false);
        zzb.zza(parcel, 7, loyaltyWalletObject.zzaWL, false);
        zzb.zza(parcel, 8, loyaltyWalletObject.zzaWM, false);
        zzb.zza(parcel, 9, loyaltyWalletObject.zzaWN, false);
        zzb.zza(parcel, 10, loyaltyWalletObject.zzaWO, false);
        zzb.zza(parcel, 11, loyaltyWalletObject.zzaWP, false);
        zzb.zzc(parcel, 12, loyaltyWalletObject.state);
        zzb.zzc(parcel, 13, loyaltyWalletObject.zzaWQ, false);
        zzb.zza(parcel, 14, loyaltyWalletObject.zzaWR, i, false);
        zzb.zzc(parcel, 15, loyaltyWalletObject.zzaWS, false);
        zzb.zza(parcel, 17, loyaltyWalletObject.zzaWU, false);
        zzb.zza(parcel, 16, loyaltyWalletObject.zzaWT, false);
        zzb.zza(parcel, 19, loyaltyWalletObject.zzaWW);
        zzb.zzc(parcel, 18, loyaltyWalletObject.zzaWV, false);
        zzb.zzc(parcel, 21, loyaltyWalletObject.zzaWY, false);
        zzb.zzc(parcel, 20, loyaltyWalletObject.zzaWX, false);
        zzb.zza(parcel, 23, loyaltyWalletObject.zzaXa, i, false);
        zzb.zzc(parcel, 22, loyaltyWalletObject.zzaWZ, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgN(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjS(x0);
    }

    public LoyaltyWalletObject zzgN(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        int i2 = 0;
        ArrayList zzpM = zzli.zzpM();
        TimeInterval timeInterval = null;
        ArrayList zzpM2 = zzli.zzpM();
        String str11 = null;
        String str12 = null;
        ArrayList zzpM3 = zzli.zzpM();
        boolean z = false;
        ArrayList zzpM4 = zzli.zzpM();
        ArrayList zzpM5 = zzli.zzpM();
        ArrayList zzpM6 = zzli.zzpM();
        LoyaltyPoints loyaltyPoints = null;
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
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    str5 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    str6 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.URL /*8*/:
                    str7 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.WIFI /*9*/:
                    str8 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.GEO /*10*/:
                    str9 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.CALENDAR_EVENT /*11*/:
                    str10 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.DRIVER_LICENSE /*12*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                    zzpM = zza.zzc(parcel, zzai, WalletObjectMessage.CREATOR);
                    break;
                case Place.TYPE_BUS_STATION /*14*/:
                    timeInterval = (TimeInterval) zza.zza(parcel, zzai, TimeInterval.CREATOR);
                    break;
                case Place.TYPE_CAFE /*15*/:
                    zzpM2 = zza.zzc(parcel, zzai, LatLng.CREATOR);
                    break;
                case Barcode.DATA_MATRIX /*16*/:
                    str11 = zza.zzo(parcel, zzai);
                    break;
                case Place.TYPE_CAR_DEALER /*17*/:
                    str12 = zza.zzo(parcel, zzai);
                    break;
                case Place.TYPE_CAR_RENTAL /*18*/:
                    zzpM3 = zza.zzc(parcel, zzai, LabelValueRow.CREATOR);
                    break;
                case Place.TYPE_CAR_REPAIR /*19*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                case Place.TYPE_CAR_WASH /*20*/:
                    zzpM4 = zza.zzc(parcel, zzai, UriData.CREATOR);
                    break;
                case Place.TYPE_CASINO /*21*/:
                    zzpM5 = zza.zzc(parcel, zzai, TextModuleData.CREATOR);
                    break;
                case Place.TYPE_CEMETERY /*22*/:
                    zzpM6 = zza.zzc(parcel, zzai, UriData.CREATOR);
                    break;
                case Place.TYPE_CHURCH /*23*/:
                    loyaltyPoints = (LoyaltyPoints) zza.zza(parcel, zzai, LoyaltyPoints.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new LoyaltyWalletObject(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, i2, zzpM, timeInterval, zzpM2, str11, str12, zzpM3, z, zzpM4, zzpM5, zzpM6, loyaltyPoints);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public LoyaltyWalletObject[] zzjS(int i) {
        return new LoyaltyWalletObject[i];
    }
}
