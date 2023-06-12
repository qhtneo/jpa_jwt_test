package com.example.study.board.api.dto;


import lombok.Builder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public record BoardCommandDto() {
    public record BoardAddRequestDto(
            String boardTitle,
            String boardContent
    ){}
    @Builder
    public record BoardAddResponseDto(
            boolean success
    ){}
}
