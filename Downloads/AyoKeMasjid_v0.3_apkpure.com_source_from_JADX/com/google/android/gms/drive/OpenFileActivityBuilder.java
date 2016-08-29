package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.drive.internal.zzt;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.zzg;

public class OpenFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private String zzagU;
    private String[] zzagV;
    private Filter zzagW;
    private DriveId zzagX;

    public IntentSender build(GoogleApiClient apiClient) {
        zzx.zza(apiClient.isConnected(), (Object) "Client must be connected");
        if (this.zzagV == null) {
            this.zzagV = new String[0];
        }
        if (this.zzagV.length <= 0 || this.zzagW == null) {
            try {
                return ((zzt) apiClient.zza(Drive.zzQf)).zzqF().zza(new OpenFileIntentSenderRequest(this.zzagU, this.zzagV, this.zzagX, this.zzagW == null ? null : new FilterHolder(this.zzagW)));
            } catch (Throwable e) {
                throw new RuntimeException("Unable to connect Drive Play Service", e);
            }
        }
        throw new IllegalStateException("Cannot use a selection filter and set mimetypes simultaneously");
    }

    public OpenFileActivityBuilder setActivityStartFolder(DriveId folder) {
        this.zzagX = (DriveId) zzx.zzv(folder);
        return this;
    }

    public OpenFileActivityBuilder setActivityTitle(String title) {
        this.zzagU = (String) zzx.zzv(title);
        return this;
    }

    public OpenFileActivityBuilder setMimeType(String[] mimeTypes) {
        zzx.zzb(mimeTypes != null, (Object) "mimeTypes may not be null");
        this.zzagV = mimeTypes;
        return this;
    }

    public OpenFileActivityBuilder setSelectionFilter(Filter filter) {
        boolean z = true;
        zzx.zzb(filter != null, (Object) "filter may not be null");
        if (zzg.zza(filter)) {
            z = false;
        }
        zzx.zzb(z, (Object) "FullTextSearchFilter cannot be used as a selection filter");
        this.zzagW = filter;
        return this;
    }
}
