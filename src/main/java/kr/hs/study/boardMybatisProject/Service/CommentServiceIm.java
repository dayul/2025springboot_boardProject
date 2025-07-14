package kr.hs.study.boardMybatisProject.Service;

import kr.hs.study.boardMybatisProject.Dao.CommentDao;
import kr.hs.study.boardMybatisProject.Dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceIm implements CommentService {
    @Autowired
    CommentDao commentDao;

    @Override
    public void writeComment(CommentDto commentDto) {
        this.commentDao.writeComment(commentDto);
    }

    @Override
    public List<CommentDto> selectAllComment(int boardId) {
        return this.commentDao.selectAllComment(boardId);
    }
}
