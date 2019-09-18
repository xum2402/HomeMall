#基于java8的环境
FROM java:8
#挂载到哪个目录
VOLUME /tmp
#添加jar包
ADD target/registry-0.0.1-SNAPSHOT.jar app.jar
#声明当前容器使用什么端口
EXPOSE 8761

ENTRYPOINT ["java","-jar","/app.jar"]