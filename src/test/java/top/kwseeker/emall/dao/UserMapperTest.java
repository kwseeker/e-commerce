package top.kwseeker.emall.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:applicationContext.xml")
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void checkUsername() {
        int resultCount = userMapper.checkUsername("admin");
        int resultCount1 = userMapper.checkUsername("notexistname");
        assertEquals(1, resultCount);
        assertEquals(0, resultCount1);
    }
}