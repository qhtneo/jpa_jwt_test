package com.example.study.book.domain;

import com.example.study.support.MySchemaConstants;
import com.example.study.support.UuidBaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.OffsetDateTime;
import java.util.UUID;

import static com.example.study.support.Constants.DEFAULT_TIMEZONE_ID;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder //이거 해줘야 flyway가 잡음
@Table(
        name = MySchemaConstants.TB_MEMBER_FAVOR_BOOK,
        schema = MySchemaConstants.SCHEMA
)
public class MemberFavorBook extends UuidBaseEntity {
    Long bookId;
    String nickname;
    Long genreId;
    @Builder.Default
    OffsetDateTime createdAt = OffsetDateTime.now(DEFAULT_TIMEZONE_ID);
    OffsetDateTime updatedAt;
    OffsetDateTime deletedAt;
}
