package org.mel.springcloudsecurityauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
@RestController
public class SpringCloudSecurityAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudSecurityAuthServerApplication.class, args);
	}

	@GetMapping("/user")
	public Principal getUser(Principal user){
		return user;
	}
}
