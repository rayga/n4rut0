package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.internal.zzlr;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

public final class SnapshotContentsEntity implements SafeParcelable, SnapshotContents {
    public static final SnapshotContentsEntityCreator CREATOR;
    private static final Object zzaze;
    private final int mVersionCode;
    private Contents zzaiD;

    static {
        zzaze = new Object();
        CREATOR = new SnapshotContentsEntityCreator();
    }

    SnapshotContentsEntity(int versionCode, Contents contents) {
        this.mVersionCode = versionCode;
        this.zzaiD = contents;
    }

    public SnapshotContentsEntity(Contents contents) {
        this(1, contents);
    }

    private boolean zza(int i, byte[] bArr, int i2, int i3, boolean z) {
        zzx.zza(!isClosed(), (Object) "Must provide a previously opened SnapshotContents");
        synchronized (zzaze) {
            OutputStream fileOutputStream = new FileOutputStream(this.zzaiD.getParcelFileDescriptor().getFileDescriptor());
            OutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            try {
                FileChannel channel = fileOutputStream.getChannel();
                channel.position((long) i);
                bufferedOutputStream.write(bArr, i2, i3);
                if (z) {
                    channel.truncate((long) bArr.length);
                }
                bufferedOutputStream.flush();
            } catch (Throwable e) {
                GamesLog.zza("SnapshotContentsEntity", "Failed to write snapshot data", e);
                return false;
            }
        }
        return true;
    }

    public void close() {
        this.zzaiD = null;
    }

    public int describeContents() {
        return 0;
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        zzx.zza(!isClosed(), (Object) "Cannot mutate closed contents!");
        return this.zzaiD.getParcelFileDescriptor();
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean isClosed() {
        return this.zzaiD == null;
    }

    public boolean modifyBytes(int dstOffset, byte[] content, int srcOffset, int count) {
        return zza(dstOffset, content, srcOffset, content.length, false);
    }

    public byte[] readFully() throws IOException {
        byte[] zza;
        boolean z = false;
        if (!isClosed()) {
            z = true;
        }
        zzx.zza(z, (Object) "Must provide a previously opened Snapshot");
        synchronized (zzaze) {
            InputStream fileInputStream = new FileInputStream(this.zzaiD.getParcelFileDescriptor().getFileDescriptor());
            InputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            try {
                fileInputStream.getChannel().position(0);
                zza = zzlr.zza(bufferedInputStream, false);
                fileInputStream.getChannel().position(0);
            } catch (Throwable e) {
                GamesLog.zzb("SnapshotContentsEntity", "Failed to read snapshot data", e);
                throw e;
            }
        }
        return zza;
    }

    public boolean writeBytes(byte[] content) {
        return zza(0, content, 0, content.length, true);
    }

    public void writeToParcel(Parcel out, int flags) {
        SnapshotContentsEntityCreator.zza(this, out, flags);
    }

    public Contents zzqh() {
        return this.zzaiD;
    }
}
