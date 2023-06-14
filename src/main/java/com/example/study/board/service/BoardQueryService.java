package com.example.study.board.service;

import com.example.study.board.api.dto.BoardQueryDto.FindBoardListResponseDto;
import com.example.study.board.type.SearchType;
import org.springframework.data.domain.Pageable;

public interface BoardQueryService {
    FindBoardListResponseDto findBoardList(Pageable pageable, String keyword, SearchType searchType,String page);
}
