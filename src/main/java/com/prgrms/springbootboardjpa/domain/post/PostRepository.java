package com.prgrms.springbootboardjpa.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

//    @Query("UPDATE Post p SET p.title = post.title, p.content = post.content WHERE p.id = id")
//    Optional<Post> updateById(Post post, Long id);
}
