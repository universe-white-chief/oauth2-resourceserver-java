package sddtc.oauth2.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

/**
 * Created by sddtc on 2017/3/31.
 */
@SpringBootApplication
@EnableResourceServer
public class OAuth2ResourceServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OAuth2ResourceServerApplication.class, args);
    }

    @Autowired
    private ResourceServerProperties sso;

    @Bean
    public ResourceServerTokenServices myUserInfoTokenServices() {
        return new CustomUserInfoTokenServices(sso.getUserInfoUri(), sso.getClientId());
    }
}
