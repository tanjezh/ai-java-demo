package com.tan.ai.langchain4j;

import com.tan.ai.langchain4j.assistant.MemoryAssistant;
import com.tan.ai.langchain4j.assistant.SeparateAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author tanjezh
 * @create 2025-07-26 15:49
 */
@SpringBootTest
public class PromptTest {

    @Autowired
    private SeparateAssistant separateAssistant;

    @Autowired
    private MemoryAssistant memoryAssistant;

    @Test
    public void test(){
        String chat = separateAssistant.chat(5, "今天几号？");
        System.out.println(chat);
    }

    @Test
    public void testMemory(){
        String chat1 = memoryAssistant.chat( "我是瑞森");
        System.out.println(chat1);

        String chat2 = memoryAssistant.chat( "今天几号？");
        System.out.println(chat2);

        String chat3 = memoryAssistant.chat( "我是谁？");
        System.out.println(chat3);
    }

    @Test
    public void testSep2(){
        String q1 = separateAssistant.chat2(6, "我是瑞森");
        System.out.println(q1);
        String q2 = separateAssistant.chat2(6, "你知道我是谁吗？");
        System.out.println(q2);

    }

}
