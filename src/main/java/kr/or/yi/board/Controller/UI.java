package kr.or.yi.board.Controller;

public enum UI {
    LIST("/kr/or/yi/board/Main.fxml"),
    INSERT("/kr/or/yi/board/Insert.fxml"),
    READ("/kr/or/yi/board/Read.fxml"),
    UPDATE("/kr/or/yi/board/Update.fxml");


    private final String path;
    UI(String path){
        this.path=path;
    }

    public String getPath(){
        return path;
    }
}
