package com.example.study.board.api;

import com.example.study.board.api.dto.BoardCommandDto.*;
import com.example.study.board.service.BoardCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardCommandApi {
    private final BoardCommandService boardCommandService;
    //게시글 생성
    @PostMapping()
    public BoardCreateResponseDto create(
            @RequestBody BoardCreateRequestDto dto, HttpServletRequest request){

        return boardCommandService.create(dto,request);
    }
    //todo 위 아래 dto리턴의 차이점 알아보기
    // 게시글 수정
    @PatchMapping("/{boardNum}")
    public BoardUpdateResponseDto update(
            @PathVariable Long boardNum,
            @RequestBody BoardUpdateRequestDto dto,
            HttpServletRequest request
    ){
        return boardCommandService.update(boardNum, dto, request);
    }

    //게시글 삭제
    @DeleteMapping("/{boardNum}")
    public BoardDeleteResponseDto delete(@PathVariable Long boardNum, HttpServletRequest request){
        return boardCommandService.delete(boardNum,request);
    }

}
