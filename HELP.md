
### 多模块项目搭建
### 问题汇总
----------------------------------------------------
1、java.sql.SQLException: The server time zone value '�й���׼ʱ��' is unrecognized or represents more than one time zone. You must configure either the server or JDBC driver (via the serverTimezone configuration property) to use a more specifc time zone value if you want to utilize time zone support.
> 解决:时区问题,在配置数据库的url后面加上 serverTimezone=GMT%2B8
 
2、Invalid bound statement (not found):
> 检查配置文件的mapper文件路径是否配置或正确 -->mybatis.mapper-locations

3、Always use constructor based dependency injection in your beans. 
   Always use assertions for mandatory
> Spring不太推荐这种,推荐写法
   
    @Service
    public class OrderService {
        private final UserService userService;
        @Autowired
        public OrderService(UserService userService) {
            this.userService = userService;
        }
    }
    但注入太多,又会很繁琐 ----
    这种是lombok的写法,有可能出现Spring循环引用的问题，不推荐
       
       @Service
       @RequiredArgsConstructor(onConstructor = @__(@Autowired))
       public class OrderService {
           //这里必须是final,若不使用final,用@NotNull注解也是可以的
           private final UserService userService;
       
       }
> ~循环依赖：详情[理解Spring循环引用（循环依赖](https://blog.csdn.net/chen2526264/article/details/80673598)

    假设 通过依赖注入的方式,A依赖B,B又依赖了A,在Spring容器中A、B就存在循环依赖 
    (前提了解Spring依赖注入方式、Spring的bean的作用域、Spring延迟加载)
    (1) 当循环依赖的bean都是通过构造器注入依赖的时候，无论这些bean是singleton还是prototype，
    在获取bean的时候都会失败。
    (2) 循环依赖的bean都是通过属性注入依赖的时候，根据bean的作用域是singleton还是prototpye，会有不同的表现。
        如果循环依赖的bean都是singleton，那么无论先获取哪个bean，都能成功。
        如果循环依赖的bean都是prototype，那么无论先获取哪个bean，都会失败。
        如果循环依赖的bean中有singleton，也有prototype，那么当先获取的那个bean是singleton时，就会成功，否则失败。
        

