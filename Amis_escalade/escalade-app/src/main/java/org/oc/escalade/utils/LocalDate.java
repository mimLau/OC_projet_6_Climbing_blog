
package org.oc.escalade.utils;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public  class LocalDate {

    public static final String getLocalDate () {
        Date today = new Date();
        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
                DateFormat.MEDIUM,
                DateFormat.MEDIUM, new Locale("FR", "fr"));
        return shortDateFormat.format( today );
    }
}
