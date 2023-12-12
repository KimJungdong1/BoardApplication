package kr.or.yi.board.Service;

import kr.or.yi.board.DTO.Board;

import java.util.List;

public interface BoardService {
    List<Board> list();
    Board select(int board_no);
    int insert(Board board);
    int update(Board board);
    int delete(int board_no);

    List<Board> pageList(int pageNo);
    int totalListCount();

}
