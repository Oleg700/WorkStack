package org.workstack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.workstack.model.User;
import org.workstack.service.user.UserService;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableAutoConfiguration
/*@ComponentScan("org.workstack")
@EnableJpaRepositories("org.workstack")*/
//@EntityScan("com.epam.news.model")
public class Application {

    @Autowired
    UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void init() {
        User user = userService.getUserByName("John");
        System.out.println(user.getEmail());
    }
}