package kr.or.yi.board.DTO;

public class User {
    private int uid;
    private String userid;
    private String username;
    private String password;

    public User() {
        this("제목 없음", "작성자 없음", "내용 없음");
    }

    public User(String userid, String username, String password) {
        this.userid = userid;
        this.username = username;
        this.password = password;
    }

    public User(int uid, String userid, String username, String password) {
        this.uid = uid;
        this.userid = userid;
        this.username = username;
        this.password = password;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
