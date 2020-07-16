package com.shenjinxiang.spb;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shenjinxiang.spb.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/21 10:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ObjectMapperTest {

    @Resource(name = "objectMapper")
    private ObjectMapper objectMapper;

    @Autowired
    private User user;

    private String jsonStr ="{\n" +
            "    \"name\":\"张三丰\",\n" +
            "    \"age\":149,\n" +
            "    \"password\":\"123456\",\n" +
            "    \"address\":\"武当山\"\n" +
            "}";


    @Test
    public void writeUserTest() throws Exception {
        String json = objectMapper.writeValueAsString(user);
        System.out.println(json);
    }

    @Test
    public void readTreeTest() throws Exception {
        JsonNode jsonNode = objectMapper.readTree(jsonStr);
        System.out.println("name: " + jsonNode.get("name").asText());
        System.out.println("age: " + jsonNode.get("age").asInt());
        System.out.println("password: " + jsonNode.get("password").asText());
        System.out.println("address: " + jsonNode.get("address").asText());
    }

    @Test
    public void readValueTest() throws Exception {
        User user = objectMapper.readValue(jsonStr, User.class);
        System.out.println(user.toString());
    }

}
