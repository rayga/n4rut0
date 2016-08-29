package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzli;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.LabelValueRow;
import com.google.android.gms.wallet.wobs.LoyaltyPoints;
import com.google.android.gms.wallet.wobs.TextModuleData;
import com.google.android.gms.wallet.wobs.TimeInterval;
import com.google.android.gms.wallet.wobs.UriData;
import com.google.android.gms.wallet.wobs.WalletObjectMessage;
import java.util.ArrayList;

public final class LoyaltyWalletObject implements SafeParcelable {
    public static final Creator<LoyaltyWalletObject> CREATOR;
    private final int mVersionCode;
    int state;
    String zzaFb;
    String zzaWI;
    String zzaWJ;
    String zzaWK;
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
    LoyaltyPoints zzaXa;
    String zzhL;

    static {
        CREATOR = new zzj();
    }

    LoyaltyWalletObject() {
        this.mVersionCode = 4;
        this.zzaWQ = zzli.zzpM();
        this.zzaWS = zzli.zzpM();
        this.zzaWV = zzli.zzpM();
        this.zzaWX = zzli.zzpM();
        this.zzaWY = zzli.zzpM();
        this.zzaWZ = zzli.zzpM();
    }

    LoyaltyWalletObject(int versionCode, String id, String accountId, String issuerName, String programName, String accountName, String barcodeAlternateText, String barcodeType, String barcodeValue, String barcodeLabel, String classId, int state, ArrayList<WalletObjectMessage> messages, TimeInterval validTimeInterval, ArrayList<LatLng> locations, String infoModuleDataHexFontColor, String infoModuleDataHexBackgroundColor, ArrayList<LabelValueRow> infoModuleDataLabelValueRows, boolean infoModuleDataShowLastUpdateTime, ArrayList<UriData> imageModuleDataMainImageUris, ArrayList<TextModuleData> textModulesData, ArrayList<UriData> linksModuleDataUris, LoyaltyPoints loyaltyPoints) {
        this.mVersionCode = versionCode;
        this.zzhL = id;
        this.zzaWI = accountId;
        this.zzaWJ = issuerName;
        this.zzaWK = programName;
        this.zzaFb = accountName;
        this.zzaWL = barcodeAlternateText;
        this.zzaWM = barcodeType;
        this.zzaWN = barcodeValue;
        this.zzaWO = barcodeLabel;
        this.zzaWP = classId;
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
        this.zzaXa = loyaltyPoints;
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountId() {
        return this.zzaWI;
    }

    public String getAccountName() {
        return this.zzaFb;
    }

    public String getBarcodeAlternateText() {
        return this.zzaWL;
    }

    public String getBarcodeType() {
        return this.zzaWM;
    }

    public String getBarcodeValue() {
        return this.zzaWN;
    }

    public String getId() {
        return this.zzhL;
    }

    public String getIssuerName() {
        return this.zzaWJ;
    }

    public String getProgramName() {
        return this.zzaWK;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }
}
