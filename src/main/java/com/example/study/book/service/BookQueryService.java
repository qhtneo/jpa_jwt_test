package com.example.study.book.service;

import com.example.study.book.api.dto.BookQueryDto.ReadBooksResponseDto;
import com.example.study.common.type.SearchType;
import org.springframework.data.domain.Pageable;

public interface BookQueryService {
	ReadBooksResponseDto searchWithGenreBy(String genreEng, SearchType searchType, String keyword, Pageable pageable, String page);

//	Page<BookListProjection> searchWithGenreBy(String genreEnglishName, SearchType searchType, String keyword, Pageable pageable);
}
