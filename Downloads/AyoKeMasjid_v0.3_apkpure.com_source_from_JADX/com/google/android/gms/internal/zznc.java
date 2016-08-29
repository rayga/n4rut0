package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

public interface zznc extends IInterface {

    public static abstract class zza extends Binder implements zznc {

        private static class zza implements zznc {
            private IBinder zznI;

            zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void zza(ListSubscriptionsResult listSubscriptionsResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
                    if (listSubscriptionsResult != null) {
                        obtain.writeInt(1);
                        listSubscriptionsResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
        }

        public static zznc zzbE(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zznc)) ? new zza(iBinder) : (zznc) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
                    zza(data.readInt() != 0 ? (ListSubscriptionsResult) ListSubscriptionsResult.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(ListSubscriptionsResult listSubscriptionsResult) throws RemoteException;
}
