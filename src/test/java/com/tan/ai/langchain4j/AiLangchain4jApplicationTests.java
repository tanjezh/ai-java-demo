package com.tan.ai.langchain4j;

import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AiLangchain4jApplicationTests {

    @Test
    void contextLoads() {
        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl("http://langchain4j.dev/demo/openai/v1")
                .apiKey("demo")
                .modelName("gpt-4o-mini")
                .build();

        String chatResult = model.chat("如何学习人工智能？");
        System.out.println(chatResult);

    }

    @Autowired
    private OpenAiChatModel chatModel;

    @Test
    public void testSpringAi(){
        String chatResult = chatModel.chat("人工智能未来发展如何？");
        System.out.println(chatResult);
    }

}
