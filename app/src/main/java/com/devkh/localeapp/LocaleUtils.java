package com.devkh.localeapp;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;

import java.util.Locale;

public class LocaleUtils extends ContextWrapper {

    public final static String KHMER = "km";
    public final static String ENGLISH = "en";

    public LocaleUtils(Context base) {
        super(base);
    }

    // Set locale code into SharedPreferences
    public static void setLocaleCode(Context context, String localeCode) {
        SharedPreferences prefs = context.getSharedPreferences("language", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("lang", localeCode);
        editor.apply();
    }

    // Get locale obj based on locale on in SharedPreferences
    public static Locale getLocale(Context context) {
        String localeCode = context
                .getSharedPreferences("language", MODE_PRIVATE)
                .getString("lang", KHMER);
        return new Locale(localeCode);
    }

    // Update locale configuration
    public static ContextWrapper updateLocale(Context context) {

            // 1.Create resource object
            Resources res = context.getResources();

            // 2.Create configuration object
            Configuration config = res.getConfiguration();
            config.setLocale(getLocale(context));

            context = context.createConfigurationContext(config);

            return new LocaleUtils(context);
    }


}
