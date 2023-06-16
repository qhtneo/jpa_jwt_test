package com.example.study.book.repository;

import com.example.study.book.domain.Book;
import com.example.study.book.repository.projection.BookCoverUrlProjection;
import com.example.study.book.repository.projection.BookListProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
//	Page<BookListProjection> findAllBytitle(Long genreId, Pageable pageable);
//	Page<BookListProjection> findAllByGenreIdAndTitleContainsIgnoreCase(Long genreId, String keyword, Pageable pageable);
//	Page<BookListProjection> findAllByGenreIdAndDescriptionContainsIgnoreCase(Long genreId, String keyword, Pageable pageable);
//	Page<BookListProjection> findAllByGenreIdAndNicknameContainsIgnoreCase(Long genreId, String keyword, Pageable pageable);
//
//	Page<BookListProjection> findAllByGenreId(Long genreId, Pageable pageable);
//	Long countByGenreId(Long genreId);
//
//	Optional<BookCoverUrlProjection> findCoverUrlById(UUID id);



	// 컬럼 이름으로 여러 회원 조회
	// List<Member> findAllBy컬럼이름(String 컬럼이름);

}
