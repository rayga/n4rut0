package com.google.android.gms.vision.face;

import android.graphics.PointF;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.toolbox.ImageRequest;
import java.util.Arrays;
import java.util.List;

public class Face {
    public static final float UNCOMPUTED_PROBABILITY = -1.0f;
    private int mId;
    private float zzaHe;
    private float zzaHf;
    private float zzaVA;
    private float zzaVB;
    private float zzaVC;
    private PointF zzaVw;
    private float zzaVx;
    private float zzaVy;
    private List<Landmark> zzaVz;

    public Face(int id, PointF position, float width, float height, float yawDegrees, float rollDegrees, Landmark[] landmarks, float isLeftEyeOpenScore, float isRightEyeOpenScore, float isSmilingScore) {
        this.mId = id;
        this.zzaVw = position;
        this.zzaHe = width;
        this.zzaHf = height;
        this.zzaVx = yawDegrees;
        this.zzaVy = rollDegrees;
        this.zzaVz = Arrays.asList(landmarks);
        if (isLeftEyeOpenScore < 0.0f || isLeftEyeOpenScore > DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
            this.zzaVA = UNCOMPUTED_PROBABILITY;
        } else {
            this.zzaVA = isLeftEyeOpenScore;
        }
        if (isRightEyeOpenScore < 0.0f || isRightEyeOpenScore > DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
            this.zzaVB = UNCOMPUTED_PROBABILITY;
        } else {
            this.zzaVB = isRightEyeOpenScore;
        }
        if (this.zzaVC < 0.0f || this.zzaVC > DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
            this.zzaVC = UNCOMPUTED_PROBABILITY;
        } else {
            this.zzaVC = isSmilingScore;
        }
    }

    public float getEulerY() {
        return this.zzaVx;
    }

    public float getEulerZ() {
        return this.zzaVy;
    }

    public float getHeight() {
        return this.zzaHf;
    }

    public int getId() {
        return this.mId;
    }

    public float getIsLeftEyeOpenProbability() {
        return this.zzaVA;
    }

    public float getIsRightEyeOpenProbability() {
        return this.zzaVB;
    }

    public float getIsSmilingProbability() {
        return this.zzaVC;
    }

    public List<Landmark> getLandmarks() {
        return this.zzaVz;
    }

    public PointF getPosition() {
        return new PointF(this.zzaVw.x - (this.zzaHe / ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT), this.zzaVw.y - (this.zzaHf / ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT));
    }

    public float getWidth() {
        return this.zzaHe;
    }
}
