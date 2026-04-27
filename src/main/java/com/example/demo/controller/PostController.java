package com.example.demo.controller;

import com.example.demo.dto.PostRequestDTO;
import com.example.demo.dto.PostResponseDTO;
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
    public ResponseEntity<PostResponseDTO> create(@RequestBody PostRequestDTO requestDTO) {
        PostResponseDTO response = postService.save(requestDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public List<PostResponseDTO> getPosts() {
        return postService.findAll();
    }
    @GetMapping("/view/{id}")
    public PostResponseDTO getPost(@PathVariable("id") Long id) {
        return postService.findById(id);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<PostResponseDTO> update(@PathVariable Long id, @RequestBody PostRequestDTO requestDTO) {
        PostResponseDTO response = postService.update(id, requestDTO);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.ok().build();
    }
}