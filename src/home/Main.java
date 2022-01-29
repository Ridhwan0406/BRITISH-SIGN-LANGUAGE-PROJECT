package home;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    private double x, y;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //tmpt nk load root fxml, paneRoot tapak fxml
        Parent root = FXMLLoader.load(getClass().getResource("paneRoot.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene((scene));

        //make border corner ,remove hujung putih
        scene.setFill(Color.TRANSPARENT);
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        //make fix size
        primaryStage.setWidth(1050);
        primaryStage.setHeight(576);
        primaryStage.setResizable(false);

        //set borderless - not used
        /*primaryStage.initStyle(StageStyle.UNDECORATED);*/

        //drag it here
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {

            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);

        });
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
