package com.google.android.gms.wearable;

import java.io.IOException;

public class ChannelIOException extends IOException {
    private final int zzaYM;
    private final int zzaYN;

    public ChannelIOException(String message, int closeReason, int appSpecificErrorCode) {
        super(message);
        this.zzaYM = closeReason;
        this.zzaYN = appSpecificErrorCode;
    }

    public int getAppSpecificErrorCode() {
        return this.zzaYN;
    }

    public int getCloseReason() {
        return this.zzaYM;
    }
}
