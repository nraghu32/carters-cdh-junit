package com.carters.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class UtilityHelper {

    public static String getCurrentDate(String format) {
        return LocalDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern(format));
    }

    public static String formatDate(String format, Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }

    public static LocalDateTime getPastFutureDate(String pastFutureDate) {
        LocalDateTime datetime = LocalDateTime.now(ZoneOffset.UTC);
        String name[] = pastFutureDate.split("_");
        if(name[0].equals("PAST")){
            switch (name[2]){
                case "DAYS":
                    datetime = datetime.minusDays(Long.parseLong(name[3]));
                    break;
                case "MONTHS":
                    datetime = datetime.minusMonths(Long.parseLong(name[3]));
                    break;
                case "YEARS":
                    datetime = datetime.minusYears(Long.parseLong(name[3]));
                    break;
            }
        } else if (name[0].equals("FUTURE")) {
            switch (name[2]){
                case "DAYS":
                    datetime = datetime.plusDays(Long.parseLong(name[3]));
                    break;
                case "MONTHS":
                    datetime = datetime.plusMonths(Long.parseLong(name[3]));
                    break;
                case "YEARS":
                    datetime = datetime.plusYears(Long.parseLong(name[3]));
                    break;
            }
        }
        return datetime;
    }
}
