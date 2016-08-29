package com.google.android.gms.iid;

import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public class MessengerCompat implements Parcelable {
    public static final Creator<MessengerCompat> CREATOR;
    Messenger zzaBc;
    zzb zzaBd;

    /* renamed from: com.google.android.gms.iid.MessengerCompat.1 */
    static class C03181 implements Creator<MessengerCompat> {
        C03181() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzen(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return zzgA(x0);
        }

        public MessengerCompat zzen(Parcel parcel) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            return readStrongBinder != null ? new MessengerCompat(readStrongBinder) : null;
        }

        public MessengerCompat[] zzgA(int i) {
            return new MessengerCompat[i];
        }
    }

    private final class zza extends com.google.android.gms.iid.zzb.zza {
        Handler handler;
        final /* synthetic */ MessengerCompat zzaBe;

        zza(MessengerCompat messengerCompat, Handler handler) {
            this.zzaBe = messengerCompat;
            this.handler = handler;
        }

        public void send(Message msg) throws RemoteException {
            msg.arg2 = Binder.getCallingUid();
            this.handler.dispatchMessage(msg);
        }
    }

    static {
        CREATOR = new C03181();
    }

    public MessengerCompat(Handler handler) {
        if (VERSION.SDK_INT >= 21) {
            this.zzaBc = new Messenger(handler);
        } else {
            this.zzaBd = new zza(this, handler);
        }
    }

    public MessengerCompat(IBinder target) {
        if (VERSION.SDK_INT >= 21) {
            this.zzaBc = new Messenger(target);
        } else {
            this.zzaBd = com.google.android.gms.iid.zzb.zza.zzbV(target);
        }
    }

    public static int zzc(Message message) {
        return VERSION.SDK_INT >= 21 ? zzd(message) : message.arg2;
    }

    private static int zzd(Message message) {
        return message.sendingUid;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object otherObj) {
        boolean z = false;
        if (otherObj != null) {
            try {
                z = getBinder().equals(((MessengerCompat) otherObj).getBinder());
            } catch (ClassCastException e) {
            }
        }
        return z;
    }

    public IBinder getBinder() {
        return this.zzaBc != null ? this.zzaBc.getBinder() : this.zzaBd.asBinder();
    }

    public int hashCode() {
        return getBinder().hashCode();
    }

    public void send(Message message) throws RemoteException {
        if (this.zzaBc != null) {
            this.zzaBc.send(message);
        } else {
            this.zzaBd.send(message);
        }
    }

    public void writeToParcel(Parcel out, int flags) {
        if (this.zzaBc != null) {
            out.writeStrongBinder(this.zzaBc.getBinder());
        } else {
            out.writeStrongBinder(this.zzaBd.asBinder());
        }
    }
}
