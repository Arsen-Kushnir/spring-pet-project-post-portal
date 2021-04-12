package com.arsenkushnir.postportal.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    private Long id;

    private Long authorUserId;

    private String title;

    private String anons;

    private String fullText;

    private String pictureUrl;

    private LocalDateTime createdAt;
}
