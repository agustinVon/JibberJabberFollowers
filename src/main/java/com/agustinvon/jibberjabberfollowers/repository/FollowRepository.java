package com.agustinvon.jibberjabberfollowers.repository;

import com.agustinvon.jibberjabberfollowers.model.Follow;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FollowRepository extends CrudRepository<Follow, UUID> {
    Optional<Follow> findFirstByMainUserAndFollowedUser(@Param("user") String user, @Param("followedUser") String followedUser);
    List<Follow> findAllByMainUser(@Param("user") String user);
    Optional<Follow> findByMainUserAndFollowedUser(@Param("user") String user, @Param("followedUser") String followedUser);
}
