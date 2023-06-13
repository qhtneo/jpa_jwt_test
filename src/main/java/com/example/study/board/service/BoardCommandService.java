package com.example.study.board.service;

import com.example.study.board.api.dto.BoardCommandDto.BoardAddRequestDto;
import com.example.study.board.api.dto.BoardCommandDto.BoardUpdateRequestDto;
import com.example.study.board.api.dto.BoardCommandDto.BoardUpdateResponseDto;

import javax.servlet.http.HttpServletRequest;

public interface BoardCommandService {
    boolean add(BoardAddRequestDto dto, HttpServletRequest request);
    BoardUpdateResponseDto update(Long boardNum, BoardUpdateRequestDto dto, HttpServletRequest request);
}
