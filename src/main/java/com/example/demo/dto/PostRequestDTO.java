package com.example.demo.dto;

import com.example.demo.entity.PostEntity;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostRequestDTO {
    private String title;
    private String contents;

    public PostEntity toEntity() {
        return PostEntity.builder()
                .title(this.title)
                .contents(this.contents)
                .build();
    }
}