package kr.hs.study.boardMybatisProject.Dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDto {
    private int id;
    private String commentWriter;
    private String commentContents;
    private String boardId;
    private LocalDateTime commentCreateTime;
}
