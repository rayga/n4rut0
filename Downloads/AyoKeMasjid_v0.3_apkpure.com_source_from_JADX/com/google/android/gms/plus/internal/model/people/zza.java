package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.plus.internal.model.people.PersonEntity.AgeRangeEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity.CoverEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity.ImageEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity.NameEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity.OrganizationsEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity.PlacesLivedEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity.UrlsEntity;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class zza implements Creator<PersonEntity> {
    static void zza(PersonEntity personEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        Set set = personEntity.zzaLT;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, personEntity.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, personEntity.zzaMR, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, personEntity.zzaMS, i, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, personEntity.zzaMT, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, personEntity.zzaMU, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zzc(parcel, 6, personEntity.zzaMV);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzb.zza(parcel, 7, personEntity.zzaMW, i, true);
        }
        if (set.contains(Integer.valueOf(8))) {
            zzb.zza(parcel, 8, personEntity.zzaMX, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            zzb.zza(parcel, 9, personEntity.zzahh, true);
        }
        if (set.contains(Integer.valueOf(12))) {
            zzb.zzc(parcel, 12, personEntity.zzsW);
        }
        if (set.contains(Integer.valueOf(14))) {
            zzb.zza(parcel, 14, personEntity.zzwj, true);
        }
        if (set.contains(Integer.valueOf(15))) {
            zzb.zza(parcel, 15, personEntity.zzaMY, i, true);
        }
        if (set.contains(Integer.valueOf(16))) {
            zzb.zza(parcel, 16, personEntity.zzaMZ);
        }
        if (set.contains(Integer.valueOf(19))) {
            zzb.zza(parcel, 19, personEntity.zzaNa, i, true);
        }
        if (set.contains(Integer.valueOf(18))) {
            zzb.zza(parcel, 18, personEntity.zzUc, true);
        }
        if (set.contains(Integer.valueOf(21))) {
            zzb.zzc(parcel, 21, personEntity.zzaNc);
        }
        if (set.contains(Integer.valueOf(20))) {
            zzb.zza(parcel, 20, personEntity.zzaNb, true);
        }
        if (set.contains(Integer.valueOf(23))) {
            zzb.zzc(parcel, 23, personEntity.zzaNe, true);
        }
        if (set.contains(Integer.valueOf(22))) {
            zzb.zzc(parcel, 22, personEntity.zzaNd, true);
        }
        if (set.contains(Integer.valueOf(25))) {
            zzb.zzc(parcel, 25, personEntity.zzaNg);
        }
        if (set.contains(Integer.valueOf(24))) {
            zzb.zzc(parcel, 24, personEntity.zzaNf);
        }
        if (set.contains(Integer.valueOf(27))) {
            zzb.zza(parcel, 27, personEntity.zzF, true);
        }
        if (set.contains(Integer.valueOf(26))) {
            zzb.zza(parcel, 26, personEntity.zzaNh, true);
        }
        if (set.contains(Integer.valueOf(29))) {
            zzb.zza(parcel, 29, personEntity.zzaNj);
        }
        if (set.contains(Integer.valueOf(28))) {
            zzb.zzc(parcel, 28, personEntity.zzaNi, true);
        }
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfV(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zziK(x0);
    }

    public PersonEntity zzfV(Parcel parcel) {
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        AgeRangeEntity ageRangeEntity = null;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        CoverEntity coverEntity = null;
        String str4 = null;
        String str5 = null;
        int i3 = 0;
        String str6 = null;
        ImageEntity imageEntity = null;
        boolean z = false;
        String str7 = null;
        NameEntity nameEntity = null;
        String str8 = null;
        int i4 = 0;
        List list = null;
        List list2 = null;
        int i5 = 0;
        int i6 = 0;
        String str9 = null;
        String str10 = null;
        List list3 = null;
        boolean z2 = false;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    AgeRangeEntity ageRangeEntity2 = (AgeRangeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, AgeRangeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    ageRangeEntity = ageRangeEntity2;
                    break;
                case Barcode.PHONE /*4*/:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case Barcode.PRODUCT /*5*/:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case Barcode.SMS /*6*/:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case Barcode.TEXT /*7*/:
                    CoverEntity coverEntity2 = (CoverEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, CoverEntity.CREATOR);
                    hashSet.add(Integer.valueOf(7));
                    coverEntity = coverEntity2;
                    break;
                case Barcode.URL /*8*/:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case Barcode.WIFI /*9*/:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case Barcode.DRIVER_LICENSE /*12*/:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case Place.TYPE_BUS_STATION /*14*/:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case Place.TYPE_CAFE /*15*/:
                    ImageEntity imageEntity2 = (ImageEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, ImageEntity.CREATOR);
                    hashSet.add(Integer.valueOf(15));
                    imageEntity = imageEntity2;
                    break;
                case Barcode.DATA_MATRIX /*16*/:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai);
                    hashSet.add(Integer.valueOf(16));
                    break;
                case Place.TYPE_CAR_RENTAL /*18*/:
                    str7 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(18));
                    break;
                case Place.TYPE_CAR_REPAIR /*19*/:
                    NameEntity nameEntity2 = (NameEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, NameEntity.CREATOR);
                    hashSet.add(Integer.valueOf(19));
                    nameEntity = nameEntity2;
                    break;
                case Place.TYPE_CAR_WASH /*20*/:
                    str8 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(20));
                    break;
                case Place.TYPE_CASINO /*21*/:
                    i4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(21));
                    break;
                case Place.TYPE_CEMETERY /*22*/:
                    list = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai, OrganizationsEntity.CREATOR);
                    hashSet.add(Integer.valueOf(22));
                    break;
                case Place.TYPE_CHURCH /*23*/:
                    list2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai, PlacesLivedEntity.CREATOR);
                    hashSet.add(Integer.valueOf(23));
                    break;
                case Place.TYPE_CITY_HALL /*24*/:
                    i5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(24));
                    break;
                case Place.TYPE_CLOTHING_STORE /*25*/:
                    i6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(25));
                    break;
                case Place.TYPE_CONVENIENCE_STORE /*26*/:
                    str9 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(26));
                    break;
                case Place.TYPE_COURTHOUSE /*27*/:
                    str10 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(27));
                    break;
                case Place.TYPE_DENTIST /*28*/:
                    list3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai, UrlsEntity.CREATOR);
                    hashSet.add(Integer.valueOf(28));
                    break;
                case Place.TYPE_DEPARTMENT_STORE /*29*/:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai);
                    hashSet.add(Integer.valueOf(29));
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new PersonEntity(hashSet, i, str, ageRangeEntity, str2, str3, i2, coverEntity, str4, str5, i3, str6, imageEntity, z, str7, nameEntity, str8, i4, list, list2, i5, i6, str9, str10, list3, z2);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public PersonEntity[] zziK(int i) {
        return new PersonEntity[i];
    }
}
