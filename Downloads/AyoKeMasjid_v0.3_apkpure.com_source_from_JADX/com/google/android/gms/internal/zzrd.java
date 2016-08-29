package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.dynamic.zzc;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public interface zzrd extends IInterface {

    public static abstract class zza extends Binder implements zzrd {

        private static class zza implements zzrd {
            private IBinder zznI;

            zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public zzra zza(zzd com_google_android_gms_dynamic_zzd, zzc com_google_android_gms_dynamic_zzc, WalletFragmentOptions walletFragmentOptions, zzrb com_google_android_gms_internal_zzrb) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    obtain.writeStrongBinder(com_google_android_gms_dynamic_zzd != null ? com_google_android_gms_dynamic_zzd.asBinder() : null);
                    obtain.writeStrongBinder(com_google_android_gms_dynamic_zzc != null ? com_google_android_gms_dynamic_zzc.asBinder() : null);
                    if (walletFragmentOptions != null) {
                        obtain.writeInt(1);
                        walletFragmentOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzrb != null) {
                        iBinder = com_google_android_gms_internal_zzrb.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    zzra zzdP = com.google.android.gms.internal.zzra.zza.zzdP(obtain2.readStrongBinder());
                    return zzdP;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzrd zzdS(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzrd)) ? new zza(iBinder) : (zzrd) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    zzra zza = zza(com.google.android.gms.dynamic.zzd.zza.zzbk(data.readStrongBinder()), com.google.android.gms.dynamic.zzc.zza.zzbj(data.readStrongBinder()), data.readInt() != 0 ? (WalletFragmentOptions) WalletFragmentOptions.CREATOR.createFromParcel(data) : null, com.google.android.gms.internal.zzrb.zza.zzdQ(data.readStrongBinder()));
                    reply.writeNoException();
                    if (zza != null) {
                        iBinder = zza.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    zzra zza(zzd com_google_android_gms_dynamic_zzd, zzc com_google_android_gms_dynamic_zzc, WalletFragmentOptions walletFragmentOptions, zzrb com_google_android_gms_internal_zzrb) throws RemoteException;
}
