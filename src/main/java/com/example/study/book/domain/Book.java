package com.example.study.book.domain;

import com.example.study.book.domain.type.BookStatus;
import com.example.study.book.domain.type.FavorOnOffType;
import com.example.study.support.MySchemaConstants;
import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;
import static com.example.study.support.Constants.DEFAULT_TIMEZONE_ID;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(
		name = MySchemaConstants.TB_BOOK,
		schema = MySchemaConstants.SCHEMA
)
public class Book{
	@Id
	Long Id;
	String nickname;
	Long genreId;
	String title;
	String description;
	String coverUrl;
	@Builder.Default
	@Enumerated(EnumType.STRING)
	BookStatus status = BookStatus.PENDING;
	@Builder.Default
	Long totalViewCount = 0L;
	@Builder.Default
	Long totalHeartCount = 0L;
	@Builder.Default
	Long favorCount = 0L;
	@Builder.Default
	@Enumerated(EnumType.STRING)
	FavorOnOffType favorOnOffType = FavorOnOffType.OFF;
	@Builder.Default
	OffsetDateTime createdAt = OffsetDateTime.now(DEFAULT_TIMEZONE_ID);
	OffsetDateTime updatedAt;
	OffsetDateTime deletedAt;
}

