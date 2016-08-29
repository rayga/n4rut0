package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.zzln;
import java.util.ArrayList;
import java.util.List;

public final class QuestEntity implements SafeParcelable, Quest {
    public static final Creator<QuestEntity> CREATOR;
    private final String mName;
    private final int mState;
    private final int mVersionCode;
    private final int zzUS;
    private final String zzaoB;
    private final long zzasc;
    private final GameEntity zzaxY;
    private final String zzayQ;
    private final long zzayR;
    private final Uri zzayS;
    private final String zzayT;
    private final long zzayU;
    private final Uri zzayV;
    private final String zzayW;
    private final long zzayX;
    private final long zzayY;
    private final ArrayList<MilestoneEntity> zzayZ;

    static {
        CREATOR = new QuestEntityCreator();
    }

    QuestEntity(int versionCode, GameEntity game, String questId, long acceptedTimestamp, Uri bannerImageUri, String bannerImageUrl, String description, long endTimestamp, long lastUpdatedTimestamp, Uri iconImageUri, String iconImageUrl, String name, long notifyTimestamp, long startTimestamp, int state, int type, ArrayList<MilestoneEntity> milestones) {
        this.mVersionCode = versionCode;
        this.zzaxY = game;
        this.zzayQ = questId;
        this.zzayR = acceptedTimestamp;
        this.zzayS = bannerImageUri;
        this.zzayT = bannerImageUrl;
        this.zzaoB = description;
        this.zzayU = endTimestamp;
        this.zzasc = lastUpdatedTimestamp;
        this.zzayV = iconImageUri;
        this.zzayW = iconImageUrl;
        this.mName = name;
        this.zzayX = notifyTimestamp;
        this.zzayY = startTimestamp;
        this.mState = state;
        this.zzUS = type;
        this.zzayZ = milestones;
    }

    public QuestEntity(Quest quest) {
        this.mVersionCode = 2;
        this.zzaxY = new GameEntity(quest.getGame());
        this.zzayQ = quest.getQuestId();
        this.zzayR = quest.getAcceptedTimestamp();
        this.zzaoB = quest.getDescription();
        this.zzayS = quest.getBannerImageUri();
        this.zzayT = quest.getBannerImageUrl();
        this.zzayU = quest.getEndTimestamp();
        this.zzayV = quest.getIconImageUri();
        this.zzayW = quest.getIconImageUrl();
        this.zzasc = quest.getLastUpdatedTimestamp();
        this.mName = quest.getName();
        this.zzayX = quest.zzva();
        this.zzayY = quest.getStartTimestamp();
        this.mState = quest.getState();
        this.zzUS = quest.getType();
        List zzuZ = quest.zzuZ();
        int size = zzuZ.size();
        this.zzayZ = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.zzayZ.add((MilestoneEntity) ((Milestone) zzuZ.get(i)).freeze());
        }
    }

    static int zza(Quest quest) {
        return zzw.hashCode(quest.getGame(), quest.getQuestId(), Long.valueOf(quest.getAcceptedTimestamp()), quest.getBannerImageUri(), quest.getDescription(), Long.valueOf(quest.getEndTimestamp()), quest.getIconImageUri(), Long.valueOf(quest.getLastUpdatedTimestamp()), quest.zzuZ(), quest.getName(), Long.valueOf(quest.zzva()), Long.valueOf(quest.getStartTimestamp()), Integer.valueOf(quest.getState()));
    }

    static boolean zza(Quest quest, Object obj) {
        if (!(obj instanceof Quest)) {
            return false;
        }
        if (quest == obj) {
            return true;
        }
        Quest quest2 = (Quest) obj;
        return zzw.equal(quest2.getGame(), quest.getGame()) && zzw.equal(quest2.getQuestId(), quest.getQuestId()) && zzw.equal(Long.valueOf(quest2.getAcceptedTimestamp()), Long.valueOf(quest.getAcceptedTimestamp())) && zzw.equal(quest2.getBannerImageUri(), quest.getBannerImageUri()) && zzw.equal(quest2.getDescription(), quest.getDescription()) && zzw.equal(Long.valueOf(quest2.getEndTimestamp()), Long.valueOf(quest.getEndTimestamp())) && zzw.equal(quest2.getIconImageUri(), quest.getIconImageUri()) && zzw.equal(Long.valueOf(quest2.getLastUpdatedTimestamp()), Long.valueOf(quest.getLastUpdatedTimestamp())) && zzw.equal(quest2.zzuZ(), quest.zzuZ()) && zzw.equal(quest2.getName(), quest.getName()) && zzw.equal(Long.valueOf(quest2.zzva()), Long.valueOf(quest.zzva())) && zzw.equal(Long.valueOf(quest2.getStartTimestamp()), Long.valueOf(quest.getStartTimestamp())) && zzw.equal(Integer.valueOf(quest2.getState()), Integer.valueOf(quest.getState()));
    }

    static String zzb(Quest quest) {
        return zzw.zzu(quest).zzg("Game", quest.getGame()).zzg("QuestId", quest.getQuestId()).zzg("AcceptedTimestamp", Long.valueOf(quest.getAcceptedTimestamp())).zzg("BannerImageUri", quest.getBannerImageUri()).zzg("BannerImageUrl", quest.getBannerImageUrl()).zzg("Description", quest.getDescription()).zzg("EndTimestamp", Long.valueOf(quest.getEndTimestamp())).zzg("IconImageUri", quest.getIconImageUri()).zzg("IconImageUrl", quest.getIconImageUrl()).zzg("LastUpdatedTimestamp", Long.valueOf(quest.getLastUpdatedTimestamp())).zzg("Milestones", quest.zzuZ()).zzg("Name", quest.getName()).zzg("NotifyTimestamp", Long.valueOf(quest.zzva())).zzg("StartTimestamp", Long.valueOf(quest.getStartTimestamp())).zzg("State", Integer.valueOf(quest.getState())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Quest freeze() {
        return this;
    }

    public long getAcceptedTimestamp() {
        return this.zzayR;
    }

    public Uri getBannerImageUri() {
        return this.zzayS;
    }

    public String getBannerImageUrl() {
        return this.zzayT;
    }

    public Milestone getCurrentMilestone() {
        return (Milestone) zzuZ().get(0);
    }

    public String getDescription() {
        return this.zzaoB;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        zzln.zzb(this.zzaoB, dataOut);
    }

    public long getEndTimestamp() {
        return this.zzayU;
    }

    public Game getGame() {
        return this.zzaxY;
    }

    public Uri getIconImageUri() {
        return this.zzayV;
    }

    public String getIconImageUrl() {
        return this.zzayW;
    }

    public long getLastUpdatedTimestamp() {
        return this.zzasc;
    }

    public String getName() {
        return this.mName;
    }

    public void getName(CharArrayBuffer dataOut) {
        zzln.zzb(this.mName, dataOut);
    }

    public String getQuestId() {
        return this.zzayQ;
    }

    public long getStartTimestamp() {
        return this.zzayY;
    }

    public int getState() {
        return this.mState;
    }

    public int getType() {
        return this.zzUS;
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

    public boolean isEndingSoon() {
        return this.zzayX <= System.currentTimeMillis() + 1800000;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        QuestEntityCreator.zza(this, out, flags);
    }

    public List<Milestone> zzuZ() {
        return new ArrayList(this.zzayZ);
    }

    public long zzva() {
        return this.zzayX;
    }
}
