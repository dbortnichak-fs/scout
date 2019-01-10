package com.djb.scout;

import com.djb.scout.model.User;
import com.djb.scout.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ApplicationX {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationX.class);

    private static ApplicationContext context;

    @Autowired
    public ApplicationX() {



    }

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationX.class);

        ApplicationX appx = context.getBean(ApplicationX .class);

        appx.start();

    }

    private void start() {

        LOGGER.info("ApplicationX started.");

        // do stuff
        System.out.println("Got an app");
        User user = new User();
        user.setUserName("foobar");
        user.setPassword("password");
        user.setEmail("foo@bar.com");

        UserRepository userRepository = context.getBean(UserRepository.class);

        userRepository.save(user);

    }

}
