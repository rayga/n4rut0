package com.google.android.gms.auth.api.credentials.internal;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.Status;

public final class zzb implements CredentialRequestResult {
    private final Status zzQA;
    private final Credential zzRx;

    public zzb(Status status, Credential credential) {
        this.zzQA = status;
        this.zzRx = credential;
    }

    public static zzb zzm(Status status) {
        return new zzb(status, null);
    }

    public Credential getCredential() {
        return this.zzRx;
    }

    public Status getStatus() {
        return this.zzQA;
    }
}
