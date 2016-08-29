package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.ArrayList;

public class zzl implements Creator<MaskedWalletRequest> {
    static void zza(MaskedWalletRequest maskedWalletRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, maskedWalletRequest.getVersionCode());
        zzb.zza(parcel, 2, maskedWalletRequest.zzaWj, false);
        zzb.zza(parcel, 3, maskedWalletRequest.zzaXe);
        zzb.zza(parcel, 4, maskedWalletRequest.zzaXf);
        zzb.zza(parcel, 5, maskedWalletRequest.zzaXg);
        zzb.zza(parcel, 6, maskedWalletRequest.zzaXh, false);
        zzb.zza(parcel, 7, maskedWalletRequest.zzaWc, false);
        zzb.zza(parcel, 8, maskedWalletRequest.zzaXi, false);
        zzb.zza(parcel, 9, maskedWalletRequest.zzaWt, i, false);
        zzb.zza(parcel, 10, maskedWalletRequest.zzaXj);
        zzb.zza(parcel, 11, maskedWalletRequest.zzaXk);
        zzb.zza(parcel, 12, maskedWalletRequest.zzaXl, i, false);
        zzb.zza(parcel, 13, maskedWalletRequest.zzaXm);
        zzb.zza(parcel, 14, maskedWalletRequest.zzaXn);
        zzb.zzc(parcel, 15, maskedWalletRequest.zzaXo, false);
        zzb.zza(parcel, 17, maskedWalletRequest.zzaXq, false);
        zzb.zza(parcel, 16, maskedWalletRequest.zzaXp, i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgP(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjU(x0);
    }

    public MaskedWalletRequest zzgP(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Cart cart = null;
        boolean z4 = false;
        boolean z5 = false;
        CountrySpecification[] countrySpecificationArr = null;
        boolean z6 = true;
        boolean z7 = true;
        ArrayList arrayList = null;
        PaymentMethodTokenizationParameters paymentMethodTokenizationParameters = null;
        ArrayList arrayList2 = null;
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
                    z = zza.zzc(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    z2 = zza.zzc(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    z3 = zza.zzc(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.URL /*8*/:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.WIFI /*9*/:
                    cart = (Cart) zza.zza(parcel, zzai, Cart.CREATOR);
                    break;
                case Barcode.GEO /*10*/:
                    z4 = zza.zzc(parcel, zzai);
                    break;
                case Barcode.CALENDAR_EVENT /*11*/:
                    z5 = zza.zzc(parcel, zzai);
                    break;
                case Barcode.DRIVER_LICENSE /*12*/:
                    countrySpecificationArr = (CountrySpecification[]) zza.zzb(parcel, zzai, CountrySpecification.CREATOR);
                    break;
                case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                    z6 = zza.zzc(parcel, zzai);
                    break;
                case Place.TYPE_BUS_STATION /*14*/:
                    z7 = zza.zzc(parcel, zzai);
                    break;
                case Place.TYPE_CAFE /*15*/:
                    arrayList = zza.zzc(parcel, zzai, CountrySpecification.CREATOR);
                    break;
                case Barcode.DATA_MATRIX /*16*/:
                    paymentMethodTokenizationParameters = (PaymentMethodTokenizationParameters) zza.zza(parcel, zzai, PaymentMethodTokenizationParameters.CREATOR);
                    break;
                case Place.TYPE_CAR_DEALER /*17*/:
                    arrayList2 = zza.zzB(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new MaskedWalletRequest(i, str, z, z2, z3, str2, str3, str4, cart, z4, z5, countrySpecificationArr, z6, z7, arrayList, paymentMethodTokenizationParameters, arrayList2);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public MaskedWalletRequest[] zzjU(int i) {
        return new MaskedWalletRequest[i];
    }
}
