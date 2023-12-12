package kr.or.yi.board.Controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import kr.or.yi.board.DTO.Board;
import kr.or.yi.board.Main;
import kr.or.yi.board.Service.BoardService;
import kr.or.yi.board.Service.BoardServiceImpl;
import kr.or.yi.board.Utils.SceneUtil;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InsertController implements Initializable {
    @FXML
    private Button fileChoose;
    @FXML
    private TextField tfTitle;
    @FXML
    private TextField tfWriter;
    @FXML
    private TextArea taContent;
    @FXML
    private FileChooser fileChooser;
    @FXML
    private TextField tfFilePath;
    @FXML
    private ImageView imageView;
    private Image image;
    private File file;


    Stage stage ;
    Scene scene;
    Parent root;

    FXMLLoader loader;

    // 아래는 정동이가 추가한 것

    private double x;
    private double y;

    public void close() {
        System.exit(0);
    }

    // 윗부분은 정동이가 추가한 것

    private BoardService boardService = new BoardServiceImpl();

    public void insert(ActionEvent event) throws IOException {
        Board board = new Board(tfTitle.getText(), tfWriter.getText(), taContent.getText(), file);
        int result = boardService.insert(board);
        if (result > 0) {
            System.out.println("글쓰기 완료");
            SceneUtil.getInstance().switchScene(event, UI.LIST.getPath());
        }
    }

    public void moveToList(ActionEvent event) throws IOException {
        SceneUtil.getInstance().switchScene(event, UI.LIST.getPath());

    }

    public void fileUpload(ActionEvent event) {
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png","*.jpg","*.jpeg","*.git"),
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("Audio Files", "*.wav","*.mp3","*.aac"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );
        file = fileChooser.showOpenDialog(stage);
        if(file !=null){
            tfFilePath.setText(file.getAbsolutePath());
            image=new Image(file.toURI().toString(),230,230,true,true);
            imageView.setImage(image);
        }

//        System.out.println(file);
    }

//    public void close(javafx.event.ActionEvent event) {
//    }

    // 아래는 정동이가 추가한 것

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

    // 윗부분은 정동이가 추가한 것
}
