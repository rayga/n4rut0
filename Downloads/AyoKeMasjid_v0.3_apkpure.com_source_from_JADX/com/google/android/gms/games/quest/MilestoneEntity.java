package com.google.android.gms.games.quest;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class MilestoneEntity implements SafeParcelable, Milestone {
    public static final Creator<MilestoneEntity> CREATOR;
    private final int mState;
    private final int mVersionCode;
    private final String zzasD;
    private final String zzatL;
    private final long zzayN;
    private final long zzayO;
    private final byte[] zzayP;

    static {
        CREATOR = new MilestoneEntityCreator();
    }

    MilestoneEntity(int versionCode, String milestoneId, long currentProgress, long targetProgress, byte[] completionBlob, int state, String eventId) {
        this.mVersionCode = versionCode;
        this.zzatL = milestoneId;
        this.zzayN = currentProgress;
        this.zzayO = targetProgress;
        this.zzayP = completionBlob;
        this.mState = state;
        this.zzasD = eventId;
    }

    public MilestoneEntity(Milestone milestone) {
        this.mVersionCode = 4;
        this.zzatL = milestone.getMilestoneId();
        this.zzayN = milestone.getCurrentProgress();
        this.zzayO = milestone.getTargetProgress();
        this.mState = milestone.getState();
        this.zzasD = milestone.getEventId();
        Object completionRewardData = milestone.getCompletionRewardData();
        if (completionRewardData == null) {
            this.zzayP = null;
            return;
        }
        this.zzayP = new byte[completionRewardData.length];
        System.arraycopy(completionRewardData, 0, this.zzayP, 0, completionRewardData.length);
    }

    static int zza(Milestone milestone) {
        return zzw.hashCode(milestone.getMilestoneId(), Long.valueOf(milestone.getCurrentProgress()), Long.valueOf(milestone.getTargetProgress()), Integer.valueOf(milestone.getState()), milestone.getEventId());
    }

    static boolean zza(Milestone milestone, Object obj) {
        if (!(obj instanceof Milestone)) {
            return false;
        }
        if (milestone == obj) {
            return true;
        }
        Milestone milestone2 = (Milestone) obj;
        return zzw.equal(milestone2.getMilestoneId(), milestone.getMilestoneId()) && zzw.equal(Long.valueOf(milestone2.getCurrentProgress()), Long.valueOf(milestone.getCurrentProgress())) && zzw.equal(Long.valueOf(milestone2.getTargetProgress()), Long.valueOf(milestone.getTargetProgress())) && zzw.equal(Integer.valueOf(milestone2.getState()), Integer.valueOf(milestone.getState())) && zzw.equal(milestone2.getEventId(), milestone.getEventId());
    }

    static String zzb(Milestone milestone) {
        return zzw.zzu(milestone).zzg("MilestoneId", milestone.getMilestoneId()).zzg("CurrentProgress", Long.valueOf(milestone.getCurrentProgress())).zzg("TargetProgress", Long.valueOf(milestone.getTargetProgress())).zzg("State", Integer.valueOf(milestone.getState())).zzg("CompletionRewardData", milestone.getCompletionRewardData()).zzg("EventId", milestone.getEventId()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Milestone freeze() {
        return this;
    }

    public byte[] getCompletionRewardData() {
        return this.zzayP;
    }

    public long getCurrentProgress() {
        return this.zzayN;
    }

    public String getEventId() {
        return this.zzasD;
    }

    public String getMilestoneId() {
        return this.zzatL;
    }

    public int getState() {
        return this.mState;
    }

    public long getTargetProgress() {
        return this.zzayO;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        MilestoneEntityCreator.zza(this, out, flags);
    }
}
