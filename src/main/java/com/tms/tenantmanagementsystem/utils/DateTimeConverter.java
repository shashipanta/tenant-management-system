package com.tms.tenantmanagementsystem.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateTimeConverter {

    private final static DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy/MM/dd - hh:mm:ss");

    public static String dateTimeToString(LocalDateTime ldt){
        return ldt.format(formatter);
    }
}
