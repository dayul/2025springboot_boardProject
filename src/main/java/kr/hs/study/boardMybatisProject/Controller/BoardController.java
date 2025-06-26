package kr.hs.study.boardMybatisProject.Controller;

import kr.hs.study.boardMybatisProject.Dto.BoardDto;
import kr.hs.study.boardMybatisProject.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/board")
    public String writeBoard() {
        return "board";
    }

    // 글 목록보기
    @GetMapping("/board/save")
    public String listBoard(Model model) {
        List<BoardDto> allList = this.boardService.selectAll();
        model.addAttribute("data", allList);
        return "board_list";
    }

    // 글 작성시
    @PostMapping("/write_done")
    public String insertBoard(BoardDto boardDto) {
        this.boardService.insertBoard(boardDto);
        return "redirect:/board/save";
    }

    @GetMapping("/show/{id}")
    public String countHits(@PathVariable("id") int id) {
        this.boardService.countHits(id);
        return "redirect:/board/save";
    }
}
