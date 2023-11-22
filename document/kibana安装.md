## Kinbana安装

#### 下载地址：https://www.elastic.co/cn/downloads/past-releases/

#### 启动步骤和es一致

#### 相关配置

需要配置kibana.yml文件

特殊端口配置，默认是5601：

```
server.port: 5601
```

主机地址配置，默认是localhost，远程不能连接；也可以配置本机局域网IP；配置0.0.0.0，表示所有远程机器可以连接：

```
server.host: "0.0.0.0"
```


Kibana配置Elasticsearch实例，该地址和端口必须与Elasticsearch实例中配置的network.host和http.port保持一致：

```
elasticsearch.hosts: ["http://localhost:9201"]
```

#### 命令行关闭kibana

- 关闭窗口
- ps -ef | grep 5601 或者 ps -ef | grep kibana 或者  lsof -i :5601
- kill -9 pid

#### 常见问题

![image-20231121114247651](C:\Users\87623\AppData\Roaming\Typora\typora-user-images\image-20231121114247651.png)



```
关于“Kibana server is not ready yet""问题的原因及解决办法
●	Kibana和Elasticsearch的版本不兼容。
		解决办法:保持版本一致
●	Elasticsearch的服 务地址和Kibana中配置的elasticsearch.hosts不同
		解决办法:修改kibana.ymI中的elasticsearch.hosts配置
●	Elasticsearch中禁止跨域访问
		解决办法:在elasticsearch.yml中配置允许跨域
●	服务器中开启了防火墙
		解决办法:关闭防火墙或者
●	Elasticsearch所在 磁盘剩余空间不足90%
		解决办法:清理磁盘空间，配置监控和报警
```

