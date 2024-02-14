package com.tpe;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan("com.tpe")
@EnableWebMvc
public class WebMvcConfig {

    //View e karsilik gelen jsp dosyasinin cozumlenmesi : view resolver.
    public InternalResourceViewResolver resourceViewResolver(){

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class); // Java Standart Tag Liblary
        //JSP Dosyalarinin icinde HTML taglerini kullanarak daha az kod yazmami saglar.
        resolver.setPrefix("/WEB-INF/views");
        resolver.setSuffix(".jsp");

        return  resolver;

    }



}
