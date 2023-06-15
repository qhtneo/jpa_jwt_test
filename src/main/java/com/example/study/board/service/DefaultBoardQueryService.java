package com.example.study.board.service;

import com.example.study.board.api.dto.BoardQueryDto.FindBoardListResponseDto;
import com.example.study.board.domain.Board;
import com.example.study.board.exception.BoardFailureErrorCode;
import com.example.study.board.repository.BoardRepository;
import com.example.study.board.type.SearchType;
import com.example.study.member.repository.MemberRepository;
import com.example.study.util.jwt.JwtPayloadParserBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public final class DefaultBoardQueryService implements BoardQueryService {
    private final BoardRepository boardRepository;
    private final JwtPayloadParserBuilder jwtPayloadParserBuilder;
    private final MemberRepository memberRepository;

    @Override
    public FindBoardListResponseDto findBoardList(Pageable pageable, String keyword, SearchType searchType,String page) {
        Page<Board> boardSearchResult = null;
        if (page != null && !page.isEmpty()) {
            pageable = PageRequest.of(Integer.parseInt(page) - 1, pageable.getPageSize(), pageable.getSort());
        }
        switch (searchType){
            case TITLE ->
                    boardSearchResult = boardRepository.findAllByTitleContainsIgnoreCase(keyword, pageable);
            case CONTENT ->
                    boardSearchResult = boardRepository.findAllByContentContainsIgnoreCase(keyword, pageable);
            case MEMBER_NAME ->
                    boardSearchResult = boardRepository.findAllByNickNameContainsIgnoreCase(keyword, pageable);
            case BOARD_NUM ->
                    boardSearchResult = boardRepository.findAllByBoardNum(Long.parseLong(keyword), pageable);
            case NONE ->
                    boardSearchResult = boardRepository.findAll(pageable);
        }


        pageable = pageable.previousOrFirst();
        List<Board> boards = boardSearchResult.toList();
        long lastPageNumber = boardSearchResult.getTotalPages();

        if (pageable.getPageNumber() >= lastPageNumber) {
            throw BoardFailureErrorCode.PAGE_OUT_OF_RANGE.defaultException();
        }

        return FindBoardListResponseDto.builder()
                .boardList(boards)
                .lastPage(lastPageNumber)
                .build();
    }



}
