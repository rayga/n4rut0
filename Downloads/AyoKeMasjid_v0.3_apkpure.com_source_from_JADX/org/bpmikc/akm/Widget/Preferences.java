package org.bpmikc.akm.Widget;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import java.util.Arrays;
import java.util.Locale;
import org.bpmikc.akm.BuildConfig;
import org.bpmikc.akm.Utils.LocaleManager;

public class Preferences {
    private static final String KEY_ALTITUDE = "location_altitude";
    private static final String KEY_BASMALA = "key_bismillah_on_boot_up";
    private static final String KEY_CALCULATION_METHOD_INDEX = "calculation_method_index";
    private static final String KEY_LATITUDE = "location_latitude";
    private static final String KEY_LOCALE = "key_locale";
    private static final String KEY_LONGITUDE = "location_longitude";
    private static final String KEY_NOTIFICATION_CUSTOM_FILE = "notification_custom_file_";
    private static final String KEY_NOTIFICATION_METHOD = "notification_method_";
    private static final String KEY_OFFSET_MINUTES = "offset_minutes";
    private static final String KEY_PRESSURE = "location_pressure";
    private static final String KEY_ROUNDING_METHOD_INDEX = "rounding_method_index";
    private static final String KEY_TEMPERATURE = "location_temperature";
    private static final String PREFERENCE_FILENAME_SUFFIX = "_preferences";
    private static Preferences sPreferences;
    private final SharedPreferences mSharedPreferences;

    public static Preferences getInstance(Context context) {
        if (sPreferences != null) {
            return sPreferences;
        }
        Preferences preferences = new Preferences(context);
        sPreferences = preferences;
        return preferences;
    }

    private Preferences(Context context) {
        this.mSharedPreferences = context.getSharedPreferences(context.getPackageName().concat(PREFERENCE_FILENAME_SUFFIX), 0);
    }

    public boolean dontNotifySunrise() {
        return getNotificationMethod(1) == 0;
    }

    public boolean getBasmalaEnabled() {
        return this.mSharedPreferences.getBoolean(KEY_BASMALA, false);
    }

    public String getLocale() {
        return this.mSharedPreferences.getString(KEY_LOCALE, LocaleManager.LOCALES[0]);
    }

    public void setLocale(String newLocale) {
        Editor editor = this.mSharedPreferences.edit();
        editor.putString(KEY_LOCALE, newLocale);
        editor.apply();
    }

    public int getNotificationMethod(int time) {
        int i = 1;
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        String concat = KEY_NOTIFICATION_METHOD.concat(Integer.toString(time));
        if (1 == time) {
            i = 0;
        }
        return sharedPreferences.getInt(concat, i);
    }

    public void setNotificationMethod(short time, int method) {
        Editor editor = this.mSharedPreferences.edit();
        editor.putInt(KEY_NOTIFICATION_METHOD.concat(Short.toString(time)), method);
        editor.apply();
    }

    public String getCustomFilePath(short time) {
        return this.mSharedPreferences.getString(KEY_NOTIFICATION_CUSTOM_FILE.concat(Short.toString(time)), BuildConfig.FLAVOR);
    }

    public void setCustomFilePath(String newPath) {
        Editor editor = this.mSharedPreferences.edit();
        editor.putString(KEY_NOTIFICATION_CUSTOM_FILE, newPath);
        editor.apply();
    }

    public int getCalculationMethodIndex() {
        return this.mSharedPreferences.getInt(KEY_CALCULATION_METHOD_INDEX, 5);
    }

    public void setCalculationMethodIndex(int index) {
        Editor editor = this.mSharedPreferences.edit();
        editor.putInt(KEY_CALCULATION_METHOD_INDEX, index);
        editor.apply();
    }

    public float[] getLocation() {
        return new float[]{this.mSharedPreferences.getFloat(KEY_LATITUDE, 21.4225f), this.mSharedPreferences.getFloat(KEY_LONGITUDE, 39.8261f)};
    }

    public boolean isLocationSet() {
        return this.mSharedPreferences.contains(KEY_LATITUDE) && this.mSharedPreferences.contains(KEY_LONGITUDE);
    }

    public void setLocation(float latitude, float longitude) {
        Editor editor = this.mSharedPreferences.edit();
        editor.putFloat(KEY_LATITUDE, latitude);
        editor.putFloat(KEY_LONGITUDE, longitude);
        editor.apply();
    }

    public float[] getApt() {
        return new float[]{this.mSharedPreferences.getFloat(KEY_ALTITUDE, 0.0f), this.mSharedPreferences.getFloat(KEY_PRESSURE, 1010.0f), this.mSharedPreferences.getFloat(KEY_TEMPERATURE, 10.0f)};
    }

    public void setApt(float altitude, float pressure, float temperature) {
        Editor editor = this.mSharedPreferences.edit();
        editor.putFloat(KEY_ALTITUDE, altitude);
        editor.putFloat(KEY_PRESSURE, pressure);
        editor.putFloat(KEY_TEMPERATURE, temperature);
        editor.apply();
    }

    public int getRoundingMethodIndex() {
        return this.mSharedPreferences.getInt(KEY_ROUNDING_METHOD_INDEX, 2);
    }

    public void setRoundingMethodIndex(int index) {
        Editor editor = this.mSharedPreferences.edit();
        editor.putInt(KEY_ROUNDING_METHOD_INDEX, index);
        editor.apply();
    }

    public int getOffsetMinutes() {
        return this.mSharedPreferences.getInt(KEY_OFFSET_MINUTES, 0);
    }

    public void setOffsetMinutes(int minutes) {
        Editor editor = this.mSharedPreferences.edit();
        editor.putInt(KEY_OFFSET_MINUTES, minutes);
        editor.apply();
    }

    public void initCalculationDefaults(Context context) {
        if (!this.mSharedPreferences.contains(KEY_CALCULATION_METHOD_INDEX)) {
            String country = Locale.getDefault().getISO3Country().toUpperCase(Locale.US);
            for (int i = 0; i < CONSTANT.CALCULATION_METHOD_COUNTRY_CODES.length; i++) {
                if (Arrays.asList(CONSTANT.CALCULATION_METHOD_COUNTRY_CODES[i]).contains(country)) {
                    setCalculationMethodIndex(i);
                    break;
                }
            }
        }
        if (!this.mSharedPreferences.contains(KEY_LATITUDE) || !this.mSharedPreferences.contains(KEY_LONGITUDE)) {
            Location currentLocation = getCurrentLocation(context);
            if (currentLocation == null) {
                throw new NullPointerException();
            }
            setLocation((float) currentLocation.getLatitude(), (float) currentLocation.getLongitude());
        }
    }

    public Location getCurrentLocation(Context context) {
        Criteria criteria = new Criteria();
        criteria.setAccuracy(1);
        criteria.setCostAllowed(true);
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        try {
            Location currentLocation = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, true));
            if (currentLocation != null) {
                return currentLocation;
            }
            criteria.setAccuracy(2);
            return locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, true));
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public net.sourceforge.jitl.astro.Location getJitlLocation() {
        float[] latLong = getLocation();
        net.sourceforge.jitl.astro.Location location = new net.sourceforge.jitl.astro.Location((double) latLong[0], (double) latLong[1], Schedule.getGMTOffset(), 0);
        float[] apt = getApt();
        location.setSeaLevel((double) apt[0]);
        location.setPressure((double) apt[1]);
        location.setTemperature((double) apt[2]);
        return location;
    }
}
