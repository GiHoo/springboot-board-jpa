package com.prgrms.springbootboardjpa.service;

import com.prgrms.springbootboardjpa.domain.post.Post;
import com.prgrms.springbootboardjpa.domain.post.PostRepository;
import com.prgrms.springbootboardjpa.dto.PostDto;
import com.prgrms.springbootboardjpa.util.PostConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.data.crossstore.ChangeSetPersister.*;

@Service
public class PostService {

    private final PostRepository repository;
    private final PostConverter converter;

    public PostService(PostRepository repository, PostConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Transactional
    public PostDto findOne(Long id) throws NotFoundException {
        return repository.findById(id)
                .map(converter::convertToPostDto)
                .orElseThrow(NotFoundException::new);
    }

    @Transactional
    public Page<PostDto> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(converter::convertToPostDto);
    }

    @Transactional
    public Long create(PostDto postDto) {
        Post post = converter.convertToPost(postDto);
        return repository.save(post).getId();
    }

//    @Transactional
//    public PostDto update(PostDto postDto, Long id) {
//        Post post = converter.convertToPost(postDto);
//        repository.updateById(post, id);
//    }
}
