package com.example.study.board.api;

import com.example.study.board.api.dto.BoardCommandDto;
import com.example.study.board.api.dto.BoardCommandDto.BoardAddRequestDto;
import com.example.study.board.api.dto.BoardCommandDto.BoardAddResponseDto;
import com.example.study.board.api.dto.BoardCommandDto.BoardUpdateRequestDto;
import com.example.study.board.api.dto.BoardCommandDto.BoardUpdateResponseDto;
import com.example.study.board.service.BoardCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardCommandApi {
    private final BoardCommandService boardCommandService;
    @PostMapping("/add")
    public BoardAddResponseDto boardAddResponseDto(
            @RequestBody BoardAddRequestDto dto, HttpServletRequest request){

        return new BoardAddResponseDto(boardCommandService.add(dto,request));
    }
    //todo 위 아래 dto리턴의 차이점 알ㅇ보기
    @PostMapping("/update/{boardNum}")
    public BoardUpdateResponseDto boardUpdate(
            @PathVariable Long boardNum,
            @RequestBody BoardUpdateRequestDto dto,
            HttpServletRequest request
    ){
        return boardCommandService.update(boardNum, dto, request);
    }

}
