package com.tan.ai.langchain4j.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author tanjezh
 * @create 2025-06-29 16:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("chat_messages")
public class ChatMessage {

    // 唯一标识，映射到 mongodb 文档的 _id 字段
    @Id
    public ObjectId messageId;

    // 存储当天聊天记录列表的json字符串
    public String content;

}

