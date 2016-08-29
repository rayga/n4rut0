package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.common.data.BitmapTeleporter;

public abstract class SnapshotMetadataChange {
    public static final SnapshotMetadataChange EMPTY_CHANGE;

    public static final class Builder {
        private String zzaoB;
        private Long zzazh;
        private Long zzazi;
        private BitmapTeleporter zzazj;
        private Uri zzazk;

        public SnapshotMetadataChange build() {
            return new SnapshotMetadataChangeEntity(this.zzaoB, this.zzazh, this.zzazj, this.zzazk, this.zzazi);
        }

        public Builder fromMetadata(SnapshotMetadata metadata) {
            this.zzaoB = metadata.getDescription();
            this.zzazh = Long.valueOf(metadata.getPlayedTime());
            this.zzazi = Long.valueOf(metadata.getProgressValue());
            if (this.zzazh.longValue() == -1) {
                this.zzazh = null;
            }
            this.zzazk = metadata.getCoverImageUri();
            if (this.zzazk != null) {
                this.zzazj = null;
            }
            return this;
        }

        public Builder setCoverImage(Bitmap coverImage) {
            this.zzazj = new BitmapTeleporter(coverImage);
            this.zzazk = null;
            return this;
        }

        public Builder setDescription(String description) {
            this.zzaoB = description;
            return this;
        }

        public Builder setPlayedTimeMillis(long playedTimeMillis) {
            this.zzazh = Long.valueOf(playedTimeMillis);
            return this;
        }

        public Builder setProgressValue(long progressValue) {
            this.zzazi = Long.valueOf(progressValue);
            return this;
        }
    }

    static {
        EMPTY_CHANGE = new SnapshotMetadataChangeEntity();
    }

    protected SnapshotMetadataChange() {
    }

    public abstract Bitmap getCoverImage();

    public abstract String getDescription();

    public abstract Long getPlayedTimeMillis();

    public abstract Long getProgressValue();

    public abstract BitmapTeleporter zzvc();
}
