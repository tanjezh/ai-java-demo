package com.tan.ai.langchain4j.assistant;

import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

/**
 * @author tanjezh
 * @create 2025-05-03 22:47
 */
@AiService(wiringMode = EXPLICIT, chatModel = "qwenChatModel", chatMemory = "chatMemory")
public interface MemoryAssistant {

    String chat(String prompt);

}
