package com.google.android.gms.safetynet;

import com.google.android.gms.common.api.CommonStatusCodes;

public final class SafetyNetStatusCodes extends CommonStatusCodes {
    public static final int SAFE_BROWSING_MISSING_API_KEY = 12001;
    public static final int SAFE_BROWSING_UNSUPPORTED_THREAT_TYPES = 12000;

    private SafetyNetStatusCodes() {
    }
}
