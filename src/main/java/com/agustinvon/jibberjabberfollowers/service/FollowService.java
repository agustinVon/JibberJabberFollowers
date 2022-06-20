package com.agustinvon.jibberjabberfollowers.service;

import com.agustinvon.jibberjabberfollowers.exceptions.AlreadyFollowedException;
import com.agustinvon.jibberjabberfollowers.model.Follow;
import com.agustinvon.jibberjabberfollowers.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FollowService {
    private FollowRepository followRepository;

    @Autowired
    public FollowService(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }

    public FollowService() {
    }

    public void followUser(String name, String username) {
        if (followRepository.findFirstByMainUserAndFollowedUser(name, username) != null) throw new AlreadyFollowedException("User is already followed");
        followRepository.save(new Follow(name, username));
    }

    public void unfollowUser(String name, String username) {
        Follow follow = followRepository.findFirstByMainUserAndFollowedUser(name, username);
        if (follow == null) throw new NoSuchElementException();
        followRepository.deleteById(follow.getId());
    }

    public List<Follow> findUserFollows(String name) {
        return followRepository.findAllByMainUser(name);
    }
}
