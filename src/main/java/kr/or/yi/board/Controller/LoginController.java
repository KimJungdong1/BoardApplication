package kr.or.yi.board.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import kr.or.yi.board.DTO.User;
import kr.or.yi.board.Service.UserService;
import kr.or.yi.board.Service.UserServiceImpl;
import kr.or.yi.board.Utils.SceneUtil;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField tfId;
    @FXML
    private TextField tfPw;
    private UserService userService = new UserServiceImpl();

    public void login(ActionEvent event) throws IOException {

        System.out.println(tfId.getText());
        System.out.println(tfPw.getText());
        if (tfId.getText().isEmpty() || tfPw.getText().isEmpty()) {
            errorIdPw();
        } else {
            User user = userService.select(tfId.getText());
            if (user.getUserid().isEmpty()) {
                isIdEmpty();
            } else {
                if (!user.getPassword().equals(tfPw.getText())) {
                    errorPw();
                } else {
                    loginSucess();
                    SceneUtil.getInstance().switchScene(event, UI.LIST.getPath());
                }
            }
        }

        User user = userService.select(tfId.getText());
        System.out.println(user);
    }

    public void close() {
        System.exit(0);
    }

    public void errorIdPw() {
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(("다시 확인 바람."));
        alert.setHeaderText(null);
        alert.setContentText("ID와 PW을 채우세요.");
        alert.showAndWait();
    }

    public void isIdEmpty() {
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(("다시 확인 바람."));
        alert.setHeaderText(null);
        alert.setContentText("사용자 계정이 없습니다.");
        alert.showAndWait();
    }

    public void errorPw() {
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(("다시 확인 바람."));
        alert.setHeaderText(null);
        alert.setContentText("비밀번호가 일치하지 않습니다.");
        alert.showAndWait();
    }

    public void loginSucess() {
        Alert alert;
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(("정보확인"));
        alert.setHeaderText(null);
        alert.setContentText("로그인 성공!!");
        alert.showAndWait();
    }

}
