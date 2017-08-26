Spring boot使用一个全局的配置文件application.properties或application.yml,
        放置在src/main/resource目录或者类路径的/config下。

        注意：目前IntelliJ IDEA只对Spring Boot的properties配置提供了自动提示的功能，
            且@PropertySource注解也不支持加载yaml文件。

使用Xml配置：Spring Boot提倡零配置(即无xml配置)，但实际项目中，可能有一些特殊要求必须使用
        xml配置，这时可通过Spring提供的@ImportResource来加载xml配置：
            @ImportResource({"classpath:a.xml","classpath:b.xml"})

外部配置(属性文件参数)：Spring Boot欲需使用properties文件、yaml文件或者命令行参数作为外部参数
        1.命令行参数配置：
            Spring Boot是可以基于jar包运行的，运行jar命令:
                java -jar xx.jar
            可以通过命令直接修改tomcat端口号：
                java -jar xx.jar --server。port=9090

        2.常规属性配置：spring环境与Spring boot环境
            1).在常规spring环境下，注入properties文件里的值的方式是通过@PropertySource指明
                properties文件的位置，然后通过@Value注入值。
            2).在SpringBoot环境里，只需要在application.properties文件里定义属性，然后
                直接使用@Value注入值即可。

                修改本项目，例子如下：
                    1.在application.properties文件里加入name和desc属性
                    2.修改入口类代码，在入口类里添加和使用属性

        3.类型安全的属性配置(基于properties):
            上例中使用@Value注入每个属性在有许多配置文件的情况下会有些麻烦，因为需要使用
                @Value注入很多次。
            Spring Boot提供了基于类型安全的配置方式，通过@ConfigurationProperties和properties
                属性和一个Bean及其属性关联，从而实现类型安全的配置。

            1).添加一个配置文件，在配置文件里添加属性(也可以直接在application.properties文件中添加)
                例如：创建author.properties，在里面添加author.name和author.age属性

            2).创建一个Bean(例如AuthorProperties),添加属性变量，添加@Compoment注解声明为spring组件，以及
                通过@ConfigurationProperties和配置文件关联

            3).@ConfigurationProperties：
                注解属性：locations : 关联的配置文件(配置文件位置)，如果是
                                        application.properties文件内的属性，则不用写
                          prefix : 关联属性的前缀，比如配置文件的属性是author.name，而
                                        bean里定义的变量名称是name,那么prefix = "author"

            4).在有使用到属性的类中，直接注入(@Autowired)属性bean来使用需要的属性
                @Autowired
                private AuthorProperties authorProperties;

                String name = authorProperties.getName();

            警告：Spring Boot 1.5版本以后取消了@ConfigurationProperties注解的locations属性，
                  1.可用@PropertySource注解替代@ConfigurationProperties注解的locations属性加载属性文件,
                  2.也可以直接使用@PropertySource注解和Environment对象操作属性
                  3.还可以在属性Bean里创建一个初始化方法，通过Environment对象设置变量的值，这样
                    就可以省略@ConfigurationProperties的perfix属性设置

日志配置：SpringBoot支持javaUtilLogging、Log4J、Logback作为框架日志，默认使用Logback
        在配置文件中配置日志参数：
            1).配置日志级别：
                logging.level.org.springframework.web=DEBUG
            2).配置日志文件：
                logging.file=D:/mylog/log.log

Profile配置(不同环境不同配置): Profile是Spring用来针对不同的环境对不同的配置提供支持的，
        全局Profile配置使用application-{profile}.properties,然后通过在application.properties中
        设置spring.profiles.active={profile}来指定活动的Profile

        例子如下：
            1).创建application-prod.properties和application-dev.properties
                设置application-prod.properties ：server.port=80
                设置application-dev.properties  ：server.port=8888
            2).在application.properties中增加spring.profiles.active=dev
            3).启动测试，分别测试dev和prod

WEB相关:src/main/resource/static:存放脚本样式、图片等静态资源
        src/main/resource/templates:存放页面
        1.视图模板引擎使用Thymeleaf
            引用jar包:spring-boot-starter=thymeleaf(包含了spring-boot-starter-web)

        2.替换web容器，把默认的tomcat替换为jetty或其他的，查看pom.xml

        3.https配置(SSL)
            1).首先生成证书，通过jdk再带的keytool工具：括号内的为解释，加密方式一定要写，火狐已放弃默认加密方式
                在doc命令行输入keytool -genkey -alias tomcat(别名) -keyalg RSA(加密方法)
                然后按照提示填写完成后，会在用户目录下生成一个名称为.keystore的证书文件
            2).把证书文件拷贝到项目的根目录下(根目录就是与pom文件同一级别)
            3).修改application.properties文件：只能在配置文件里配置http或者https其中的一个，剩下的要在代码中实现
                #修改默认端口号
                server.port=80
                #证书的目录，在项目根目录下
                server.ssl.key-store=.keystore
                #证书的密码
                server.ssl.key-store-password=handonglin
                #证书类型
                server.ssl.key-store-type=JKS
                #别名
                server.ssl.key-alias=tomcat(别名)
                #启用ssl
                server.ssl.enabled=true

        4.http转换成https:通过代码实现
            查看src/main/java/com.handl.springboot.common.spring.WebServerConfig文件




