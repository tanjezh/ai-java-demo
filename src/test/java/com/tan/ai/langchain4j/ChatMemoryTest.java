package com.tan.ai.langchain4j;

import com.tan.ai.langchain4j.chatmemory.AssistantMemory;
import com.tan.ai.langchain4j.chatmemory.SimpleChatMemory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author tanjezh
 * @create 2025-05-03 22:24
 */
@SpringBootTest
public class ChatMemoryTest {

    @Autowired
    private SimpleChatMemory chatMemory;

    @Autowired
    private AssistantMemory assistantMemory;

    @Test
    public void testSimpleChat(){
        chatMemory.chat();
    }

    @Test
    public void testAssistant(){
//        assistantMemory.chat();
//        assistantMemory.assistantAnnotationChat();
        assistantMemory.separateAssistantChat();
    }


}
