package com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.dynamic.zzc.zza;

public final class zzb extends zza {
    private Fragment zzamZ;

    private zzb(Fragment fragment) {
        this.zzamZ = fragment;
    }

    public static zzb zza(Fragment fragment) {
        return fragment != null ? new zzb(fragment) : null;
    }

    public Bundle getArguments() {
        return this.zzamZ.getArguments();
    }

    public int getId() {
        return this.zzamZ.getId();
    }

    public boolean getRetainInstance() {
        return this.zzamZ.getRetainInstance();
    }

    public String getTag() {
        return this.zzamZ.getTag();
    }

    public int getTargetRequestCode() {
        return this.zzamZ.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.zzamZ.getUserVisibleHint();
    }

    public zzd getView() {
        return zze.zzx(this.zzamZ.getView());
    }

    public boolean isAdded() {
        return this.zzamZ.isAdded();
    }

    public boolean isDetached() {
        return this.zzamZ.isDetached();
    }

    public boolean isHidden() {
        return this.zzamZ.isHidden();
    }

    public boolean isInLayout() {
        return this.zzamZ.isInLayout();
    }

    public boolean isRemoving() {
        return this.zzamZ.isRemoving();
    }

    public boolean isResumed() {
        return this.zzamZ.isResumed();
    }

    public boolean isVisible() {
        return this.zzamZ.isVisible();
    }

    public void setHasOptionsMenu(boolean hasMenu) {
        this.zzamZ.setHasOptionsMenu(hasMenu);
    }

    public void setMenuVisibility(boolean menuVisible) {
        this.zzamZ.setMenuVisibility(menuVisible);
    }

    public void setRetainInstance(boolean retain) {
        this.zzamZ.setRetainInstance(retain);
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.zzamZ.setUserVisibleHint(isVisibleToUser);
    }

    public void startActivity(Intent intent) {
        this.zzamZ.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        this.zzamZ.startActivityForResult(intent, requestCode);
    }

    public void zzn(zzd com_google_android_gms_dynamic_zzd) {
        this.zzamZ.registerForContextMenu((View) zze.zzp(com_google_android_gms_dynamic_zzd));
    }

    public void zzo(zzd com_google_android_gms_dynamic_zzd) {
        this.zzamZ.unregisterForContextMenu((View) zze.zzp(com_google_android_gms_dynamic_zzd));
    }

    public zzd zzro() {
        return zze.zzx(this.zzamZ.getActivity());
    }

    public zzc zzrp() {
        return zza(this.zzamZ.getParentFragment());
    }

    public zzd zzrq() {
        return zze.zzx(this.zzamZ.getResources());
    }

    public zzc zzrr() {
        return zza(this.zzamZ.getTargetFragment());
    }
}
