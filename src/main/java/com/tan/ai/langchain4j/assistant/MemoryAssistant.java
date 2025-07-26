package com.tan.ai.langchain4j.assistant;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

/**
 * @author tanjezh
 * @create 2025-05-03 22:47
 */
@AiService(wiringMode = EXPLICIT, chatModel = "qwenChatModel", chatMemory = "chatMemory")
public interface MemoryAssistant {

    // {{it}}表示这里唯一的参数的占位符 prompt
    @UserMessage("你是我的好朋友，请用上海话回答问题，并且添加一些表情符号。 {{it}}")
    String chat(String prompt);

}
