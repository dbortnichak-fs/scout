package com.djb.scout.controller;

import com.djb.scout.contoller.ContentController;
import com.djb.scout.contoller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ContentController.class, secure = false)
public class UserControllerTest {
    @Autowired
    UserController userController;

    @Test
    public void createUser() {

    }
}
