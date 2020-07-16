package com.shenjinxiang.spb;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shenjinxiang.spb.domain.User1;
import com.shenjinxiang.spb.domain.User2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/22 15:17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonAnnotationTest {

    @Resource(name = "objectMapper1")
    private ObjectMapper objectMapper;

    @Autowired
    private User1 user1;

    @Autowired
    private User2 user2;


    @Test
    public void jsonPropertyWriteTest() throws Exception {
        String json = objectMapper.writeValueAsString(user1);
        System.out.println(json);
    }

    @Test
    public void jsonPropertyReadTest() throws Exception {
        String jsonStr ="{\n" +
                "    \"name\":\"张四丰\",\n" +
                "    \"age\":149,\n" +
                "    \"password\":\"123456\",\n" +
                "    \"bth\":\"2020-04-12 11:32:45\",\n" +
                "    \"addr\":\"武当山\"\n" +
                "}";
        User1 user = objectMapper.readValue(jsonStr, User1.class);
        System.out.println(user.toString());
    }

    @Test
    public void jsonIgnoreWriteTest() throws Exception {
        String json = objectMapper.writeValueAsString(user2);
        System.out.println(json);
    }

    @Test
    public void jsonIgnoreReadTest() throws Exception {
        String jsonStr ="{\n" +
                "    \"name\":\"张四丰\",\n" +
                "    \"age\":149,\n" +
                "    \"password\":\"123456\",\n" +
                "    \"birthday\":\"2020-04-12 11:32:45\",\n" +
                "    \"address\":\"武当山\"\n" +
                "}";
        User2 user = objectMapper.readValue(jsonStr, User2.class);
        System.out.println(user.toString());
    }

}
