package com.google.android.gms.vision;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import com.google.android.gms.common.images.Size;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.vision.barcode.Barcode;
import java.io.IOException;
import java.lang.Thread.State;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CameraSource {
    public static final int CAMERA_FACING_BACK = 0;
    public static final int CAMERA_FACING_FRONT = 1;
    private Context mContext;
    private Size zzaUA;
    private float zzaUB;
    private int zzaUC;
    private int zzaUD;
    private SurfaceView zzaUE;
    private SurfaceTexture zzaUF;
    private boolean zzaUG;
    private Thread zzaUH;
    private zzb zzaUI;
    private Map<byte[], ByteBuffer> zzaUJ;
    private final Object zzaUx;
    private Camera zzaUy;
    private int zzaUz;
    private int zzzS;

    public static class Builder {
        private final Detector<?> zzaUK;
        private CameraSource zzaUL;

        public Builder(Context context, Detector<?> detector) {
            this.zzaUL = new CameraSource();
            if (context == null) {
                throw new IllegalArgumentException("No context supplied.");
            } else if (detector == null) {
                throw new IllegalArgumentException("No detector supplied.");
            } else {
                this.zzaUK = detector;
                this.zzaUL.mContext = context;
            }
        }

        public CameraSource build() {
            CameraSource cameraSource = this.zzaUL;
            CameraSource cameraSource2 = this.zzaUL;
            cameraSource2.getClass();
            cameraSource.zzaUI = new zzb(cameraSource2, this.zzaUK);
            return this.zzaUL;
        }

        public Builder setFacing(int facing) {
            if (facing == 0 || facing == CameraSource.CAMERA_FACING_FRONT) {
                this.zzaUL.zzaUz = facing;
                return this;
            }
            throw new IllegalArgumentException("Invalid camera: " + facing);
        }

        public Builder setRequestedFps(float fps) {
            if (fps <= 0.0f) {
                throw new IllegalArgumentException("Invalid fps: " + fps);
            }
            this.zzaUL.zzaUB = fps;
            return this;
        }

        public Builder setRequestedPreviewSize(int width, int height) {
            if (width <= 0 || width > 1000000 || height <= 0 || height > 1000000) {
                throw new IllegalArgumentException("Invalid preview size: " + width + "x" + height);
            }
            this.zzaUL.zzaUC = width;
            this.zzaUL.zzaUD = height;
            return this;
        }
    }

    public interface PictureCallback {
        void onPictureTaken(byte[] bArr);
    }

    public interface ShutterCallback {
        void onShutter();
    }

    private class zza implements PreviewCallback {
        final /* synthetic */ CameraSource zzaUM;

        private zza(CameraSource cameraSource) {
            this.zzaUM = cameraSource;
        }

        public void onPreviewFrame(byte[] data, Camera camera) {
            this.zzaUM.zzaUI.zza(data, camera);
        }
    }

    private class zzb implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled;
        private long zzMS;
        private Detector<?> zzaUK;
        final /* synthetic */ CameraSource zzaUM;
        private boolean zzaUN;
        private long zzaUO;
        private int zzaUP;
        private ByteBuffer zzaUQ;
        private final Object zzpc;

        static {
            $assertionsDisabled = !CameraSource.class.desiredAssertionStatus();
        }

        zzb(CameraSource cameraSource, Detector<?> detector) {
            this.zzaUM = cameraSource;
            this.zzMS = SystemClock.elapsedRealtime();
            this.zzpc = new Object();
            this.zzaUN = true;
            this.zzaUP = CameraSource.CAMERA_FACING_BACK;
            this.zzaUK = detector;
        }

        void release() {
            if ($assertionsDisabled || this.zzaUM.zzaUH.getState() == State.TERMINATED) {
                this.zzaUK.release();
                this.zzaUK = null;
                return;
            }
            throw new AssertionError();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r6 = this;
        L_0x0000:
            r1 = r6.zzpc;
            monitor-enter(r1);
            r0 = r6.zzaUN;	 Catch:{ all -> 0x0020 }
            if (r0 == 0) goto L_0x0010;
        L_0x0007:
            r0 = r6.zzaUQ;	 Catch:{ all -> 0x0020 }
            if (r0 != 0) goto L_0x0010;
        L_0x000b:
            r0 = r6.zzpc;	 Catch:{ InterruptedException -> 0x0016 }
            r0.wait();	 Catch:{ InterruptedException -> 0x0016 }
        L_0x0010:
            r0 = r6.zzaUN;	 Catch:{ all -> 0x0020 }
            if (r0 != 0) goto L_0x0023;
        L_0x0014:
            monitor-exit(r1);	 Catch:{ all -> 0x0020 }
        L_0x0015:
            return;
        L_0x0016:
            r0 = move-exception;
            r2 = "CameraSource";
            r3 = "Frame processing loop terminated.";
            android.util.Log.d(r2, r3, r0);	 Catch:{ all -> 0x0020 }
            monitor-exit(r1);	 Catch:{ all -> 0x0020 }
            goto L_0x0015;
        L_0x0020:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0020 }
            throw r0;
        L_0x0023:
            r0 = new com.google.android.gms.vision.Frame$Builder;	 Catch:{ all -> 0x0020 }
            r0.<init>();	 Catch:{ all -> 0x0020 }
            r2 = r6.zzaUQ;	 Catch:{ all -> 0x0020 }
            r3 = r6.zzaUM;	 Catch:{ all -> 0x0020 }
            r3 = r3.zzaUA;	 Catch:{ all -> 0x0020 }
            r3 = r3.getWidth();	 Catch:{ all -> 0x0020 }
            r4 = r6.zzaUM;	 Catch:{ all -> 0x0020 }
            r4 = r4.zzaUA;	 Catch:{ all -> 0x0020 }
            r4 = r4.getHeight();	 Catch:{ all -> 0x0020 }
            r5 = 17;
            r0 = r0.setImageData(r2, r3, r4, r5);	 Catch:{ all -> 0x0020 }
            r2 = r6.zzaUP;	 Catch:{ all -> 0x0020 }
            r0 = r0.setId(r2);	 Catch:{ all -> 0x0020 }
            r2 = r6.zzaUO;	 Catch:{ all -> 0x0020 }
            r0 = r0.setTimestampMillis(r2);	 Catch:{ all -> 0x0020 }
            r2 = r6.zzaUM;	 Catch:{ all -> 0x0020 }
            r2 = r2.zzzS;	 Catch:{ all -> 0x0020 }
            r0 = r0.setRotation(r2);	 Catch:{ all -> 0x0020 }
            r0 = r0.build();	 Catch:{ all -> 0x0020 }
            r2 = r6.zzaUQ;	 Catch:{ all -> 0x0020 }
            r3 = 0;
            r6.zzaUQ = r3;	 Catch:{ all -> 0x0020 }
            monitor-exit(r1);	 Catch:{ all -> 0x0020 }
            r1 = r6.zzaUK;	 Catch:{ Throwable -> 0x0077 }
            r1.receiveFrame(r0);	 Catch:{ Throwable -> 0x0077 }
            r0 = r6.zzaUM;
            r0 = r0.zzaUy;
            r1 = r2.array();
            r0.addCallbackBuffer(r1);
            goto L_0x0000;
        L_0x0077:
            r0 = move-exception;
            r1 = "CameraSource";
            r3 = "Exception thrown from receiver.";
            android.util.Log.e(r1, r3, r0);	 Catch:{ all -> 0x008e }
            r0 = r6.zzaUM;
            r0 = r0.zzaUy;
            r1 = r2.array();
            r0.addCallbackBuffer(r1);
            goto L_0x0000;
        L_0x008e:
            r0 = move-exception;
            r1 = r6.zzaUM;
            r1 = r1.zzaUy;
            r2 = r2.array();
            r1.addCallbackBuffer(r2);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.vision.CameraSource.zzb.run():void");
        }

        void setActive(boolean active) {
            synchronized (this.zzpc) {
                this.zzaUN = active;
                this.zzpc.notifyAll();
            }
        }

        void zza(byte[] bArr, Camera camera) {
            synchronized (this.zzpc) {
                if (this.zzaUQ != null) {
                    camera.addCallbackBuffer(this.zzaUQ.array());
                    this.zzaUQ = null;
                }
                this.zzaUO = SystemClock.elapsedRealtime() - this.zzMS;
                this.zzaUP += CameraSource.CAMERA_FACING_FRONT;
                this.zzaUQ = (ByteBuffer) this.zzaUM.zzaUJ.get(bArr);
                this.zzpc.notifyAll();
            }
        }
    }

    private class zzc implements android.hardware.Camera.PictureCallback {
        final /* synthetic */ CameraSource zzaUM;
        private PictureCallback zzaUR;

        private zzc(CameraSource cameraSource) {
            this.zzaUM = cameraSource;
        }

        public void onPictureTaken(byte[] data, Camera camera) {
            if (this.zzaUR != null) {
                this.zzaUR.onPictureTaken(data);
            }
            synchronized (this.zzaUM.zzaUx) {
                if (this.zzaUM.zzaUy != null) {
                    this.zzaUM.zzaUy.startPreview();
                }
            }
        }
    }

    private class zzd implements android.hardware.Camera.ShutterCallback {
        final /* synthetic */ CameraSource zzaUM;
        private ShutterCallback zzaUS;

        private zzd(CameraSource cameraSource) {
            this.zzaUM = cameraSource;
        }

        public void onShutter() {
            if (this.zzaUS != null) {
                this.zzaUS.onShutter();
            }
        }
    }

    private static class zze {
        private Size zzaUT;
        private Size zzaUU;

        public zze(Camera.Size size, Camera.Size size2) {
            this.zzaUT = new Size(size.width, size.height);
            this.zzaUU = new Size(size2.width, size2.height);
        }

        public Size zzCa() {
            return this.zzaUT;
        }

        public Size zzCb() {
            return this.zzaUU;
        }
    }

    private CameraSource() {
        this.zzaUx = new Object();
        this.zzaUz = CAMERA_FACING_BACK;
        this.zzaUB = BitmapDescriptorFactory.HUE_ORANGE;
        this.zzaUC = Barcode.UPC_E;
        this.zzaUD = 768;
        this.zzaUJ = new HashMap();
    }

    private Camera zzBZ() {
        int zzjn = zzjn(this.zzaUz);
        if (zzjn == -1) {
            throw new RuntimeException("Could not find requested camera.");
        }
        Camera open = Camera.open(zzjn);
        zze zza = zza(open, this.zzaUC, this.zzaUD);
        if (zza == null) {
            throw new RuntimeException("Could not find suitable preview size.");
        }
        Size zzCb = zza.zzCb();
        this.zzaUA = zza.zzCa();
        int[] zza2 = zza(open, this.zzaUB);
        if (zza2 == null) {
            throw new RuntimeException("Could not find suitable preview frames per second range.");
        }
        Parameters parameters = open.getParameters();
        parameters.setPictureSize(zzCb.getWidth(), zzCb.getHeight());
        parameters.setPreviewSize(this.zzaUA.getWidth(), this.zzaUA.getHeight());
        parameters.setPreviewFpsRange(zza2[CAMERA_FACING_BACK], zza2[CAMERA_FACING_FRONT]);
        parameters.setPreviewFormat(17);
        zza(open, parameters, zzjn);
        open.setParameters(parameters);
        open.setPreviewCallbackWithBuffer(new zza());
        open.addCallbackBuffer(zza(this.zzaUA));
        open.addCallbackBuffer(zza(this.zzaUA));
        open.addCallbackBuffer(zza(this.zzaUA));
        open.addCallbackBuffer(zza(this.zzaUA));
        return open;
    }

    private static zze zza(Camera camera, int i, int i2) {
        List<zze> zza = zza(camera);
        zze com_google_android_gms_vision_CameraSource_zze = null;
        int i3 = Strategy.TTL_SECONDS_INFINITE;
        for (zze com_google_android_gms_vision_CameraSource_zze2 : zza) {
            zze com_google_android_gms_vision_CameraSource_zze3;
            int i4;
            Size zzCa = com_google_android_gms_vision_CameraSource_zze2.zzCa();
            int abs = Math.abs(zzCa.getHeight() - i2) + Math.abs(zzCa.getWidth() - i);
            if (abs < i3) {
                int i5 = abs;
                com_google_android_gms_vision_CameraSource_zze3 = com_google_android_gms_vision_CameraSource_zze2;
                i4 = i5;
            } else {
                i4 = i3;
                com_google_android_gms_vision_CameraSource_zze3 = com_google_android_gms_vision_CameraSource_zze;
            }
            i3 = i4;
            com_google_android_gms_vision_CameraSource_zze = com_google_android_gms_vision_CameraSource_zze3;
        }
        return com_google_android_gms_vision_CameraSource_zze;
    }

    private static List<zze> zza(Camera camera) {
        Parameters parameters = camera.getParameters();
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        List supportedPictureSizes = parameters.getSupportedPictureSizes();
        List<zze> arrayList = new ArrayList();
        for (Camera.Size size : supportedPreviewSizes) {
            float f = ((float) size.width) / ((float) size.height);
            for (int size2 = supportedPictureSizes.size() - 1; size2 >= 0; size2--) {
                Camera.Size size3 = (Camera.Size) supportedPictureSizes.get(size2);
                if (Math.abs(f - (((float) size3.width) / ((float) size3.height))) < 0.01f) {
                    arrayList.add(new zze(size, size3));
                    break;
                }
            }
        }
        if (arrayList.size() == 0) {
            Log.w("CameraSource", "No preview sizes have a corresponding same-aspect-ratio picture size");
            for (Camera.Size size4 : supportedPreviewSizes) {
                arrayList.add(new zze(size4, null));
            }
        }
        return arrayList;
    }

    private void zza(Camera camera, Parameters parameters, int i) {
        int i2;
        int rotation = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
        switch (rotation) {
            case CAMERA_FACING_BACK /*0*/:
                rotation = CAMERA_FACING_BACK;
                break;
            case CAMERA_FACING_FRONT /*1*/:
                rotation = 90;
                break;
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                rotation = 180;
                break;
            case CompletionEvent.STATUS_CANCELED /*3*/:
                rotation = 270;
                break;
            default:
                Log.e("CameraSource", "Bad rotation value: " + rotation);
                rotation = CAMERA_FACING_BACK;
                break;
        }
        CameraInfo cameraInfo = new CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        if (cameraInfo.facing == CAMERA_FACING_FRONT) {
            i2 = (rotation + cameraInfo.orientation) % 360;
            rotation = (360 - i2) % 360;
        } else {
            rotation = ((cameraInfo.orientation - rotation) + 360) % 360;
            i2 = rotation;
        }
        this.zzzS = i2 / 90;
        camera.setDisplayOrientation(rotation);
        parameters.setRotation(i2);
    }

    private byte[] zza(Size size) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(((int) Math.ceil(((double) ((long) (ImageFormat.getBitsPerPixel(17) * (size.getHeight() * size.getWidth())))) / 8.0d)) + CAMERA_FACING_FRONT);
        this.zzaUJ.put(allocateDirect.array(), allocateDirect);
        return allocateDirect.array();
    }

    private int[] zza(Camera camera, float f) {
        int i = (int) (1000.0f * f);
        int[] iArr = null;
        int i2 = Strategy.TTL_SECONDS_INFINITE;
        for (int[] iArr2 : camera.getParameters().getSupportedPreviewFpsRange()) {
            int[] iArr3;
            int i3;
            int abs = Math.abs(i - iArr2[CAMERA_FACING_BACK]) + Math.abs(i - iArr2[CAMERA_FACING_FRONT]);
            if (abs < i2) {
                int i4 = abs;
                iArr3 = iArr2;
                i3 = i4;
            } else {
                i3 = i2;
                iArr3 = iArr;
            }
            i2 = i3;
            iArr = iArr3;
        }
        return iArr;
    }

    private static int zzjn(int i) {
        CameraInfo cameraInfo = new CameraInfo();
        for (int i2 = CAMERA_FACING_BACK; i2 < Camera.getNumberOfCameras(); i2 += CAMERA_FACING_FRONT) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == i) {
                return i2;
            }
        }
        return -1;
    }

    public int getCameraFacing() {
        return this.zzaUz;
    }

    public Size getPreviewSize() {
        return this.zzaUA;
    }

    public void release() {
        synchronized (this.zzaUx) {
            stop();
            this.zzaUI.release();
        }
    }

    public CameraSource start() throws IOException {
        synchronized (this.zzaUx) {
            if (this.zzaUy != null) {
            } else {
                this.zzaUy = zzBZ();
                if (VERSION.SDK_INT >= 11) {
                    this.zzaUF = new SurfaceTexture(100);
                    this.zzaUy.setPreviewTexture(this.zzaUF);
                    this.zzaUG = true;
                } else {
                    this.zzaUE = new SurfaceView(this.mContext);
                    this.zzaUy.setPreviewDisplay(this.zzaUE.getHolder());
                    this.zzaUG = false;
                }
                this.zzaUy.startPreview();
                this.zzaUH = new Thread(this.zzaUI);
                this.zzaUI.setActive(true);
                this.zzaUH.start();
            }
        }
        return this;
    }

    public CameraSource start(SurfaceHolder surfaceHolder) throws IOException {
        synchronized (this.zzaUx) {
            if (this.zzaUy != null) {
            } else {
                this.zzaUy = zzBZ();
                this.zzaUy.setPreviewDisplay(surfaceHolder);
                this.zzaUy.startPreview();
                this.zzaUH = new Thread(this.zzaUI);
                this.zzaUI.setActive(true);
                this.zzaUH.start();
                this.zzaUG = false;
            }
        }
        return this;
    }

    public void stop() {
        synchronized (this.zzaUx) {
            this.zzaUI.setActive(false);
            if (this.zzaUH != null) {
                try {
                    this.zzaUH.join();
                } catch (InterruptedException e) {
                    Log.d("CameraSource", "Frame processing thread interrupted on release.");
                }
                this.zzaUH = null;
            }
            if (this.zzaUy != null) {
                this.zzaUy.stopPreview();
                this.zzaUy.setPreviewCallbackWithBuffer(null);
                try {
                    if (this.zzaUG) {
                        this.zzaUy.setPreviewTexture(null);
                    } else {
                        this.zzaUy.setPreviewDisplay(null);
                    }
                } catch (Exception e2) {
                    Log.e("CameraSource", "Failed to clear camera preview: " + e2);
                }
                this.zzaUy.release();
                this.zzaUy = null;
            }
        }
    }

    public void takePicture(ShutterCallback shutter, PictureCallback jpeg) {
        synchronized (this.zzaUx) {
            if (this.zzaUy != null) {
                android.hardware.Camera.ShutterCallback com_google_android_gms_vision_CameraSource_zzd = new zzd();
                com_google_android_gms_vision_CameraSource_zzd.zzaUS = shutter;
                android.hardware.Camera.PictureCallback com_google_android_gms_vision_CameraSource_zzc = new zzc();
                com_google_android_gms_vision_CameraSource_zzc.zzaUR = jpeg;
                this.zzaUy.takePicture(com_google_android_gms_vision_CameraSource_zzd, null, null, com_google_android_gms_vision_CameraSource_zzc);
            }
        }
    }
}
