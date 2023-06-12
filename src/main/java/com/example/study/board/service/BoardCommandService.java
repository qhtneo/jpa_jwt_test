package com.example.study.board.service;

import com.example.study.board.api.dto.BoardCommandDto.BoardAddRequestDto;

import javax.servlet.http.HttpServletRequest;

public interface BoardCommandService {
    boolean add(BoardAddRequestDto dto, HttpServletRequest request);
}
