package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.CompletionListener;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.ProgressEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;
import com.google.android.gms.drive.events.zzc;
import com.google.android.gms.drive.events.zzf;
import com.google.android.gms.drive.events.zzi;
import com.google.android.gms.drive.events.zzj;
import com.google.android.gms.drive.events.zzl;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.ArrayList;
import java.util.List;

public class zzad extends com.google.android.gms.drive.internal.zzan.zza {
    private final int zzafk;
    private final zzf zzajf;
    private final zza zzajg;
    private final List<Integer> zzajh;

    private static class zza extends Handler {
        private final Context mContext;

        /* renamed from: com.google.android.gms.drive.internal.zzad.zza.1 */
        static class C07281 implements zzj {
            final /* synthetic */ MetadataBuffer zzaji;

            C07281(MetadataBuffer metadataBuffer) {
                this.zzaji = metadataBuffer;
            }
        }

        private zza(Looper looper, Context context) {
            super(looper);
            this.mContext = context;
        }

        private static void zza(zzl com_google_android_gms_drive_events_zzl, QueryResultEventParcelable queryResultEventParcelable) {
            DataHolder zzqA = queryResultEventParcelable.zzqA();
            if (zzqA != null) {
                com_google_android_gms_drive_events_zzl.zza(new C07281(new MetadataBuffer(zzqA)));
            }
            if (queryResultEventParcelable.zzqB()) {
                com_google_android_gms_drive_events_zzl.zzcs(queryResultEventParcelable.zzqC());
            }
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    Pair pair = (Pair) msg.obj;
                    zzf com_google_android_gms_drive_events_zzf = (zzf) pair.first;
                    DriveEvent driveEvent = (DriveEvent) pair.second;
                    switch (driveEvent.getType()) {
                        case CompletionEvent.STATUS_FAILURE /*1*/:
                            ((ChangeListener) com_google_android_gms_drive_events_zzf).onChange((ChangeEvent) driveEvent);
                        case CompletionEvent.STATUS_CONFLICT /*2*/:
                            ((CompletionListener) com_google_android_gms_drive_events_zzf).onCompletion((CompletionEvent) driveEvent);
                        case CompletionEvent.STATUS_CANCELED /*3*/:
                            zza((zzl) com_google_android_gms_drive_events_zzf, (QueryResultEventParcelable) driveEvent);
                        case Barcode.PHONE /*4*/:
                            ((zzc) com_google_android_gms_drive_events_zzf).zza((ChangesAvailableEvent) driveEvent);
                        case Barcode.PRODUCT /*5*/:
                        case Barcode.SMS /*6*/:
                            ((zzi) com_google_android_gms_drive_events_zzf).zza((ProgressEvent) driveEvent);
                        default:
                            zzy.zzw("EventCallback", "Unexpected event: " + driveEvent);
                    }
                default:
                    zzy.zzf(this.mContext, "EventCallback", "Don't know how to handle this event");
            }
        }

        public void zza(zzf com_google_android_gms_drive_events_zzf, DriveEvent driveEvent) {
            sendMessage(obtainMessage(1, new Pair(com_google_android_gms_drive_events_zzf, driveEvent)));
        }
    }

    public zzad(Looper looper, Context context, int i, zzf com_google_android_gms_drive_events_zzf) {
        this.zzajh = new ArrayList();
        this.zzafk = i;
        this.zzajf = com_google_android_gms_drive_events_zzf;
        this.zzajg = new zza(context, null);
    }

    public void zzc(OnEventResponse onEventResponse) throws RemoteException {
        DriveEvent zzqS = onEventResponse.zzqS();
        zzx.zzY(this.zzafk == zzqS.getType());
        zzx.zzY(this.zzajh.contains(Integer.valueOf(zzqS.getType())));
        this.zzajg.zza(this.zzajf, zzqS);
    }

    public void zzcJ(int i) {
        this.zzajh.add(Integer.valueOf(i));
    }

    public boolean zzcK(int i) {
        return this.zzajh.contains(Integer.valueOf(i));
    }
}
