package es.codeurjc.books;

import java.util.Arrays;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application {

    @Bean
    public Mapper mapper() {
        return new DozerBeanMapper(Arrays.asList("dozer_mapping.xml"));
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
