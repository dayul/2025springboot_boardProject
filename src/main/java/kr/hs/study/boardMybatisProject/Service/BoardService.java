package kr.hs.study.boardMybatisProject.Service;

import kr.hs.study.boardMybatisProject.Dto.BoardDto;

import java.util.List;

public interface BoardService {
    public void insertBoard(BoardDto boardDto);
    public void updateBoard(BoardDto boardDto);
    public void countHits(int id);
    public void deletePost(int id);
    public BoardDto selectOne(int id);
    public List<BoardDto> selectAll();
}
