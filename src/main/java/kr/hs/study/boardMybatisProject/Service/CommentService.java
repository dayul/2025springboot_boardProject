package kr.hs.study.boardMybatisProject.Service;

import kr.hs.study.boardMybatisProject.Dto.CommentDto;

import java.util.List;

public interface CommentService {
    public void writeComment(CommentDto commentDto);
    public List<CommentDto> selectAllComment(int boardId);
}
