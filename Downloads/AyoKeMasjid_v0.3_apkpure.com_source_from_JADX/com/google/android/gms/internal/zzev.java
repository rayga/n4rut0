package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
import com.google.android.gms.C0197R;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.plus.PlusShare;
import java.util.Map;
import org.bpmikc.akm.BuildConfig;

@zzgk
public class zzev extends zzfb {
    private final Context mContext;
    private final Map<String, String> zzvs;
    private String zzzi;
    private long zzzj;
    private long zzzk;
    private String zzzl;
    private String zzzm;

    /* renamed from: com.google.android.gms.internal.zzev.1 */
    class C03601 implements OnClickListener {
        final /* synthetic */ zzev zzzn;

        C03601(zzev com_google_android_gms_internal_zzev) {
            this.zzzn = com_google_android_gms_internal_zzev;
        }

        public void onClick(DialogInterface dialog, int which) {
            this.zzzn.mContext.startActivity(this.zzzn.createIntent());
        }
    }

    /* renamed from: com.google.android.gms.internal.zzev.2 */
    class C03612 implements OnClickListener {
        final /* synthetic */ zzev zzzn;

        C03612(zzev com_google_android_gms_internal_zzev) {
            this.zzzn = com_google_android_gms_internal_zzev;
        }

        public void onClick(DialogInterface dialog, int which) {
            this.zzzn.zzah("Operation denied by user.");
        }
    }

    public zzev(zzip com_google_android_gms_internal_zzip, Map<String, String> map) {
        super(com_google_android_gms_internal_zzip, "createCalendarEvent");
        this.zzvs = map;
        this.mContext = com_google_android_gms_internal_zzip.zzgN();
        zzdV();
    }

    private String zzae(String str) {
        return TextUtils.isEmpty((CharSequence) this.zzvs.get(str)) ? BuildConfig.FLAVOR : (String) this.zzvs.get(str);
    }

    private long zzaf(String str) {
        String str2 = (String) this.zzvs.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void zzdV() {
        this.zzzi = zzae(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
        this.zzzl = zzae("summary");
        this.zzzj = zzaf("start_ticks");
        this.zzzk = zzaf("end_ticks");
        this.zzzm = zzae("location");
    }

    Intent createIntent() {
        Intent data = new Intent("android.intent.action.EDIT").setData(Events.CONTENT_URI);
        data.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, this.zzzi);
        data.putExtra("eventLocation", this.zzzm);
        data.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, this.zzzl);
        if (this.zzzj > -1) {
            data.putExtra("beginTime", this.zzzj);
        }
        if (this.zzzk > -1) {
            data.putExtra("endTime", this.zzzk);
        }
        data.setFlags(DriveFile.MODE_READ_ONLY);
        return data;
    }

    public void execute() {
        if (this.mContext == null) {
            zzah("Activity context is not available.");
        } else if (zzp.zzbx().zzM(this.mContext).zzda()) {
            Builder zzL = zzp.zzbx().zzL(this.mContext);
            zzL.setTitle(zzp.zzbA().zzc(C0197R.string.create_calendar_title, "Create calendar event"));
            zzL.setMessage(zzp.zzbA().zzc(C0197R.string.create_calendar_message, "Allow Ad to create a calendar event?"));
            zzL.setPositiveButton(zzp.zzbA().zzc(C0197R.string.accept, "Accept"), new C03601(this));
            zzL.setNegativeButton(zzp.zzbA().zzc(C0197R.string.decline, "Decline"), new C03612(this));
            zzL.create().show();
        } else {
            zzah("This feature is not available on the device.");
        }
    }
}
