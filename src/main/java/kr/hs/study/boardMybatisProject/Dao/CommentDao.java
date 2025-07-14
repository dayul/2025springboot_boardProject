package kr.hs.study.boardMybatisProject.Dao;

import kr.hs.study.boardMybatisProject.Dto.CommentDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentDao {
    public void writeComment(CommentDto commentDto);
    public List<CommentDto> selectAllComment(int boardId);
}
