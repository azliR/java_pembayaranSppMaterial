package cores.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rizal
 */
public class Intl {
    private static final Logger LOG = Logger.getLogger(Intl.class.getName());

    public static String convertCurrency(int currency) {
        final var decimalFormat = (DecimalFormat) DecimalFormat.getInstance();
        final var decimalFormatSymbols = DecimalFormatSymbols.getInstance();

        decimalFormatSymbols.setCurrencySymbol("Rp. ");
        decimalFormatSymbols.setMonetaryDecimalSeparator(',');
        decimalFormatSymbols.setGroupingSeparator('.');

        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);

        return "Rp. " + decimalFormat.format(currency);
    }

    public static String convertTimestamp(String dateString) {
        try {
            final var simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            final var date = simpleDateFormat.parse(dateString);
            return new SimpleDateFormat("HH:mm  |  dd MMMM yyyy").format(date);
        } catch (ParseException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String convertSimpleTimestamp(String dateString) {
        try {
            final var simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            final var date = simpleDateFormat.parse(dateString);
            final var currentDate = new Date();

            long minutes = 1000 * 60;
            long different = currentDate.getTime() - date.getTime();
            long elapsedMinutes = different / minutes;

            if (elapsedMinutes == 0) {
                return "Baru saja";

            } else if (elapsedMinutes < 60) {
                return elapsedMinutes + " menit lalu";

            } else {
                long hours = minutes * 60;
                long elapsedHour = different / hours;

                if (elapsedHour < 24) {
                    return elapsedHour + " jam lalu";
                } else {
                    long days = hours * 24;
                    long elapsedDay = different / days;

                    if (elapsedDay < 7) {
                        return elapsedDay + " hari lalu";
                    } else {
                        long weeks = days * 7;
                        long elapsedWeek = different / weeks;

                        if (elapsedDay < 30) {
                            return elapsedWeek + " minggu lalu";

                        } else {
                            long months = days * 30;
                            long elapsedMonth = different / months;

                            if (elapsedMonth < 12) {
                                return elapsedMonth + " bulan lalu";
                            } else {
                                long years = days * 365;
                                long elapsedYear = different / years;

                                return elapsedYear + " tahun lalu";
                            }
                        }
                    }
                }
            }
        } catch (ParseException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static int extractNumber(String s) {
        return Integer.parseInt(s.replaceAll("\\D+", ""));
    }

    private Intl() {
    }
}
