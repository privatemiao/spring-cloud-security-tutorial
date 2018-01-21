package org.mel.springcloudsecurityresourceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableResourceServer
@RestController
public class SpringCloudSecurityResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudSecurityResourceServerApplication.class, args);
	}

	private Map<Integer, Account> map = new HashMap<>();
	@GetMapping("/api/account")
	public Collection<Account> getAccount(){
		if (ObjectUtils.isEmpty(map)) {
			map.put(111, new Account(111, "MastCard", "Mel", "CBC"));
			map.put(222, new Account(222, "MastCard", "John", "CBC"));
		}
		return map.values();
	}
}
