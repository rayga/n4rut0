package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountChangeEventsRequest implements SafeParcelable {
    public static final Creator<AccountChangeEventsRequest> CREATOR;
    final int mVersion;
    Account zzOY;
    @Deprecated
    String zzQE;
    int zzQG;

    static {
        CREATOR = new zzb();
    }

    public AccountChangeEventsRequest() {
        this.mVersion = 1;
    }

    AccountChangeEventsRequest(int version, int eventIndex, String accountName, Account account) {
        this.mVersion = version;
        this.zzQG = eventIndex;
        this.zzQE = accountName;
        if (account != null || TextUtils.isEmpty(accountName)) {
            this.zzOY = account;
        } else {
            this.zzOY = new Account(accountName, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
        }
    }

    public int describeContents() {
        return 0;
    }

    public Account getAccount() {
        return this.zzOY;
    }

    public String getAccountName() {
        return this.zzQE;
    }

    public int getEventIndex() {
        return this.zzQG;
    }

    public AccountChangeEventsRequest setAccount(Account account) {
        this.zzOY = account;
        return this;
    }

    public AccountChangeEventsRequest setAccountName(String accountName) {
        this.zzQE = accountName;
        return this;
    }

    public AccountChangeEventsRequest setEventIndex(int eventIndex) {
        this.zzQG = eventIndex;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }
}
