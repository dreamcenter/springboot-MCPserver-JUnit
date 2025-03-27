# Springboot + MCP + JUnit 模板项目

<hr/>

>使用springboot快速构建一个mcp项目，项目支持 JUNIT单元测试。
> 
>模式支持： **STDIO** 和 **SSE**


> **解说视频：**
> * 全网首发：从零搭建 Springboot+MCP+JUnit 项目 【搭配CherryStudio】[BV1qUXkYRE6C](https://www.bilibili.com/video/BV1qUXkYRE6C)
> * 全网首发：Springboot+MCP(SSE)+JUnit 从搭建到上线  [BV1rSXWYGEVz](https://www.bilibili.com/video/BV1rSXWYGEVz)

<hr/>

### 开发环境

- 开发IDE: IDEA
- java版本: JAVA17 (Spring官方要求必须java17+)
- maven版本: 3.8.1 (太高引入项目时可能报错，请选择适当版本)

### 参考文档资料
1. [MCP官网-协议](https://spec.modelcontextprotocol.io) (必读文档)
2. [MCP官网-编码指南](https://modelcontextprotocol.io/quickstart/server)
3. [Spring官网](https://docs.spring.io/spring-ai/reference/api/mcp/mcp-server-boot-starter-docs.html)


### 客户端测试方案

#### 1. 对于STDIO客户端配置方式：
```text
命令(Command)：
    java
参数(Arguments)：
    -jar
    -Dfile.encoding=UTF-8
    -Dspring.ai.mcp.server.stdio=true
    AbsolutePath/**/xxx.jar
环境(Environments)：
    env1=xxx
    env2=yyy
```
指令是java（如果本地主环境不是17+，注意切换）；

参数file.encoding指定System.in和System.out为UTF-8编码，避免编码问题；

参数spring.ai.mcp.server.stdio表示以stdio的方式启用该服务；

环境配置，是将配置写入当前系统环境，以供当前程序调取。

<br/>

#### 2. 对于SSE客户端配置方式：
```text
SSE地址填写如下链接即可
http://主机地址:端口/sse
```


<hr/>

### 额外可选功能的探索
#### 1. 修改消息端点
配置文件参见：McpServerProperties
```yaml
spring.ai.mcp.server.sseMessageEndpoint=/mcp/message
```
#### 2. 修改sse端点
原始的sse端点在/sse，而配置文件没有提供sse端点的配置方式，所以需要重新注入 **ServerMcpTransport** 来换掉原来的。

注意下面两个Bean配置都要加，因为自动注入文件 **MpcWebMvcServerAutoConfiguration** 中，对整个注册的注入条件是
@ConditionalOnMissingBean(ServerMcpTransport.class)，导致下面两个bean都不会注入


```java
private final String SSE_ENDPOINT = "/sse";

@Bean
@ConditionalOnMissingBean
public WebMvcSseServerTransport webMvcSseServerTransport(ObjectMapper objectMapper,
        McpServerProperties serverProperties) {
    return new WebMvcSseServerTransport(objectMapper, serverProperties.getSseMessageEndpoint(), SSE_ENDPOINT);
}

@Bean
public RouterFunction<ServerResponse> mvcMcpRouterFunction(WebMvcSseServerTransport transport) {
    return transport.getRouterFunction();
}
```

#### 3. 一服务多端点？
需要重新注入多个 **McpSyncServer** ，详见类 **MpcServerAutoConfiguration** 。

因为多端点可能会涉及到的东西非常多，感兴趣的可以自己研究，我就只提供这样的指引啦！

#### 4. SSE授权？
在2025.03.26 的MCP官方协议文档中，更新了鉴权方案，
期待Spring的更新。


<br/>
<hr/>

Bye.ヾ(•ω•`)o