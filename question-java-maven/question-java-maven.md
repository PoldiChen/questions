# question-java-maven
some questions and answers for Maven.

#### 1. Maven包冲突如何解决？
包冲突常见的报错：
```
caused by: java.lang.NoSuchMethodError
caused by: java.lang.ClassNotFoundException
```
##### 依赖传递
项目需要依赖A的时候，在pom.xml中引入A的jar包，而A的jar包中又可能依赖B的jar包，maven会依次将A、B的jar包都引入进来。

##### jar包冲突原理
引入A、E后，D1、D2都会被引入，D1、D2是同一个依赖D的不同版本。<br>
调用D2的method1方法时，JVM加载的是D1的依赖，没有method1方法，就会报NoSuchMethodError错误。
```
A->B->C->D1(version 1.0)
E->F->D2(version 2.0)
```

##### jar包冲突解决方案：
Maven默认处理策略：<br>
最短路径优先：选择D2<br>
最先声明优先：如果路径长度一样，选择最先声明的<br>

##### 手动移除依赖
在pom.xml中使用\<exclusion>标签排除冲突的jar包
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
        <version>1.4.4.RELEASE</version>
        <exclusions>
            <exclusion>
                <groupId>com.google.guava</groupId>
                <artifactId>guava</artifactId>
            </exclusion>
    </exclusions>
</dependency>
```

#### 2. 常用的Maven命令？
mvn dependency:tree --查看依赖树<br>
mvn compile --编译类文件<br>
mvn package --打包（没有部署到本地仓库或私服仓库）<br>
mvn install --包括compile和package，并上传到本地仓库，没有上传到私服仓库<br>
mvn deploy --包括install，并上传到私服仓库<br>
mvn -version --查看版本<br>


#### 100.
