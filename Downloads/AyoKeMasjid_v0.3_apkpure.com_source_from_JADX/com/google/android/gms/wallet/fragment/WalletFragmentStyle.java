package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.google.android.gms.C0197R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class WalletFragmentStyle implements SafeParcelable {
    public static final Creator<WalletFragmentStyle> CREATOR;
    final int mVersionCode;
    Bundle zzaYk;
    int zzaYl;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BuyButtonAppearance {
        public static final int GOOGLE_WALLET_CLASSIC = 1;
        public static final int GOOGLE_WALLET_GRAYSCALE = 2;
        public static final int GOOGLE_WALLET_MONOCHROME = 3;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BuyButtonText {
        public static final int BUY_WITH = 5;
        public static final int DONATE_WITH = 7;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Dimension {
        public static final int MATCH_PARENT = -1;
        public static final int UNIT_DIP = 1;
        public static final int UNIT_IN = 4;
        public static final int UNIT_MM = 5;
        public static final int UNIT_PT = 3;
        public static final int UNIT_PX = 0;
        public static final int UNIT_SP = 2;
        public static final int WRAP_CONTENT = -2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LogoImageType {
        public static final int GOOGLE_WALLET_CLASSIC = 1;
        public static final int GOOGLE_WALLET_MONOCHROME = 2;
    }

    static {
        CREATOR = new zzc();
    }

    public WalletFragmentStyle() {
        this.mVersionCode = 1;
        this.zzaYk = new Bundle();
    }

    WalletFragmentStyle(int versionCode, Bundle attributes, int styleResourceId) {
        this.mVersionCode = versionCode;
        this.zzaYk = attributes;
        this.zzaYl = styleResourceId;
    }

    private static int zza(long j, DisplayMetrics displayMetrics) {
        int i = (int) (j >>> 32);
        int i2 = (int) j;
        switch (i) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
                i = 0;
                break;
            case CompletionEvent.STATUS_FAILURE /*1*/:
                i = 1;
                break;
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                i = 2;
                break;
            case CompletionEvent.STATUS_CANCELED /*3*/:
                i = 3;
                break;
            case Barcode.PHONE /*4*/:
                i = 4;
                break;
            case Barcode.PRODUCT /*5*/:
                i = 5;
                break;
            case Barcode.ITF /*128*/:
                return TypedValue.complexToDimensionPixelSize(i2, displayMetrics);
            case 129:
                return i2;
            default:
                throw new IllegalStateException("Unexpected unit or type: " + i);
        }
        return Math.round(TypedValue.applyDimension(i, Float.intBitsToFloat(i2), displayMetrics));
    }

    private static long zza(int i, float f) {
        switch (i) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
            case CompletionEvent.STATUS_FAILURE /*1*/:
            case CompletionEvent.STATUS_CONFLICT /*2*/:
            case CompletionEvent.STATUS_CANCELED /*3*/:
            case Barcode.PHONE /*4*/:
            case Barcode.PRODUCT /*5*/:
                return zzu(i, Float.floatToIntBits(f));
            default:
                throw new IllegalArgumentException("Unrecognized unit: " + i);
        }
    }

    private static long zza(TypedValue typedValue) {
        switch (typedValue.type) {
            case Barcode.PRODUCT /*5*/:
                return zzu(Barcode.ITF, typedValue.data);
            case Barcode.DATA_MATRIX /*16*/:
                return zzkg(typedValue.data);
            default:
                throw new IllegalArgumentException("Unexpected dimension type: " + typedValue.type);
        }
    }

    private void zza(TypedArray typedArray, int i, String str) {
        if (!this.zzaYk.containsKey(str)) {
            TypedValue peekValue = typedArray.peekValue(i);
            if (peekValue != null) {
                this.zzaYk.putLong(str, zza(peekValue));
            }
        }
    }

    private void zza(TypedArray typedArray, int i, String str, String str2) {
        if (!this.zzaYk.containsKey(str) && !this.zzaYk.containsKey(str2)) {
            TypedValue peekValue = typedArray.peekValue(i);
            if (peekValue == null) {
                return;
            }
            if (peekValue.type < 28 || peekValue.type > 31) {
                this.zzaYk.putInt(str2, peekValue.resourceId);
            } else {
                this.zzaYk.putInt(str, peekValue.data);
            }
        }
    }

    private void zzb(TypedArray typedArray, int i, String str) {
        if (!this.zzaYk.containsKey(str)) {
            TypedValue peekValue = typedArray.peekValue(i);
            if (peekValue != null) {
                this.zzaYk.putInt(str, peekValue.data);
            }
        }
    }

    private static long zzkg(int i) {
        if (i >= 0) {
            return zza(0, (float) i);
        }
        if (i == -1 || i == -2) {
            return zzu(129, i);
        }
        throw new IllegalArgumentException("Unexpected dimension value: " + i);
    }

    private static long zzu(int i, int i2) {
        return (((long) i) << 32) | (((long) i2) & 4294967295L);
    }

    public int describeContents() {
        return 0;
    }

    public WalletFragmentStyle setBuyButtonAppearance(int buyButtonAppearance) {
        this.zzaYk.putInt("buyButtonAppearance", buyButtonAppearance);
        return this;
    }

    public WalletFragmentStyle setBuyButtonHeight(int height) {
        this.zzaYk.putLong("buyButtonHeight", zzkg(height));
        return this;
    }

    public WalletFragmentStyle setBuyButtonHeight(int unit, float height) {
        this.zzaYk.putLong("buyButtonHeight", zza(unit, height));
        return this;
    }

    public WalletFragmentStyle setBuyButtonText(int buyButtonText) {
        this.zzaYk.putInt("buyButtonText", buyButtonText);
        return this;
    }

    public WalletFragmentStyle setBuyButtonWidth(int width) {
        this.zzaYk.putLong("buyButtonWidth", zzkg(width));
        return this;
    }

    public WalletFragmentStyle setBuyButtonWidth(int unit, float width) {
        this.zzaYk.putLong("buyButtonWidth", zza(unit, width));
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsBackgroundColor(int color) {
        this.zzaYk.remove("maskedWalletDetailsBackgroundResource");
        this.zzaYk.putInt("maskedWalletDetailsBackgroundColor", color);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsBackgroundResource(int resourceId) {
        this.zzaYk.remove("maskedWalletDetailsBackgroundColor");
        this.zzaYk.putInt("maskedWalletDetailsBackgroundResource", resourceId);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundColor(int color) {
        this.zzaYk.remove("maskedWalletDetailsButtonBackgroundResource");
        this.zzaYk.putInt("maskedWalletDetailsButtonBackgroundColor", color);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundResource(int resourceId) {
        this.zzaYk.remove("maskedWalletDetailsButtonBackgroundColor");
        this.zzaYk.putInt("maskedWalletDetailsButtonBackgroundResource", resourceId);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonTextAppearance(int resourceId) {
        this.zzaYk.putInt("maskedWalletDetailsButtonTextAppearance", resourceId);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsHeaderTextAppearance(int resourceId) {
        this.zzaYk.putInt("maskedWalletDetailsHeaderTextAppearance", resourceId);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsLogoImageType(int imageType) {
        this.zzaYk.putInt("maskedWalletDetailsLogoImageType", imageType);
        return this;
    }

    @Deprecated
    public WalletFragmentStyle setMaskedWalletDetailsLogoTextColor(int color) {
        this.zzaYk.putInt("maskedWalletDetailsLogoTextColor", color);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsTextAppearance(int resourceId) {
        this.zzaYk.putInt("maskedWalletDetailsTextAppearance", resourceId);
        return this;
    }

    public WalletFragmentStyle setStyleResourceId(int id) {
        this.zzaYl = id;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }

    public int zza(String str, DisplayMetrics displayMetrics, int i) {
        return this.zzaYk.containsKey(str) ? zza(this.zzaYk.getLong(str), displayMetrics) : i;
    }

    public void zzaS(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(this.zzaYl <= 0 ? C0197R.style.WalletFragmentDefaultStyle : this.zzaYl, C0197R.styleable.WalletFragmentStyle);
        zza(obtainStyledAttributes, C0197R.styleable.WalletFragmentStyle_buyButtonWidth, "buyButtonWidth");
        zza(obtainStyledAttributes, C0197R.styleable.WalletFragmentStyle_buyButtonHeight, "buyButtonHeight");
        zzb(obtainStyledAttributes, C0197R.styleable.WalletFragmentStyle_buyButtonText, "buyButtonText");
        zzb(obtainStyledAttributes, C0197R.styleable.WalletFragmentStyle_buyButtonAppearance, "buyButtonAppearance");
        zzb(obtainStyledAttributes, C0197R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance, "maskedWalletDetailsTextAppearance");
        zzb(obtainStyledAttributes, C0197R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance, "maskedWalletDetailsHeaderTextAppearance");
        zza(obtainStyledAttributes, C0197R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground, "maskedWalletDetailsBackgroundColor", "maskedWalletDetailsBackgroundResource");
        zzb(obtainStyledAttributes, C0197R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance, "maskedWalletDetailsButtonTextAppearance");
        zza(obtainStyledAttributes, C0197R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground, "maskedWalletDetailsButtonBackgroundColor", "maskedWalletDetailsButtonBackgroundResource");
        zzb(obtainStyledAttributes, C0197R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor, "maskedWalletDetailsLogoTextColor");
        zzb(obtainStyledAttributes, C0197R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType, "maskedWalletDetailsLogoImageType");
        obtainStyledAttributes.recycle();
    }
}
