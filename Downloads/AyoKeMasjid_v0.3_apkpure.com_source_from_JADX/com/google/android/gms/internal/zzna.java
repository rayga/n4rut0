package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.SensorRegistrationRequest;
import com.google.android.gms.fitness.request.SensorUnregistrationRequest;

public interface zzna extends IInterface {

    public static abstract class zza extends Binder implements zzna {

        private static class zza implements zzna {
            private IBinder zznI;

            zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void zza(DataSourcesRequest dataSourcesRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (dataSourcesRequest != null) {
                        obtain.writeInt(1);
                        dataSourcesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(SensorRegistrationRequest sensorRegistrationRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (sensorRegistrationRequest != null) {
                        obtain.writeInt(1);
                        sensorRegistrationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(SensorUnregistrationRequest sensorUnregistrationRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (sensorUnregistrationRequest != null) {
                        obtain.writeInt(1);
                        sensorUnregistrationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzna zzbC(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzna)) ? new zza(iBinder) : (zzna) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            SensorUnregistrationRequest sensorUnregistrationRequest = null;
            switch (code) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    DataSourcesRequest dataSourcesRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (data.readInt() != 0) {
                        dataSourcesRequest = (DataSourcesRequest) DataSourcesRequest.CREATOR.createFromParcel(data);
                    }
                    zza(dataSourcesRequest);
                    return true;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    SensorRegistrationRequest sensorRegistrationRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (data.readInt() != 0) {
                        sensorRegistrationRequest = (SensorRegistrationRequest) SensorRegistrationRequest.CREATOR.createFromParcel(data);
                    }
                    zza(sensorRegistrationRequest);
                    return true;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    if (data.readInt() != 0) {
                        sensorUnregistrationRequest = (SensorUnregistrationRequest) SensorUnregistrationRequest.CREATOR.createFromParcel(data);
                    }
                    zza(sensorUnregistrationRequest);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(DataSourcesRequest dataSourcesRequest) throws RemoteException;

    void zza(SensorRegistrationRequest sensorRegistrationRequest) throws RemoteException;

    void zza(SensorUnregistrationRequest sensorUnregistrationRequest) throws RemoteException;
}
