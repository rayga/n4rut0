package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzd implements Creator<CreateWalletObjectsRequest> {
    static void zza(CreateWalletObjectsRequest createWalletObjectsRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, createWalletObjectsRequest.getVersionCode());
        zzb.zza(parcel, 2, createWalletObjectsRequest.zzaWf, i, false);
        zzb.zza(parcel, 3, createWalletObjectsRequest.zzaWg, i, false);
        zzb.zza(parcel, 4, createWalletObjectsRequest.zzaWh, i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgH(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjM(x0);
    }

    public CreateWalletObjectsRequest zzgH(Parcel parcel) {
        GiftCardWalletObject giftCardWalletObject = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        OfferWalletObject offerWalletObject = null;
        LoyaltyWalletObject loyaltyWalletObject = null;
        while (parcel.dataPosition() < zzaj) {
            OfferWalletObject offerWalletObject2;
            LoyaltyWalletObject loyaltyWalletObject2;
            int zzg;
            GiftCardWalletObject giftCardWalletObject2;
            int zzai = zza.zzai(parcel);
            GiftCardWalletObject giftCardWalletObject3;
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    giftCardWalletObject3 = giftCardWalletObject;
                    offerWalletObject2 = offerWalletObject;
                    loyaltyWalletObject2 = loyaltyWalletObject;
                    zzg = zza.zzg(parcel, zzai);
                    giftCardWalletObject2 = giftCardWalletObject3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    zzg = i;
                    OfferWalletObject offerWalletObject3 = offerWalletObject;
                    loyaltyWalletObject2 = (LoyaltyWalletObject) zza.zza(parcel, zzai, LoyaltyWalletObject.CREATOR);
                    giftCardWalletObject2 = giftCardWalletObject;
                    offerWalletObject2 = offerWalletObject3;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    loyaltyWalletObject2 = loyaltyWalletObject;
                    zzg = i;
                    giftCardWalletObject3 = giftCardWalletObject;
                    offerWalletObject2 = (OfferWalletObject) zza.zza(parcel, zzai, OfferWalletObject.CREATOR);
                    giftCardWalletObject2 = giftCardWalletObject3;
                    break;
                case Barcode.PHONE /*4*/:
                    giftCardWalletObject2 = (GiftCardWalletObject) zza.zza(parcel, zzai, GiftCardWalletObject.CREATOR);
                    offerWalletObject2 = offerWalletObject;
                    loyaltyWalletObject2 = loyaltyWalletObject;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    giftCardWalletObject2 = giftCardWalletObject;
                    offerWalletObject2 = offerWalletObject;
                    loyaltyWalletObject2 = loyaltyWalletObject;
                    zzg = i;
                    break;
            }
            i = zzg;
            loyaltyWalletObject = loyaltyWalletObject2;
            offerWalletObject = offerWalletObject2;
            giftCardWalletObject = giftCardWalletObject2;
        }
        if (parcel.dataPosition() == zzaj) {
            return new CreateWalletObjectsRequest(i, loyaltyWalletObject, offerWalletObject, giftCardWalletObject);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public CreateWalletObjectsRequest[] zzjM(int i) {
        return new CreateWalletObjectsRequest[i];
    }
}
