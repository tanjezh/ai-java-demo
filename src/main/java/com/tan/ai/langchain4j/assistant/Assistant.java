package com.tan.ai.langchain4j.assistant;

import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

/**
 * @author tanjezh
 * @create 2025-05-03 20:41
 */
@AiService(wiringMode = EXPLICIT, chatModel = "qwenChatModel")
public interface Assistant {

    // 根据提示返回聊天内容
    String chat(String prompt);

}
