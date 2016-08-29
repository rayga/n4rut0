package com.bumptech.glide;

import com.android.volley.DefaultRetryPolicy;

public enum MemoryCategory {
    LOW(0.5f),
    NORMAL(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT),
    HIGH(1.5f);
    
    private float multiplier;

    private MemoryCategory(float multiplier) {
        this.multiplier = multiplier;
    }

    public float getMultiplier() {
        return this.multiplier;
    }
}
