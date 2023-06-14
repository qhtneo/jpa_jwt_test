package com.example.study.board.repository;

import com.example.study.board.domain.Board;
import com.example.study.board.repository.projection.BoardProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;
import java.util.UUID;

public interface BoardRepository extends JpaRepository<Board, UUID> {

    Page<Board> findAllByTitleContainsIgnoreCase(String keyword, Pageable pageable);

    Page<Board> findAllByContentContainsIgnoreCase(String keyword, Pageable pageable);

    Page<Board> findAllByNickNameContainsIgnoreCase(String keyword, Pageable pageable) ;

    Page<Board> findAllByBoardNum(Long keyword, Pageable pageable);


    Page<Board> findAll(Pageable pageable);

    Optional<Board> findByBoardNum(Long boardNum);

    void deleteByBoardNum(Long boardNum);

}
