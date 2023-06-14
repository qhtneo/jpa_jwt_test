package com.example.study.board.api;


import com.example.study.board.api.dto.BoardQueryDto.FindBoardListResponseDto;
import com.example.study.board.service.BoardQueryService;
import com.example.study.board.type.SearchType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public final class BoardQueryApi {
    private final BoardQueryService boardQueryService;

    @GetMapping("")
    public FindBoardListResponseDto findBoardList(
            @PageableDefault(size=10, sort="boardNum", direction = Sort.Direction.DESC) Pageable pageable,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false, defaultValue = "NONE") SearchType searchType,
            @RequestParam(required = false) String page
    ){
        return boardQueryService.findBoardList(pageable,keyword,searchType,page);
    }

}
