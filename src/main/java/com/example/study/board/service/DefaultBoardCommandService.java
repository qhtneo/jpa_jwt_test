package com.example.study.board.service;

import com.example.study.board.api.dto.BoardCommandDto.BoardAddRequestDto;
import com.example.study.board.api.dto.BoardCommandDto.BoardUpdateRequestDto;
import com.example.study.board.api.dto.BoardCommandDto.BoardUpdateResponseDto;
import com.example.study.board.domain.Board;
import com.example.study.board.repository.BoardRepository;
import com.example.study.member.repository.MemberRepository;
import com.example.study.util.jwt.JwtPayloadParser;
import com.example.study.util.jwt.JwtPayloadParserBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DefaultBoardCommandService implements BoardCommandService{

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
                .title(dto.title())
                .content(dto.content())
                .build();
        boardRepository.save(board);

        return true;
    }

    @Override
    @Transactional //todo 이거 뭔지 정리
    public BoardUpdateResponseDto update(Long boardNum, BoardUpdateRequestDto dto, HttpServletRequest request) {
        JwtPayloadParser payloadParser = jwtPayloadParserBuilder.buildWith(request);

        String email = payloadParser.subject();
        // todo 유저 아이디 비교(글쓴 사람인지 확인)
        // 유저 아이디
        UUID memberId = memberRepository.findIdByEmail(email)
                .orElseThrow(IllegalStateException::new)
                .id();

            Board board = boardRepository.findByBoardNum(boardNum);
        if (board.getMemberId().equals(memberId)) {
            board.setContent(dto.content());
            board.setTitle(dto.title());
        }
        //todo 예외처리

        return BoardUpdateResponseDto.builder()
                .success(true)
                .build();
    }


}
