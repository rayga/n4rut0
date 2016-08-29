package com.google.android.gms.gcm;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.iid.InstanceID;
import java.io.IOException;
import java.util.regex.Pattern;

public class GcmPubSub {
    private static GcmPubSub zzazJ;
    private static final Pattern zzazL;
    private InstanceID zzazK;

    static {
        zzazL = Pattern.compile("/topics/[a-zA-Z0-9-_.~%]{1,900}");
    }

    private GcmPubSub(Context context) {
        this.zzazK = InstanceID.getInstance(context);
    }

    public static synchronized GcmPubSub getInstance(Context context) {
        GcmPubSub gcmPubSub;
        synchronized (GcmPubSub.class) {
            if (zzazJ == null) {
                zzazJ = new GcmPubSub(context);
            }
            gcmPubSub = zzazJ;
        }
        return gcmPubSub;
    }

    public void subscribe(String registrationToken, String topic, Bundle extras) throws IOException {
        if (registrationToken == null || registrationToken.isEmpty()) {
            throw new IllegalArgumentException("Invalid appInstanceToken: " + registrationToken);
        } else if (topic == null || !zzazL.matcher(topic).matches()) {
            throw new IllegalArgumentException("Invalid topic name: " + topic);
        } else {
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putString("gcm.topic", topic);
            this.zzazK.getToken(registrationToken, topic, extras);
        }
    }

    public void unsubscribe(String registrationToken, String topic) throws IOException {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", topic);
        this.zzazK.zzb(registrationToken, topic, bundle);
    }
}
