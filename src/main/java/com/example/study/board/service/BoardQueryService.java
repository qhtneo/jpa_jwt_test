package com.example.study.board.service;

import com.example.study.board.api.dto.BoardQueryDto.BoardFindResponseDto;
import com.example.study.board.domain.Board;

import java.util.List;
import java.util.UUID;

public interface BoardQueryService {


    List<BoardFindResponseDto> findAll();

    Board findByBoardNum(Long boardNum);


}
