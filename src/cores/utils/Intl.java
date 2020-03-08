package cores.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeMap;
import java.util.logging.Logger;

/**
 *
 * @author rizal
 */
public class Intl {
    private static final Logger LOG = Logger.getLogger(Intl.class.getName());
    private static final TreeMap<Integer, String> MAP = new TreeMap<>();

    static {
        MAP.put(1000, "M");
        MAP.put(900, "CM");
        MAP.put(500, "D");
        MAP.put(400, "CD");
        MAP.put(100, "C");
        MAP.put(90, "XC");
        MAP.put(50, "L");
        MAP.put(40, "XL");
        MAP.put(10, "X");
        MAP.put(9, "IX");
        MAP.put(5, "V");
        MAP.put(4, "IV");
        MAP.put(1, "I");
    }

    public static String convertCurrency(int currency) {
        final var decimalFormat = (DecimalFormat) DecimalFormat.getInstance();
        final var decimalFormatSymbols = DecimalFormatSymbols.getInstance();

        decimalFormatSymbols.setCurrencySymbol("Rp. ");
        decimalFormatSymbols.setMonetaryDecimalSeparator(',');
        decimalFormatSymbols.setGroupingSeparator('.');

        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);

        return "Rp. " + decimalFormat.format(currency);
    }

    public static String convertTimestamp(Date date) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat("HH:mm  |  dd MMMM yyyy").format(date);
    }

    public static String convertSimpleTimestamp(Date dateValue) {
        if (dateValue == null) {
            return null;
        }
        final var date = dateValue;
        final var currentDate = new Date();
        final long minutes = 1000 * 60;
        final long different = currentDate.getTime() - date.getTime();
        final long elapsedMinutes = different / minutes;

        if (elapsedMinutes == 0) {
            return "Baru saja";

        } else if (elapsedMinutes < 60) {
            return elapsedMinutes + " menit lalu";

        } else {
            final long hours = minutes * 60;
            final long elapsedHour = different / hours;

            if (elapsedHour < 24) {
                return elapsedHour + " jam lalu";
            } else {
                final long days = hours * 24;
                final long elapsedDay = different / days;

                if (elapsedDay < 7) {
                    return elapsedDay + " hari lalu";
                } else {
                    final long weeks = days * 7;
                    final long elapsedWeek = different / weeks;

                    if (elapsedDay < 30) {
                        return elapsedWeek + " minggu lalu";

                    } else {
                        final long months = days * 30;
                        final long elapsedMonth = different / months;

                        if (elapsedMonth < 12) {
                            return elapsedMonth + " bulan lalu";
                        } else {
                            final long years = days * 365;
                            final long elapsedYear = different / years;

                            return elapsedYear + " tahun lalu";
                        }
                    }
                }
            }
        }
    }

    public static int extractNumber(String s) {
        if (s == null) {
            return 0;
        }
        return Integer.parseInt(s.replaceAll("\\D+", ""));
    }

    public static String toRoman(int number) {
        int l = MAP.floorKey(number);
        if (number == l) {
            return MAP.get(number);
        }
        return MAP.get(l) + toRoman(number - l);
    }

    private Intl() {
    }
}
