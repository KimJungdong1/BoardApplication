package kr.or.yi.board.Service;

import kr.or.yi.board.DTO.User;

public interface UserService {

    User select(String userid);
    int insert(User user);
    int update(User user);
    int delete(String userid);

}
