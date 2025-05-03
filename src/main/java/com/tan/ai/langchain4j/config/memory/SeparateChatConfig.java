package com.tan.ai.langchain4j.config.memory;

import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.store.memory.chat.InMemoryChatMemoryStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 记忆隔离配置类
 *
 * @author tanjezh
 * @create 2025-05-03 23:13
 */
@Configuration
public class SeparateChatConfig {

    @Bean
    public ChatMemoryProvider chatMemoryProvider(){
        // 返回一个ChatMemoryProvider对象
        return memoryId -> MessageWindowChatMemory.builder()
                .id(memoryId)
                .maxMessages(10)
                .chatMemoryStore(new InMemoryChatMemoryStore())
                .build();
        // 使用lambda表达式，根据memoryId创建一个MessageWindowChatMemory对象，并设置最大消息数为10
    }
}
