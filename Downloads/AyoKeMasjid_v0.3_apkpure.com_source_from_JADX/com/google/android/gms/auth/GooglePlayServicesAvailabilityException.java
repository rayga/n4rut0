package com.google.android.gms.auth;

import android.content.Intent;

public class GooglePlayServicesAvailabilityException extends UserRecoverableAuthException {
    private final int zzQK;

    GooglePlayServicesAvailabilityException(int connectionStatusCode, String msg, Intent intent) {
        super(msg, intent);
        this.zzQK = connectionStatusCode;
    }

    public int getConnectionStatusCode() {
        return this.zzQK;
    }
}
