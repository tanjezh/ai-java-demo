package com.tan.ai.langchain4j;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.community.model.dashscope.WanxImageModel;
import dev.langchain4j.data.image.Image;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.language.LanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.output.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;

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

    // open ai 模型
    @Autowired
    private OpenAiChatModel chatModel;

    @Test
    public void testSpringAi(){
        String chatResult = chatModel.chat("人工智能未来发展如何？");
        System.out.println(chatResult);
    }

    // 本地 ollama 模型
    @Autowired
    private OllamaChatModel ollamaChatModel;

    @Test
    public void testOllama(){
        String chat = ollamaChatModel.chat("人工智能是什么？");
        System.out.println(chat);
    }

    // 阿里千问
    @Autowired
    private QwenChatModel qwenChatModel;

    @Test
    // 测试qwenChatModel的chat方法
    public void testQwen(){
        // 调用qwenChatModel的chat方法，传入参数"人工智能对普通人有什么影响？"
        String chat = qwenChatModel.chat("人工智能对普通人有什么影响？");
        // 打印chat的值
        System.out.println(chat);

    }

    @Test
    public void testAliWanx(){
        // 创建一个WanxImageModel对象，设置apiKey和modelName
        WanxImageModel imageModel = WanxImageModel.builder()
                .apiKey(System.getenv("DASHSCOPE_API_KEY"))
                .modelName("wanx2.1-t2i-turbo")
                .build();

        // 调用generate方法，传入描述文字，生成图片
        Response<Image> response = imageModel.generate("奇幻森林精灵：在一片弥漫着轻柔薄雾的 古老森林深处，阳光透过茂密枝叶洒下金色光斑。一位身材娇小、长着透明薄翼的精灵少女站在一朵硕大的蘑菇上。她 有着海藻般的绿色长发，发间点缀着蓝色的小花，皮肤泛着珍珠般的微光。身上穿着由翠绿树叶和白色藤蔓编织而成的 连衣裙，手中捧着一颗散发着柔和光芒的水晶球，周围环绕着五彩斑斓的蝴蝶，脚下是铺满苔藓的地面，蘑菇和蕨类植 物丛生，营造出神秘而梦幻的氛围。");
        // 获取生成的图片的URL
        URI url = response.content().url();
        // 打印URL
        System.out.println(url);
    }

}
