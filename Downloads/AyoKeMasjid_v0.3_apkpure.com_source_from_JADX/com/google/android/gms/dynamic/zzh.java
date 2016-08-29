package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.google.android.gms.dynamic.zzc.zza;

public final class zzh extends zza {
    private Fragment zzadh;

    private zzh(Fragment fragment) {
        this.zzadh = fragment;
    }

    public static zzh zza(Fragment fragment) {
        return fragment != null ? new zzh(fragment) : null;
    }

    public Bundle getArguments() {
        return this.zzadh.getArguments();
    }

    public int getId() {
        return this.zzadh.getId();
    }

    public boolean getRetainInstance() {
        return this.zzadh.getRetainInstance();
    }

    public String getTag() {
        return this.zzadh.getTag();
    }

    public int getTargetRequestCode() {
        return this.zzadh.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.zzadh.getUserVisibleHint();
    }

    public zzd getView() {
        return zze.zzx(this.zzadh.getView());
    }

    public boolean isAdded() {
        return this.zzadh.isAdded();
    }

    public boolean isDetached() {
        return this.zzadh.isDetached();
    }

    public boolean isHidden() {
        return this.zzadh.isHidden();
    }

    public boolean isInLayout() {
        return this.zzadh.isInLayout();
    }

    public boolean isRemoving() {
        return this.zzadh.isRemoving();
    }

    public boolean isResumed() {
        return this.zzadh.isResumed();
    }

    public boolean isVisible() {
        return this.zzadh.isVisible();
    }

    public void setHasOptionsMenu(boolean hasMenu) {
        this.zzadh.setHasOptionsMenu(hasMenu);
    }

    public void setMenuVisibility(boolean menuVisible) {
        this.zzadh.setMenuVisibility(menuVisible);
    }

    public void setRetainInstance(boolean retain) {
        this.zzadh.setRetainInstance(retain);
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.zzadh.setUserVisibleHint(isVisibleToUser);
    }

    public void startActivity(Intent intent) {
        this.zzadh.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        this.zzadh.startActivityForResult(intent, requestCode);
    }

    public void zzn(zzd com_google_android_gms_dynamic_zzd) {
        this.zzadh.registerForContextMenu((View) zze.zzp(com_google_android_gms_dynamic_zzd));
    }

    public void zzo(zzd com_google_android_gms_dynamic_zzd) {
        this.zzadh.unregisterForContextMenu((View) zze.zzp(com_google_android_gms_dynamic_zzd));
    }

    public zzd zzro() {
        return zze.zzx(this.zzadh.getActivity());
    }

    public zzc zzrp() {
        return zza(this.zzadh.getParentFragment());
    }

    public zzd zzrq() {
        return zze.zzx(this.zzadh.getResources());
    }

    public zzc zzrr() {
        return zza(this.zzadh.getTargetFragment());
    }
}
