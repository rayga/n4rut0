package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.internal.zzi;
import com.google.android.gms.maps.model.internal.zzi.zza;

public final class TileOverlayOptions implements SafeParcelable {
    public static final zzo CREATOR;
    private final int mVersionCode;
    private float zzaGZ;
    private zzi zzaHH;
    private TileProvider zzaHI;
    private boolean zzaHJ;
    private boolean zzaHa;

    /* renamed from: com.google.android.gms.maps.model.TileOverlayOptions.1 */
    class C08181 implements TileProvider {
        private final zzi zzaHK;
        final /* synthetic */ TileOverlayOptions zzaHL;

        C08181(TileOverlayOptions tileOverlayOptions) {
            this.zzaHL = tileOverlayOptions;
            this.zzaHK = this.zzaHL.zzaHH;
        }

        public Tile getTile(int x, int y, int zoom) {
            try {
                return this.zzaHK.getTile(x, y, zoom);
            } catch (RemoteException e) {
                return null;
            }
        }
    }

    /* renamed from: com.google.android.gms.maps.model.TileOverlayOptions.2 */
    class C11712 extends zza {
        final /* synthetic */ TileOverlayOptions zzaHL;
        final /* synthetic */ TileProvider zzaHM;

        C11712(TileOverlayOptions tileOverlayOptions, TileProvider tileProvider) {
            this.zzaHL = tileOverlayOptions;
            this.zzaHM = tileProvider;
        }

        public Tile getTile(int x, int y, int zoom) {
            return this.zzaHM.getTile(x, y, zoom);
        }
    }

    static {
        CREATOR = new zzo();
    }

    public TileOverlayOptions() {
        this.zzaHa = true;
        this.zzaHJ = true;
        this.mVersionCode = 1;
    }

    TileOverlayOptions(int versionCode, IBinder delegate, boolean visible, float zIndex, boolean fadeIn) {
        this.zzaHa = true;
        this.zzaHJ = true;
        this.mVersionCode = versionCode;
        this.zzaHH = zza.zzcX(delegate);
        this.zzaHI = this.zzaHH == null ? null : new C08181(this);
        this.zzaHa = visible;
        this.zzaGZ = zIndex;
        this.zzaHJ = fadeIn;
    }

    public int describeContents() {
        return 0;
    }

    public TileOverlayOptions fadeIn(boolean fadeIn) {
        this.zzaHJ = fadeIn;
        return this;
    }

    public boolean getFadeIn() {
        return this.zzaHJ;
    }

    public TileProvider getTileProvider() {
        return this.zzaHI;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public float getZIndex() {
        return this.zzaGZ;
    }

    public boolean isVisible() {
        return this.zzaHa;
    }

    public TileOverlayOptions tileProvider(TileProvider tileProvider) {
        this.zzaHI = tileProvider;
        this.zzaHH = this.zzaHI == null ? null : new C11712(this, tileProvider);
        return this;
    }

    public TileOverlayOptions visible(boolean visible) {
        this.zzaHa = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzo.zza(this, out, flags);
    }

    public TileOverlayOptions zIndex(float zIndex) {
        this.zzaGZ = zIndex;
        return this;
    }

    IBinder zzxf() {
        return this.zzaHH.asBinder();
    }
}
