package com.google.android.gms.vision;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.vision.Detector.Detections;
import com.google.android.gms.vision.Detector.Processor;

public abstract class FocusingProcessor<T> implements Processor<T> {
    private Detector<T> zzaUK;
    private Tracker<T> zzaVa;
    private boolean zzaVb;
    private int zzaVc;

    public FocusingProcessor(Detector<T> detector, Tracker<T> tracker) {
        this.zzaVb = false;
        this.zzaUK = detector;
        this.zzaVa = tracker;
    }

    public void receiveDetections(Detections<T> detections) {
        SparseArray detectedItems = detections.getDetectedItems();
        if (detectedItems.size() == 0) {
            this.zzaVa.onMissing(detections);
            return;
        }
        if (this.zzaVb) {
            Object obj = detectedItems.get(this.zzaVc);
            if (obj != null) {
                this.zzaVa.onUpdate(detections, obj);
                return;
            } else {
                this.zzaVa.onDone();
                this.zzaVb = false;
            }
        }
        int selectFocus = selectFocus(detections);
        Object obj2 = detectedItems.get(selectFocus);
        if (obj2 == null) {
            Log.w("FocusingProcessor", "Invalid focus selected: " + selectFocus);
            return;
        }
        this.zzaVb = true;
        this.zzaVc = selectFocus;
        this.zzaUK.setFocus(this.zzaVc);
        this.zzaVa.onNewItem(this.zzaVc, obj2);
        this.zzaVa.onUpdate(detections, obj2);
    }

    public void release() {
        this.zzaVa.onDone();
    }

    public abstract int selectFocus(Detections<T> detections);
}
