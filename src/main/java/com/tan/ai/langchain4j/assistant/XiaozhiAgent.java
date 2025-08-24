package com.tan.ai.langchain4j.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

/**
 * 小智助手
 * @author tanjezh
 * @create 2025-08-24 14:53
 */
@AiService(
        // 模式
        wiringMode = EXPLICIT,
        // 具体模型
        chatModel = "qwenChatModel",
        // 模型提供者类
        chatMemoryProvider = "xiaozhiMemoryProvider")
public interface XiaozhiAgent {

    @SystemMessage(fromResource = "xiaozhi-prompt.txt")
    String chat(@MemoryId Long memoryId, @UserMessage String userMessage);

}
