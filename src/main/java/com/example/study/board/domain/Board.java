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
//		catalog = MySchemaConstants.SCHEMA
)
public class Board extends UuidBaseEntity {
    public UUID memberId;
    @Column(name = "board_num", insertable = false, updatable = false)
    public Long boardNum;
    public String title;
    public String content;
    @Builder.Default
    public OffsetDateTime createdAt = OffsetDateTime.now(DEFAULT_TIMEZONE_ID);

}
