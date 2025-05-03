package com.tan.ai.langchain4j.chatmemory;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.response.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author tanjezh
 * @create 2025-05-03 22:17
 */
@Component
public class SimpleChatMemory {

    @Autowired
    private QwenChatModel chatModel;

    public void chat(){
        // 用户提问
        UserMessage userMessage = new UserMessage("我是大汤姆");
        ChatResponse chatResponse = chatModel.chat(userMessage);
        // 基于第一次提问的 AI 回复
        AiMessage aiMessage = chatResponse.aiMessage();
        // 第二次提问
        UserMessage secondMsg = new UserMessage("你知道我是谁吗？");
        // 第二次提问的回复
        ChatResponse secondRes = chatModel.chat(Arrays.asList(userMessage, aiMessage, secondMsg));
        // 打印第二次提问的回复内容
        System.out.println(secondRes.aiMessage().text());
    }


}
