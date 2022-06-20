package com.agustinvon.jibberjabberfollowers.repository;

import com.agustinvon.jibberjabberfollowers.model.Follow;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface FollowRepository extends CrudRepository<Follow, UUID> {
    Follow findFirstByMainUserAndFollowedUser(@Param("user") String user, @Param("followedUser") String followedUser);
    List<Follow> findAllByMainUser(@Param("user") String user);
}
