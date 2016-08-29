package com.google.android.gms.internal;

import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Status;

class zzkb implements ProxyResult {
    private Status zzQA;
    private ProxyResponse zzRN;

    public zzkb(ProxyResponse proxyResponse) {
        this.zzRN = proxyResponse;
        this.zzQA = Status.zzaaD;
    }

    public zzkb(Status status) {
        this.zzQA = status;
    }

    public ProxyResponse getResponse() {
        return this.zzRN;
    }

    public Status getStatus() {
        return this.zzQA;
    }
}
