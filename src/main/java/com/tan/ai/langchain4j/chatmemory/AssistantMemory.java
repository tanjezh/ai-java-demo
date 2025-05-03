package com.tan.ai.langchain4j.chatmemory;

import com.tan.ai.langchain4j.assistant.Assistant;
import com.tan.ai.langchain4j.assistant.MemoryAssistant;
import com.tan.ai.langchain4j.assistant.SeparateAssistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.service.AiServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 通过 assistant 构建聊天记忆功能
 * @author tanjezh
 * @create 2025-05-03 22:36
 */
@Component
public class AssistantMemory {

    @Autowired
    private QwenChatModel qwenChatModel;

    @Autowired
    MemoryAssistant memoryAssistant;

    @Autowired
    SeparateAssistant separateAssistant;

    public void chat(){
        // 使用 MessageWindowChatMemory 作为聊天记忆
        MessageWindowChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(10);

        Assistant assistant = AiServices.builder(Assistant.class)
                .chatLanguageModel(qwenChatModel)
                .chatMemory(chatMemory)
                .build();

        // 使用 assistant 进行聊天
        String chat = assistant.chat("我是大汤姆");
        String chat2 = assistant.chat("我是谁？");
        System.out.println(chat2);

    }

    public void assistantAnnotationChat(){
//        MemoryAssistant memoryAssistant = AiServices.builder(MemoryAssistant.class).build();
        String chat = memoryAssistant.chat("我是大聪明");
        System.out.println(chat);
        String chat2 = memoryAssistant.chat("我是谁？");
        System.out.println(chat2);

    }

    public void separateAssistantChat(){
        separateAssistant.chat(1, "我是大马哥");
        String chat = separateAssistant.chat(1, "我是谁？");
        System.out.println(chat);

        String chatId2 = separateAssistant.chat(2, "我是谁？");
        System.out.println(chatId2);
    }

}
