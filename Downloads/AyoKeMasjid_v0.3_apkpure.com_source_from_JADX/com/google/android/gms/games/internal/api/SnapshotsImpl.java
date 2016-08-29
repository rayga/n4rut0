package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange.Builder;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;

public final class SnapshotsImpl implements Snapshots {

    private static abstract class CommitImpl extends BaseGamesApiMethodImpl<CommitSnapshotResult> {

        /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.CommitImpl.1 */
        class C11271 implements CommitSnapshotResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ CommitImpl zzawf;

            C11271(CommitImpl commitImpl, Status status) {
                this.zzawf = commitImpl;
                this.zzQs = status;
            }

            public SnapshotMetadata getSnapshotMetadata() {
                return null;
            }

            public Status getStatus() {
                return this.zzQs;
            }
        }

        private CommitImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public CommitSnapshotResult zzaA(Status status) {
            return new C11271(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzaA(status);
        }
    }

    private static abstract class DeleteImpl extends BaseGamesApiMethodImpl<DeleteSnapshotResult> {

        /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.DeleteImpl.1 */
        class C11281 implements DeleteSnapshotResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ DeleteImpl zzawg;

            C11281(DeleteImpl deleteImpl, Status status) {
                this.zzawg = deleteImpl;
                this.zzQs = status;
            }

            public String getSnapshotId() {
                return null;
            }

            public Status getStatus() {
                return this.zzQs;
            }
        }

        private DeleteImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public DeleteSnapshotResult zzaB(Status status) {
            return new C11281(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzaB(status);
        }
    }

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadSnapshotsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.LoadImpl.1 */
        class C11291 implements LoadSnapshotsResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ LoadImpl zzawh;

            C11291(LoadImpl loadImpl, Status status) {
                this.zzawh = loadImpl;
                this.zzQs = status;
            }

            public SnapshotMetadataBuffer getSnapshots() {
                return new SnapshotMetadataBuffer(DataHolder.zzbp(14));
            }

            public Status getStatus() {
                return this.zzQs;
            }

            public void release() {
            }
        }

        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadSnapshotsResult zzaC(Status status) {
            return new C11291(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzaC(status);
        }
    }

    private static abstract class OpenImpl extends BaseGamesApiMethodImpl<OpenSnapshotResult> {

        /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.OpenImpl.1 */
        class C11301 implements OpenSnapshotResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ OpenImpl zzawi;

            C11301(OpenImpl openImpl, Status status) {
                this.zzawi = openImpl;
                this.zzQs = status;
            }

            public String getConflictId() {
                return null;
            }

            public Snapshot getConflictingSnapshot() {
                return null;
            }

            public SnapshotContents getResolutionSnapshotContents() {
                return null;
            }

            public Snapshot getSnapshot() {
                return null;
            }

            public Status getStatus() {
                return this.zzQs;
            }
        }

        private OpenImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public OpenSnapshotResult zzaD(Status status) {
            return new C11301(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzaD(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.1 */
    class C13441 extends LoadImpl {
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ SnapshotsImpl zzavV;

        C13441(SnapshotsImpl snapshotsImpl, GoogleApiClient x0, boolean z) {
            this.zzavV = snapshotsImpl;
            this.zzaut = z;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzf((zzb) this, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.2 */
    class C13452 extends OpenImpl {
        final /* synthetic */ SnapshotsImpl zzavV;
        final /* synthetic */ String zzavW;
        final /* synthetic */ boolean zzavX;
        final /* synthetic */ int zzavY;

        C13452(SnapshotsImpl snapshotsImpl, GoogleApiClient x0, String str, boolean z, int i) {
            this.zzavV = snapshotsImpl;
            this.zzavW = str;
            this.zzavX = z;
            this.zzavY = i;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzavW, this.zzavX, this.zzavY);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.3 */
    class C13463 extends CommitImpl {
        final /* synthetic */ SnapshotsImpl zzavV;
        final /* synthetic */ Snapshot zzavZ;
        final /* synthetic */ SnapshotMetadataChange zzawa;

        C13463(SnapshotsImpl snapshotsImpl, GoogleApiClient x0, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) {
            this.zzavV = snapshotsImpl;
            this.zzavZ = snapshot;
            this.zzawa = snapshotMetadataChange;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzavZ, this.zzawa);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.4 */
    class C13474 extends DeleteImpl {
        final /* synthetic */ SnapshotsImpl zzavV;
        final /* synthetic */ SnapshotMetadata zzawb;

        C13474(SnapshotsImpl snapshotsImpl, GoogleApiClient x0, SnapshotMetadata snapshotMetadata) {
            this.zzavV = snapshotsImpl;
            this.zzawb = snapshotMetadata;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzi((zzb) this, this.zzawb.getSnapshotId());
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.5 */
    class C13485 extends OpenImpl {
        final /* synthetic */ SnapshotsImpl zzavV;
        final /* synthetic */ SnapshotMetadataChange zzawa;
        final /* synthetic */ String zzawc;
        final /* synthetic */ String zzawd;
        final /* synthetic */ SnapshotContents zzawe;

        C13485(SnapshotsImpl snapshotsImpl, GoogleApiClient x0, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) {
            this.zzavV = snapshotsImpl;
            this.zzawc = str;
            this.zzawd = str2;
            this.zzawa = snapshotMetadataChange;
            this.zzawe = snapshotContents;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzawc, this.zzawd, this.zzawa, this.zzawe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl.6 */
    class C13496 extends LoadImpl {
        final /* synthetic */ String zzWg;
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ String zzauv;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzWg, this.zzauv, this.zzaut);
        }
    }

    public PendingResult<CommitSnapshotResult> commitAndClose(GoogleApiClient apiClient, Snapshot snapshot, SnapshotMetadataChange metadataChange) {
        return apiClient.zzb(new C13463(this, apiClient, snapshot, metadataChange));
    }

    public PendingResult<DeleteSnapshotResult> delete(GoogleApiClient apiClient, SnapshotMetadata metadata) {
        return apiClient.zzb(new C13474(this, apiClient, metadata));
    }

    public void discardAndClose(GoogleApiClient apiClient, Snapshot snapshot) {
        Games.zzd(apiClient).zza(snapshot);
    }

    public int getMaxCoverImageSize(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zzuc();
    }

    public int getMaxDataSize(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zzub();
    }

    public Intent getSelectSnapshotIntent(GoogleApiClient apiClient, String title, boolean allowAddButton, boolean allowDelete, int maxSnapshots) {
        return Games.zzd(apiClient).zza(title, allowAddButton, allowDelete, maxSnapshots);
    }

    public SnapshotMetadata getSnapshotFromBundle(Bundle extras) {
        return (extras == null || !extras.containsKey(Snapshots.EXTRA_SNAPSHOT_METADATA)) ? null : (SnapshotMetadata) extras.getParcelable(Snapshots.EXTRA_SNAPSHOT_METADATA);
    }

    public PendingResult<LoadSnapshotsResult> load(GoogleApiClient apiClient, boolean forceReload) {
        return apiClient.zza(new C13441(this, apiClient, forceReload));
    }

    public PendingResult<OpenSnapshotResult> open(GoogleApiClient apiClient, SnapshotMetadata metadata) {
        return open(apiClient, metadata.getUniqueName(), false);
    }

    public PendingResult<OpenSnapshotResult> open(GoogleApiClient apiClient, SnapshotMetadata metadata, int conflictPolicy) {
        return open(apiClient, metadata.getUniqueName(), false, conflictPolicy);
    }

    public PendingResult<OpenSnapshotResult> open(GoogleApiClient apiClient, String fileName, boolean createIfNotFound) {
        return open(apiClient, fileName, createIfNotFound, -1);
    }

    public PendingResult<OpenSnapshotResult> open(GoogleApiClient apiClient, String fileName, boolean createIfNotFound, int conflictPolicy) {
        return apiClient.zzb(new C13452(this, apiClient, fileName, createIfNotFound, conflictPolicy));
    }

    public PendingResult<OpenSnapshotResult> resolveConflict(GoogleApiClient apiClient, String conflictId, Snapshot snapshot) {
        SnapshotMetadata metadata = snapshot.getMetadata();
        SnapshotMetadataChange build = new Builder().fromMetadata(metadata).build();
        return resolveConflict(apiClient, conflictId, metadata.getSnapshotId(), build, snapshot.getSnapshotContents());
    }

    public PendingResult<OpenSnapshotResult> resolveConflict(GoogleApiClient apiClient, String conflictId, String snapshotId, SnapshotMetadataChange metadataChange, SnapshotContents snapshotContents) {
        return apiClient.zzb(new C13485(this, apiClient, conflictId, snapshotId, metadataChange, snapshotContents));
    }
}
