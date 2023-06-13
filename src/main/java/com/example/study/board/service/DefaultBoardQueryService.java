package com.example.study.board.service;

import com.example.study.board.api.dto.BoardQueryDto.BoardFindResponseDto;
import com.example.study.board.domain.Board;
import com.example.study.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public final class DefaultBoardQueryService implements BoardQueryService{
    private final BoardRepository repository;


//    @Override
//    public List<BoardFindResponseDto> findAll() {
//        return repository.findAll();
//    }
@Override
public List<BoardFindResponseDto> findAll() {
    List<Board> boards = repository.findAll();
    List<BoardFindResponseDto> dtos = new ArrayList<>();
    for (Board board : boards) {

        BoardFindResponseDto dto = BoardFindResponseDto.builder()
                .boardNum(board.getBoardNum())
                .title(board.getTitle())
                .content(board.getContent())
                .createdAt(board.getCreatedAt())
                .build();
        dtos.add(dto);
    }
    return dtos;
}

    @Override
    public Board findByBoardNum(Long boardNum) {
        return repository.findByBoardNum(boardNum);
    }

}
