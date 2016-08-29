package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.vision.barcode.Barcode;

public class zzk implements Creator<MaskedWallet> {
    static void zza(MaskedWallet maskedWallet, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, maskedWallet.getVersionCode());
        zzb.zza(parcel, 2, maskedWallet.zzaWi, false);
        zzb.zza(parcel, 3, maskedWallet.zzaWj, false);
        zzb.zza(parcel, 4, maskedWallet.zzaWo, false);
        zzb.zza(parcel, 5, maskedWallet.zzaWl, false);
        zzb.zza(parcel, 6, maskedWallet.zzaWm, i, false);
        zzb.zza(parcel, 7, maskedWallet.zzaWn, i, false);
        zzb.zza(parcel, 8, maskedWallet.zzaXb, i, false);
        zzb.zza(parcel, 9, maskedWallet.zzaXc, i, false);
        zzb.zza(parcel, 10, maskedWallet.zzaWp, i, false);
        zzb.zza(parcel, 11, maskedWallet.zzaWq, i, false);
        zzb.zza(parcel, 12, maskedWallet.zzaWr, i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgO(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjT(x0);
    }

    public MaskedWallet zzgO(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String[] strArr = null;
        String str3 = null;
        Address address = null;
        Address address2 = null;
        LoyaltyWalletObject[] loyaltyWalletObjectArr = null;
        OfferWalletObject[] offerWalletObjectArr = null;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        InstrumentInfo[] instrumentInfoArr = null;
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
                    strArr = zza.zzA(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    address = (Address) zza.zza(parcel, zzai, Address.CREATOR);
                    break;
                case Barcode.TEXT /*7*/:
                    address2 = (Address) zza.zza(parcel, zzai, Address.CREATOR);
                    break;
                case Barcode.URL /*8*/:
                    loyaltyWalletObjectArr = (LoyaltyWalletObject[]) zza.zzb(parcel, zzai, LoyaltyWalletObject.CREATOR);
                    break;
                case Barcode.WIFI /*9*/:
                    offerWalletObjectArr = (OfferWalletObject[]) zza.zzb(parcel, zzai, OfferWalletObject.CREATOR);
                    break;
                case Barcode.GEO /*10*/:
                    userAddress = (UserAddress) zza.zza(parcel, zzai, UserAddress.CREATOR);
                    break;
                case Barcode.CALENDAR_EVENT /*11*/:
                    userAddress2 = (UserAddress) zza.zza(parcel, zzai, UserAddress.CREATOR);
                    break;
                case Barcode.DRIVER_LICENSE /*12*/:
                    instrumentInfoArr = (InstrumentInfo[]) zza.zzb(parcel, zzai, InstrumentInfo.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new MaskedWallet(i, str, str2, strArr, str3, address, address2, loyaltyWalletObjectArr, offerWalletObjectArr, userAddress, userAddress2, instrumentInfoArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public MaskedWallet[] zzjT(int i) {
        return new MaskedWallet[i];
    }
}
