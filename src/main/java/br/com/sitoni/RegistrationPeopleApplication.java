package br.com.sitoni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RegistrationPeopleApplication extends SpringBootServletInitializer {

    /*@Autowired
    @Qualifier("applicationName")
    private String applicationName;*/

    //@Value("${application.name}")
    //private String applicationName;

//    @GetMapping("/hello")
//    public String helloWorld() {
//        return "<h1>HelloWorld<h1>";
//    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT", "PATCH");
                registry.addMapping("/**").exposedHeaders("Content-Disposition");
            }
        };
    }

    public static void main(String[] args) {

        SpringApplication.run(RegistrationPeopleApplication.class, args);

    }
}
