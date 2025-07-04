package kr.hs.study.boardMybatisProject.Controller;

import kr.hs.study.boardMybatisProject.Dao.BoardDeleteDto;
import kr.hs.study.boardMybatisProject.Dto.BoardDto;
import kr.hs.study.boardMybatisProject.Service.BoardService;
import lombok.Getter;
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

    @GetMapping("board/{id}")
    public String moveDetail(@PathVariable("id") int id, Model model) {
        BoardDto one = this.boardService.selectOne(id);
        model.addAttribute("one", one);
        return "board_detail";
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
        return "redirect:/board/" + id;
    }

    @GetMapping("/edit/{id}")
    public String moveEditpage(@PathVariable("id") int id, Model model) {
        BoardDto one = this.boardService.selectOne(id);
        model.addAttribute("one", one);
        return "board_edit";
    }

    @PostMapping("/edit")
    public String editPost(BoardDto boardDto) {
        BoardDto existing = this.boardService.selectOne(boardDto.getId());

        if(existing.getBoardPass().equals(boardDto.getBoardPass())) {
            System.out.println("수정 성공");
            this.boardService.updateBoard(boardDto);
            return "redirect:/board/" + boardDto.getId();
        }

        return "redirect:/edit/" + boardDto.getId();
    }

    @GetMapping("/delete/{id}")
    public String moveDeletePage(@PathVariable("id") int id, Model model) {
        BoardDto one = this.boardService.selectOne(id);
        model.addAttribute("one", one);
        return "board_delete";
    }

    @PostMapping("/delete")
    public String deletePost(BoardDeleteDto boardDeleteDto) {
        int id = boardDeleteDto.getId();
        BoardDto boardDto = this.boardService.selectOne(id);

        if(boardDto.getBoardPass().equals(boardDeleteDto.getPassword())) {
            this.boardService.deletePost(id);
        }

        return "redirect:/board/save";
    }
}
