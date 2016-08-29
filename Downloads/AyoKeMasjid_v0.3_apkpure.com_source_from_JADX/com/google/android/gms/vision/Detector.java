package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.Frame.Metadata;

public abstract class Detector<T> {
    private Object zzaUV;
    private Processor<T> zzaUW;

    public static class Detections<T> {
        private SparseArray<T> zzaUX;
        private Metadata zzaUY;
        private boolean zzaUZ;

        public Detections(SparseArray<T> detectedItems, Metadata frameMetadata, boolean isOperational) {
            this.zzaUX = detectedItems;
            this.zzaUY = frameMetadata;
            this.zzaUZ = isOperational;
        }

        public boolean detectorIsOperational() {
            return this.zzaUZ;
        }

        public SparseArray<T> getDetectedItems() {
            return this.zzaUX;
        }

        public Metadata getFrameMetadata() {
            return this.zzaUY;
        }
    }

    public interface Processor<T> {
        void receiveDetections(Detections<T> detections);

        void release();
    }

    public Detector() {
        this.zzaUV = new Object();
    }

    public abstract SparseArray<T> detect(Frame frame);

    public boolean isOperational() {
        return true;
    }

    public void receiveFrame(Frame frame) {
        synchronized (this.zzaUV) {
            if (this.zzaUW == null) {
                throw new IllegalStateException("Detector processor must first be set with setProcessor in order to receive detection results.");
            }
            Metadata metadata = new Metadata(frame.getMetadata());
            metadata.zzCd();
            this.zzaUW.receiveDetections(new Detections(detect(frame), metadata, isOperational()));
        }
    }

    public void release() {
        synchronized (this.zzaUV) {
            if (this.zzaUW != null) {
                this.zzaUW.release();
                this.zzaUW = null;
            }
        }
    }

    public boolean setFocus(int id) {
        return true;
    }

    public void setProcessor(Processor<T> processor) {
        this.zzaUW = processor;
    }
}
