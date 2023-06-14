package com.example.study.board.service;

import com.example.study.board.api.dto.BoardCommandDto.*;
import com.example.study.board.domain.Board;
import com.example.study.board.repository.BoardRepository;
import com.example.study.member.repository.MemberRepository;
import com.example.study.util.jwt.JwtPayloadParser;
import com.example.study.util.jwt.JwtPayloadParserBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DefaultBoardCommandService implements BoardCommandService{

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    private final JwtPayloadParserBuilder jwtPayloadParserBuilder;
    @Override
    public BoardCreateResponseDto create(BoardCreateRequestDto dto, HttpServletRequest request) {

        JwtPayloadParser payloadParser = jwtPayloadParserBuilder.buildWith(request);
        String nickname = payloadParser.claims().get("nickname", String.class);
        String email = payloadParser.subject();
        // 유저 아이디
        UUID memberId = memberRepository.findIdByEmail(email)
                .orElseThrow(IllegalStateException::new)
                .id();

        Board board = Board.builder()
                .memberId(memberId)
                .nickName(nickname)
                .title(dto.title())
                .content(dto.content())
                .build();
        boardRepository.save(board);
        return BoardCreateResponseDto.builder()
                .success(true)
                .build();
    }

    @Override
    @Transactional //todo 이거 뭔지 정리
    public BoardUpdateResponseDto update(Long boardNum, BoardUpdateRequestDto dto, HttpServletRequest request) {
        JwtPayloadParser payloadParser = jwtPayloadParserBuilder.buildWith(request);
        String email = payloadParser.subject();
        // 유저 아이디
        UUID memberId = memberRepository.findIdByEmail(email)
                .orElseThrow(IllegalStateException::new)
                .id();

        Optional<Board> optionalBoard = boardRepository.findByBoardNum(boardNum);
        if(optionalBoard.isEmpty()){
            throw new IllegalStateException();
        }

        Board board = optionalBoard.get();
        if (board.getMemberId().equals(memberId)) {
            board.setContent(dto.content());
            board.setTitle(dto.title());
        }
        return BoardUpdateResponseDto.builder()
                .success(true)
                .build();
    }

    @Override
    @Transactional
    public BoardDeleteResponseDto delete(Long boardNum, HttpServletRequest request) {
        JwtPayloadParser payloadParser = jwtPayloadParserBuilder.buildWith(request);
        String email = payloadParser.subject();
        // 유저 아이디
        UUID memberId = memberRepository.findIdByEmail(email)
                .orElseThrow(IllegalStateException::new)
                .id();

        Optional<Board> optionalBoard = boardRepository.findByBoardNum(boardNum);
        if(optionalBoard.isEmpty()){
            throw new IllegalStateException();
        }

        Board board = optionalBoard.get();
        if(board.getMemberId().equals(memberId)){
            boardRepository.deleteByBoardNum(boardNum);
        }
        return BoardDeleteResponseDto.builder()
                .success(true)
                .build();
    }


}
