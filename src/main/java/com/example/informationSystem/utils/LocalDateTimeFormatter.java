package com.example.informationSystem.utils;

import org.springframework.format.Formatter;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateTimeFormatter implements Formatter<LocalDateTime> {
    @Override
    public LocalDateTime parse(String text, Locale locale) throws ParseException {
        String locDateTime = "^[0-9]{2}-[0-9]{1,2}-[0-9]{1,2}[0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}$";
        /*
         * 匹配日期格式
         */
        System.out.println(7777);
       if(text.trim().matches(locDateTime)){
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime ldt = LocalDateTime.parse(locDateTime,df);
            return ldt;

        }
        else {
            return null;
        }


    }


    @Override
    public String print(LocalDateTime object, Locale locale) {
        return null;
    }
}