package com.example.study.board.domain;

import com.example.study.support.MySchemaConstants;
import com.example.study.support.UuidBaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

import static com.example.study.support.Constants.DEFAULT_TIMEZONE_ID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = MySchemaConstants.TB_BOARD,
        schema = MySchemaConstants.SCHEMA
)
public class Board extends UuidBaseEntity {
    public UUID memberId;
    public String nickName;
    @Column(name = "board_num", insertable = false, updatable = false)
    public Long boardNum;
    public String title;
    public String content;
    // 빌더로 생성을 할 때 기본으로 넣어주는 값
    @Builder.Default
    public OffsetDateTime createdAt = OffsetDateTime.now(DEFAULT_TIMEZONE_ID);
    public OffsetDateTime updatedAt;
    public OffsetDateTime deletedAt;
}
