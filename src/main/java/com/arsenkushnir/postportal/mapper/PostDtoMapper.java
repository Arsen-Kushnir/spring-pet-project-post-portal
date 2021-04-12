package com.arsenkushnir.postportal.mapper;

import com.arsenkushnir.postportal.domain.Post;
import com.arsenkushnir.postportal.dto.ResponsePostDto;
import org.springframework.stereotype.Component;

@Component
public class PostDtoMapper {

    public ResponsePostDto toDto(Post post, String authorFullName){
        return ResponsePostDto.builder()
                .id(post.getId())
                .authorFullName(authorFullName)
                .title(post.getTitle())
                .anons(post.getAnons())
                .fullText(post.getFullText())
                .pictureUrl(post.getPictureUrl())
                .createdAt(post.getCreatedAt())
                .build();
    }
}
