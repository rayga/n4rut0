package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class zza implements Creator<ItemScopeEntity> {
    static void zza(ItemScopeEntity itemScopeEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        Set set = itemScopeEntity.zzaLT;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, itemScopeEntity.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, itemScopeEntity.zzaLU, i, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zzb(parcel, 3, itemScopeEntity.zzaLV, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, itemScopeEntity.zzaLW, i, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, itemScopeEntity.zzaLX, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zza(parcel, 6, itemScopeEntity.zzaLY, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzb.zza(parcel, 7, itemScopeEntity.zzaLZ, true);
        }
        if (set.contains(Integer.valueOf(8))) {
            zzb.zzc(parcel, 8, itemScopeEntity.zzaMa, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            zzb.zzc(parcel, 9, itemScopeEntity.zzaMb);
        }
        if (set.contains(Integer.valueOf(10))) {
            zzb.zzc(parcel, 10, itemScopeEntity.zzaMc, true);
        }
        if (set.contains(Integer.valueOf(11))) {
            zzb.zza(parcel, 11, itemScopeEntity.zzaMd, i, true);
        }
        if (set.contains(Integer.valueOf(12))) {
            zzb.zzc(parcel, 12, itemScopeEntity.zzaMe, true);
        }
        if (set.contains(Integer.valueOf(13))) {
            zzb.zza(parcel, 13, itemScopeEntity.zzaMf, true);
        }
        if (set.contains(Integer.valueOf(14))) {
            zzb.zza(parcel, 14, itemScopeEntity.zzaMg, true);
        }
        if (set.contains(Integer.valueOf(15))) {
            zzb.zza(parcel, 15, itemScopeEntity.zzaMh, i, true);
        }
        if (set.contains(Integer.valueOf(17))) {
            zzb.zza(parcel, 17, itemScopeEntity.zzaMj, true);
        }
        if (set.contains(Integer.valueOf(16))) {
            zzb.zza(parcel, 16, itemScopeEntity.zzaMi, true);
        }
        if (set.contains(Integer.valueOf(19))) {
            zzb.zzc(parcel, 19, itemScopeEntity.zzaMk, true);
        }
        if (set.contains(Integer.valueOf(18))) {
            zzb.zza(parcel, 18, itemScopeEntity.zzsV, true);
        }
        if (set.contains(Integer.valueOf(21))) {
            zzb.zza(parcel, 21, itemScopeEntity.zzaMm, true);
        }
        if (set.contains(Integer.valueOf(20))) {
            zzb.zza(parcel, 20, itemScopeEntity.zzaMl, true);
        }
        if (set.contains(Integer.valueOf(23))) {
            zzb.zza(parcel, 23, itemScopeEntity.zzaoB, true);
        }
        if (set.contains(Integer.valueOf(22))) {
            zzb.zza(parcel, 22, itemScopeEntity.zzaMn, true);
        }
        if (set.contains(Integer.valueOf(25))) {
            zzb.zza(parcel, 25, itemScopeEntity.zzaMp, true);
        }
        if (set.contains(Integer.valueOf(24))) {
            zzb.zza(parcel, 24, itemScopeEntity.zzaMo, true);
        }
        if (set.contains(Integer.valueOf(27))) {
            zzb.zza(parcel, 27, itemScopeEntity.zzaMr, true);
        }
        if (set.contains(Integer.valueOf(26))) {
            zzb.zza(parcel, 26, itemScopeEntity.zzaMq, true);
        }
        if (set.contains(Integer.valueOf(29))) {
            zzb.zza(parcel, 29, itemScopeEntity.zzaMt, i, true);
        }
        if (set.contains(Integer.valueOf(28))) {
            zzb.zza(parcel, 28, itemScopeEntity.zzaMs, true);
        }
        if (set.contains(Integer.valueOf(31))) {
            zzb.zza(parcel, 31, itemScopeEntity.zzaMv, true);
        }
        if (set.contains(Integer.valueOf(30))) {
            zzb.zza(parcel, 30, itemScopeEntity.zzaMu, true);
        }
        if (set.contains(Integer.valueOf(34))) {
            zzb.zza(parcel, 34, itemScopeEntity.zzaMx, i, true);
        }
        if (set.contains(Integer.valueOf(32))) {
            zzb.zza(parcel, 32, itemScopeEntity.zzwj, true);
        }
        if (set.contains(Integer.valueOf(33))) {
            zzb.zza(parcel, 33, itemScopeEntity.zzaMw, true);
        }
        if (set.contains(Integer.valueOf(38))) {
            zzb.zza(parcel, 38, itemScopeEntity.zzaBE);
        }
        if (set.contains(Integer.valueOf(39))) {
            zzb.zza(parcel, 39, itemScopeEntity.mName, true);
        }
        if (set.contains(Integer.valueOf(36))) {
            zzb.zza(parcel, 36, itemScopeEntity.zzaBD);
        }
        if (set.contains(Integer.valueOf(37))) {
            zzb.zza(parcel, 37, itemScopeEntity.zzaMy, i, true);
        }
        if (set.contains(Integer.valueOf(42))) {
            zzb.zza(parcel, 42, itemScopeEntity.zzaMB, true);
        }
        if (set.contains(Integer.valueOf(43))) {
            zzb.zza(parcel, 43, itemScopeEntity.zzaMC, true);
        }
        if (set.contains(Integer.valueOf(40))) {
            zzb.zza(parcel, 40, itemScopeEntity.zzaMz, i, true);
        }
        if (set.contains(Integer.valueOf(41))) {
            zzb.zzc(parcel, 41, itemScopeEntity.zzaMA, true);
        }
        if (set.contains(Integer.valueOf(46))) {
            zzb.zza(parcel, 46, itemScopeEntity.zzaMF, i, true);
        }
        if (set.contains(Integer.valueOf(47))) {
            zzb.zza(parcel, 47, itemScopeEntity.zzaMG, true);
        }
        if (set.contains(Integer.valueOf(44))) {
            zzb.zza(parcel, 44, itemScopeEntity.zzaMD, true);
        }
        if (set.contains(Integer.valueOf(45))) {
            zzb.zza(parcel, 45, itemScopeEntity.zzaME, true);
        }
        if (set.contains(Integer.valueOf(51))) {
            zzb.zza(parcel, 51, itemScopeEntity.zzaMK, true);
        }
        if (set.contains(Integer.valueOf(50))) {
            zzb.zza(parcel, 50, itemScopeEntity.zzaMJ, i, true);
        }
        if (set.contains(Integer.valueOf(49))) {
            zzb.zza(parcel, 49, itemScopeEntity.zzaMI, true);
        }
        if (set.contains(Integer.valueOf(48))) {
            zzb.zza(parcel, 48, itemScopeEntity.zzaMH, true);
        }
        if (set.contains(Integer.valueOf(55))) {
            zzb.zza(parcel, 55, itemScopeEntity.zzaMM, true);
        }
        if (set.contains(Integer.valueOf(54))) {
            zzb.zza(parcel, 54, itemScopeEntity.zzF, true);
        }
        if (set.contains(Integer.valueOf(53))) {
            zzb.zza(parcel, 53, itemScopeEntity.zzFz, true);
        }
        if (set.contains(Integer.valueOf(52))) {
            zzb.zza(parcel, 52, itemScopeEntity.zzaML, true);
        }
        if (set.contains(Integer.valueOf(56))) {
            zzb.zza(parcel, 56, itemScopeEntity.zzaMN, true);
        }
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfT(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zziI(x0);
    }

    public ItemScopeEntity zzfT(Parcel parcel) {
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        ItemScopeEntity itemScopeEntity = null;
        List list = null;
        ItemScopeEntity itemScopeEntity2 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        List list2 = null;
        int i2 = 0;
        List list3 = null;
        ItemScopeEntity itemScopeEntity3 = null;
        List list4 = null;
        String str4 = null;
        String str5 = null;
        ItemScopeEntity itemScopeEntity4 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        List list5 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        String str15 = null;
        String str16 = null;
        String str17 = null;
        ItemScopeEntity itemScopeEntity5 = null;
        String str18 = null;
        String str19 = null;
        String str20 = null;
        String str21 = null;
        ItemScopeEntity itemScopeEntity6 = null;
        double d = 0.0d;
        ItemScopeEntity itemScopeEntity7 = null;
        double d2 = 0.0d;
        String str22 = null;
        ItemScopeEntity itemScopeEntity8 = null;
        List list6 = null;
        String str23 = null;
        String str24 = null;
        String str25 = null;
        String str26 = null;
        ItemScopeEntity itemScopeEntity9 = null;
        String str27 = null;
        String str28 = null;
        String str29 = null;
        ItemScopeEntity itemScopeEntity10 = null;
        String str30 = null;
        String str31 = null;
        String str32 = null;
        String str33 = null;
        String str34 = null;
        String str35 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            ItemScopeEntity itemScopeEntity11;
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    itemScopeEntity11 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    itemScopeEntity = itemScopeEntity11;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    list = com.google.android.gms.common.internal.safeparcel.zza.zzC(parcel, zzai);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case Barcode.PHONE /*4*/:
                    itemScopeEntity11 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    itemScopeEntity2 = itemScopeEntity11;
                    break;
                case Barcode.PRODUCT /*5*/:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case Barcode.SMS /*6*/:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case Barcode.TEXT /*7*/:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case Barcode.URL /*8*/:
                    list2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case Barcode.WIFI /*9*/:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case Barcode.GEO /*10*/:
                    list3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(10));
                    break;
                case Barcode.CALENDAR_EVENT /*11*/:
                    itemScopeEntity11 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(11));
                    itemScopeEntity3 = itemScopeEntity11;
                    break;
                case Barcode.DRIVER_LICENSE /*12*/:
                    list4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(13));
                    break;
                case Place.TYPE_BUS_STATION /*14*/:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case Place.TYPE_CAFE /*15*/:
                    itemScopeEntity11 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(15));
                    itemScopeEntity4 = itemScopeEntity11;
                    break;
                case Barcode.DATA_MATRIX /*16*/:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(16));
                    break;
                case Place.TYPE_CAR_DEALER /*17*/:
                    str7 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(17));
                    break;
                case Place.TYPE_CAR_RENTAL /*18*/:
                    str8 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(18));
                    break;
                case Place.TYPE_CAR_REPAIR /*19*/:
                    list5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(19));
                    break;
                case Place.TYPE_CAR_WASH /*20*/:
                    str9 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(20));
                    break;
                case Place.TYPE_CASINO /*21*/:
                    str10 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(21));
                    break;
                case Place.TYPE_CEMETERY /*22*/:
                    str11 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(22));
                    break;
                case Place.TYPE_CHURCH /*23*/:
                    str12 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(23));
                    break;
                case Place.TYPE_CITY_HALL /*24*/:
                    str13 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(24));
                    break;
                case Place.TYPE_CLOTHING_STORE /*25*/:
                    str14 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(25));
                    break;
                case Place.TYPE_CONVENIENCE_STORE /*26*/:
                    str15 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(26));
                    break;
                case Place.TYPE_COURTHOUSE /*27*/:
                    str16 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(27));
                    break;
                case Place.TYPE_DENTIST /*28*/:
                    str17 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(28));
                    break;
                case Place.TYPE_DEPARTMENT_STORE /*29*/:
                    itemScopeEntity11 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(29));
                    itemScopeEntity5 = itemScopeEntity11;
                    break;
                case Place.TYPE_DOCTOR /*30*/:
                    str18 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(30));
                    break;
                case Place.TYPE_ELECTRICIAN /*31*/:
                    str19 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(31));
                    break;
                case Barcode.EAN_13 /*32*/:
                    str20 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(32));
                    break;
                case Place.TYPE_EMBASSY /*33*/:
                    str21 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(33));
                    break;
                case Place.TYPE_ESTABLISHMENT /*34*/:
                    itemScopeEntity11 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(34));
                    itemScopeEntity6 = itemScopeEntity11;
                    break;
                case Place.TYPE_FIRE_STATION /*36*/:
                    d = com.google.android.gms.common.internal.safeparcel.zza.zzm(parcel, zzai);
                    hashSet.add(Integer.valueOf(36));
                    break;
                case Place.TYPE_FLORIST /*37*/:
                    itemScopeEntity11 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(37));
                    itemScopeEntity7 = itemScopeEntity11;
                    break;
                case Place.TYPE_FOOD /*38*/:
                    d2 = com.google.android.gms.common.internal.safeparcel.zza.zzm(parcel, zzai);
                    hashSet.add(Integer.valueOf(38));
                    break;
                case Place.TYPE_FUNERAL_HOME /*39*/:
                    str22 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(39));
                    break;
                case Place.TYPE_FURNITURE_STORE /*40*/:
                    itemScopeEntity11 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(40));
                    itemScopeEntity8 = itemScopeEntity11;
                    break;
                case Place.TYPE_GAS_STATION /*41*/:
                    list6 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(41));
                    break;
                case Place.TYPE_GENERAL_CONTRACTOR /*42*/:
                    str23 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(42));
                    break;
                case Place.TYPE_GROCERY_OR_SUPERMARKET /*43*/:
                    str24 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(43));
                    break;
                case Place.TYPE_GYM /*44*/:
                    str25 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(44));
                    break;
                case Place.TYPE_HAIR_CARE /*45*/:
                    str26 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(45));
                    break;
                case Place.TYPE_HARDWARE_STORE /*46*/:
                    itemScopeEntity11 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(46));
                    itemScopeEntity9 = itemScopeEntity11;
                    break;
                case Place.TYPE_HEALTH /*47*/:
                    str27 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(47));
                    break;
                case Place.TYPE_HINDU_TEMPLE /*48*/:
                    str28 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(48));
                    break;
                case Place.TYPE_HOME_GOODS_STORE /*49*/:
                    str29 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(49));
                    break;
                case Place.TYPE_HOSPITAL /*50*/:
                    itemScopeEntity11 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(50));
                    itemScopeEntity10 = itemScopeEntity11;
                    break;
                case Place.TYPE_INSURANCE_AGENCY /*51*/:
                    str30 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(51));
                    break;
                case Place.TYPE_JEWELRY_STORE /*52*/:
                    str31 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(52));
                    break;
                case Place.TYPE_LAUNDRY /*53*/:
                    str32 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(53));
                    break;
                case Place.TYPE_LAWYER /*54*/:
                    str33 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(54));
                    break;
                case Place.TYPE_LIBRARY /*55*/:
                    str34 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(55));
                    break;
                case Place.TYPE_LIQUOR_STORE /*56*/:
                    str35 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(56));
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ItemScopeEntity(hashSet, i, itemScopeEntity, list, itemScopeEntity2, str, str2, str3, list2, i2, list3, itemScopeEntity3, list4, str4, str5, itemScopeEntity4, str6, str7, str8, list5, str9, str10, str11, str12, str13, str14, str15, str16, str17, itemScopeEntity5, str18, str19, str20, str21, itemScopeEntity6, d, itemScopeEntity7, d2, str22, itemScopeEntity8, list6, str23, str24, str25, str26, itemScopeEntity9, str27, str28, str29, itemScopeEntity10, str30, str31, str32, str33, str34, str35);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ItemScopeEntity[] zziI(int i) {
        return new ItemScopeEntity[i];
    }
}
