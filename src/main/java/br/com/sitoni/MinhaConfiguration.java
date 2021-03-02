package br.com.sitoni;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinhaConfiguration {

    @Bean
    public String applicationName() {
        return "Cadastro de Pessoas";
    }
}
