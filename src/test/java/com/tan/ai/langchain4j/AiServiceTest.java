package com.tan.ai.langchain4j;

import com.tan.ai.langchain4j.assistant.Assistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author tanjezh
 * @create 2025-05-03 20:47
 */
@SpringBootTest
public class AiServiceTest {

    @Autowired
    private QwenChatModel chatModel;

    @Test
    public void test(){
        Assistant assistant = AiServices.create(Assistant.class, chatModel);
        String chat = assistant.chat("油性发质有哪些？");
        System.out.println(chat);

    }

    // AiService 注解方式
    @Autowired
    private Assistant assistant;

    @Test
    public void test2() {
        String chat = assistant.chat("针对不同的油性头发出油，给出防止头发过度油腻的办法，并具体说说。");
        System.out.println(chat);
    }

}
