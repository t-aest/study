## Elasticsearch安装

#### 下载地址：https://www.elastic.co/cn/downloads/past-releases/

#### 目录结构：

| 目录名称 |                             描述                             |
| :------: | :----------------------------------------------------------: |
|   bin    | 可执行脚本文件，包括启动elasticsearch服务、 插件管理、函数命令等。 |
|  config  |  配置文件目录，如elasticsearch配置、 角色配置、jvm配置等。   |
|   lib    |                elasticsearch所依赖的java库。                 |
|   data   | 默认的数据存放目录，包含节点、分片、索引、文档的所有数据，生产环境要求必须修改。 |
|   logs   |          默认的日志文件存储路径，生产环境务必修改。          |
| modules  | 包含所有的Elasticsearch模块，如Cluster、 Discovery、 Indices等 。 |
| plugins  |                     已经安装的插件的目录                     |
|   jdk    |                 7.0以后才有，自带的java环境                  |

#### 配置文件修改：

如果jdk环境不是11以及以上需要修改bin目录下 的elasticsearch-env。

修改如下内容

```
# now set the path to java
# 注释掉原来的配置信息
#if [ ! -z "$JAVA_HOME" ]; then
#  JAVA="$JAVA_HOME/bin/java"
#  JAVA_TYPE="JAVA_HOME"
#else
#  if [ "$(uname -s)" = "Darwin" ]; then
#    # macOS has a different structure
#    JAVA="$ES_HOME/jdk.app/Contents/Home/bin/java"
#  else
#    JAVA="$ES_HOME/jdk/bin/java"
#  fi
#  JAVA_TYPE="bundled jdk"
#fi
export JAVA_HOME=/root/software/elasticsearch-7.10.0/jdk
export PATH=$JAVA_HOME/bin:$PATH

if [ -x "$JAVA_HOME/bin/java" ]; then
        JAVA="/root/software/elasticsearch-7.10.0/jdk/bin/java"
else
        JAVA=`which java`
fi
```

#### 创建并切换用户启动：

es为了安全不允许使用root用户启动

1. 创建用户：

   ```
   adduser elasticsearch
   ```

2. 创建用户密码，需要输入两次：

   ```
   passwd elasticsearch
   ```

   my test pwd 123456

3. 将对应的文件夹权限赋给该用户：

   ```
   chown -R elasticsearch /root/software/elasticsearch-7.10.0
   ```

   

4. 切换至elasticsearch用户：

   ```
   su elasticsearch
   ```

   

#### 单节点启动：

![](C:\Users\87623\Desktop\document\es单节点启动.png)

|        | Windows                                 | Linux                                   | MacOS   |
| ------ | --------------------------------------- | --------------------------------------- | ------- |
| 命令行 | cd elasticsearch\bin .\elasticsearch -d | cd elasticsearch\bin ./elasticsearch -d | 同linux |

验证服务：http://localhost:9200

#### 多节点启动：

![image-20231120182954812](C:\Users\87623\AppData\Roaming\Typora\typora-user-images\image-20231120182954812.png)

```
./elasticsearch -E path.data=data1 E path.logs=log1 -E node.name=node1 -E cluster.name=clustertest

./elasticsearch -E path.data=data2 E path.logs=log2 -E node.name=node2 -E cluster.name=clustertest
```

#### 异常问题排查

```
##### 异常

max file descriptors [4096] for elasticsearch process is too low, increase to at least [65535]

##### 解决方案

将当前用户的软硬限制调大。

找到文件 /etc/security/limits.conf，编辑，在文件的最后追加如下配置：

elasticsearch soft nofile 65535

elasticsearch hard nofile 65537

soft nofile表示软限制，hard nofile表示硬限制
```



```
##### 异常

[1]: the default discovery settings are unsuitable for production use; at least one of [discovery.seed_hosts, discovery.seed_providers, cluster.initial_master_nodes] must be configured

##### 解决方案

vim config/elasticsearch.yml


#添加配置
discovery.seed_hosts: ["127.0.0.1"]

cluster.initial_master_nodes: ["node-1"]
```

