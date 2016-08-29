package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.Participant;
import java.util.ArrayList;

public final class ZInvitationCluster implements SafeParcelable, Invitation {
    public static final InvitationClusterCreator CREATOR;
    private final int mVersionCode;
    private final ArrayList<InvitationEntity> zzawK;

    static {
        CREATOR = new InvitationClusterCreator();
    }

    ZInvitationCluster(int versionCode, ArrayList<InvitationEntity> invitationList) {
        this.mVersionCode = versionCode;
        this.zzawK = invitationList;
        zzuz();
    }

    private void zzuz() {
        zzb.zzY(!this.zzawK.isEmpty());
        Invitation invitation = (Invitation) this.zzawK.get(0);
        int size = this.zzawK.size();
        for (int i = 1; i < size; i++) {
            zzb.zza(invitation.getInviter().equals(((Invitation) this.zzawK.get(i)).getInviter()), "All the invitations must be from the same inviter");
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ZInvitationCluster)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ZInvitationCluster zInvitationCluster = (ZInvitationCluster) obj;
        if (zInvitationCluster.zzawK.size() != this.zzawK.size()) {
            return false;
        }
        int size = this.zzawK.size();
        for (int i = 0; i < size; i++) {
            if (!((Invitation) this.zzawK.get(i)).equals((Invitation) zInvitationCluster.zzawK.get(i))) {
                return false;
            }
        }
        return true;
    }

    public Invitation freeze() {
        return this;
    }

    public int getAvailableAutoMatchSlots() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public long getCreationTimestamp() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public Game getGame() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public String getInvitationId() {
        return ((InvitationEntity) this.zzawK.get(0)).getInvitationId();
    }

    public int getInvitationType() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public Participant getInviter() {
        return ((InvitationEntity) this.zzawK.get(0)).getInviter();
    }

    public ArrayList<Participant> getParticipants() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getVariant() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzawK.toArray());
    }

    public boolean isDataValid() {
        return true;
    }

    public void writeToParcel(Parcel dest, int flags) {
        InvitationClusterCreator.zza(this, dest, flags);
    }

    public ArrayList<Invitation> zzuA() {
        return new ArrayList(this.zzawK);
    }
}
