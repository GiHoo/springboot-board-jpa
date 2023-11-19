package com.prgrms.springbootboardjpa.controller;

import com.prgrms.springbootboardjpa.ApiResponse;
import com.prgrms.springbootboardjpa.dto.PostDto;
import com.prgrms.springbootboardjpa.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.crossstore.ChangeSetPersister.*;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @ExceptionHandler(NotFoundException.class)
    public ApiResponse<String> notFoundHandler(NotFoundException e) {
        return ApiResponse.fail(404, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse<String> internalServerErrorHandler(Exception e) {
        return ApiResponse.fail(500, e.getMessage());
    }

    //게시글 조회 - 전체 조회
    @GetMapping("/posts")
    public ApiResponse<Page<PostDto>> getAll(Pageable pageable) {
        Page<PostDto> postDtos = postService.findAll(pageable);
        return ApiResponse.ok(postDtos);
    }

    //게시글 조회 - 단건 조회
    @GetMapping("/posts/{id}")
    public ApiResponse<PostDto> getOne(@PathVariable Long id) throws NotFoundException {
        PostDto postDto = postService.findOne(id);
        return ApiResponse.ok(postDto);
    }

    //게시글 작성
    @PostMapping("/posts")
    public ApiResponse<Long> create(@RequestBody PostDto postDto) {
        Long id = postService.create(postDto);
        return ApiResponse.ok(id);
    }

    //게시글 수정
//    @PostMapping("/posts/{id}")
//    public ApiResponse<String> update(@RequestBody PostDto postDto, @PathVariable String id) {
//
//    }
}
