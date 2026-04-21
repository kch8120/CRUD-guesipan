package com.example.demo.dto;

import com.example.demo.entity.PostEntity;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonPropertyOrder({"id", "title", "contents"})
public class PostDto {
    private Long id;
    private String title;
    private String contents;

    public static PostDto fromEntity(PostEntity entity) {
        PostDto dto = new PostDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setContents(entity.getContents());
        return dto;
    }
}