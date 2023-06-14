package com.example.study.board.api.dto;


import lombok.Builder;

public record BoardCommandDto() {
    public record BoardCreateRequestDto(
            String title,
            String content
    ){}
    @Builder
    public record BoardCreateResponseDto(
            boolean success
    ){}

    public record BoardUpdateRequestDto(
            String title,
            String content
    ){}
    @Builder
    public record BoardUpdateResponseDto(
            boolean success
    ){}
    @Builder
    public record BoardDeleteResponseDto(
            boolean success
    ){

    }
}
