package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.Detector.Detections;
import com.google.android.gms.vision.Detector.Processor;
import java.util.HashSet;
import java.util.Set;

public class MultiProcessor<T> implements Processor<T> {
    private Factory<T> zzaVl;
    private SparseArray<zza<T>> zzaVm;
    private int zzaVn;

    public static class Builder<T> {
        private MultiProcessor<T> zzaVo;

        public Builder(Factory<T> factory) {
            this.zzaVo = new MultiProcessor();
            if (factory == null) {
                throw new IllegalArgumentException("No factory supplied.");
            }
            this.zzaVo.zzaVl = factory;
        }

        public MultiProcessor<T> build() {
            return this.zzaVo;
        }

        public Builder<T> setMaxGapFrames(int maxGapFrames) {
            if (maxGapFrames < 0) {
                throw new IllegalArgumentException("Invalid max gap: " + maxGapFrames);
            }
            this.zzaVo.zzaVn = maxGapFrames;
            return this;
        }
    }

    public interface Factory<T> {
        Tracker<T> create(T t);
    }

    private class zza<T> {
        private Tracker<T> zzaVa;
        private int zzaVp;
        final /* synthetic */ MultiProcessor zzaVq;

        private zza(MultiProcessor multiProcessor) {
            this.zzaVq = multiProcessor;
            this.zzaVp = 0;
        }
    }

    private MultiProcessor() {
        this.zzaVm = new SparseArray();
        this.zzaVn = 3;
    }

    private void zza(Detections<T> detections) {
        SparseArray detectedItems = detections.getDetectedItems();
        for (int i = 0; i < detectedItems.size(); i++) {
            int keyAt = detectedItems.keyAt(i);
            Object valueAt = detectedItems.valueAt(i);
            if (this.zzaVm.get(keyAt) == null) {
                zza com_google_android_gms_vision_MultiProcessor_zza = new zza();
                com_google_android_gms_vision_MultiProcessor_zza.zzaVa = this.zzaVl.create(valueAt);
                com_google_android_gms_vision_MultiProcessor_zza.zzaVa.onNewItem(keyAt, valueAt);
                this.zzaVm.append(keyAt, com_google_android_gms_vision_MultiProcessor_zza);
            }
        }
    }

    private void zzb(Detections<T> detections) {
        SparseArray detectedItems = detections.getDetectedItems();
        Set<Integer> hashSet = new HashSet();
        for (int i = 0; i < this.zzaVm.size(); i++) {
            int keyAt = this.zzaVm.keyAt(i);
            if (detectedItems.get(keyAt) == null) {
                zza com_google_android_gms_vision_MultiProcessor_zza = (zza) this.zzaVm.valueAt(i);
                com_google_android_gms_vision_MultiProcessor_zza.zzaVp = com_google_android_gms_vision_MultiProcessor_zza.zzaVp + 1;
                if (com_google_android_gms_vision_MultiProcessor_zza.zzaVp == this.zzaVn) {
                    com_google_android_gms_vision_MultiProcessor_zza.zzaVa.onDone();
                    hashSet.add(Integer.valueOf(keyAt));
                }
            }
        }
        for (Integer intValue : hashSet) {
            this.zzaVm.delete(intValue.intValue());
        }
    }

    private void zzc(Detections<T> detections) {
        SparseArray detectedItems = detections.getDetectedItems();
        for (int i = 0; i < detectedItems.size(); i++) {
            int keyAt = detectedItems.keyAt(i);
            ((zza) this.zzaVm.get(keyAt)).zzaVa.onUpdate(detections, detectedItems.valueAt(i));
        }
    }

    public void receiveDetections(Detections<T> detections) {
        zza(detections);
        zzb(detections);
        zzc(detections);
    }

    public void release() {
        for (int i = 0; i < this.zzaVm.size(); i++) {
            ((zza) this.zzaVm.valueAt(i)).zzaVa.onDone();
        }
        this.zzaVm.clear();
    }
}
