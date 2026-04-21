package com.example.demo.service;

import com.example.demo.dto.PostDto;
import com.example.demo.entity.PostEntity;
import com.example.demo.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    private final PostRepository postRepository;

    public void save(PostDto postDto) {
        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(postDto.getTitle());
        postEntity.setContents(postDto.getContents());

        postRepository.save(postEntity);
    }
    public List<PostDto> findAll() {
        return postRepository.findAll()
                .stream()
                .map(PostDto::fromEntity)
                .toList();
    }

    public void update(Long id, PostDto postDto) {
        PostEntity postEntity = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        if (postDto.getTitle() != null) {
            postEntity.setTitle(postDto.getTitle());
        }
        if (postDto.getContents() != null) {
            postEntity.setContents(postDto.getContents());
        }
    }

    public PostDto findById(Long id) {
        PostEntity entity = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return PostDto.fromEntity(entity);
    }
    public void delete(Long id) {
        PostEntity post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글 없음"));
        postRepository.delete(post);
    }
}