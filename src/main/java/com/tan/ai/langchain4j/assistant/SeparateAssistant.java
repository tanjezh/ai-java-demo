package com.tan.ai.langchain4j.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

/**
 * 通过 chatMemoryProvider 实现聊天记忆的隔离
 *
 * @author tanjezh
 * @create 2025-05-03 23:10
 */
@AiService(wiringMode = EXPLICIT, chatModel = "qwenChatModel", chatMemoryProvider = "chatMemoryProvider")
public interface SeparateAssistant {

    String chat(@MemoryId int id, @UserMessage String message);

}
