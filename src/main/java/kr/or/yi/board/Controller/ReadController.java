package kr.or.yi.board.Controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import kr.or.yi.board.DTO.Board;
import kr.or.yi.board.Service.BoardService;
import kr.or.yi.board.Service.BoardServiceImpl;
import kr.or.yi.board.Utils.SceneUtil;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class ReadController implements Initializable{
    @FXML
    private TextField tfTitle;
    @FXML
    private TextField tfWriter;
    @FXML
    private TextArea taContent;
    @FXML
    private ImageView imageView;
    private Image image;
    private BoardService boardService = new BoardServiceImpl();
    int boardNo; // 현재 게시물 번호
    List<Integer> numArr;
    int targetValue = boardNo;
    int preValue = -1;
    int nextValue = -1;

    Stage stage;
    Scene scene;
    Parent root;

    FXMLLoader loader;

    private double x;
    private double y;

    public void close() {
        System.exit(0);
    }

    public void read(int boardNo) {
        numArr = listNum();
        this.targetValue = boardNo;
        this.boardNo = boardNo;
        Board board = boardService.select(boardNo);
        tfTitle.setText(board.getTitle());
        tfWriter.setText(board.getWriter());
        taContent.setText(board.getContent());
        if (board.getFisFile() != null) {
            image = new Image(board.getFisFile(), 230, 230, true, true);
            imageView.setImage(image);
        } else {
//            image=new Image("kr/or/yi/board/images/*.*");
            imageView.setImage(null);
        }
    }

    public void moveToList(ActionEvent event) throws IOException {
        SceneUtil.getInstance().switchScene(event, UI.LIST.getPath());

    }

    public void moveToUpdate(ActionEvent event) throws IOException {
        UpdateController updateController = SceneUtil.getInstance().getController(UI.UPDATE.getPath());
        updateController.read(boardNo);
        Parent root = SceneUtil.getInstance().getRoot();
        SceneUtil.getInstance().switchScene(event, UI.UPDATE.getPath(), root);
    }

    public void deleteToList(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("게시글 삭제");
        alert.setHeaderText("정말로 삭제하시겠습니까?");
        alert.setContentText("삭제후에는 되돌릴 수 없습니다.");

        int result = 0;
        if (alert.showAndWait().get() == ButtonType.OK) {
            result = boardService.delete(boardNo);
        }
        if (result > 0) {
            System.out.println("글삭제가 되었습니다.");
            SceneUtil.getInstance().switchScene(event, UI.LIST.getPath());
        }
    }


    public void moveToPrev(ActionEvent event) {
        numArr = listNum();
        read(preValue);
    }

    public void moveToNext(ActionEvent event) {
        numArr = listNum();
        read(nextValue);
    }

    public List<Integer> listNum() {
        List<Board> boardList;
        boardList = boardService.list();
        System.out.println("1111->" + boardList);
        numArr = new ArrayList<>();
        for (Board board : boardList) {
            numArr.add(board.getBoard_no());
        }

        System.out.println(numArr);
        targetValue = boardNo;

        for (int i = 0; i < numArr.size(); i++) {
            if (numArr.get(i) == targetValue) {
                if (i > 0) {
                    preValue = numArr.get(i - 1);
                }
                if (i < numArr.size() - 1) {
                    nextValue = numArr.get(i + 1);
                }

                break;
            }

        }
        return numArr;
    }


    public int showNum(int index) {
        int num = 0;
        if (index >= 0 && index < numArr.size()) {
            num = numArr.get(index);
        }

        return num;
    }

    @FXML
    private AnchorPane rootPane;

    @FXML
    public void handleMouseClicked(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            stage = (Stage) rootPane.getScene().getWindow();
            rootPane.setOnMousePressed((event1) -> {
                x = event1.getSceneX();
                y = event1.getSceneY();
            });
            rootPane.setOnMouseDragged((event1) -> {
                stage.setX((event1.getScreenX()) - x);
                stage.setY((event1.getScreenY()) - y);
                stage.setOpacity(0.8f);
            });
            rootPane.setOnDragDone((event1)->{
                stage=(Stage) rootPane.getScene().getWindow();
                stage.setOpacity(1.0f);
            });
            rootPane.setOnMouseReleased((event1) ->{
                stage=(Stage) rootPane.getScene().getWindow();
                stage.setOpacity(1.0f);
            });
        });
    }
}
