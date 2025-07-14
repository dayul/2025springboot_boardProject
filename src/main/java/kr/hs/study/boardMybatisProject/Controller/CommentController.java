package kr.hs.study.boardMybatisProject.Controller;

import kr.hs.study.boardMybatisProject.Dto.CommentDto;
import kr.hs.study.boardMybatisProject.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/comment")
    public String writeComment(CommentDto commentDto) {
        this.commentService.writeComment(commentDto);
        return "redirect:/board/save";
    }
}
