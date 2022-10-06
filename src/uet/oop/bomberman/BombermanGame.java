package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import uet.oop.bomberman.control.Move;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.animal.Animal;
import uet.oop.bomberman.entities.animal.Bomber;
import uet.oop.bomberman.entities.block.Bomb;
import uet.oop.bomberman.graphics.Map;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;

public class BombermanGame extends Application {

    public int WIDTH = 31;
    public int HEIGHT = 13;
    public int levelGame = 1;

    private GraphicsContext gc;
    private Canvas canvas;
    public static List<Entity> entities = new ArrayList<>();
    public static final List<Entity> blocks = new ArrayList<>();
    public static Animal player;
    Group root = new Group();
    Scene scene = new Scene(root);

    public static char[][] tileMap;

    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();

        // Tao root container
        root.getChildren().add(canvas);

        // Tao scene
        stage.setTitle("Bomber Man");
        scene.setOnKeyPressed(keyEvent -> {
            if (player.isLife()) {
                switch (keyEvent.getCode()) {
                    case W:
                        Move.up(player);
                        break;
                    case S:
                        Move.down(player);
                        break;
                    case A:
                        Move.left(player);
                        break;
                    case D:
                        Move.right(player);
                        break;
                    case SPACE:
                        Bomb.setBomb();
                        break;
                }
            }
        });

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                update();
            }
        };
        timer.start();
        player = new Bomber(1, 1, Sprite.player_right.getFxImage());
        player.setLife(true);
        Map map = new Map(scene, levelGame);
    }


    public void update() {
        entities.forEach(Entity::update);
        blocks.forEach(Entity::update);
        player.update();

        player.setCountToRun(player.getCountToRun() + 1);
        if (player.getCountToRun() == 4) {
            Move.checkRun(player);
            player.setCountToRun(0);
        }
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        blocks.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
        player.render(gc);
    }
}
