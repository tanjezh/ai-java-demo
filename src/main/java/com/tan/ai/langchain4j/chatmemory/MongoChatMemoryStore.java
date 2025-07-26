package com.tan.ai.langchain4j.chatmemory;

import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.ChatMessageDeserializer;
import dev.langchain4j.data.message.ChatMessageSerializer;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * 用 mongodb 实现对话记忆存储
 * @author tanjezh
 * @create 2025-07-05 15:29
 */
@Component
public class MongoChatMemoryStore implements ChatMemoryStore {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<ChatMessage> getMessages(Object memoryId) {
        Criteria criteria = Criteria.where("memoryId").is(memoryId);
        Query query = new Query(criteria);
        // 这里查询到的是自定义的 chatmessage 对象
        com.tan.ai.langchain4j.bean.ChatMessage message = mongoTemplate.findOne(query, com.tan.ai.langchain4j.bean.ChatMessage.class);
        if (message == null) {
            return new LinkedList<>();
        }
        // 通过反序列化转化为 langchain4j 的 ChatMessage 数组对象
        String content = message.getContent();
        return ChatMessageDeserializer.messagesFromJson(content);
    }

    @Override
    public void updateMessages(Object memoryId, List<ChatMessage> list) {
        // 根据 Criteria 创建查询条件
        Criteria criteria = Criteria.where("memoryId").is(memoryId);
        Query query = new Query(criteria);
        // 把 list 数组转成 json 格式数据
        String messages = ChatMessageSerializer.messagesToJson(list);
        Update update = new Update().set("content", messages);
        // upsert 如果不存在则插入，存在则更新
        mongoTemplate.upsert(query, update, com.tan.ai.langchain4j.bean.ChatMessage.class);
    }

    @Override
    public void deleteMessages(Object memoryId) {
        // 根据 Criteria 创建查询条件
        Criteria criteria = Criteria.where("memoryId").is(memoryId);
        Query query = new Query(criteria);
        mongoTemplate.remove(query);
    }

}
