package com.example.study.book.api.dto;

import com.example.study.book.repository.projection.BookListProjection;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

public record BookQueryDto() {

	@Builder
	public record ReadBooksResponseDto(
			List<BookListProjection> books,
			Long lastPage
	){}

	

}
