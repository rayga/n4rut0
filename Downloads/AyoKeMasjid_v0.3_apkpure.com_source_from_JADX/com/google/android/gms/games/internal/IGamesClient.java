package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.places.Place;

public interface IGamesClient extends IInterface {

    public static abstract class Stub extends Binder implements IGamesClient {

        private static class Proxy implements IGamesClient {
            private IBinder zznI;

            Proxy(IBinder remote) {
                this.zznI = remote;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public PopupLocationInfoParcelable zztC() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesClient");
                    this.zznI.transact(Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_1, obtain, obtain2, 0);
                    obtain2.readException();
                    PopupLocationInfoParcelable zzdO = obtain2.readInt() != 0 ? PopupLocationInfoParcelable.CREATOR.zzdO(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return zzdO;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IGamesClient");
        }

        public static IGamesClient zzbP(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesClient");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGamesClient)) ? new Proxy(iBinder) : (IGamesClient) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_1 /*1001*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesClient");
                    PopupLocationInfoParcelable zztC = zztC();
                    reply.writeNoException();
                    if (zztC != null) {
                        reply.writeInt(1);
                        zztC.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.games.internal.IGamesClient");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    PopupLocationInfoParcelable zztC() throws RemoteException;
}
