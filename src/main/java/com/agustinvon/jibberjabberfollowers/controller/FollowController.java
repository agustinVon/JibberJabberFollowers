package com.agustinvon.jibberjabberfollowers.controller;

import com.agustinvon.jibberjabberfollowers.model.Follow;
import com.agustinvon.jibberjabberfollowers.model.dto.FollowResponse;
import com.agustinvon.jibberjabberfollowers.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/follow")
public class FollowController {

    private final FollowService followService;

    @Autowired
    public FollowController(FollowService followService) {
        this.followService = followService;
    }

    @PostMapping("/{username}")
    public ResponseEntity<String> followUser(@PathVariable String username, Principal principal) {
        followService.followUser(principal.getName(), username);
        return ResponseEntity.ok("Following " + username);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<String> unfollowUser(@PathVariable String username, Principal principal) {
        followService.unfollowUser(principal.getName(), username);
        return ResponseEntity.ok("Stopped following " + username);
    }

    @GetMapping
    public ResponseEntity<FollowResponse> getAllFollowedUsers(Principal principal) {
        return ResponseEntity.ok(new FollowResponse(followService.findUserFollows(principal.getName())));
    }
    // test

    @GetMapping("/{username}")
    public ResponseEntity<Boolean> isFollowingByID(@PathVariable String username, Principal principal) {
        return ResponseEntity.ok(followService.isFollowedByID(principal.getName(),username));
    }
}
