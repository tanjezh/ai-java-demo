package com.tan.ai.langchain4j;

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

    @Test
    public void test(){
        String chat = separateAssistant.chat(4, "今天几号？");
        System.out.println(chat);
    }

}
