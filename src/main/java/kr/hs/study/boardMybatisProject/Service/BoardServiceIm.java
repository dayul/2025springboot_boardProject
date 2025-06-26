package kr.hs.study.boardMybatisProject.Service;

import kr.hs.study.boardMybatisProject.Dao.BoardDao;
import kr.hs.study.boardMybatisProject.Dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceIm implements BoardService{
    @Autowired
    BoardDao boardDao;

    @Override
    public void insertBoard(BoardDto boardDto) {
        this.boardDao.insertBoard(boardDto);
    }

    @Override
    public void countHits(int id) {
        this.boardDao.countHits(id);
    }

    @Override
    public BoardDto selectOne(int id) {
        return this.boardDao.selectOne(id);
    }

    @Override
    public List<BoardDto> selectAll() {
        return this.boardDao.selectAll();
    }
}
