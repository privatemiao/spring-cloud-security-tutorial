package org.mel.springcloudsecurityresttemplate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;

@SpringBootApplication
public class SpringCloudSecurityResttemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudSecurityResttemplateApplication.class, args);
    }

    @Bean
    public SecurityTemplate restTemplate() {
        return new SecurityTemplate();
    }

    class SecurityTemplate implements CommandLineRunner {
        @Override
        public void run(String... strings) {
            ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails();

            resource.setAccessTokenUri("http://127.0.0.1:9000/service/oauth/token");
            resource.setGrantType("password");
            resource.setClientId("springdeveloper123");
            resource.setClientSecret("test");
            resource.setUsername("allen");
            resource.setPassword("pass");
            resource.setClientAuthenticationScheme(AuthenticationScheme.header);

            OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resource);
            System.out.println(String.format("Result is: %s", restTemplate.getForObject(
                    "http://127.0.0.1:8080/resource/api/account", String.class
            )));
        }
    }

}
