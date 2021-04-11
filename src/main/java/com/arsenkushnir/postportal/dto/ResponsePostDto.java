package com.arsenkushnir.postportal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePostDto {

    private Long id;

    private String authorFullName;

    private String title;

    private String anons;

    private String fullText;

    private LocalDateTime createdAt;
}
