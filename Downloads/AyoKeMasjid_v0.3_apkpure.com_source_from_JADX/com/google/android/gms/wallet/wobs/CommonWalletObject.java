package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzli;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class CommonWalletObject implements SafeParcelable {
    public static final Creator<CommonWalletObject> CREATOR;
    private final int mVersionCode;
    String name;
    int state;
    String zzaWJ;
    String zzaWL;
    String zzaWM;
    String zzaWN;
    String zzaWO;
    String zzaWP;
    ArrayList<WalletObjectMessage> zzaWQ;
    TimeInterval zzaWR;
    ArrayList<LatLng> zzaWS;
    String zzaWT;
    String zzaWU;
    ArrayList<LabelValueRow> zzaWV;
    boolean zzaWW;
    ArrayList<UriData> zzaWX;
    ArrayList<TextModuleData> zzaWY;
    ArrayList<UriData> zzaWZ;
    String zzhL;

    public final class zza {
        final /* synthetic */ CommonWalletObject zzaYu;

        private zza(CommonWalletObject commonWalletObject) {
            this.zzaYu = commonWalletObject;
        }

        public CommonWalletObject zzCo() {
            return this.zzaYu;
        }

        public zza zzfu(String str) {
            this.zzaYu.zzhL = str;
            return this;
        }
    }

    static {
        CREATOR = new zza();
    }

    CommonWalletObject() {
        this.mVersionCode = 1;
        this.zzaWQ = zzli.zzpM();
        this.zzaWS = zzli.zzpM();
        this.zzaWV = zzli.zzpM();
        this.zzaWX = zzli.zzpM();
        this.zzaWY = zzli.zzpM();
        this.zzaWZ = zzli.zzpM();
    }

    CommonWalletObject(int versionCode, String id, String classId, String name, String issuerName, String barcodeAlternateText, String barcodeType, String barcodeValue, String barcodeLabel, int state, ArrayList<WalletObjectMessage> messages, TimeInterval validTimeInterval, ArrayList<LatLng> locations, String infoModuleDataHexFontColor, String infoModuleDataHexBackgroundColor, ArrayList<LabelValueRow> infoModuleDataLabelValueRows, boolean infoModuleDataShowLastUpdateTime, ArrayList<UriData> imageModuleDataMainImageUris, ArrayList<TextModuleData> textModulesData, ArrayList<UriData> linksModuleDataUris) {
        this.mVersionCode = versionCode;
        this.zzhL = id;
        this.zzaWP = classId;
        this.name = name;
        this.zzaWJ = issuerName;
        this.zzaWL = barcodeAlternateText;
        this.zzaWM = barcodeType;
        this.zzaWN = barcodeValue;
        this.zzaWO = barcodeLabel;
        this.state = state;
        this.zzaWQ = messages;
        this.zzaWR = validTimeInterval;
        this.zzaWS = locations;
        this.zzaWT = infoModuleDataHexFontColor;
        this.zzaWU = infoModuleDataHexBackgroundColor;
        this.zzaWV = infoModuleDataLabelValueRows;
        this.zzaWW = infoModuleDataShowLastUpdateTime;
        this.zzaWX = imageModuleDataMainImageUris;
        this.zzaWY = textModulesData;
        this.zzaWZ = linksModuleDataUris;
    }

    public static zza zzCn() {
        CommonWalletObject commonWalletObject = new CommonWalletObject();
        commonWalletObject.getClass();
        return new zza(null);
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzhL;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }
}
