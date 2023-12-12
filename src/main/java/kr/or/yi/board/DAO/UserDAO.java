package kr.or.yi.board.DAO;

import kr.or.yi.board.DTO.User;

public class UserDAO extends JDBCConnection {
    public int insert(User user) {
        return 0;
    }

    public User select(String userid) {
        User user = new User();
        String sql = "SELECT * "
                + " FROM User"
                + " WHERE userid = ?";
        try {
            psmt = con.prepareStatement(sql);
            psmt.setString(1, userid);
            rs=psmt.executeQuery();

            if (rs.next()){
                user.setUserid(rs.getString("Userid"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            } else {
                System.out.println("사용자가 없습니다.");
            }
        } catch(Exception e ){
            e.printStackTrace();
        }
        return user;
    }

    public int update(User user) {
        return 0;
    }

    public int delete(String userid) {
        return 0;
    }

}
