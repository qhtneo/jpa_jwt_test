package com.example.study.board.repository.projection;


import java.time.OffsetDateTime;

public record BoardProjection(
        Long boardNum,
        String title,
        String content,
        String nickname,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt,
        OffsetDateTime deletedAt
) {}
