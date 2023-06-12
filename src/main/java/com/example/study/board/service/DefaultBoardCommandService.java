package com.example.study.board.service;

import com.example.study.board.api.dto.BoardCommandDto.BoardAddRequestDto;
import com.example.study.board.domain.Board;
import com.example.study.board.repository.BoardRepository;
import com.example.study.member.repository.MemberRepository;
import com.example.study.util.jwt.JwtPayloadParser;
import com.example.study.util.jwt.JwtPayloadParserBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public final class DefaultBoardCommandService implements BoardCommandService{

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    private final JwtPayloadParserBuilder jwtPayloadParserBuilder;
    @Override
    public boolean add(BoardAddRequestDto dto, HttpServletRequest request) {

        JwtPayloadParser payloadParser = jwtPayloadParserBuilder.buildWith(request);

        String email = payloadParser.subject();
        // 유저 아이디
        UUID memberId = memberRepository.findIdByEmail(email)
                .orElseThrow(IllegalStateException::new)
                .id();

        Board board = Board.builder()
                .memberId(memberId)
                .boardTitle(dto.boardTitle())
                .boardContent(dto.boardContent())
                .build();
        boardRepository.save(board);

        return true;
    }

}
