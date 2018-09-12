package top.kwseeker.emall.util;

import org.junit.Test;

import java.util.Date;

public class DateTimeUtilTest {

    @Test
    public void dateTimeUtilTest() {
        System.out.println(DateTimeUtil.dateToStr(new Date(),"yyyy-MM-dd HH:mm:ss"));
        System.out.println(DateTimeUtil.strToDate("2010-01-01 11:11:11","yyyy-MM-dd HH:mm:ss"));
    }
}