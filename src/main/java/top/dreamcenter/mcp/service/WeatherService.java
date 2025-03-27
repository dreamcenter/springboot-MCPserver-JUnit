package top.dreamcenter.mcp.service;

import org.springframework.ai.autoconfigure.mcp.server.McpServerProperties;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class WeatherService {

    @Autowired
    private McpServerProperties mcpServerProperties;

    @Tool(description = "通过城市名字获取温度[伪]")
    public String getWeather(String cityName) {

        String prefix = "";

        if (mcpServerProperties.isStdio())  {
            // 获取environments
            Map<String, String> getenv = System.getenv();
            prefix = getenv.getOrDefault("dreamcenter", "X.X");
        }

        return prefix + cityName + "今天的温度是" + cityName.length()  * 10;
    }


}
