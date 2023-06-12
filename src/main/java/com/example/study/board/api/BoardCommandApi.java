package com.example.study.board.api;

import com.example.study.board.api.dto.BoardCommandDto;
import com.example.study.board.api.dto.BoardCommandDto.BoardAddRequestDto;
import com.example.study.board.api.dto.BoardCommandDto.BoardAddResponseDto;
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

}
