
# Manage
 这是一个后台管理的网站,使用了struts2，spring，hibernate 框架，基于mvc的编程思想，后台数据的增删改查管理，和用户权限的管理，订单流量的统计。
 同时该项目也能生成订单和打印订单。
### 实现功能 :
  为客户端提供数据，管理数据的增删改查，实现管理者与客户端的链接。 
### 开发平台：
  Windows8+ idea + JDK1.7+ Tomcat7+ MySql 所用技术：Java + （CSS+JS）+ HTML+ struts2框架+ Spring框架+hibernate框架 
### 设计思想：
（采用了MVC的设计思想） 界面和服务器交互模式 视图层 ( V ): HTML + js HTML界面 控制层 ( C ): Servlet （struts2框架） —>Servlet(Controller,Service,Dao) 业务层 ( M ): Service 数据处理层 ( M ): Dao 功能模块：登录管理、商品信息管理、订单管理 

### 所引用的包：
maven配置：

```
	<properties>
		<log4j.version>2.0.2</log4j.version>
		<spring.framework.version>3.1.4.RELEASE</spring.framework.version>
		<cxf.version>2.7.5</cxf.version>
	</properties>
		<build>
			<resources>
				<resource>
					<directory>src/main/java</directory>
					<includes>
						<include>**/*.xml</include>
					</includes>
					<filtering>true</filtering>
				</resource>
			</resources>
		<pluginManagement>

	      <plugins>
	  <plugin>  
                <groupId>org.apache.maven.plugins</groupId>  
                <artifactId>maven-war-plugin</artifactId>  
                <version>2.1.1</version>  
                <configuration>  
                    <packagingExcludes>WEB-INF/web.xml</packagingExcludes>    
                </configuration>  
            </plugin>
			  <plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>2.3.2</version>
			    <configuration>
			        <source>1.8</source>
			        <target>1.8</target>
			        <showWarnings>true</showWarnings>
			        <encoding>UTF-8</encoding>
			    </configuration>
			  </plugin>
	      </plugins>
	    </pluginManagement>
		
	</build>

	<dependencies>
		<!--cxf-->
		<dependency>
			<groupId>org.apache.cxf</groupId>
			<artifactId>cxf-rt-frontend-jaxws</artifactId>
			<version>${cxf.version}</version>
		</dependency>
		<dependency>
			<groupId>org.apache.cxf</groupId>
			<artifactId>cxf-rt-transports-http</artifactId>
			<version>${cxf.version}</version>
		</dependency>
		<dependency>
			<groupId>org.apache.cxf</groupId>
			<artifactId>cxf-rt-transports-http-jetty</artifactId>
			<version>${cxf.version}</version>
		</dependency>
		<!-- log4j2 -->
		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-api</artifactId>
			<version>${log4j.version}</version>
			<scope>compile</scope>
		</dependency>

		<!-- 加入fastjson依赖包 -->
		<dependency>
			<groupId>com.alibaba</groupId>
			<artifactId>fastjson</artifactId>
			<version>1.1.37</version>
		</dependency>

		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-core</artifactId>
			<version>${log4j.version}</version>
			<scope>runtime</scope>
		</dependency>

		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-jcl</artifactId>
			<version>${log4j.version}</version>
			<scope>runtime</scope>
		</dependency>

		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-slf4j-impl</artifactId>
			<version>${log4j.version}</version>
			<scope>runtime</scope>
		</dependency>

		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-taglib</artifactId>
			<version>${log4j.version}</version>
			<scope>runtime</scope>
		</dependency>

	<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
			<version>3.1.0</version>
			<scope>provided</scope>
		</dependency>
		<dependency>
	<groupId>junit</groupId>
	<artifactId>junit</artifactId>
	<version>4.10</version>
</dependency>

		<!--spring framework -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-test</artifactId>
			<version>${spring.framework.version}</version>
		</dependency>
		<dependency>
			<groupId>org.springframework.data</groupId>
			<artifactId>spring-data-jpa</artifactId>
			<version>1.3.2.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-jdbc</artifactId>
			<version>${spring.framework.version}</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
			<version>${spring.framework.version}</version>
			<scope>compile</scope>
		</dependency>

		<dependency>
			<groupId>org.aspectj</groupId>
			<artifactId>aspectjweaver</artifactId>
			<version>1.8.8</version>
		</dependency>

		<!-- hibernate begin -->
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-core</artifactId>
			<version>4.2.1.Final</version>
		</dependency>
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-entitymanager</artifactId>
			<version>4.2.1.Final</version>
		</dependency>
		<dependency>
			<groupId>org.hibernate.common</groupId>
			<artifactId>hibernate-commons-annotations</artifactId>
			<version>4.0.1.Final</version>
		</dependency>
		<!-- hibernate end -->

		<!-- validator  mysql el -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>5.1.35</version>
		</dependency>
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-validator</artifactId>
			<version>5.2.4.Final</version>
		</dependency>
		<dependency>
			<groupId>javax.el</groupId>
			<artifactId>javax.el-api</artifactId>
			<version>2.2.4</version>
		</dependency>
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>jstl</artifactId>
			<version>1.2</version>
		</dependency>
		<dependency>
			<groupId>javax.validation</groupId>
			<artifactId>validation-api</artifactId>
			<version>1.1.0.Final</version>
		</dependency>

		<!-- struts2 core 	struts2-spring-->
		<dependency>
			<groupId>org.apache.struts</groupId>
			<artifactId>struts2-spring-plugin</artifactId>
			<version>2.3.32</version>
		</dependency>
		<dependency>
			<groupId>org.apache.struts</groupId>
			<artifactId>struts2-core</artifactId>
			<version>2.3.32</version>
		</dependency>


		<dependency>
			<groupId>antlr</groupId>
			<artifactId>antlr</artifactId>
			<version>2.7.6</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/cglib/cglib-nodep -->
		<dependency>
			<groupId>cglib</groupId>
			<artifactId>cglib-nodep</artifactId>
			<version>2.1_3</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.apache.commons/commons-lang3 -->
		<dependency>
			<groupId>org.apache.commons</groupId>
			<artifactId>commons-lang3</artifactId>
			<version>3.1</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/commons-dbcp/commons-dbcp -->
		<dependency>
			<groupId>commons-dbcp</groupId>
			<artifactId>commons-dbcp</artifactId>
			<version>1.4</version>
		</dependency>
		<dependency>
			<groupId>commons-logging</groupId>
			<artifactId>commons-logging</artifactId>
			<version>1.1</version>
		</dependency>
		<dependency>
			<groupId>commons-collections</groupId>
			<artifactId>commons-collections</artifactId>
			<version>3.2.1</version>
		</dependency>

	</dependencies>
```
