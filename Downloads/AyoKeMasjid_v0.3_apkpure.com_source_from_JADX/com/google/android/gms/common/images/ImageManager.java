package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.internal.zzku;
import com.google.android.gms.internal.zzlf;
import com.google.android.gms.internal.zzlv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    private static final Object zzabB;
    private static HashSet<Uri> zzabC;
    private static ImageManager zzabD;
    private static ImageManager zzabE;
    private final Context mContext;
    private final Handler mHandler;
    private final ExecutorService zzabF;
    private final zzb zzabG;
    private final zzku zzabH;
    private final Map<zza, ImageReceiver> zzabI;
    private final Map<Uri, ImageReceiver> zzabJ;
    private final Map<Uri, Long> zzabK;

    private final class ImageReceiver extends ResultReceiver {
        private final Uri mUri;
        private final ArrayList<zza> zzabL;
        final /* synthetic */ ImageManager zzabM;

        ImageReceiver(ImageManager imageManager, Uri uri) {
            this.zzabM = imageManager;
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
            this.zzabL = new ArrayList();
        }

        public void onReceiveResult(int resultCode, Bundle resultData) {
            this.zzabM.zzabF.execute(new zzc(this.zzabM, this.mUri, (ParcelFileDescriptor) resultData.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }

        public void zzb(zza com_google_android_gms_common_images_zza) {
            com.google.android.gms.common.internal.zzb.zzch("ImageReceiver.addImageRequest() must be called in the main thread");
            this.zzabL.add(com_google_android_gms_common_images_zza);
        }

        public void zzc(zza com_google_android_gms_common_images_zza) {
            com.google.android.gms.common.internal.zzb.zzch("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.zzabL.remove(com_google_android_gms_common_images_zza);
        }

        public void zzoc() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            this.zzabM.mContext.sendBroadcast(intent);
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    private static final class zza {
        static int zza(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    private final class zzc implements Runnable {
        private final Uri mUri;
        final /* synthetic */ ImageManager zzabM;
        private final ParcelFileDescriptor zzabN;

        public zzc(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.zzabM = imageManager;
            this.mUri = uri;
            this.zzabN = parcelFileDescriptor;
        }

        public void run() {
            com.google.android.gms.common.internal.zzb.zzci("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmap = null;
            if (this.zzabN != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.zzabN.getFileDescriptor());
                } catch (Throwable e) {
                    Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, e);
                    z = true;
                }
                try {
                    this.zzabN.close();
                } catch (Throwable e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.zzabM.mHandler.post(new zzf(this.zzabM, this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
            }
        }
    }

    private final class zzd implements Runnable {
        final /* synthetic */ ImageManager zzabM;
        private final zza zzabO;

        public zzd(ImageManager imageManager, zza com_google_android_gms_common_images_zza) {
            this.zzabM = imageManager;
            this.zzabO = com_google_android_gms_common_images_zza;
        }

        public void run() {
            com.google.android.gms.common.internal.zzb.zzch("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) this.zzabM.zzabI.get(this.zzabO);
            if (imageReceiver != null) {
                this.zzabM.zzabI.remove(this.zzabO);
                imageReceiver.zzc(this.zzabO);
            }
            zza com_google_android_gms_common_images_zza_zza = this.zzabO.zzabQ;
            if (com_google_android_gms_common_images_zza_zza.uri == null) {
                this.zzabO.zza(this.zzabM.mContext, this.zzabM.zzabH, true);
                return;
            }
            Bitmap zza = this.zzabM.zza(com_google_android_gms_common_images_zza_zza);
            if (zza != null) {
                this.zzabO.zza(this.zzabM.mContext, zza, true);
                return;
            }
            Long l = (Long) this.zzabM.zzabK.get(com_google_android_gms_common_images_zza_zza.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.zzabO.zza(this.zzabM.mContext, this.zzabM.zzabH, true);
                    return;
                }
                this.zzabM.zzabK.remove(com_google_android_gms_common_images_zza_zza.uri);
            }
            this.zzabO.zza(this.zzabM.mContext, this.zzabM.zzabH);
            imageReceiver = (ImageReceiver) this.zzabM.zzabJ.get(com_google_android_gms_common_images_zza_zza.uri);
            if (imageReceiver == null) {
                imageReceiver = new ImageReceiver(this.zzabM, com_google_android_gms_common_images_zza_zza.uri);
                this.zzabM.zzabJ.put(com_google_android_gms_common_images_zza_zza.uri, imageReceiver);
            }
            imageReceiver.zzb(this.zzabO);
            if (!(this.zzabO instanceof com.google.android.gms.common.images.zza.zzc)) {
                this.zzabM.zzabI.put(this.zzabO, imageReceiver);
            }
            synchronized (ImageManager.zzabB) {
                if (!ImageManager.zzabC.contains(com_google_android_gms_common_images_zza_zza.uri)) {
                    ImageManager.zzabC.add(com_google_android_gms_common_images_zza_zza.uri);
                    imageReceiver.zzoc();
                }
            }
        }
    }

    private static final class zze implements ComponentCallbacks2 {
        private final zzb zzabG;

        public zze(zzb com_google_android_gms_common_images_ImageManager_zzb) {
            this.zzabG = com_google_android_gms_common_images_ImageManager_zzb;
        }

        public void onConfigurationChanged(Configuration newConfig) {
        }

        public void onLowMemory() {
            this.zzabG.evictAll();
        }

        public void onTrimMemory(int level) {
            if (level >= 60) {
                this.zzabG.evictAll();
            } else if (level >= 20) {
                this.zzabG.trimToSize(this.zzabG.size() / 2);
            }
        }
    }

    private final class zzf implements Runnable {
        private final Bitmap mBitmap;
        private final Uri mUri;
        final /* synthetic */ ImageManager zzabM;
        private boolean zzabP;
        private final CountDownLatch zzoR;

        public zzf(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.zzabM = imageManager;
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.zzabP = z;
            this.zzoR = countDownLatch;
        }

        private void zza(ImageReceiver imageReceiver, boolean z) {
            ArrayList zza = imageReceiver.zzabL;
            int size = zza.size();
            for (int i = 0; i < size; i++) {
                zza com_google_android_gms_common_images_zza = (zza) zza.get(i);
                if (z) {
                    com_google_android_gms_common_images_zza.zza(this.zzabM.mContext, this.mBitmap, false);
                } else {
                    this.zzabM.zzabK.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                    com_google_android_gms_common_images_zza.zza(this.zzabM.mContext, this.zzabM.zzabH, false);
                }
                if (!(com_google_android_gms_common_images_zza instanceof com.google.android.gms.common.images.zza.zzc)) {
                    this.zzabM.zzabI.remove(com_google_android_gms_common_images_zza);
                }
            }
        }

        public void run() {
            com.google.android.gms.common.internal.zzb.zzch("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (this.zzabM.zzabG != null) {
                if (this.zzabP) {
                    this.zzabM.zzabG.evictAll();
                    System.gc();
                    this.zzabP = false;
                    this.zzabM.mHandler.post(this);
                    return;
                } else if (z) {
                    this.zzabM.zzabG.put(new zza(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) this.zzabM.zzabJ.remove(this.mUri);
            if (imageReceiver != null) {
                zza(imageReceiver, z);
            }
            this.zzoR.countDown();
            synchronized (ImageManager.zzabB) {
                ImageManager.zzabC.remove(this.mUri);
            }
        }
    }

    private static final class zzb extends zzlf<zza, Bitmap> {
        public zzb(Context context) {
            super(zzai(context));
        }

        private static int zzai(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            int memoryClass = (((context.getApplicationInfo().flags & AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START) != 0 ? 1 : null) == null || !zzlv.zzpO()) ? activityManager.getMemoryClass() : zza.zza(activityManager);
            return (int) (((float) (memoryClass * AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START)) * 0.33f);
        }

        protected /* synthetic */ void entryRemoved(boolean x0, Object x1, Object x2, Object x3) {
            zza(x0, (zza) x1, (Bitmap) x2, (Bitmap) x3);
        }

        protected /* synthetic */ int sizeOf(Object x0, Object x1) {
            return zza((zza) x0, (Bitmap) x1);
        }

        protected int zza(zza com_google_android_gms_common_images_zza_zza, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        protected void zza(boolean z, zza com_google_android_gms_common_images_zza_zza, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, com_google_android_gms_common_images_zza_zza, bitmap, bitmap2);
        }
    }

    static {
        zzabB = new Object();
        zzabC = new HashSet();
    }

    private ImageManager(Context context, boolean withMemoryCache) {
        this.mContext = context.getApplicationContext();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.zzabF = Executors.newFixedThreadPool(4);
        if (withMemoryCache) {
            this.zzabG = new zzb(this.mContext);
            if (zzlv.zzpR()) {
                zznZ();
            }
        } else {
            this.zzabG = null;
        }
        this.zzabH = new zzku();
        this.zzabI = new HashMap();
        this.zzabJ = new HashMap();
        this.zzabK = new HashMap();
    }

    public static ImageManager create(Context context) {
        return zzb(context, false);
    }

    private Bitmap zza(zza com_google_android_gms_common_images_zza_zza) {
        return this.zzabG == null ? null : (Bitmap) this.zzabG.get(com_google_android_gms_common_images_zza_zza);
    }

    public static ImageManager zzb(Context context, boolean z) {
        if (z) {
            if (zzabE == null) {
                zzabE = new ImageManager(context, true);
            }
            return zzabE;
        }
        if (zzabD == null) {
            zzabD = new ImageManager(context, false);
        }
        return zzabD;
    }

    private void zznZ() {
        this.mContext.registerComponentCallbacks(new zze(this.zzabG));
    }

    public void loadImage(ImageView imageView, int resId) {
        zza(new com.google.android.gms.common.images.zza.zzb(imageView, resId));
    }

    public void loadImage(ImageView imageView, Uri uri) {
        zza(new com.google.android.gms.common.images.zza.zzb(imageView, uri));
    }

    public void loadImage(ImageView imageView, Uri uri, int defaultResId) {
        zza com_google_android_gms_common_images_zza_zzb = new com.google.android.gms.common.images.zza.zzb(imageView, uri);
        com_google_android_gms_common_images_zza_zzb.zzbt(defaultResId);
        zza(com_google_android_gms_common_images_zza_zzb);
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri) {
        zza(new com.google.android.gms.common.images.zza.zzc(listener, uri));
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri, int defaultResId) {
        zza com_google_android_gms_common_images_zza_zzc = new com.google.android.gms.common.images.zza.zzc(listener, uri);
        com_google_android_gms_common_images_zza_zzc.zzbt(defaultResId);
        zza(com_google_android_gms_common_images_zza_zzc);
    }

    public void zza(zza com_google_android_gms_common_images_zza) {
        com.google.android.gms.common.internal.zzb.zzch("ImageManager.loadImage() must be called in the main thread");
        new zzd(this, com_google_android_gms_common_images_zza).run();
    }
}
