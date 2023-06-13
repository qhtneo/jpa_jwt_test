package com.example.study.board.api.dto;

import lombok.Builder;

import java.time.OffsetDateTime;

public record BoardQueryDto() {
  @Builder
  public record BoardFindResponseDto(
          Long boardNum,
          String title,
          String content,
          OffsetDateTime createdAt
  ){}
}
