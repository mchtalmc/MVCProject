package com.tpe;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


// web.xml yerine kullanilir
//Servlet'in tanimlanmasi.
//Configuration Class'larinin yerlerini gosterme.
public class WebAppInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override  //Hibarnate/JDBC erisimi icin
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
                RootContexConfig.class
        };
    }

    @Override // Controller, Handler, Mapping, View , Resolver(MVC) ile ilgili config'leri icerir
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    @Override //Hangi Url ile gelen request'ler karsilanacak. O belirlenecek.
    // https://localhost:8080/SpringMVCProject/????????
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
