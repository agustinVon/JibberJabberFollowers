package com.agustinvon.jibberjabberfollowers.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name= "follow_relations")
public class Follow {

    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String mainUser;

    @Column
    private String followedUser;

    public Follow(String mainUser, String followedUser) {
        this.mainUser = mainUser;
        this.followedUser = followedUser;
    }

    public Follow() {
    }

    public void setMainUser(String mainUser) {
        this.mainUser = mainUser;
    }

    public void setFollowedUser(String followedUser) {
        this.followedUser = followedUser;
    }

    public UUID getId() {
        return id;
    }

    public String getMainUser() {
        return mainUser;
    }

    public String getFollowedUser() {
        return followedUser;
    }
}
