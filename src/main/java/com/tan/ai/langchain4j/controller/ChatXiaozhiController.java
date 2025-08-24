package com.tan.ai.langchain4j.controller;

import com.tan.ai.langchain4j.assistant.XiaozhiAgent;
import com.tan.ai.langchain4j.bean.ChatForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanjezh
 * @create 2025-08-24 15:36
 */
@Tag(name = "硅谷小智")
@RestController
@RequestMapping("/chat")
public class ChatXiaozhiController {

    @Autowired
    private XiaozhiAgent xiaozhiAgent;

    @Operation(summary = "对话")
    @PostMapping("/xiaozhi")
    public String chat(@RequestBody ChatForm chatForm) {
        return xiaozhiAgent.chat(chatForm.getMemoryId(), chatForm.getChatMessage());
    }

}
