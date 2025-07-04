package kr.hs.study.boardMybatisProject.Dao;

import kr.hs.study.boardMybatisProject.Dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDao {
    public void insertBoard(BoardDto boardDto);
    public void countHits(int id);
    public void updateBoard(BoardDto boardDto);
    public void deletePost(int id);
    public BoardDto selectOne(int id);
    public List<BoardDto> selectAll();
}
