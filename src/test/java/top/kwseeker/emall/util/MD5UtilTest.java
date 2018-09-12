package top.kwseeker.emall.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class MD5UtilTest {

    @Test
    public void MD5EncodeUtf8() {
        String password = "112358";
        String passwordMD5 = MD5Util.MD5EncodeUtf8(password);
        System.out.println(passwordMD5);
    }
}