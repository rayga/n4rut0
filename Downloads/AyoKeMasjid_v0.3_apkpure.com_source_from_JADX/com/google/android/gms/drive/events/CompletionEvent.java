package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.zzao.zza;
import com.google.android.gms.drive.internal.zzy;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.zzlr;
import com.google.android.gms.internal.zzmb;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class CompletionEvent implements SafeParcelable, ResourceEvent {
    public static final Creator<CompletionEvent> CREATOR;
    public static final int STATUS_CANCELED = 3;
    public static final int STATUS_CONFLICT = 2;
    public static final int STATUS_FAILURE = 1;
    public static final int STATUS_SUCCESS = 0;
    final int mVersionCode;
    final String zzQE;
    final DriveId zzags;
    final ParcelFileDescriptor zzahs;
    final ParcelFileDescriptor zzaht;
    final MetadataBundle zzahu;
    final List<String> zzahv;
    final IBinder zzahw;
    private boolean zzahx;
    private boolean zzahy;
    private boolean zzahz;
    final int zzxJ;

    static {
        CREATOR = new zze();
    }

    CompletionEvent(int versionCode, DriveId driveId, String accountName, ParcelFileDescriptor baseParcelFileDescriptor, ParcelFileDescriptor modifiedParcelFileDescriptor, MetadataBundle modifiedMetadataBundle, List<String> trackingTags, int status, IBinder releaseCallback) {
        this.zzahx = false;
        this.zzahy = false;
        this.zzahz = false;
        this.mVersionCode = versionCode;
        this.zzags = driveId;
        this.zzQE = accountName;
        this.zzahs = baseParcelFileDescriptor;
        this.zzaht = modifiedParcelFileDescriptor;
        this.zzahu = modifiedMetadataBundle;
        this.zzahv = trackingTags;
        this.zzxJ = status;
        this.zzahw = releaseCallback;
    }

    private void zzqx() {
        if (this.zzahz) {
            throw new IllegalStateException("Event has already been dismissed or snoozed.");
        }
    }

    private void zzt(boolean z) {
        zzqx();
        this.zzahz = true;
        zzlr.zza(this.zzahs);
        zzlr.zza(this.zzaht);
        if (this.zzahu != null && this.zzahu.zzc(zzmb.zzakT)) {
            ((BitmapTeleporter) this.zzahu.zza(zzmb.zzakT)).release();
        }
        if (this.zzahw == null) {
            zzy.zzx("CompletionEvent", "No callback on " + (z ? "snooze" : "dismiss"));
            return;
        }
        try {
            zza.zzaV(this.zzahw).zzt(z);
        } catch (RemoteException e) {
            zzy.zzx("CompletionEvent", "RemoteException on " + (z ? "snooze" : "dismiss") + ": " + e);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void dismiss() {
        zzt(false);
    }

    public String getAccountName() {
        zzqx();
        return this.zzQE;
    }

    public InputStream getBaseContentsInputStream() {
        zzqx();
        if (this.zzahs == null) {
            return null;
        }
        if (this.zzahx) {
            throw new IllegalStateException("getBaseInputStream() can only be called once per CompletionEvent instance.");
        }
        this.zzahx = true;
        return new FileInputStream(this.zzahs.getFileDescriptor());
    }

    public DriveId getDriveId() {
        zzqx();
        return this.zzags;
    }

    public InputStream getModifiedContentsInputStream() {
        zzqx();
        if (this.zzaht == null) {
            return null;
        }
        if (this.zzahy) {
            throw new IllegalStateException("getModifiedInputStream() can only be called once per CompletionEvent instance.");
        }
        this.zzahy = true;
        return new FileInputStream(this.zzaht.getFileDescriptor());
    }

    public MetadataChangeSet getModifiedMetadataChangeSet() {
        zzqx();
        return this.zzahu != null ? new MetadataChangeSet(this.zzahu) : null;
    }

    public int getStatus() {
        zzqx();
        return this.zzxJ;
    }

    public List<String> getTrackingTags() {
        zzqx();
        return new ArrayList(this.zzahv);
    }

    public int getType() {
        return STATUS_CONFLICT;
    }

    public void snooze() {
        zzt(true);
    }

    public String toString() {
        String str = this.zzahv == null ? "<null>" : "'" + TextUtils.join("','", this.zzahv) + "'";
        Object[] objArr = new Object[STATUS_CANCELED];
        objArr[0] = this.zzags;
        objArr[STATUS_FAILURE] = Integer.valueOf(this.zzxJ);
        objArr[STATUS_CONFLICT] = str;
        return String.format(Locale.US, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", objArr);
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags | STATUS_FAILURE);
    }
}
