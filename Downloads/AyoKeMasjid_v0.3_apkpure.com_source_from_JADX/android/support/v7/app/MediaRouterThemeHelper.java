package android.support.v7.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.mediarouter.C0142R;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

final class MediaRouterThemeHelper {
    private MediaRouterThemeHelper() {
    }

    public static Context createThemedContext(Context context) {
        return new ContextThemeWrapper(context, isLightTheme(context) ? C0142R.style.Theme_MediaRouter_Light : C0142R.style.Theme_MediaRouter);
    }

    public static int getThemeResource(Context context, int attr) {
        TypedValue value = new TypedValue();
        return context.getTheme().resolveAttribute(attr, value, true) ? value.resourceId : 0;
    }

    public static Drawable getThemeDrawable(Context context, int attr) {
        int res = getThemeResource(context, attr);
        return res != 0 ? context.getResources().getDrawable(res) : null;
    }

    private static boolean isLightTheme(Context context) {
        TypedValue value = new TypedValue();
        if (!context.getTheme().resolveAttribute(C0142R.attr.isLightTheme, value, true) || value.data == 0) {
            return false;
        }
        return true;
    }
}
