package com.example.bfm_test.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
    public static String formatUnixTimestamp(long unixTime) {
        Date date = new Date(unixTime * 1000L);

        // Create a SimpleDateFormat instance with the desired pattern
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy, hh:mma", Locale.ENGLISH);

        // Format the date and return it as a string
        return sdf.format(date);
    }
}
