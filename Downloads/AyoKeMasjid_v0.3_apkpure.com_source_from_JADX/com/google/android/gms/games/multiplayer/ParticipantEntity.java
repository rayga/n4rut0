package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.zzln;

public final class ParticipantEntity extends GamesDowngradeableSafeParcel implements Participant {
    public static final Creator<ParticipantEntity> CREATOR;
    private final int mVersionCode;
    private final int zzTv;
    private final String zzahh;
    private final Uri zzaqW;
    private final Uri zzaqX;
    private final PlayerEntity zzarZ;
    private final String zzarh;
    private final String zzari;
    private final String zzasH;
    private final String zzatI;
    private final boolean zzayg;
    private final ParticipantResult zzayh;
    private final int zzxJ;

    static final class ParticipantEntityCreatorCompat extends ParticipantEntityCreator {
        ParticipantEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzdU(x0);
        }

        public ParticipantEntity zzdU(Parcel parcel) {
            Object obj = 1;
            if (GamesDowngradeableSafeParcel.zzd(DowngradeableSafeParcel.zzor()) || DowngradeableSafeParcel.zzcj(ParticipantEntity.class.getCanonicalName())) {
                return super.zzdU(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            Uri parse = readString3 == null ? null : Uri.parse(readString3);
            String readString4 = parcel.readString();
            Uri parse2 = readString4 == null ? null : Uri.parse(readString4);
            int readInt = parcel.readInt();
            String readString5 = parcel.readString();
            boolean z = parcel.readInt() > 0;
            if (parcel.readInt() <= 0) {
                obj = null;
            }
            return new ParticipantEntity(3, readString, readString2, parse, parse2, readInt, readString5, z, obj != null ? (PlayerEntity) PlayerEntity.CREATOR.createFromParcel(parcel) : null, 7, null, null, null);
        }
    }

    static {
        CREATOR = new ParticipantEntityCreatorCompat();
    }

    ParticipantEntity(int versionCode, String participantId, String displayName, Uri iconImageUri, Uri hiResImageUri, int status, String clientAddress, boolean connectedToRoom, PlayerEntity player, int capabilities, ParticipantResult result, String iconImageUrl, String hiResImageUrl) {
        this.mVersionCode = versionCode;
        this.zzatI = participantId;
        this.zzahh = displayName;
        this.zzaqW = iconImageUri;
        this.zzaqX = hiResImageUri;
        this.zzxJ = status;
        this.zzasH = clientAddress;
        this.zzayg = connectedToRoom;
        this.zzarZ = player;
        this.zzTv = capabilities;
        this.zzayh = result;
        this.zzarh = iconImageUrl;
        this.zzari = hiResImageUrl;
    }

    public ParticipantEntity(Participant participant) {
        this.mVersionCode = 3;
        this.zzatI = participant.getParticipantId();
        this.zzahh = participant.getDisplayName();
        this.zzaqW = participant.getIconImageUri();
        this.zzaqX = participant.getHiResImageUri();
        this.zzxJ = participant.getStatus();
        this.zzasH = participant.zztD();
        this.zzayg = participant.isConnectedToRoom();
        Player player = participant.getPlayer();
        this.zzarZ = player == null ? null : new PlayerEntity(player);
        this.zzTv = participant.getCapabilities();
        this.zzayh = participant.getResult();
        this.zzarh = participant.getIconImageUrl();
        this.zzari = participant.getHiResImageUrl();
    }

    static int zza(Participant participant) {
        return zzw.hashCode(participant.getPlayer(), Integer.valueOf(participant.getStatus()), participant.zztD(), Boolean.valueOf(participant.isConnectedToRoom()), participant.getDisplayName(), participant.getIconImageUri(), participant.getHiResImageUri(), Integer.valueOf(participant.getCapabilities()), participant.getResult(), participant.getParticipantId());
    }

    static boolean zza(Participant participant, Object obj) {
        if (!(obj instanceof Participant)) {
            return false;
        }
        if (participant == obj) {
            return true;
        }
        Participant participant2 = (Participant) obj;
        return zzw.equal(participant2.getPlayer(), participant.getPlayer()) && zzw.equal(Integer.valueOf(participant2.getStatus()), Integer.valueOf(participant.getStatus())) && zzw.equal(participant2.zztD(), participant.zztD()) && zzw.equal(Boolean.valueOf(participant2.isConnectedToRoom()), Boolean.valueOf(participant.isConnectedToRoom())) && zzw.equal(participant2.getDisplayName(), participant.getDisplayName()) && zzw.equal(participant2.getIconImageUri(), participant.getIconImageUri()) && zzw.equal(participant2.getHiResImageUri(), participant.getHiResImageUri()) && zzw.equal(Integer.valueOf(participant2.getCapabilities()), Integer.valueOf(participant.getCapabilities())) && zzw.equal(participant2.getResult(), participant.getResult()) && zzw.equal(participant2.getParticipantId(), participant.getParticipantId());
    }

    static String zzb(Participant participant) {
        return zzw.zzu(participant).zzg("ParticipantId", participant.getParticipantId()).zzg("Player", participant.getPlayer()).zzg("Status", Integer.valueOf(participant.getStatus())).zzg("ClientAddress", participant.zztD()).zzg("ConnectedToRoom", Boolean.valueOf(participant.isConnectedToRoom())).zzg("DisplayName", participant.getDisplayName()).zzg("IconImage", participant.getIconImageUri()).zzg("IconImageUrl", participant.getIconImageUrl()).zzg("HiResImage", participant.getHiResImageUri()).zzg("HiResImageUrl", participant.getHiResImageUrl()).zzg("Capabilities", Integer.valueOf(participant.getCapabilities())).zzg("Result", participant.getResult()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Participant freeze() {
        return this;
    }

    public int getCapabilities() {
        return this.zzTv;
    }

    public String getDisplayName() {
        return this.zzarZ == null ? this.zzahh : this.zzarZ.getDisplayName();
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        if (this.zzarZ == null) {
            zzln.zzb(this.zzahh, dataOut);
        } else {
            this.zzarZ.getDisplayName(dataOut);
        }
    }

    public Uri getHiResImageUri() {
        return this.zzarZ == null ? this.zzaqX : this.zzarZ.getHiResImageUri();
    }

    public String getHiResImageUrl() {
        return this.zzarZ == null ? this.zzari : this.zzarZ.getHiResImageUrl();
    }

    public Uri getIconImageUri() {
        return this.zzarZ == null ? this.zzaqW : this.zzarZ.getIconImageUri();
    }

    public String getIconImageUrl() {
        return this.zzarZ == null ? this.zzarh : this.zzarZ.getIconImageUrl();
    }

    public String getParticipantId() {
        return this.zzatI;
    }

    public Player getPlayer() {
        return this.zzarZ;
    }

    public ParticipantResult getResult() {
        return this.zzayh;
    }

    public int getStatus() {
        return this.zzxJ;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isConnectedToRoom() {
        return this.zzayg;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        String str = null;
        int i = 0;
        if (zzos()) {
            dest.writeString(this.zzatI);
            dest.writeString(this.zzahh);
            dest.writeString(this.zzaqW == null ? null : this.zzaqW.toString());
            if (this.zzaqX != null) {
                str = this.zzaqX.toString();
            }
            dest.writeString(str);
            dest.writeInt(this.zzxJ);
            dest.writeString(this.zzasH);
            dest.writeInt(this.zzayg ? 1 : 0);
            if (this.zzarZ != null) {
                i = 1;
            }
            dest.writeInt(i);
            if (this.zzarZ != null) {
                this.zzarZ.writeToParcel(dest, flags);
                return;
            }
            return;
        }
        ParticipantEntityCreator.zza(this, dest, flags);
    }

    public String zztD() {
        return this.zzasH;
    }
}
