package org.bpmikc.akm.Utils;

import android.content.Context;
import android.content.res.Configuration;
import java.util.Locale;
import java.util.MissingResourceException;
import org.bpmikc.akm.Widget.Preferences;

public class LocaleManager {
    public static final String[] LOCALES;
    private static LocaleManager sLocaleManager;
    private int languageIndex;
    private Locale mLocale;

    static {
        LOCALES = new String[]{"default", "uz", "ar", "de", "en", "es", "fr", "in", "it", "tr", "ru"};
    }

    public static LocaleManager getInstance(Context context, boolean forced) {
        if (!forced && sLocaleManager != null) {
            return sLocaleManager;
        }
        LocaleManager localeManager = new LocaleManager(context);
        sLocaleManager = localeManager;
        return localeManager;
    }

    private LocaleManager(Context context) {
        Locale locale;
        this.languageIndex = 0;
        String languageKey = Preferences.getInstance(context).getLocale();
        Locale defaultLocale = Locale.getDefault();
        if (LOCALES[0].equals(languageKey)) {
            languageKey = defaultLocale.getCountry();
        }
        try {
            locale = new Locale(languageKey, defaultLocale.getISO3Country().toUpperCase(defaultLocale));
        } catch (MissingResourceException e) {
            locale = new Locale(languageKey);
        }
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
        for (int i = 0; i < LOCALES.length; i++) {
            if (languageKey.equals(LOCALES[i])) {
                this.languageIndex = i;
                break;
            }
        }
        setLocale(locale);
    }

    public int getLanguageIndex() {
        return this.languageIndex;
    }

    private void setLocale(Locale locale) {
        this.mLocale = locale;
    }

    public Locale getLocale(Context context) {
        if (this.mLocale == null) {
            LocaleManager localeManager = new LocaleManager(context);
        }
        return this.mLocale;
    }
}
