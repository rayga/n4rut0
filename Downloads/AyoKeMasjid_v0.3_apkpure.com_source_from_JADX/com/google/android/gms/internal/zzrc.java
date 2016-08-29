package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.wallet.CreateWalletObjectsRequest;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.firstparty.GetBuyFlowInitializationTokenRequest;
import com.google.android.gms.wallet.firstparty.GetInstrumentsRequest;

public interface zzrc extends IInterface {

    public static abstract class zza extends Binder implements zzrc {

        private static class zza implements zzrc {
            private IBinder zznI;

            zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void zzB(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(9, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzC(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(10, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(Bundle bundle, zzrf com_google_android_gms_internal_zzrf) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzrf != null) {
                        iBinder = com_google_android_gms_internal_zzrf.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(CreateWalletObjectsRequest createWalletObjectsRequest, Bundle bundle, zzrf com_google_android_gms_internal_zzrf) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (createWalletObjectsRequest != null) {
                        obtain.writeInt(1);
                        createWalletObjectsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzrf != null) {
                        iBinder = com_google_android_gms_internal_zzrf.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(FullWalletRequest fullWalletRequest, Bundle bundle, zzrf com_google_android_gms_internal_zzrf) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (fullWalletRequest != null) {
                        obtain.writeInt(1);
                        fullWalletRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzrf != null) {
                        iBinder = com_google_android_gms_internal_zzrf.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(MaskedWalletRequest maskedWalletRequest, Bundle bundle, zzre com_google_android_gms_internal_zzre) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (maskedWalletRequest != null) {
                        obtain.writeInt(1);
                        maskedWalletRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzre != null) {
                        iBinder = com_google_android_gms_internal_zzre.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(MaskedWalletRequest maskedWalletRequest, Bundle bundle, zzrf com_google_android_gms_internal_zzrf) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (maskedWalletRequest != null) {
                        obtain.writeInt(1);
                        maskedWalletRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzrf != null) {
                        iBinder = com_google_android_gms_internal_zzrf.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (notifyTransactionStatusRequest != null) {
                        obtain.writeInt(1);
                        notifyTransactionStatusRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(GetBuyFlowInitializationTokenRequest getBuyFlowInitializationTokenRequest, Bundle bundle, zzrf com_google_android_gms_internal_zzrf) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (getBuyFlowInitializationTokenRequest != null) {
                        obtain.writeInt(1);
                        getBuyFlowInitializationTokenRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzrf != null) {
                        iBinder = com_google_android_gms_internal_zzrf.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(12, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(GetInstrumentsRequest getInstrumentsRequest, Bundle bundle, zzrf com_google_android_gms_internal_zzrf) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (getInstrumentsRequest != null) {
                        obtain.writeInt(1);
                        getInstrumentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzrf != null) {
                        iBinder = com_google_android_gms_internal_zzrf.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(String str, String str2, Bundle bundle, zzrf com_google_android_gms_internal_zzrf) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzrf != null) {
                        iBinder = com_google_android_gms_internal_zzrf.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzb(Bundle bundle, zzrf com_google_android_gms_internal_zzrf) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzrf != null) {
                        iBinder = com_google_android_gms_internal_zzrf.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(11, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzrc zzdR(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IOwService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzrc)) ? new zza(iBinder) : (zzrc) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(data.readInt() != 0 ? (MaskedWalletRequest) MaskedWalletRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, com.google.android.gms.internal.zzrf.zza.zzdU(data.readStrongBinder()));
                    return true;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(data.readInt() != 0 ? (FullWalletRequest) FullWalletRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, com.google.android.gms.internal.zzrf.zza.zzdU(data.readStrongBinder()));
                    return true;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(data.readString(), data.readString(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, com.google.android.gms.internal.zzrf.zza.zzdU(data.readStrongBinder()));
                    return true;
                case Barcode.PHONE /*4*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(data.readInt() != 0 ? (NotifyTransactionStatusRequest) NotifyTransactionStatusRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    return true;
                case Barcode.PRODUCT /*5*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, com.google.android.gms.internal.zzrf.zza.zzdU(data.readStrongBinder()));
                    return true;
                case Barcode.SMS /*6*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(data.readInt() != 0 ? (CreateWalletObjectsRequest) CreateWalletObjectsRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, com.google.android.gms.internal.zzrf.zza.zzdU(data.readStrongBinder()));
                    return true;
                case Barcode.TEXT /*7*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(data.readInt() != 0 ? (MaskedWalletRequest) MaskedWalletRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, com.google.android.gms.internal.zzre.zza.zzdT(data.readStrongBinder()));
                    return true;
                case Barcode.URL /*8*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(data.readInt() != 0 ? (GetInstrumentsRequest) GetInstrumentsRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, com.google.android.gms.internal.zzrf.zza.zzdU(data.readStrongBinder()));
                    return true;
                case Barcode.WIFI /*9*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zzB(data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    return true;
                case Barcode.GEO /*10*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zzC(data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    return true;
                case Barcode.CALENDAR_EVENT /*11*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zzb(data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, com.google.android.gms.internal.zzrf.zza.zzdU(data.readStrongBinder()));
                    return true;
                case Barcode.DRIVER_LICENSE /*12*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(data.readInt() != 0 ? (GetBuyFlowInitializationTokenRequest) GetBuyFlowInitializationTokenRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, com.google.android.gms.internal.zzrf.zza.zzdU(data.readStrongBinder()));
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wallet.internal.IOwService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zzB(Bundle bundle) throws RemoteException;

    void zzC(Bundle bundle) throws RemoteException;

    void zza(Bundle bundle, zzrf com_google_android_gms_internal_zzrf) throws RemoteException;

    void zza(CreateWalletObjectsRequest createWalletObjectsRequest, Bundle bundle, zzrf com_google_android_gms_internal_zzrf) throws RemoteException;

    void zza(FullWalletRequest fullWalletRequest, Bundle bundle, zzrf com_google_android_gms_internal_zzrf) throws RemoteException;

    void zza(MaskedWalletRequest maskedWalletRequest, Bundle bundle, zzre com_google_android_gms_internal_zzre) throws RemoteException;

    void zza(MaskedWalletRequest maskedWalletRequest, Bundle bundle, zzrf com_google_android_gms_internal_zzrf) throws RemoteException;

    void zza(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Bundle bundle) throws RemoteException;

    void zza(GetBuyFlowInitializationTokenRequest getBuyFlowInitializationTokenRequest, Bundle bundle, zzrf com_google_android_gms_internal_zzrf) throws RemoteException;

    void zza(GetInstrumentsRequest getInstrumentsRequest, Bundle bundle, zzrf com_google_android_gms_internal_zzrf) throws RemoteException;

    void zza(String str, String str2, Bundle bundle, zzrf com_google_android_gms_internal_zzrf) throws RemoteException;

    void zzb(Bundle bundle, zzrf com_google_android_gms_internal_zzrf) throws RemoteException;
}
