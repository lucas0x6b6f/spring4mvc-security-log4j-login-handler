Package Package
----------------------------
![image](https://github.com/lucas0x6b6f/spring4mvc-security-log4j-login-handler/blob/master/src/main/resources/package-explorer.png)


The Setting of spring-security.xml
----------------------------
1.handler-ref:

		authentication-success-handler-ref="LoginSucessHandler"
		authentication-failure-handler-ref="LoginFailureHandler"

2.bean id:
	
		<bean id="LoginSucessHandler" class="com.lucasko.handler.LoginSucessHandler" />
		<bean id="LoginFailureHandler" class="com.lucasko.handler.LoginFailureHandler" />
		
3.accounts:
```xml
	<user name="admin" password="P@ssw0rd" authorities="ROLE_ADMIN" />
	<user name="user" password="P@ssw0rd" authorities="ROLE_USER" />
```

4.
```XML
	<security:intercept-url pattern="/admin**"  access="ROLE_ADMIN" />
	<security:intercept-url pattern="/user**"	access="ROLE_USER" />
```

The Setting of log4j
----------------------------
log4j.rootLogger=INFO,stdout

log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.Target=System.out
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n


Run Project on Server
-----------------------------
1.[Markdown](http://127.0.0.1:8080/spring4mvc-security-login-log-handler/)

2.The logger of login admin:P@ssw0rd (LoginSucessHandler.java):

	2016-03-24 16:23:20 INFO  LoginSucessHandler:28 - username=admin
	2016-03-24 16:23:20 INFO  LoginSucessHandler:29 - ip address=127.0.0.1
	2016-03-24 16:23:20 INFO  LoginSucessHandler:34 - role=ROLE_ADMIN 

3.The logger of login user:P@ssw0rd (LoginSucessHandler.java):
		
	2016-03-24 16:25:29 INFO  LoginSucessHandler:28 - username=user
	2016-03-24 16:25:29 INFO  LoginSucessHandler:29 - ip address=127.0.0.1
	2016-03-24 16:25:29 INFO  LoginSucessHandler:37 - role=ROLE_USER 
4.The logger of login user:P@ssw0rd (LoginFailureHandler.java):

	2016-03-24 16:26:09 WARN  LoginFailureHandler:24 - username=test
	2016-03-24 16:26:09 WARN  LoginFailureHandler:25 - password=P@ssw0rd
	2016-03-24 16:26:09 WARN  LoginFailureHandler:26 - ip address=127.0.0.1

Before login
-----------------------------
![image](https://github.com/lucas0x6b6f/spring4mvc-security-log4j-login-handler/blob/master/src/main/resources/before-login.png)


After login
-----------------------------
![image](https://github.com/lucas0x6b6f/spring4mvc-security-log4j-login-handler/blob/master/src/main/resources/after-login.png)

