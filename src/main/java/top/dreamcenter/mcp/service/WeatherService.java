package top.dreamcenter.mcp.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Tool(description = "通过城市名字获取温度[伪]")
    public String getWeather(String cityName) {
        return cityName + "今天的温度是" + cityName.length()  * 10;
    }


}
