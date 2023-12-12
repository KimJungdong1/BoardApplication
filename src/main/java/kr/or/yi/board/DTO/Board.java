package kr.or.yi.board.DTO;

import javafx.scene.control.CheckBox;

import java.io.File;
import java.io.InputStream;
import java.util.Date;

public class Board {
    private int board_no;
    private String title;
    private String writer;
    private String content;
    private String reg_date;
    private String upd_date;
    private File file;
    private InputStream isfile;
    private CheckBox cbDelete;


    public Board() {
        this("제목 없음", "작성자 없음", "내용 없음");
    }

    public Board(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.cbDelete = new CheckBox();

    }

    public Board(String title, String writer, String content, File file) {
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.file = file;
        this.cbDelete = new CheckBox();

    }

    public void setBoard_no(int board_no) {
        this.board_no = board_no;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    public void setUpd_date(String upd_date) {
        this.upd_date = upd_date;
    }

    public int getBoard_no() {
        return board_no;
    }

    public String getTitle() {
        return title;
    }

    public String getWriter() {
        return writer;
    }

    public String getContent() {
        return content;
    }

    public String getReg_date() {
        return reg_date;
    }

    public String getUpd_date() {
        return upd_date;
    }

    public CheckBox getCbDelete() {
        return cbDelete;
    }

    public void setCbDelete(CheckBox cbDelete) {
        this.cbDelete = cbDelete;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public InputStream getFisFile() {
        return isfile;
    }

    public void setFisFile(InputStream fis) {
        this.isfile = fis;
    }

    @Override
    public String toString() {
        return "Board{" +
                "board_no=" + board_no +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", content='" + content + '\'' +
                ", reg_date=" + reg_date +
                ", upd_date=" + upd_date +
                '}';
    }
}
