package com.dev.springsecurity6jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.springsecurity6jwt.entities.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long>{
    
}
