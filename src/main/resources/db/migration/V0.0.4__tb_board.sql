CREATE SEQUENCE board_num_seq;
-- 게시판(Board)
CREATE TABLE IF NOT EXISTS joara_basic.board (
    id                  UUID                                PRIMARY KEY,
    member_id           UUID                                ,
    board_num           BIGINT                              DEFAULT nextval('board_num_seq') not null,
    title               VARCHAR(255)                        ,
    content             TEXT                                ,
    created_at          DATE
);
