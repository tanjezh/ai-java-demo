package com.tan.ai.langchain4j;

import com.tan.ai.langchain4j.assistant.SeparateAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author tanjezh
 * @create 2025-08-24 15:58
 */
@SpringBootTest
public class CalculateTest {

    @Autowired
    private SeparateAssistant separateAssistant;

    @Test
    public void test(){
        // 689,706.48653
        String chat = separateAssistant.chat(99, "1+2等于几，475695037565的平方根是多少？");
        System.out.println(chat);
    }

}
