package com.tpe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:application.properties")
public class RootContexConfig {

    //Sprin MVC icerisinde olan bir interface
    //Bu sekilde dogrudan enjekte edebiliyorum @Bean olusturmadan
    //Properties.source icerisinde belirtmis oldugum dosyadan direkt okumami sagliyor.
    //hibernateProperties methodunda properties'lere ulasabilmek icin kullandim.
    private Environment environment;



    //Hibernate DB ile iletisim icin Session objesi olusturuyorum.
    //SessionFactory'nin bu objesini kullanarak session acmam gerekiyor. Spring'de class'in objesini uygulamanin
    //Her yerinde kullabilmek icin @Bean kullaniyorum. Bu sekilde diger class'lar session'in objesini diger class'lar da kullanabilecek.
    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setHibernateProperties(hibernateProperties()); //Hibernate ozelliklerini belirtecegim
        sessionFactory.setDataSource(dataSource()); // JDBC icin gerekli bilgiler belirtilecek.
        sessionFactory.setPackagesToScan(new String[]{"com.tpe.doamain"});
        // Hibernate'de Entity Class'larimiz var ve bu class'lar maplenerek DB'de
        //Tablo olusmasini istiyorum. Burada entity class'larinin yerini belirtecegim
        return sessionFactory;
    }
    private Properties hibernateProperties (){
        Properties properties= new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibarnate.dialect"));
        properties.put("hibarnate.show_sql", environment.getRequiredProperty("hibarnate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibarnate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibarnate.hbm2ddl.auto"));
        return properties;
    }

    //JDBC ayarlarini set edebilmek icin olusturdum.
    private DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }

}
