package com.google.android.gms.games.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.google.android.gms.internal.zzlv;
import java.lang.ref.WeakReference;

public class PopupManager {
    protected GamesClientImpl zzauo;
    protected PopupLocationInfo zzaup;

    public static final class PopupLocationInfo {
        public int bottom;
        public int gravity;
        public int left;
        public int right;
        public int top;
        public IBinder zzauq;
        public int zzaur;

        private PopupLocationInfo(int gravity, IBinder windowToken) {
            this.zzaur = -1;
            this.left = 0;
            this.top = 0;
            this.right = 0;
            this.bottom = 0;
            this.gravity = gravity;
            this.zzauq = windowToken;
        }

        public Bundle zzuo() {
            Bundle bundle = new Bundle();
            bundle.putInt("popupLocationInfo.gravity", this.gravity);
            bundle.putInt("popupLocationInfo.displayId", this.zzaur);
            bundle.putInt("popupLocationInfo.left", this.left);
            bundle.putInt("popupLocationInfo.top", this.top);
            bundle.putInt("popupLocationInfo.right", this.right);
            bundle.putInt("popupLocationInfo.bottom", this.bottom);
            return bundle;
        }
    }

    private static final class PopupManagerHCMR1 extends PopupManager implements OnAttachStateChangeListener, OnGlobalLayoutListener {
        private boolean zzasO;
        private WeakReference<View> zzaus;

        protected PopupManagerHCMR1(GamesClientImpl gamesClientImpl, int gravity) {
            super(gravity, null);
            this.zzasO = false;
        }

        private void zzo(View view) {
            int i = -1;
            if (zzlv.zzpT()) {
                Display display = view.getDisplay();
                if (display != null) {
                    i = display.getDisplayId();
                }
            }
            IBinder windowToken = view.getWindowToken();
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int width = view.getWidth();
            int height = view.getHeight();
            this.zzaup.zzaur = i;
            this.zzaup.zzauq = windowToken;
            this.zzaup.left = iArr[0];
            this.zzaup.top = iArr[1];
            this.zzaup.right = iArr[0] + width;
            this.zzaup.bottom = iArr[1] + height;
            if (this.zzasO) {
                zzup();
                this.zzasO = false;
            }
        }

        public void onGlobalLayout() {
            if (this.zzaus != null) {
                View view = (View) this.zzaus.get();
                if (view != null) {
                    zzo(view);
                }
            }
        }

        public void onViewAttachedToWindow(View v) {
            zzo(v);
        }

        public void onViewDetachedFromWindow(View v) {
            this.zzauo.zzud();
            v.removeOnAttachStateChangeListener(this);
        }

        protected void zzfP(int i) {
            this.zzaup = new PopupLocationInfo(null, null);
        }

        public void zzn(View view) {
            View view2;
            Context context;
            this.zzauo.zzud();
            if (this.zzaus != null) {
                view2 = (View) this.zzaus.get();
                context = this.zzauo.getContext();
                if (view2 == null && (context instanceof Activity)) {
                    view2 = ((Activity) context).getWindow().getDecorView();
                }
                if (view2 != null) {
                    view2.removeOnAttachStateChangeListener(this);
                    ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                    if (zzlv.zzpS()) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    }
                }
            }
            this.zzaus = null;
            context = this.zzauo.getContext();
            if (view == null && (context instanceof Activity)) {
                view2 = ((Activity) context).findViewById(16908290);
                if (view2 == null) {
                    view2 = ((Activity) context).getWindow().getDecorView();
                }
                GamesLog.zzw("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view. Note that this may not work as expected in multi-screen environments");
                view = view2;
            }
            if (view != null) {
                zzo(view);
                this.zzaus = new WeakReference(view);
                view.addOnAttachStateChangeListener(this);
                view.getViewTreeObserver().addOnGlobalLayoutListener(this);
                return;
            }
            GamesLog.zzx("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
        }

        public void zzup() {
            if (this.zzaup.zzauq != null) {
                super.zzup();
            } else {
                this.zzasO = this.zzaus != null;
            }
        }
    }

    private PopupManager(GamesClientImpl gamesClientImpl, int gravity) {
        this.zzauo = gamesClientImpl;
        zzfP(gravity);
    }

    public static PopupManager zza(GamesClientImpl gamesClientImpl, int i) {
        return zzlv.zzpP() ? new PopupManagerHCMR1(gamesClientImpl, i) : new PopupManager(gamesClientImpl, i);
    }

    public void setGravity(int gravity) {
        this.zzaup.gravity = gravity;
    }

    protected void zzfP(int i) {
        this.zzaup = new PopupLocationInfo(new Binder(), null);
    }

    public void zzn(View view) {
    }

    public void zzup() {
        this.zzauo.zza(this.zzaup.zzauq, this.zzaup.zzuo());
    }

    public Bundle zzuq() {
        return this.zzaup.zzuo();
    }

    public IBinder zzur() {
        return this.zzaup.zzauq;
    }

    public PopupLocationInfo zzus() {
        return this.zzaup;
    }
}
