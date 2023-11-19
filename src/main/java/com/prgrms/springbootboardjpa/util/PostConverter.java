package com.prgrms.springbootboardjpa.util;

import com.prgrms.springbootboardjpa.domain.post.Post;
import com.prgrms.springbootboardjpa.domain.user.User;
import com.prgrms.springbootboardjpa.dto.PostDto;
import com.prgrms.springbootboardjpa.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class PostConverter {

    // dto -> entity
    public Post convertToPost(PostDto postDto) {
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());

        post.setUser(this.convertToUser(postDto.getUserDto()));

        return post;
    }

    public User convertToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setAge(userDto.getAge());
        user.setHobby(userDto.getHobby());

        return user;
    }

    // entity -> dto
    public PostDto convertToPostDto(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .userDto(convertToUserDto(post.getUser()))
                .build();
    }

    public UserDto convertToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .age(user.getAge())
                .hobby(user.getHobby())
                .build();
    }
}
