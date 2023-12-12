package kr.or.yi.board.Service;

import kr.or.yi.board.DAO.UserDAO;
import kr.or.yi.board.DTO.User;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO = new UserDAO();


    @Override
    public User select(String userid) {
        User user = userDAO.select(userid);
        return user;
    }

    @Override
    public int insert(User user) {
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int delete(String userid) {
        return 0;
    }
}
