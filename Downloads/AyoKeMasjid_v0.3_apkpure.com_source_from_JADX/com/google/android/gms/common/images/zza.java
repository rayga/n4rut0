package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.images.ImageManager.OnImageLoadedListener;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzkr;
import com.google.android.gms.internal.zzks;
import com.google.android.gms.internal.zzkt;
import com.google.android.gms.internal.zzku;
import java.lang.ref.WeakReference;

public abstract class zza {
    final zza zzabQ;
    protected int zzabR;
    protected int zzabS;
    protected boolean zzabT;
    protected OnImageLoadedListener zzabU;
    private boolean zzabV;
    private boolean zzabW;
    private boolean zzabX;
    protected int zzabY;

    static final class zza {
        public final Uri uri;

        public zza(Uri uri) {
            this.uri = uri;
        }

        public boolean equals(Object obj) {
            if (obj instanceof zza) {
                return this == obj ? true : zzw.equal(((zza) obj).uri, this.uri);
            } else {
                return false;
            }
        }

        public int hashCode() {
            return zzw.hashCode(this.uri);
        }
    }

    public static final class zzb extends zza {
        private WeakReference<ImageView> zzabZ;

        public zzb(ImageView imageView, int i) {
            super(null, i);
            com.google.android.gms.common.internal.zzb.zzr(imageView);
            this.zzabZ = new WeakReference(imageView);
        }

        public zzb(ImageView imageView, Uri uri) {
            super(uri, 0);
            com.google.android.gms.common.internal.zzb.zzr(imageView);
            this.zzabZ = new WeakReference(imageView);
        }

        private void zza(ImageView imageView, Drawable drawable, boolean z, boolean z2, boolean z3) {
            Object obj = (z2 || z3) ? null : 1;
            if (obj != null && (imageView instanceof zzkt)) {
                int zzof = ((zzkt) imageView).zzof();
                if (this.zzabS != 0 && zzof == this.zzabS) {
                    return;
                }
            }
            boolean zzb = zzb(z, z2);
            Drawable newDrawable = (!this.zzabT || drawable == null) ? drawable : drawable.getConstantState().newDrawable();
            if (zzb) {
                newDrawable = zza(imageView.getDrawable(), newDrawable);
            }
            imageView.setImageDrawable(newDrawable);
            if (imageView instanceof zzkt) {
                zzkt com_google_android_gms_internal_zzkt = (zzkt) imageView;
                com_google_android_gms_internal_zzkt.zzj(z3 ? this.zzabQ.uri : null);
                com_google_android_gms_internal_zzkt.zzbv(obj != null ? this.zzabS : 0);
            }
            if (zzb) {
                ((zzkr) newDrawable).startTransition(250);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzb)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageView imageView = (ImageView) this.zzabZ.get();
            ImageView imageView2 = (ImageView) ((zzb) obj).zzabZ.get();
            boolean z = (imageView2 == null || imageView == null || !zzw.equal(imageView2, imageView)) ? false : true;
            return z;
        }

        public int hashCode() {
            return 0;
        }

        protected void zza(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageView imageView = (ImageView) this.zzabZ.get();
            if (imageView != null) {
                zza(imageView, drawable, z, z2, z3);
            }
        }
    }

    public static final class zzc extends zza {
        private WeakReference<OnImageLoadedListener> zzaca;

        public zzc(OnImageLoadedListener onImageLoadedListener, Uri uri) {
            super(uri, 0);
            com.google.android.gms.common.internal.zzb.zzr(onImageLoadedListener);
            this.zzaca = new WeakReference(onImageLoadedListener);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzc)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzc com_google_android_gms_common_images_zza_zzc = (zzc) obj;
            OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.zzaca.get();
            OnImageLoadedListener onImageLoadedListener2 = (OnImageLoadedListener) com_google_android_gms_common_images_zza_zzc.zzaca.get();
            boolean z = onImageLoadedListener2 != null && onImageLoadedListener != null && zzw.equal(onImageLoadedListener2, onImageLoadedListener) && zzw.equal(com_google_android_gms_common_images_zza_zzc.zzabQ, this.zzabQ);
            return z;
        }

        public int hashCode() {
            return zzw.hashCode(this.zzabQ);
        }

        protected void zza(Drawable drawable, boolean z, boolean z2, boolean z3) {
            if (!z2) {
                OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.zzaca.get();
                if (onImageLoadedListener != null) {
                    onImageLoadedListener.onImageLoaded(this.zzabQ.uri, drawable, z3);
                }
            }
        }
    }

    public zza(Uri uri, int i) {
        this.zzabR = 0;
        this.zzabS = 0;
        this.zzabT = false;
        this.zzabV = true;
        this.zzabW = false;
        this.zzabX = true;
        this.zzabQ = new zza(uri);
        this.zzabS = i;
    }

    private Drawable zza(Context context, zzku com_google_android_gms_internal_zzku, int i) {
        Resources resources = context.getResources();
        if (this.zzabY <= 0) {
            return resources.getDrawable(i);
        }
        com.google.android.gms.internal.zzku.zza com_google_android_gms_internal_zzku_zza = new com.google.android.gms.internal.zzku.zza(i, this.zzabY);
        Drawable drawable = (Drawable) com_google_android_gms_internal_zzku.get(com_google_android_gms_internal_zzku_zza);
        if (drawable != null) {
            return drawable;
        }
        drawable = resources.getDrawable(i);
        if ((this.zzabY & 1) != 0) {
            drawable = zza(resources, drawable);
        }
        com_google_android_gms_internal_zzku.put(com_google_android_gms_internal_zzku_zza, drawable);
        return drawable;
    }

    protected Drawable zza(Resources resources, Drawable drawable) {
        return zzks.zza(resources, drawable);
    }

    protected zzkr zza(Drawable drawable, Drawable drawable2) {
        if (drawable == null) {
            drawable = null;
        } else if (drawable instanceof zzkr) {
            drawable = ((zzkr) drawable).zzod();
        }
        return new zzkr(drawable, drawable2);
    }

    void zza(Context context, Bitmap bitmap, boolean z) {
        com.google.android.gms.common.internal.zzb.zzr(bitmap);
        if ((this.zzabY & 1) != 0) {
            bitmap = zzks.zza(bitmap);
        }
        Drawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        if (this.zzabU != null) {
            this.zzabU.onImageLoaded(this.zzabQ.uri, bitmapDrawable, true);
        }
        zza(bitmapDrawable, z, false, true);
    }

    void zza(Context context, zzku com_google_android_gms_internal_zzku) {
        if (this.zzabX) {
            Drawable drawable = null;
            if (this.zzabR != 0) {
                drawable = zza(context, com_google_android_gms_internal_zzku, this.zzabR);
            }
            zza(drawable, false, true, false);
        }
    }

    void zza(Context context, zzku com_google_android_gms_internal_zzku, boolean z) {
        Drawable drawable = null;
        if (this.zzabS != 0) {
            drawable = zza(context, com_google_android_gms_internal_zzku, this.zzabS);
        }
        if (this.zzabU != null) {
            this.zzabU.onImageLoaded(this.zzabQ.uri, drawable, false);
        }
        zza(drawable, z, false, false);
    }

    protected abstract void zza(Drawable drawable, boolean z, boolean z2, boolean z3);

    protected boolean zzb(boolean z, boolean z2) {
        return this.zzabV && !z2 && (!z || this.zzabW);
    }

    public void zzbt(int i) {
        this.zzabS = i;
    }
}
