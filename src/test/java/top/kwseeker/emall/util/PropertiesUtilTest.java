package top.kwseeker.emall.util;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class PropertiesUtilTest {

    @Test
    public void getProperty() {
        String value = PropertiesUtil.getProperty("password.salt");
        assertEquals("weiminsdafaqj23ou89ZXcj@#$@#$#@KJdjklj;D../dSF.,", value);
    }
}