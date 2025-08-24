package com.tan.ai.langchain4j.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

/**
 * 通过 chatMemoryProvider 实现聊天记忆的隔离
 *
 * @author tanjezh
 * @create 2025-05-03 23:10
 */
@AiService(wiringMode = EXPLICIT, chatModel = "qwenChatModel", chatMemoryProvider = "chatMemoryProvider",
// 调用工具
tools = "calculatorTools")
public interface SeparateAssistant {

    // 系统提示词注解
//    @SystemMessage("你是我的好朋友，请用东北话回答问题。今天是{{current_date}}")
    @SystemMessage(fromResource = "my-prompt.txt")
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);


    @UserMessage("你是我的好朋友，请用粤语回答问题。{{m}}")
    String chat2(@MemoryId int memoryId, @V("m") String userMessage);


    @SystemMessage(fromResource = "prompt-template.txt")
    String chat3(@MemoryId int memoryId, @UserMessage String userMessage, @V("username") String name, @V("age") int age);

}
