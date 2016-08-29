package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.internal.MessageType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bpmikc.akm.BuildConfig;

public class MessageFilter implements SafeParcelable {
    public static final Creator<MessageFilter> CREATOR;
    public static final MessageFilter INCLUDE_ALL_MY_TYPES;
    final int versionCode;
    private final List<MessageType> zzaJI;

    public static final class Builder {
        private final List<MessageType> zzaJI;

        public Builder() {
            this.zzaJI = new ArrayList();
        }

        private Builder zzE(String str, String str2) {
            this.zzaJI.add(new MessageType(str, str2));
            return this;
        }

        public MessageFilter build() {
            zzx.zza(!this.zzaJI.isEmpty(), (Object) "At least one of the include methods must be called.");
            return new MessageFilter(null);
        }

        public Builder includeAllMyTypes() {
            return zzE(BuildConfig.FLAVOR, BuildConfig.FLAVOR);
        }

        public Builder includeFilter(MessageFilter filter) {
            this.zzaJI.addAll(filter.zzyo());
            return this;
        }

        public Builder includeNamespacedType(String namespace, String type) {
            return zzE(namespace, type);
        }
    }

    static {
        CREATOR = new zzb();
        INCLUDE_ALL_MY_TYPES = new Builder().includeAllMyTypes().build();
    }

    MessageFilter(int versionCode, List<MessageType> messageTypes) {
        this.versionCode = versionCode;
        this.zzaJI = Collections.unmodifiableList((List) zzx.zzv(messageTypes));
    }

    private MessageFilter(List<MessageType> messageTypes) {
        this(1, (List) messageTypes);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MessageFilter)) {
            return false;
        }
        return zzw.equal(this.zzaJI, ((MessageFilter) o).zzaJI);
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaJI);
    }

    public String toString() {
        return "MessageFilter" + this.zzaJI;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }

    List<MessageType> zzyo() {
        return this.zzaJI;
    }
}
