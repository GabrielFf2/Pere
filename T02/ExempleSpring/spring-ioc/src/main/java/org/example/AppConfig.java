package org.example;

import org.example.service.ITalker;
import org.example.service.TalkerEnglishImpl;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "org.example")
public class AppConfig {

//    @Bean
//    @Primary
//    public ISaludator saludator() {
//        return new SaludatorAdvancedImpl();
//    }

    @Bean
    @Primary
    public ITalker talker(){
        return new TalkerEnglishImpl();
    }
}
