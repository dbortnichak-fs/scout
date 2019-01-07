package com.djb.scout.contoller;

import com.djb.scout.model.Follower;
import com.djb.scout.repository.FollowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class FollowerController {
    @Autowired
    FollowerRepository followerRepository;

    @PostMapping("/followers")
    public Follower createFollower(@Valid @RequestBody Follower follower) {
        return followerRepository.save(follower);
    }
}
