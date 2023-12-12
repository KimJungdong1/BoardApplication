package kr.or.yi.board.DAO;

import java.sql.*;

public class JDBCConnection {
    public Connection con;
    public Statement stmt;
    public PreparedStatement psmt;
    public ResultSet rs;

    public JDBCConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Board?serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true&useSSL=false";
            String id = "root";
            String pw = "edurootroot";

            con = DriverManager.getConnection(url, id, pw);
            con.setAutoCommit(false);
            System.out.println("DB 연결 성공");
        } catch (Exception e) {
            System.out.println("DB 연결 실패");
            e.printStackTrace();
        }
    }
}
