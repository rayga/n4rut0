package com.google.android.gms.appinvite;

import android.accounts.Account;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import java.util.Map;

public final class AppInviteInvitation {

    public static final class IntentBuilder {
        public static final int MAX_MESSAGE_LENGTH = 100;
        public static final int PROJECT_PLATFORM_IOS = 1;
        private final Intent mIntent;

        public IntentBuilder(CharSequence title) {
            zzx.zzv(title);
            this.mIntent = new Intent("com.google.android.gms.appinvite.ACTION_APP_INVITE");
            this.mIntent.putExtra("com.google.android.gms.appinvite.TITLE", title);
            this.mIntent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
        }

        public Intent build() {
            return this.mIntent;
        }

        public IntentBuilder setAccount(Account account) {
            if (account == null || !GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE.equals(account.type)) {
                this.mIntent.removeExtra("com.google.android.gms.appinvite.ACCOUNT_NAME");
            } else {
                this.mIntent.putExtra("com.google.android.gms.appinvite.ACCOUNT_NAME", account);
            }
            return this;
        }

        public IntentBuilder setAdditionalReferralParameters(Map<String, String> params) {
            if (params != null) {
                this.mIntent.putExtra("com.google.android.gms.appinvite.REFERRAL_PARAMETERS_URI", AppInviteInvitation.zzA(params));
            } else {
                this.mIntent.removeExtra("com.google.android.gms.appinvite.REFERRAL_PARAMETERS_URI");
            }
            return this;
        }

        public IntentBuilder setDeepLink(Uri deepLink) {
            if (deepLink != null) {
                this.mIntent.putExtra("com.google.android.gms.appinvite.DEEP_LINK_URL", deepLink);
            } else {
                this.mIntent.removeExtra("com.google.android.gms.appinvite.DEEP_LINK_URL");
            }
            return this;
        }

        public IntentBuilder setGoogleAnalyticsTrackingId(String trackingId) {
            this.mIntent.putExtra("com.google.android.gms.appinvite.GOOGLE_ANALYTICS_TRACKING_ID", trackingId);
            return this;
        }

        public IntentBuilder setMessage(CharSequence message) {
            if (message == null || message.length() <= MAX_MESSAGE_LENGTH) {
                this.mIntent.putExtra("com.google.android.gms.appinvite.MESSAGE", message);
                return this;
            }
            Object[] objArr = new Object[PROJECT_PLATFORM_IOS];
            objArr[0] = Integer.valueOf(MAX_MESSAGE_LENGTH);
            throw new IllegalArgumentException(String.format("Message must be %d chars or less.", objArr));
        }

        public IntentBuilder setOtherPlatformsTargetApplication(int targetPlatform, String clientId) {
            if (targetPlatform == PROJECT_PLATFORM_IOS) {
                this.mIntent.putExtra("com.google.android.gms.appinvite.iosTargetApplication", clientId);
            }
            return this;
        }
    }

    private AppInviteInvitation() {
    }

    public static String[] getInvitationIds(int resultCode, Intent result) {
        return resultCode == -1 ? result.getStringArrayExtra("com.google.android.gms.appinvite.RESULT_INVITATION_IDS") : null;
    }

    private static Bundle zzA(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            bundle.putString(str, (String) map.get(str));
        }
        return bundle;
    }
}
