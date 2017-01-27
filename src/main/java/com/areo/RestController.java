package com.areo;

import com.fasterxml.jackson.annotation.JacksonInject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

/**
 * Created by gta on 27.01.17.
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {



    @RequestMapping("/")
    public String index(){
        return "isOk";
    }


    @Bean
    public CommandLineRunner lineRunner(ApplicationContext ctx){

        return args -> {


            String[]beanDefinitionNames = ctx.getBeanDefinitionNames();

            Arrays.sort(beanDefinitionNames);
            for (String s : beanDefinitionNames) {
                System.out.println(s);
            }
        };
    }

}
