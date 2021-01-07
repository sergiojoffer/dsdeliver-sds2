package com.devsuperior.dsdeliver.config;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public  class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private Environment env;

    @Override
    protected  void  configure ( HttpSecurity  http ) lança  exceção {
        if ( Arrays . AsList (env . GetActiveProfiles ()) . Contains ( " test " )) {
            http . cabeçalhos () . frameOptions () . desativar ();
        }

        http . cors () . e () . csrf () . desativar ();
        http . sessionManagement () . sessionCreationPolicy ( SessionCreationPolicy . SEM ESTADOS );
        http . authorizeRequests () . anyRequest () . permitAll ();
    }

    @Bean
    CorsConfigurationSource  corsConfigurationSource () {
        CorsConfiguration configuration =  new  CorsConfiguration () . applyPermitDefaultValues ​​();
        configuração . setAllowedMethods ( Arrays . asList ( " POST " , " GET " , " PUT " , " DELETE " , " OPTIONS " ));
        final  UrlBasedCorsConfigurationSource source =  new  UrlBasedCorsConfigurationSource ();
        fonte . registerCorsConfiguration ( " / ** " , configuração);
        fonte de retorno ;
    }
}
