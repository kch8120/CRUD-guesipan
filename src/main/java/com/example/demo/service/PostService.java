package com.example.demo.service;


import com.example.demo.dto.PostRequestDTO;
import com.example.demo.dto.PostResponseDTO;
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

    public PostResponseDTO save(PostRequestDTO requestDTO) {
        PostEntity postEntity = requestDTO.toEntity();
        PostEntity SavedEntity = postRepository.save(postEntity);
        return PostResponseDTO.fromEntity(SavedEntity);
    }
    public List<PostResponseDTO> findAll() {
        return postRepository.findAll()
                .stream()
                .map(PostResponseDTO::fromEntity)
                .toList();
    }

    public PostResponseDTO update(Long id, PostRequestDTO requestDTO) {
        PostEntity postEntity = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        if (requestDTO.getTitle() != null) {
            postEntity.setTitle(requestDTO.getTitle());
        }
        if (requestDTO.getContents() != null) {
            postEntity.setContents(requestDTO.getContents());
        }

        return PostResponseDTO.fromEntity(postEntity);
    }

    public PostResponseDTO findById(Long id) {
        PostEntity entity = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return PostResponseDTO.fromEntity(entity);
    }
    public void delete(Long id) {
        PostEntity post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글 없음"));
        postRepository.delete(post);
    }
}