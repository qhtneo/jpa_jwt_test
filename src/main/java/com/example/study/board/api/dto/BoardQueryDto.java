package com.example.study.board.api.dto;

import com.example.study.board.domain.Board;
import lombok.Builder;

import java.util.List;

public record BoardQueryDto() {
    @Builder
    public record FindBoardListResponseDto(
            List<Board> boardList,
            Long lastPage
    ){}

}
