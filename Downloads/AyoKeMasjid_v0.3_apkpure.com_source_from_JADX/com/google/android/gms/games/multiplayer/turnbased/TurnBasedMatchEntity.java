package com.google.android.gms.games.multiplayer.turnbased;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.zzln;
import java.util.ArrayList;

public final class TurnBasedMatchEntity implements SafeParcelable, TurnBasedMatch {
    public static final Creator<TurnBasedMatchEntity> CREATOR;
    private final int mVersion;
    private final int mVersionCode;
    private final String zzaoB;
    private final long zzasc;
    private final String zzatz;
    private final GameEntity zzaxY;
    private final long zzaxZ;
    private final String zzayD;
    private final String zzayE;
    private final int zzayF;
    private final byte[] zzayG;
    private final String zzayH;
    private final byte[] zzayI;
    private final int zzayJ;
    private final int zzayK;
    private final boolean zzayL;
    private final String zzayM;
    private final ArrayList<ParticipantEntity> zzayc;
    private final int zzayd;
    private final Bundle zzayt;
    private final String zzayv;

    static {
        CREATOR = new TurnBasedMatchEntityCreator();
    }

    TurnBasedMatchEntity(int versionCode, GameEntity game, String matchId, String creatorId, long creationTimestamp, String lastUpdaterId, long lastUpdatedTimestamp, String pendingParticipantId, int matchStatus, int variant, int version, byte[] data, ArrayList<ParticipantEntity> participants, String rematchId, byte[] previousData, int matchNumber, Bundle autoMatchCriteria, int turnStatus, boolean isLocallyModified, String description, String descriptionParticipantId) {
        this.mVersionCode = versionCode;
        this.zzaxY = game;
        this.zzatz = matchId;
        this.zzayv = creatorId;
        this.zzaxZ = creationTimestamp;
        this.zzayD = lastUpdaterId;
        this.zzasc = lastUpdatedTimestamp;
        this.zzayE = pendingParticipantId;
        this.zzayF = matchStatus;
        this.zzayK = turnStatus;
        this.zzayd = variant;
        this.mVersion = version;
        this.zzayG = data;
        this.zzayc = participants;
        this.zzayH = rematchId;
        this.zzayI = previousData;
        this.zzayJ = matchNumber;
        this.zzayt = autoMatchCriteria;
        this.zzayL = isLocallyModified;
        this.zzaoB = description;
        this.zzayM = descriptionParticipantId;
    }

    public TurnBasedMatchEntity(TurnBasedMatch match) {
        this.mVersionCode = 2;
        this.zzaxY = new GameEntity(match.getGame());
        this.zzatz = match.getMatchId();
        this.zzayv = match.getCreatorId();
        this.zzaxZ = match.getCreationTimestamp();
        this.zzayD = match.getLastUpdaterId();
        this.zzasc = match.getLastUpdatedTimestamp();
        this.zzayE = match.getPendingParticipantId();
        this.zzayF = match.getStatus();
        this.zzayK = match.getTurnStatus();
        this.zzayd = match.getVariant();
        this.mVersion = match.getVersion();
        this.zzayH = match.getRematchId();
        this.zzayJ = match.getMatchNumber();
        this.zzayt = match.getAutoMatchCriteria();
        this.zzayL = match.isLocallyModified();
        this.zzaoB = match.getDescription();
        this.zzayM = match.getDescriptionParticipantId();
        Object data = match.getData();
        if (data == null) {
            this.zzayG = null;
        } else {
            this.zzayG = new byte[data.length];
            System.arraycopy(data, 0, this.zzayG, 0, data.length);
        }
        data = match.getPreviousMatchData();
        if (data == null) {
            this.zzayI = null;
        } else {
            this.zzayI = new byte[data.length];
            System.arraycopy(data, 0, this.zzayI, 0, data.length);
        }
        ArrayList participants = match.getParticipants();
        int size = participants.size();
        this.zzayc = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.zzayc.add((ParticipantEntity) ((Participant) participants.get(i)).freeze());
        }
    }

    static int zza(TurnBasedMatch turnBasedMatch) {
        return zzw.hashCode(turnBasedMatch.getGame(), turnBasedMatch.getMatchId(), turnBasedMatch.getCreatorId(), Long.valueOf(turnBasedMatch.getCreationTimestamp()), turnBasedMatch.getLastUpdaterId(), Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp()), turnBasedMatch.getPendingParticipantId(), Integer.valueOf(turnBasedMatch.getStatus()), Integer.valueOf(turnBasedMatch.getTurnStatus()), turnBasedMatch.getDescription(), Integer.valueOf(turnBasedMatch.getVariant()), Integer.valueOf(turnBasedMatch.getVersion()), turnBasedMatch.getParticipants(), turnBasedMatch.getRematchId(), Integer.valueOf(turnBasedMatch.getMatchNumber()), turnBasedMatch.getAutoMatchCriteria(), Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots()), Boolean.valueOf(turnBasedMatch.isLocallyModified()));
    }

    static int zza(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant.getStatus();
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in match " + turnBasedMatch.getMatchId());
    }

    static boolean zza(TurnBasedMatch turnBasedMatch, Object obj) {
        if (!(obj instanceof TurnBasedMatch)) {
            return false;
        }
        if (turnBasedMatch == obj) {
            return true;
        }
        TurnBasedMatch turnBasedMatch2 = (TurnBasedMatch) obj;
        return zzw.equal(turnBasedMatch2.getGame(), turnBasedMatch.getGame()) && zzw.equal(turnBasedMatch2.getMatchId(), turnBasedMatch.getMatchId()) && zzw.equal(turnBasedMatch2.getCreatorId(), turnBasedMatch.getCreatorId()) && zzw.equal(Long.valueOf(turnBasedMatch2.getCreationTimestamp()), Long.valueOf(turnBasedMatch.getCreationTimestamp())) && zzw.equal(turnBasedMatch2.getLastUpdaterId(), turnBasedMatch.getLastUpdaterId()) && zzw.equal(Long.valueOf(turnBasedMatch2.getLastUpdatedTimestamp()), Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp())) && zzw.equal(turnBasedMatch2.getPendingParticipantId(), turnBasedMatch.getPendingParticipantId()) && zzw.equal(Integer.valueOf(turnBasedMatch2.getStatus()), Integer.valueOf(turnBasedMatch.getStatus())) && zzw.equal(Integer.valueOf(turnBasedMatch2.getTurnStatus()), Integer.valueOf(turnBasedMatch.getTurnStatus())) && zzw.equal(turnBasedMatch2.getDescription(), turnBasedMatch.getDescription()) && zzw.equal(Integer.valueOf(turnBasedMatch2.getVariant()), Integer.valueOf(turnBasedMatch.getVariant())) && zzw.equal(Integer.valueOf(turnBasedMatch2.getVersion()), Integer.valueOf(turnBasedMatch.getVersion())) && zzw.equal(turnBasedMatch2.getParticipants(), turnBasedMatch.getParticipants()) && zzw.equal(turnBasedMatch2.getRematchId(), turnBasedMatch.getRematchId()) && zzw.equal(Integer.valueOf(turnBasedMatch2.getMatchNumber()), Integer.valueOf(turnBasedMatch.getMatchNumber())) && zzw.equal(turnBasedMatch2.getAutoMatchCriteria(), turnBasedMatch.getAutoMatchCriteria()) && zzw.equal(Integer.valueOf(turnBasedMatch2.getAvailableAutoMatchSlots()), Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots())) && zzw.equal(Boolean.valueOf(turnBasedMatch2.isLocallyModified()), Boolean.valueOf(turnBasedMatch.isLocallyModified()));
    }

    static String zzb(TurnBasedMatch turnBasedMatch) {
        return zzw.zzu(turnBasedMatch).zzg("Game", turnBasedMatch.getGame()).zzg("MatchId", turnBasedMatch.getMatchId()).zzg("CreatorId", turnBasedMatch.getCreatorId()).zzg("CreationTimestamp", Long.valueOf(turnBasedMatch.getCreationTimestamp())).zzg("LastUpdaterId", turnBasedMatch.getLastUpdaterId()).zzg("LastUpdatedTimestamp", Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp())).zzg("PendingParticipantId", turnBasedMatch.getPendingParticipantId()).zzg("MatchStatus", Integer.valueOf(turnBasedMatch.getStatus())).zzg("TurnStatus", Integer.valueOf(turnBasedMatch.getTurnStatus())).zzg("Description", turnBasedMatch.getDescription()).zzg("Variant", Integer.valueOf(turnBasedMatch.getVariant())).zzg("Data", turnBasedMatch.getData()).zzg("Version", Integer.valueOf(turnBasedMatch.getVersion())).zzg("Participants", turnBasedMatch.getParticipants()).zzg("RematchId", turnBasedMatch.getRematchId()).zzg("PreviousData", turnBasedMatch.getPreviousMatchData()).zzg("MatchNumber", Integer.valueOf(turnBasedMatch.getMatchNumber())).zzg("AutoMatchCriteria", turnBasedMatch.getAutoMatchCriteria()).zzg("AvailableAutoMatchSlots", Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots())).zzg("LocallyModified", Boolean.valueOf(turnBasedMatch.isLocallyModified())).zzg("DescriptionParticipantId", turnBasedMatch.getDescriptionParticipantId()).toString();
    }

    static String zzb(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
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

    static Participant zzc(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant;
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in match " + turnBasedMatch.getMatchId());
    }

    static ArrayList<String> zzc(TurnBasedMatch turnBasedMatch) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        ArrayList<String> arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(((Participant) participants.get(i)).getParticipantId());
        }
        return arrayList;
    }

    public boolean canRematch() {
        return this.zzayF == 2 && this.zzayH == null;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza((TurnBasedMatch) this, obj);
    }

    public TurnBasedMatch freeze() {
        return this;
    }

    public Bundle getAutoMatchCriteria() {
        return this.zzayt;
    }

    public int getAvailableAutoMatchSlots() {
        return this.zzayt == null ? 0 : this.zzayt.getInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS);
    }

    public long getCreationTimestamp() {
        return this.zzaxZ;
    }

    public String getCreatorId() {
        return this.zzayv;
    }

    public byte[] getData() {
        return this.zzayG;
    }

    public String getDescription() {
        return this.zzaoB;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        zzln.zzb(this.zzaoB, dataOut);
    }

    public Participant getDescriptionParticipant() {
        String descriptionParticipantId = getDescriptionParticipantId();
        return descriptionParticipantId == null ? null : getParticipant(descriptionParticipantId);
    }

    public String getDescriptionParticipantId() {
        return this.zzayM;
    }

    public Game getGame() {
        return this.zzaxY;
    }

    public long getLastUpdatedTimestamp() {
        return this.zzasc;
    }

    public String getLastUpdaterId() {
        return this.zzayD;
    }

    public String getMatchId() {
        return this.zzatz;
    }

    public int getMatchNumber() {
        return this.zzayJ;
    }

    public Participant getParticipant(String participantId) {
        return zzc(this, participantId);
    }

    public String getParticipantId(String playerId) {
        return zzb(this, playerId);
    }

    public ArrayList<String> getParticipantIds() {
        return zzc(this);
    }

    public int getParticipantStatus(String participantId) {
        return zza((TurnBasedMatch) this, participantId);
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList(this.zzayc);
    }

    public String getPendingParticipantId() {
        return this.zzayE;
    }

    public byte[] getPreviousMatchData() {
        return this.zzayI;
    }

    public String getRematchId() {
        return this.zzayH;
    }

    public int getStatus() {
        return this.zzayF;
    }

    public int getTurnStatus() {
        return this.zzayK;
    }

    public int getVariant() {
        return this.zzayd;
    }

    public int getVersion() {
        return this.mVersion;
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

    public boolean isLocallyModified() {
        return this.zzayL;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        TurnBasedMatchEntityCreator.zza(this, out, flags);
    }
}
