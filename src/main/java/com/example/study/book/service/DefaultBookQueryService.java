package com.example.study.book.service;

import com.example.study.book.api.dto.BookQueryDto.ReadBooksResponseDto;
import com.example.study.book.exception.BookQueryErrorCode;
import com.example.study.book.repository.BookGenreRepository;
import com.example.study.book.repository.BookRepository;
import com.example.study.book.repository.projection.BookListProjection;
import com.example.study.common.type.SearchType;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
@Log4j2
public class DefaultBookQueryService implements BookQueryService{

//	private final BookRepository bookRepository;
//	private final BookGenreRepository bookGenreRepository;
//
//	@Override
//	public ReadBooksResponseDto searchWithGenreBy(
//			String genreEng,
//			SearchType searchType,
//			String keyword,
//			Pageable pageable,
//			String page) {
//
//		Long genreId = bookGenreRepository.findIdByEng(genreEng);
//
//		if(genreId==null){
//			BookQueryErrorCode.GENRE_NULL.defaultException();
//		}
//
//		Page<BookListProjection> bookSearchResult = null;
//		if (page != null && !page.isEmpty()) {
//			pageable = PageRequest.of(Integer.parseInt(page) - 1, pageable.getPageSize(), pageable.getSort());
//		}
//
//		switch (searchType) {
//			case TITLE -> bookSearchResult = bookRepository.findAllByGenreIdAndTitleContainsIgnoreCase(genreId, keyword, pageable);
//			case CONTENT -> bookSearchResult = bookRepository.findAllByGenreIdAndDescriptionContainsIgnoreCase(genreId, keyword, pageable);
//			case MEMBER_NAME -> bookSearchResult = bookRepository.findAllByGenreIdAndNicknameContainsIgnoreCase(genreId, keyword, pageable);
//			case NONE -> bookSearchResult = bookRepository.findAllByGenreId(genreId, pageable);
//		}
//		pageable = pageable.previousOrFirst();
//		List<BookListProjection> books = bookSearchResult.toList();
//		long lastPageNumber = bookSearchResult.getTotalPages();
//		if (pageable.getPageNumber() >= lastPageNumber) {
//			throw BookQueryErrorCode.PAGE_OUT_OF_RANGE.defaultException();
//		}
//		return ReadBooksResponseDto.builder()
//				.books(books)
//				.lastPage(lastPageNumber)
//				.build();
//	}


}
