package com.cc.gatewaydemo.utils;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static String getUTCTime(){
        String tStr = ZonedDateTime.now().format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
        return tStr;
    }
}
