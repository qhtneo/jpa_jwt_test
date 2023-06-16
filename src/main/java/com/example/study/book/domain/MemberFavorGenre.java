package com.example.study.book.domain;

import com.example.study.support.MySchemaConstants;
import com.example.study.support.UuidBaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.OffsetDateTime;

import static com.example.study.support.Constants.DEFAULT_TIMEZONE_ID;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(
        name = MySchemaConstants.TB_MEMBER_FAVOR_GENRE,
        schema = MySchemaConstants.SCHEMA
)
public class MemberFavorGenre extends UuidBaseEntity {
    Long genreId;
    String nickname;
    @Builder.Default
    OffsetDateTime createdAt = OffsetDateTime.now(DEFAULT_TIMEZONE_ID);
    OffsetDateTime updatedAt;
    OffsetDateTime deletedAt;
}
