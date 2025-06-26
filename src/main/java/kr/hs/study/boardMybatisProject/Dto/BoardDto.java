package kr.hs.study.boardMybatisProject.Dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardDto {
    private int id;
    private String boardWriter;
    private String boardPass;
    private String boardTitle;
    private String boardContents;
    private int boardHits;
    private LocalDateTime boardCreatedTime;
}
