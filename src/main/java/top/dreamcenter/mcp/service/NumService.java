package top.dreamcenter.mcp.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

@Service
public class NumService {

    @Tool(description = "判断是否是双数")
    public String judgeIfOdd(@ToolParam(description = "待判断的数") Integer num) {
        return num + (num%2 == 0 ? "是双数" : "不是双数");
    }

}
