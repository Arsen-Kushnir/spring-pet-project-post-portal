package com.arsenkushnir.postportal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostDto {

    @NotBlank(message = "Should not be empty!")
    private String title;

    @NotBlank(message = "Should not be empty!")
    private String anons;

    @NotBlank(message = "Should not be empty!")
    private String fullText;
}
