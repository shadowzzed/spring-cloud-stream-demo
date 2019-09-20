# spring-cloud-stream-demo
examples for spring-cloud-stream

# notes 笔记
# 入门
ref-blog: https://www.cnblogs.com/hellxz/p/9396282.html
### 作用
连接应用程序和中间件（MQ）<br>
<br>springcloud-stream的binder负责与中间件交互，是消息驱动的

### 绑定使用（绑定信道）
* 需要使用注解`@EnableBinding(类名)` 这个注解包含了`@Configuration` JSON格式可以添加多个
* 发送`@SendTo(信道名称)`
* 接受`@StreamListener(信道名称)`
<br>***需要注意的是：管道名称不能有输入和输出管道名相同的不然会自己发送自己接受从而报错*** <br>

### 注解注入和自动注入的区别
* 注解注入不能在发送或者接收时进行别的操作
* 自动注入可以
* 都需要添加`@EnableBinding`在类上面

### 其他配置
