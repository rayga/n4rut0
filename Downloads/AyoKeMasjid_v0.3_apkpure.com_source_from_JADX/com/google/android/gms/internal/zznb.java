package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.SessionRegistrationRequest;
import com.google.android.gms.fitness.request.SessionStartRequest;
import com.google.android.gms.fitness.request.SessionStopRequest;
import com.google.android.gms.fitness.request.SessionUnregistrationRequest;
import com.google.android.gms.vision.barcode.Barcode;

public interface zznb extends IInterface {

    public static abstract class zza extends Binder implements zznb {

        private static class zza implements zznb {
            private IBinder zznI;

            zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void zza(SessionInsertRequest sessionInsertRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (sessionInsertRequest != null) {
                        obtain.writeInt(1);
                        sessionInsertRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(SessionReadRequest sessionReadRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (sessionReadRequest != null) {
                        obtain.writeInt(1);
                        sessionReadRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(SessionRegistrationRequest sessionRegistrationRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (sessionRegistrationRequest != null) {
                        obtain.writeInt(1);
                        sessionRegistrationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(SessionStartRequest sessionStartRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (sessionStartRequest != null) {
                        obtain.writeInt(1);
                        sessionStartRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(SessionStopRequest sessionStopRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (sessionStopRequest != null) {
                        obtain.writeInt(1);
                        sessionStopRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(SessionUnregistrationRequest sessionUnregistrationRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (sessionUnregistrationRequest != null) {
                        obtain.writeInt(1);
                        sessionUnregistrationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zznb zzbD(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zznb)) ? new zza(iBinder) : (zznb) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            SessionUnregistrationRequest sessionUnregistrationRequest = null;
            switch (code) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    SessionStartRequest sessionStartRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (data.readInt() != 0) {
                        sessionStartRequest = (SessionStartRequest) SessionStartRequest.CREATOR.createFromParcel(data);
                    }
                    zza(sessionStartRequest);
                    return true;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    SessionStopRequest sessionStopRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (data.readInt() != 0) {
                        sessionStopRequest = (SessionStopRequest) SessionStopRequest.CREATOR.createFromParcel(data);
                    }
                    zza(sessionStopRequest);
                    return true;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    SessionInsertRequest sessionInsertRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (data.readInt() != 0) {
                        sessionInsertRequest = (SessionInsertRequest) SessionInsertRequest.CREATOR.createFromParcel(data);
                    }
                    zza(sessionInsertRequest);
                    return true;
                case Barcode.PHONE /*4*/:
                    SessionReadRequest sessionReadRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (data.readInt() != 0) {
                        sessionReadRequest = (SessionReadRequest) SessionReadRequest.CREATOR.createFromParcel(data);
                    }
                    zza(sessionReadRequest);
                    return true;
                case Barcode.PRODUCT /*5*/:
                    SessionRegistrationRequest sessionRegistrationRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (data.readInt() != 0) {
                        sessionRegistrationRequest = (SessionRegistrationRequest) SessionRegistrationRequest.CREATOR.createFromParcel(data);
                    }
                    zza(sessionRegistrationRequest);
                    return true;
                case Barcode.SMS /*6*/:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (data.readInt() != 0) {
                        sessionUnregistrationRequest = (SessionUnregistrationRequest) SessionUnregistrationRequest.CREATOR.createFromParcel(data);
                    }
                    zza(sessionUnregistrationRequest);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(SessionInsertRequest sessionInsertRequest) throws RemoteException;

    void zza(SessionReadRequest sessionReadRequest) throws RemoteException;

    void zza(SessionRegistrationRequest sessionRegistrationRequest) throws RemoteException;

    void zza(SessionStartRequest sessionStartRequest) throws RemoteException;

    void zza(SessionStopRequest sessionStopRequest) throws RemoteException;

    void zza(SessionUnregistrationRequest sessionUnregistrationRequest) throws RemoteException;
}
