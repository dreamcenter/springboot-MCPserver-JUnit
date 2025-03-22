# Springboot + MCP + JUnit 模板项目

使用springboot快速构建一个mcp项目，项目支持 JUNIT单元测试。

模式支持： **STDIO** 和 **SSE**


解说视频： [BV1qUXkYRE6C](https://www.bilibili.com/video/BV1qUXkYRE6C)

### 开发环境

- 开发IDE: IDEA
- java版本: JAVA17 (Spring官方要求必须java17+)
- maven版本: 3.8.1 (太高引入项目时可能报错，请选择适当版本)

### 参考文档资料
1. [MCP官网](https://modelcontextprotocol.io/quickstart/server)
2. [Spring官网](https://docs.spring.io/spring-ai/reference/api/mcp/mcp-server-boot-starter-docs.html)


### 客户端测试方案

对于STDIO客户端配置方式：
```text
命令：java
参数：
    -jar
    -Dspring.ai.mcp.server.stdio=true
    AbsolutePath/**/xxx.jar
```

对于SSE客户端配置方式：
```text
SSE地址填写如下链接即可
http://主机地址:端口/sse
```
