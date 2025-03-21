package top.dreamcenter.mcp.config;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.dreamcenter.mcp.service.NumService;
import top.dreamcenter.mcp.service.WeatherService;

@Configuration
public class ToolCallbackProviderRegister {

    @Bean
    public ToolCallbackProvider weatherTools(WeatherService weatherService) {
        return MethodToolCallbackProvider.builder().toolObjects(weatherService).build();
    }

    @Bean
    public ToolCallbackProvider numTools(NumService numService) {
        return MethodToolCallbackProvider.builder().toolObjects(numService).build();
    }

}
