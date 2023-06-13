package com.example.study.board.api.dto;


import lombok.Builder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public record BoardCommandDto() {
    public record BoardAddRequestDto(
            String title,
            String content
    ){}
    public record BoardUpdateRequestDto(
            String title,
            String content
    ){}
    @Builder
    public record BoardAddResponseDto(
            boolean success
    ){}
    @Builder
    public record BoardUpdateResponseDto(
            boolean success
    ){}
}
