package com.example.study.board.api;

import com.example.study.board.api.dto.BoardQueryDto.BoardFindResponseDto;
import com.example.study.board.domain.Board;
import com.example.study.board.service.BoardQueryService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public final class BoardQueryApi {
    private final BoardQueryService boardQueryService;

    @GetMapping("")
    public List<BoardFindResponseDto> boardFindResponseDto(){
        return boardQueryService.findAll();
    }

    @GetMapping(path = "/{boardNum}")
    public Board boardFindByBoardNum(@PathVariable Long boardNum){
        return boardQueryService.findByBoardNum(boardNum);
    }


}
