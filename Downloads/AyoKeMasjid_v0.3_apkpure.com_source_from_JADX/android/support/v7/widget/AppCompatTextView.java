package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.appcompat.C0107R;
import android.support.v7.internal.text.AllCapsTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

public class AppCompatTextView extends TextView {
    public AppCompatTextView(Context context) {
        this(context, null);
    }

    public AppCompatTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 16842884);
    }

    public AppCompatTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs, C0107R.styleable.AppCompatTextView, defStyle, 0);
        int ap = a.getResourceId(C0107R.styleable.AppCompatTextView_android_textAppearance, -1);
        a.recycle();
        if (ap != -1) {
            TypedArray appearance = context.obtainStyledAttributes(ap, C0107R.styleable.TextAppearance);
            if (appearance.hasValue(C0107R.styleable.TextAppearance_textAllCaps)) {
                setAllCaps(appearance.getBoolean(C0107R.styleable.TextAppearance_textAllCaps, false));
            }
            appearance.recycle();
        }
        a = context.obtainStyledAttributes(attrs, C0107R.styleable.AppCompatTextView, defStyle, 0);
        if (a.hasValue(C0107R.styleable.AppCompatTextView_textAllCaps)) {
            setAllCaps(a.getBoolean(C0107R.styleable.AppCompatTextView_textAllCaps, false));
        }
        a.recycle();
    }

    public void setAllCaps(boolean allCaps) {
        setTransformationMethod(allCaps ? new AllCapsTransformationMethod(getContext()) : null);
    }

    public void setTextAppearance(Context context, int resId) {
        super.setTextAppearance(context, resId);
        TypedArray appearance = context.obtainStyledAttributes(resId, C0107R.styleable.TextAppearance);
        if (appearance.hasValue(C0107R.styleable.TextAppearance_textAllCaps)) {
            setAllCaps(appearance.getBoolean(C0107R.styleable.TextAppearance_textAllCaps, false));
        }
        appearance.recycle();
    }
}
