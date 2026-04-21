package com.example.demo.controller;

import com.example.demo.dto.PostDto;
import com.example.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/gwaje")
public class PostController {
    private final PostService postService;

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Void> create(@RequestBody PostDto postDto) {
        postService.save(postDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public List<PostDto> getPosts() {
        return postService.findAll();
    }
    @GetMapping("/view/{id}")
    public PostDto getPost(@PathVariable("id") Long id) {
        return postService.findById(id);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody PostDto postDto) {
        postService.update(id, postDto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.ok().build();
    }
}