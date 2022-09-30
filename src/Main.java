import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String Args){
        launch(Args);
    }

    @Override
    public void start(Stage theStage){
        theStage.setTitle("Bomb");
        Button button = new Button();
        theStage.show();
        System.out.println("commit");
    }
}
