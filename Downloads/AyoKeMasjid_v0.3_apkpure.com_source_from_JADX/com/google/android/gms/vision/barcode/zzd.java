package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode.CalendarDateTime;
import com.google.android.gms.vision.barcode.Barcode.CalendarEvent;

public class zzd implements Creator<CalendarEvent> {
    static void zza(CalendarEvent calendarEvent, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, calendarEvent.versionCode);
        zzb.zza(parcel, 2, calendarEvent.summary, false);
        zzb.zza(parcel, 3, calendarEvent.description, false);
        zzb.zza(parcel, 4, calendarEvent.location, false);
        zzb.zza(parcel, 5, calendarEvent.organizer, false);
        zzb.zza(parcel, 6, calendarEvent.status, false);
        zzb.zza(parcel, 7, calendarEvent.start, i, false);
        zzb.zza(parcel, 8, calendarEvent.end, i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgp(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjt(x0);
    }

    public CalendarEvent zzgp(Parcel parcel) {
        CalendarDateTime calendarDateTime = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        CalendarDateTime calendarDateTime2 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str5 = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    calendarDateTime2 = (CalendarDateTime) zza.zza(parcel, zzai, CalendarDateTime.CREATOR);
                    break;
                case Barcode.URL /*8*/:
                    calendarDateTime = (CalendarDateTime) zza.zza(parcel, zzai, CalendarDateTime.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new CalendarEvent(i, str5, str4, str3, str2, str, calendarDateTime2, calendarDateTime);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public CalendarEvent[] zzjt(int i) {
        return new CalendarEvent[i];
    }
}
