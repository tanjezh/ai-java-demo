package com.tan.ai.langchain4j.config.memory;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tanjezh
 * @create 2025-05-03 22:52
 */
@Configuration
public class MemoryChatConfig {

    @Bean
    // 定义一个名为chatMemory的Bean
    public ChatMemory chatMemory(){
        // 返回一个MessageWindowChatMemory对象，最大消息数为10
        return MessageWindowChatMemory.withMaxMessages(10);
    }

}
