package com.google.android.gms.cast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import android.view.accessibility.CaptioningManager.CaptionStyle;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzls;
import com.google.android.gms.internal.zzlv;
import net.sourceforge.jitl.astro.Utils;
import org.json.JSONException;
import org.json.JSONObject;

public final class TextTrackStyle {
    public static final int COLOR_UNSPECIFIED = 0;
    public static final float DEFAULT_FONT_SCALE = 1.0f;
    public static final int EDGE_TYPE_DEPRESSED = 4;
    public static final int EDGE_TYPE_DROP_SHADOW = 2;
    public static final int EDGE_TYPE_NONE = 0;
    public static final int EDGE_TYPE_OUTLINE = 1;
    public static final int EDGE_TYPE_RAISED = 3;
    public static final int EDGE_TYPE_UNSPECIFIED = -1;
    public static final int FONT_FAMILY_CASUAL = 4;
    public static final int FONT_FAMILY_CURSIVE = 5;
    public static final int FONT_FAMILY_MONOSPACED_SANS_SERIF = 1;
    public static final int FONT_FAMILY_MONOSPACED_SERIF = 3;
    public static final int FONT_FAMILY_SANS_SERIF = 0;
    public static final int FONT_FAMILY_SERIF = 2;
    public static final int FONT_FAMILY_SMALL_CAPITALS = 6;
    public static final int FONT_FAMILY_UNSPECIFIED = -1;
    public static final int FONT_STYLE_BOLD = 1;
    public static final int FONT_STYLE_BOLD_ITALIC = 3;
    public static final int FONT_STYLE_ITALIC = 2;
    public static final int FONT_STYLE_NORMAL = 0;
    public static final int FONT_STYLE_UNSPECIFIED = -1;
    public static final int WINDOW_TYPE_NONE = 0;
    public static final int WINDOW_TYPE_NORMAL = 1;
    public static final int WINDOW_TYPE_ROUNDED = 2;
    public static final int WINDOW_TYPE_UNSPECIFIED = -1;
    private JSONObject zzUl;
    private float zzVE;
    private int zzVF;
    private int zzVG;
    private int zzVH;
    private int zzVI;
    private int zzVJ;
    private int zzVK;
    private String zzVL;
    private int zzVM;
    private int zzVN;
    private int zzvF;

    public TextTrackStyle() {
        clear();
    }

    private void clear() {
        this.zzVE = DEFAULT_FONT_SCALE;
        this.zzVF = WINDOW_TYPE_NONE;
        this.zzvF = WINDOW_TYPE_NONE;
        this.zzVG = WINDOW_TYPE_UNSPECIFIED;
        this.zzVH = WINDOW_TYPE_NONE;
        this.zzVI = WINDOW_TYPE_UNSPECIFIED;
        this.zzVJ = WINDOW_TYPE_NONE;
        this.zzVK = WINDOW_TYPE_NONE;
        this.zzVL = null;
        this.zzVM = WINDOW_TYPE_UNSPECIFIED;
        this.zzVN = WINDOW_TYPE_UNSPECIFIED;
        this.zzUl = null;
    }

    public static TextTrackStyle fromSystemSettings(Context context) {
        TextTrackStyle textTrackStyle = new TextTrackStyle();
        if (!zzlv.zzpV()) {
            return textTrackStyle;
        }
        CaptioningManager captioningManager = (CaptioningManager) context.getSystemService("captioning");
        textTrackStyle.setFontScale(captioningManager.getFontScale());
        CaptionStyle userStyle = captioningManager.getUserStyle();
        textTrackStyle.setBackgroundColor(userStyle.backgroundColor);
        textTrackStyle.setForegroundColor(userStyle.foregroundColor);
        switch (userStyle.edgeType) {
            case WINDOW_TYPE_NORMAL /*1*/:
                textTrackStyle.setEdgeType(WINDOW_TYPE_NORMAL);
                break;
            case WINDOW_TYPE_ROUNDED /*2*/:
                textTrackStyle.setEdgeType(WINDOW_TYPE_ROUNDED);
                break;
            default:
                textTrackStyle.setEdgeType(WINDOW_TYPE_NONE);
                break;
        }
        textTrackStyle.setEdgeColor(userStyle.edgeColor);
        Typeface typeface = userStyle.getTypeface();
        if (typeface != null) {
            if (Typeface.MONOSPACE.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(WINDOW_TYPE_NORMAL);
            } else if (Typeface.SANS_SERIF.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(WINDOW_TYPE_NONE);
            } else if (Typeface.SERIF.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(WINDOW_TYPE_ROUNDED);
            } else {
                textTrackStyle.setFontGenericFamily(WINDOW_TYPE_NONE);
            }
            boolean isBold = typeface.isBold();
            boolean isItalic = typeface.isItalic();
            if (isBold && isItalic) {
                textTrackStyle.setFontStyle(FONT_STYLE_BOLD_ITALIC);
            } else if (isBold) {
                textTrackStyle.setFontStyle(WINDOW_TYPE_NORMAL);
            } else if (isItalic) {
                textTrackStyle.setFontStyle(WINDOW_TYPE_ROUNDED);
            } else {
                textTrackStyle.setFontStyle(WINDOW_TYPE_NONE);
            }
        }
        return textTrackStyle;
    }

    private String zzH(int i) {
        Object[] objArr = new Object[FONT_FAMILY_CASUAL];
        objArr[WINDOW_TYPE_NONE] = Integer.valueOf(Color.red(i));
        objArr[WINDOW_TYPE_NORMAL] = Integer.valueOf(Color.green(i));
        objArr[WINDOW_TYPE_ROUNDED] = Integer.valueOf(Color.blue(i));
        objArr[FONT_STYLE_BOLD_ITALIC] = Integer.valueOf(Color.alpha(i));
        return String.format("#%02X%02X%02X%02X", objArr);
    }

    private int zzbH(String str) {
        int i = WINDOW_TYPE_NONE;
        if (str != null && str.length() == 9 && str.charAt(i) == '#') {
            try {
                i = Color.argb(Integer.parseInt(str.substring(7, 9), 16), Integer.parseInt(str.substring(WINDOW_TYPE_NORMAL, FONT_STYLE_BOLD_ITALIC), 16), Integer.parseInt(str.substring(FONT_STYLE_BOLD_ITALIC, FONT_FAMILY_CURSIVE), 16), Integer.parseInt(str.substring(FONT_FAMILY_CURSIVE, 7), 16));
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    public boolean equals(Object other) {
        boolean z = true;
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextTrackStyle)) {
            return false;
        }
        TextTrackStyle textTrackStyle = (TextTrackStyle) other;
        if ((this.zzUl == null ? WINDOW_TYPE_NORMAL : false) != (textTrackStyle.zzUl == null ? WINDOW_TYPE_NORMAL : false)) {
            return false;
        }
        if (this.zzUl != null && textTrackStyle.zzUl != null && !zzls.zzd(this.zzUl, textTrackStyle.zzUl)) {
            return false;
        }
        if (!(this.zzVE == textTrackStyle.zzVE && this.zzVF == textTrackStyle.zzVF && this.zzvF == textTrackStyle.zzvF && this.zzVG == textTrackStyle.zzVG && this.zzVH == textTrackStyle.zzVH && this.zzVI == textTrackStyle.zzVI && this.zzVK == textTrackStyle.zzVK && zzf.zza(this.zzVL, textTrackStyle.zzVL) && this.zzVM == textTrackStyle.zzVM && this.zzVN == textTrackStyle.zzVN)) {
            z = false;
        }
        return z;
    }

    public int getBackgroundColor() {
        return this.zzvF;
    }

    public JSONObject getCustomData() {
        return this.zzUl;
    }

    public int getEdgeColor() {
        return this.zzVH;
    }

    public int getEdgeType() {
        return this.zzVG;
    }

    public String getFontFamily() {
        return this.zzVL;
    }

    public int getFontGenericFamily() {
        return this.zzVM;
    }

    public float getFontScale() {
        return this.zzVE;
    }

    public int getFontStyle() {
        return this.zzVN;
    }

    public int getForegroundColor() {
        return this.zzVF;
    }

    public int getWindowColor() {
        return this.zzVJ;
    }

    public int getWindowCornerRadius() {
        return this.zzVK;
    }

    public int getWindowType() {
        return this.zzVI;
    }

    public int hashCode() {
        return zzw.hashCode(Float.valueOf(this.zzVE), Integer.valueOf(this.zzVF), Integer.valueOf(this.zzvF), Integer.valueOf(this.zzVG), Integer.valueOf(this.zzVH), Integer.valueOf(this.zzVI), Integer.valueOf(this.zzVJ), Integer.valueOf(this.zzVK), this.zzVL, Integer.valueOf(this.zzVM), Integer.valueOf(this.zzVN), this.zzUl);
    }

    public void setBackgroundColor(int backgroundColor) {
        this.zzvF = backgroundColor;
    }

    public void setCustomData(JSONObject customData) {
        this.zzUl = customData;
    }

    public void setEdgeColor(int edgeColor) {
        this.zzVH = edgeColor;
    }

    public void setEdgeType(int edgeType) {
        if (edgeType < 0 || edgeType > FONT_FAMILY_CASUAL) {
            throw new IllegalArgumentException("invalid edgeType");
        }
        this.zzVG = edgeType;
    }

    public void setFontFamily(String fontFamily) {
        this.zzVL = fontFamily;
    }

    public void setFontGenericFamily(int fontGenericFamily) {
        if (fontGenericFamily < 0 || fontGenericFamily > FONT_FAMILY_SMALL_CAPITALS) {
            throw new IllegalArgumentException("invalid fontGenericFamily");
        }
        this.zzVM = fontGenericFamily;
    }

    public void setFontScale(float fontScale) {
        this.zzVE = fontScale;
    }

    public void setFontStyle(int fontStyle) {
        if (fontStyle < 0 || fontStyle > FONT_STYLE_BOLD_ITALIC) {
            throw new IllegalArgumentException("invalid fontStyle");
        }
        this.zzVN = fontStyle;
    }

    public void setForegroundColor(int foregroundColor) {
        this.zzVF = foregroundColor;
    }

    public void setWindowColor(int windowColor) {
        this.zzVJ = windowColor;
    }

    public void setWindowCornerRadius(int windowCornerRadius) {
        if (windowCornerRadius < 0) {
            throw new IllegalArgumentException("invalid windowCornerRadius");
        }
        this.zzVK = windowCornerRadius;
    }

    public void setWindowType(int windowType) {
        if (windowType < 0 || windowType > WINDOW_TYPE_ROUNDED) {
            throw new IllegalArgumentException("invalid windowType");
        }
        this.zzVI = windowType;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fontScale", (double) this.zzVE);
            if (this.zzVF != 0) {
                jSONObject.put("foregroundColor", zzH(this.zzVF));
            }
            if (this.zzvF != 0) {
                jSONObject.put("backgroundColor", zzH(this.zzvF));
            }
            switch (this.zzVG) {
                case WINDOW_TYPE_NONE /*0*/:
                    jSONObject.put("edgeType", "NONE");
                    break;
                case WINDOW_TYPE_NORMAL /*1*/:
                    jSONObject.put("edgeType", "OUTLINE");
                    break;
                case WINDOW_TYPE_ROUNDED /*2*/:
                    jSONObject.put("edgeType", "DROP_SHADOW");
                    break;
                case FONT_STYLE_BOLD_ITALIC /*3*/:
                    jSONObject.put("edgeType", "RAISED");
                    break;
                case FONT_FAMILY_CASUAL /*4*/:
                    jSONObject.put("edgeType", "DEPRESSED");
                    break;
            }
            if (this.zzVH != 0) {
                jSONObject.put("edgeColor", zzH(this.zzVH));
            }
            switch (this.zzVI) {
                case WINDOW_TYPE_NONE /*0*/:
                    jSONObject.put("windowType", "NONE");
                    break;
                case WINDOW_TYPE_NORMAL /*1*/:
                    jSONObject.put("windowType", "NORMAL");
                    break;
                case WINDOW_TYPE_ROUNDED /*2*/:
                    jSONObject.put("windowType", "ROUNDED_CORNERS");
                    break;
            }
            if (this.zzVJ != 0) {
                jSONObject.put("windowColor", zzH(this.zzVJ));
            }
            if (this.zzVI == WINDOW_TYPE_ROUNDED) {
                jSONObject.put("windowRoundedCornerRadius", this.zzVK);
            }
            if (this.zzVL != null) {
                jSONObject.put("fontFamily", this.zzVL);
            }
            switch (this.zzVM) {
                case WINDOW_TYPE_NONE /*0*/:
                    jSONObject.put("fontGenericFamily", "SANS_SERIF");
                    break;
                case WINDOW_TYPE_NORMAL /*1*/:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SANS_SERIF");
                    break;
                case WINDOW_TYPE_ROUNDED /*2*/:
                    jSONObject.put("fontGenericFamily", "SERIF");
                    break;
                case FONT_STYLE_BOLD_ITALIC /*3*/:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SERIF");
                    break;
                case FONT_FAMILY_CASUAL /*4*/:
                    jSONObject.put("fontGenericFamily", "CASUAL");
                    break;
                case FONT_FAMILY_CURSIVE /*5*/:
                    jSONObject.put("fontGenericFamily", "CURSIVE");
                    break;
                case FONT_FAMILY_SMALL_CAPITALS /*6*/:
                    jSONObject.put("fontGenericFamily", "SMALL_CAPITALS");
                    break;
            }
            switch (this.zzVN) {
                case WINDOW_TYPE_NONE /*0*/:
                    jSONObject.put("fontStyle", "NORMAL");
                    break;
                case WINDOW_TYPE_NORMAL /*1*/:
                    jSONObject.put("fontStyle", "BOLD");
                    break;
                case WINDOW_TYPE_ROUNDED /*2*/:
                    jSONObject.put("fontStyle", "ITALIC");
                    break;
                case FONT_STYLE_BOLD_ITALIC /*3*/:
                    jSONObject.put("fontStyle", "BOLD_ITALIC");
                    break;
            }
            if (this.zzUl != null) {
                jSONObject.put("customData", this.zzUl);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void zzf(JSONObject jSONObject) throws JSONException {
        String string;
        clear();
        this.zzVE = (float) jSONObject.optDouble("fontScale", Utils.AGGRESSIVE_ROUND_SEC);
        this.zzVF = zzbH(jSONObject.optString("foregroundColor"));
        this.zzvF = zzbH(jSONObject.optString("backgroundColor"));
        if (jSONObject.has("edgeType")) {
            string = jSONObject.getString("edgeType");
            if ("NONE".equals(string)) {
                this.zzVG = WINDOW_TYPE_NONE;
            } else if ("OUTLINE".equals(string)) {
                this.zzVG = WINDOW_TYPE_NORMAL;
            } else if ("DROP_SHADOW".equals(string)) {
                this.zzVG = WINDOW_TYPE_ROUNDED;
            } else if ("RAISED".equals(string)) {
                this.zzVG = FONT_STYLE_BOLD_ITALIC;
            } else if ("DEPRESSED".equals(string)) {
                this.zzVG = FONT_FAMILY_CASUAL;
            }
        }
        this.zzVH = zzbH(jSONObject.optString("edgeColor"));
        if (jSONObject.has("windowType")) {
            string = jSONObject.getString("windowType");
            if ("NONE".equals(string)) {
                this.zzVI = WINDOW_TYPE_NONE;
            } else if ("NORMAL".equals(string)) {
                this.zzVI = WINDOW_TYPE_NORMAL;
            } else if ("ROUNDED_CORNERS".equals(string)) {
                this.zzVI = WINDOW_TYPE_ROUNDED;
            }
        }
        this.zzVJ = zzbH(jSONObject.optString("windowColor"));
        if (this.zzVI == WINDOW_TYPE_ROUNDED) {
            this.zzVK = jSONObject.optInt("windowRoundedCornerRadius", WINDOW_TYPE_NONE);
        }
        this.zzVL = jSONObject.optString("fontFamily", null);
        if (jSONObject.has("fontGenericFamily")) {
            string = jSONObject.getString("fontGenericFamily");
            if ("SANS_SERIF".equals(string)) {
                this.zzVM = WINDOW_TYPE_NONE;
            } else if ("MONOSPACED_SANS_SERIF".equals(string)) {
                this.zzVM = WINDOW_TYPE_NORMAL;
            } else if ("SERIF".equals(string)) {
                this.zzVM = WINDOW_TYPE_ROUNDED;
            } else if ("MONOSPACED_SERIF".equals(string)) {
                this.zzVM = FONT_STYLE_BOLD_ITALIC;
            } else if ("CASUAL".equals(string)) {
                this.zzVM = FONT_FAMILY_CASUAL;
            } else if ("CURSIVE".equals(string)) {
                this.zzVM = FONT_FAMILY_CURSIVE;
            } else if ("SMALL_CAPITALS".equals(string)) {
                this.zzVM = FONT_FAMILY_SMALL_CAPITALS;
            }
        }
        if (jSONObject.has("fontStyle")) {
            string = jSONObject.getString("fontStyle");
            if ("NORMAL".equals(string)) {
                this.zzVN = WINDOW_TYPE_NONE;
            } else if ("BOLD".equals(string)) {
                this.zzVN = WINDOW_TYPE_NORMAL;
            } else if ("ITALIC".equals(string)) {
                this.zzVN = WINDOW_TYPE_ROUNDED;
            } else if ("BOLD_ITALIC".equals(string)) {
                this.zzVN = FONT_STYLE_BOLD_ITALIC;
            }
        }
        this.zzUl = jSONObject.optJSONObject("customData");
    }
}
