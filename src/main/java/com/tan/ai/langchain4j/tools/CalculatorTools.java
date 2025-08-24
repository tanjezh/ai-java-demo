package com.tan.ai.langchain4j.tools;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.agent.tool.ToolMemoryId;
import org.springframework.stereotype.Component;

/**
 * @author tanjezh
 * @create 2025-08-24 16:20
 */
@Component
public class CalculatorTools {

    @Tool(name = "加法运算", value = "计算两个数字的和并返回结果")
    public double sum(
            @ToolMemoryId int memoryId,
            @P(value = "加数1", required = true) double a,
            @P(value = "加数2", required = true) double b) {
        System.out.println("调用加法运算 memoryId=" + memoryId);
        return a + b;
    }

    @Tool(name = "平方根运算", value = "计算数字的平方根并返回结果")
    public double squareRoot(@ToolMemoryId int memoryId, double x) {
        System.out.println("调用平方根运算 memoryId=" + memoryId);
        return Math.sqrt(x);
    }
}
