package com.tan.ai.langchain4j;

import com.tan.ai.langchain4j.bean.ChatMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 * @author tanjezh
 * @create 2025-06-29 16:52
 */
@SpringBootTest
public class MongoTest {

    @Autowired
    private MongoTemplate mongoTemplate;


//    @Test
//    public void testInsert(){
//        mongoTemplate.insert(new ChatMessage(1L, "聊天记录"));
//    }

    // 插入操作
    @Test
    public void testInsert2(){
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setContent("聊天记录列表");
        mongoTemplate.insert(chatMessage);
    }

    // 查询操作
    @Test
    public void testFind(){
        ChatMessage chatMessage = mongoTemplate.findById("68610567e3731d1334db87e4", ChatMessage.class);
        System.out.println(chatMessage);
    }

    // 更新操作
    @Test
    public void testUpdate(){
        // 如果 id 字段和数据库不匹配，则会新建一条记录
        Criteria criteria = Criteria.where("_id").is("100");
        Query query = new Query(criteria);
        Update u = new Update().set("content", "更新后的聊天记录");

        // 修改或新增
        mongoTemplate.upsert(query, u, ChatMessage.class);
    }

    // 删除操作
    @Test
    public void testDelete(){
        Criteria criteria = Criteria.where("_id").is("100");
        Query query = new Query(criteria);
        mongoTemplate.remove(query, ChatMessage.class);
    }

}
