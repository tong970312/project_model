#####加载配置文件内容
##### 1、配置文件 
        bean.email=1111111111@qq.com
        bean.phone=22222222222
##### 2、创建测试实体类 TestBean(任意地方)
        @Component 
        @PropertySource(value = "classpath:application.properties")
        @ConfigurationProperties(prefix = "bean") 
        @Data 
        public class TestBean {
            private String email;
            private String phone;
        }
>注意
- ##### @component （把普通实体类实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>）
- ##### 当前写完之后会报错，需要在Controller里加入配置 @EnableConfigurationProperties({TestBean.class}) 或者在当前类加@Component
- ##### 必要的get、set方法 或者直接用lombok的@Data标注

######3、[SpringBoot整合AOP](https://blog.csdn.net/lmb55/article/details/82470388)