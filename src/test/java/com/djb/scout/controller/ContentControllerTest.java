package com.djb.scout.controller;

import com.djb.scout.contoller.ContentController;
import com.djb.scout.model.Content;
import com.djb.scout.model.User;
import com.djb.scout.repository.ContentRepository;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ContentController.class, secure = false)
public class ContentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContentRepository contentRepository;

    Content mockContent;
    User mockUser;

    @Before
    public void executedOnce() {
        mockUser = new User();
        mockUser.setId(1L);
        mockUser.setUserName("otto_tester");
        mockUser.setPassword("password");

        mockContent = new Content();
        mockContent.setTitle("Example Title");
        mockContent.setUrl("http://www.exmaple.com");
        mockContent.setUserId(mockUser.getId());

        String exampleJson = "{\"id\": 9,\"userId\": 1,\"createdAt\": \"2019-01-03T16:10:47.000+0000\",\"url\": \"https://www.earthworkdesign.com/\"," +
                "\"title\": \"Garden Design Construction &amp; Landscape | Yardley | Earth Work Design\"," +
                "\"imageUrl\": null\" }";
    }

    @Test
    public void retrieveDetailsForContent() throws Exception {

    }



}
