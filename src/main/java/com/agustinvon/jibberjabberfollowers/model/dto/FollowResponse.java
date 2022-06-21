package com.agustinvon.jibberjabberfollowers.model.dto;

import com.agustinvon.jibberjabberfollowers.model.Follow;

import java.util.List;

public class FollowResponse {
    private final List<Follow> followList;

    public FollowResponse(List<Follow> followList) {
        this.followList = followList;
    }

    public List<Follow> getFollowList() {
        return followList;
    }
}
