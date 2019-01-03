package com.djb.scout.contoller;

import com.djb.scout.NotFoundException;
import com.djb.scout.model.Content;
import com.djb.scout.repository.ContentRepository;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ContentController {
    @Autowired
    ContentRepository contentRepository;

    // Get all content
    @GetMapping("/contents")
    public List<Content> getAllContent() {
        return contentRepository.findAll();
    }

    // Create content
    @PostMapping("/contents")
    public Content createContent(@Valid @RequestBody Content content) {
        content.setTitle((getContentTitle(content.getUrl())));
        return contentRepository.save(content);
    }

    // Get content
    @GetMapping("/contents/{id}")
    public Content getContentById(@PathVariable(value="id") Long contentId) {
        return contentRepository.findById(contentId)
                .orElseThrow(() -> new NotFoundException("Content", "id", contentId) );
    }

    // Delete content
    @DeleteMapping("/contents/{id}")
    public ResponseEntity<?> deleteContent(@PathVariable(value="id")Long contentId) {
        Content content = contentRepository.findById(contentId)
                .orElseThrow(() -> new NotFoundException("content", "id", contentId));
        contentRepository.delete(content);
        return ResponseEntity.ok().build();
    }

    private String getContentTitle(String url) {
        String title = null;
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);

        try {
            HttpResponse response = client.execute(request);
            if(response.getStatusLine().getStatusCode() == HttpStatus.OK.value()) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        response.getEntity().getContent()
                ));
                StringBuffer result = new StringBuffer();
                String line = "";
                while((line = reader.readLine()) != null) {
                    result.append(line);
                }
                int startOfTitle = result.indexOf(">",result.indexOf("<title")) + 1;
                int endOfTitle = result.indexOf("</title>", startOfTitle);
                System.out.println("Start index = "+startOfTitle);
                System.out.println("End index = "+endOfTitle);
                title = result.substring(startOfTitle, endOfTitle);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return title;
    }
}
