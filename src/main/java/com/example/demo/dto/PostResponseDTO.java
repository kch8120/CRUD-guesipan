package com.example.demo.dto;

import com.example.demo.entity.PostEntity;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonPropertyOrder({"id", "title", "contents"})
public class PostResponseDTO {
    private final Long id;
    private final String title;
    private final String contents;

    public static PostResponseDTO fromEntity(PostEntity entity) {
        return PostResponseDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .contents(entity.getContents())
                .build();
    }
}