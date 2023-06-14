package com.example.study.board.service;

import com.example.study.board.api.dto.BoardCommandDto.*;

import javax.servlet.http.HttpServletRequest;

public interface BoardCommandService {
    BoardCreateResponseDto create(BoardCreateRequestDto dto, HttpServletRequest request);
    BoardUpdateResponseDto update(Long boardNum, BoardUpdateRequestDto dto, HttpServletRequest request);

    BoardDeleteResponseDto delete(Long boardNum, HttpServletRequest request);
}
