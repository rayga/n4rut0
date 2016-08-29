package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.zzln;
import java.util.ArrayList;

public final class RoomEntity extends GamesDowngradeableSafeParcel implements Room {
    public static final Creator<RoomEntity> CREATOR;
    private final int mVersionCode;
    private final String zzaoB;
    private final String zzatg;
    private final long zzaxZ;
    private final ArrayList<ParticipantEntity> zzayc;
    private final int zzayd;
    private final Bundle zzayt;
    private final String zzayv;
    private final int zzayw;
    private final int zzayx;

    static final class RoomEntityCreatorCompat extends RoomEntityCreator {
        RoomEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzdX(x0);
        }

        public RoomEntity zzdX(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.zzd(DowngradeableSafeParcel.zzor()) || DowngradeableSafeParcel.zzcj(RoomEntity.class.getCanonicalName())) {
                return super.zzdX(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            String readString3 = parcel.readString();
            int readInt2 = parcel.readInt();
            Bundle readBundle = parcel.readBundle();
            int readInt3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt3);
            for (int i = 0; i < readInt3; i++) {
                arrayList.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            return new RoomEntity(2, readString, readString2, readLong, readInt, readString3, readInt2, readBundle, arrayList, -1);
        }
    }

    static {
        CREATOR = new RoomEntityCreatorCompat();
    }

    RoomEntity(int versionCode, String roomId, String creatorId, long creationTimestamp, int roomStatus, String description, int variant, Bundle autoMatchCriteria, ArrayList<ParticipantEntity> participants, int autoMatchWaitEstimateSeconds) {
        this.mVersionCode = versionCode;
        this.zzatg = roomId;
        this.zzayv = creatorId;
        this.zzaxZ = creationTimestamp;
        this.zzayw = roomStatus;
        this.zzaoB = description;
        this.zzayd = variant;
        this.zzayt = autoMatchCriteria;
        this.zzayc = participants;
        this.zzayx = autoMatchWaitEstimateSeconds;
    }

    public RoomEntity(Room room) {
        this.mVersionCode = 2;
        this.zzatg = room.getRoomId();
        this.zzayv = room.getCreatorId();
        this.zzaxZ = room.getCreationTimestamp();
        this.zzayw = room.getStatus();
        this.zzaoB = room.getDescription();
        this.zzayd = room.getVariant();
        this.zzayt = room.getAutoMatchCriteria();
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        this.zzayc = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.zzayc.add((ParticipantEntity) ((Participant) participants.get(i)).freeze());
        }
        this.zzayx = room.getAutoMatchWaitEstimateSeconds();
    }

    static int zza(Room room) {
        return zzw.hashCode(room.getRoomId(), room.getCreatorId(), Long.valueOf(room.getCreationTimestamp()), Integer.valueOf(room.getStatus()), room.getDescription(), Integer.valueOf(room.getVariant()), room.getAutoMatchCriteria(), room.getParticipants(), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds()));
    }

    static int zza(Room room, String str) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant.getStatus();
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in room " + room.getRoomId());
    }

    static boolean zza(Room room, Object obj) {
        if (!(obj instanceof Room)) {
            return false;
        }
        if (room == obj) {
            return true;
        }
        Room room2 = (Room) obj;
        return zzw.equal(room2.getRoomId(), room.getRoomId()) && zzw.equal(room2.getCreatorId(), room.getCreatorId()) && zzw.equal(Long.valueOf(room2.getCreationTimestamp()), Long.valueOf(room.getCreationTimestamp())) && zzw.equal(Integer.valueOf(room2.getStatus()), Integer.valueOf(room.getStatus())) && zzw.equal(room2.getDescription(), room.getDescription()) && zzw.equal(Integer.valueOf(room2.getVariant()), Integer.valueOf(room.getVariant())) && zzw.equal(room2.getAutoMatchCriteria(), room.getAutoMatchCriteria()) && zzw.equal(room2.getParticipants(), room.getParticipants()) && zzw.equal(Integer.valueOf(room2.getAutoMatchWaitEstimateSeconds()), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds()));
    }

    static String zzb(Room room) {
        return zzw.zzu(room).zzg("RoomId", room.getRoomId()).zzg("CreatorId", room.getCreatorId()).zzg("CreationTimestamp", Long.valueOf(room.getCreationTimestamp())).zzg("RoomStatus", Integer.valueOf(room.getStatus())).zzg("Description", room.getDescription()).zzg("Variant", Integer.valueOf(room.getVariant())).zzg("AutoMatchCriteria", room.getAutoMatchCriteria()).zzg("Participants", room.getParticipants()).zzg("AutoMatchWaitEstimateSeconds", Integer.valueOf(room.getAutoMatchWaitEstimateSeconds())).toString();
    }

    static String zzb(Room room, String str) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            Player player = participant.getPlayer();
            if (player != null && player.getPlayerId().equals(str)) {
                return participant.getParticipantId();
            }
        }
        return null;
    }

    static Participant zzc(Room room, String str) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant;
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in match " + room.getRoomId());
    }

    static ArrayList<String> zzc(Room room) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        ArrayList<String> arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(((Participant) participants.get(i)).getParticipantId());
        }
        return arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza((Room) this, obj);
    }

    public Room freeze() {
        return this;
    }

    public Bundle getAutoMatchCriteria() {
        return this.zzayt;
    }

    public int getAutoMatchWaitEstimateSeconds() {
        return this.zzayx;
    }

    public long getCreationTimestamp() {
        return this.zzaxZ;
    }

    public String getCreatorId() {
        return this.zzayv;
    }

    public String getDescription() {
        return this.zzaoB;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        zzln.zzb(this.zzaoB, dataOut);
    }

    public Participant getParticipant(String participantId) {
        return zzc(this, participantId);
    }

    public String getParticipantId(String playerId) {
        return zzb(this, playerId);
    }

    public ArrayList<String> getParticipantIds() {
        return zzc((Room) this);
    }

    public int getParticipantStatus(String participantId) {
        return zza((Room) this, participantId);
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList(this.zzayc);
    }

    public String getRoomId() {
        return this.zzatg;
    }

    public int getStatus() {
        return this.zzayw;
    }

    public int getVariant() {
        return this.zzayd;
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

    public void writeToParcel(Parcel dest, int flags) {
        if (zzos()) {
            dest.writeString(this.zzatg);
            dest.writeString(this.zzayv);
            dest.writeLong(this.zzaxZ);
            dest.writeInt(this.zzayw);
            dest.writeString(this.zzaoB);
            dest.writeInt(this.zzayd);
            dest.writeBundle(this.zzayt);
            int size = this.zzayc.size();
            dest.writeInt(size);
            for (int i = 0; i < size; i++) {
                ((ParticipantEntity) this.zzayc.get(i)).writeToParcel(dest, flags);
            }
            return;
        }
        RoomEntityCreator.zza(this, dest, flags);
    }
}
