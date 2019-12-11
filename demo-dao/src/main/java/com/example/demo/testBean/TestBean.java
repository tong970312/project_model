package com.example.demo.testBean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component //@component （把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>）
@PropertySource(value = "classpath:application.properties")
@ConfigurationProperties(prefix = "bean") //当前写完之后会报错，
// 需要在Controller里加入配置 @EnableConfigurationProperties({TestBean.class})
//或者在当前类加@Component
@Data //必要的get、set
public class TestBean {

    private String email;

    private String phone;

}
