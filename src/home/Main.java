package home;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;



public class Main extends Application {
    private double x, y;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //tmpt nk load root fxml, paneRoot tapak fxml
        Parent root = FXMLLoader.load(getClass().getResource("paneRoot.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene((scene));

        primaryStage.setWidth(1050);
        primaryStage.setHeight(576);
        primaryStage.setResizable(false);
        //set borderless
        primaryStage.initStyle(StageStyle.UNDECORATED);



        // TODO Auto-generated method stub
        //Initialising path of the media file, replace this with your file path

        //drag it here
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {

            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);

        });
        playVideo();
        primaryStage.show();

    }
    public static void main(String[] args) {

        launch(args);
    }
    public void  playVideo() {
        //MUSIC
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
       // System.out.println("Current absolute path is: " + s);
        String path = s + "/src/videos/kroni2.mp3";

        //Instantiating Media class
        Media mediaMusic = new Media(new File(path).toURI().toString());

        //Instantiating MediaPlayer class
        MediaPlayer mediaPlayerMusic = new MediaPlayer(mediaMusic);

        //by setting this property to true, the audio will be played
        mediaPlayerMusic.setAutoPlay(true);

    }
}
