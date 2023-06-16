

--작품(BookGenre)장르 테이블
CREATE TABLE IF NOT EXISTS joara_basic.book_genre (
    id                  BIGINT                              PRIMARY KEY,
    genre_kor           VARCHAR(255)                        UNIQUE,
    genre_eng           VARCHAR(255)                        UNIQUE
);

--작품(Book)테이블,  SEQUENCE 추가
CREATE TABLE IF NOT EXISTS joara_basic.book (
    id                  BIGINT                              PRIMARY KEY,
    nickname            VARCHAR(255)                        ,
    genre_id            BIGINT                              ,
    book_title          VARCHAR(255)                        UNIQUE,
    description         TEXT                                ,
    cover_url           VARCHAR(255)                        ,
    status              VARCHAR(255)                        ,
    total_view_count    BIGINT                              ,
    total_heart_count   BIGINT                              ,
    favor_count         BIGINT                              ,
    favor_on_off        VARCHAR(255)                        ,
    created_at          DATE                                NOT NULL,
    updated_at          DATE                                ,
    deleted_at          DATE
);

--작품태그 목록(BookTag)테이블
CREATE TABLE IF NOT EXISTS joara_basic.book_tag (
    id                  UUID                                PRIMARY KEY,
    book_id             BIGINT                              NOT NULL,
    tag_name            VARCHAR(255)
);

-- 회원 선호 장르 테이블
CREATE TABLE IF NOT EXISTS joara_basic.member_favor_genre (
    id                  UUID                                PRIMARY KEY,
    genre_id            BIGINT                              NOT NULL,
    nickname            VARCHAR(255)                        NOT NULL,
    created_at          DATE                                NOT NULL,
    updated_at          DATE                                ,
    deleted_at          DATE
);

-- 회원 선호 작품 테이블
CREATE TABLE IF NOT EXISTS joara_basic.member_favor_book(
    id                  UUID                                PRIMARY KEY,
    book_id             BIGINT                              NOT NULL,
    nickname            VARCHAR(255)                        NOT NULL,
    genre_id            BIGINT                              NOT NULL,
    created_at          DATE                                NOT NULL,
    updated_at          DATE                                ,
    deleted_at          DATE
);
