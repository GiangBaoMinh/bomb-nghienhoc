package uet.oop.bomberman;

import javafx.scene.Scene;
import uet.oop.bomberman.entities.Brick;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Grass;
import uet.oop.bomberman.entities.Wall;
import uet.oop.bomberman.graphics.Sprite;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Map {
    public int WIDTH = 31;
    public int HEIGHT = 13;
    Scene scene = null;

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    char[][] tileMap;
    Entity object;
    Entity bomb;
    public List<Entity> cells = new ArrayList<>();
    public List<Entity> bombs = new ArrayList<>();

    Map(Scene scene, int level) {
        this.scene = scene;
        loadLevel(level);
    }

    public void loadLevel(int level) {
        tileMap = new char[13][31];
        Scanner scan = null;
        try {
            scan = new Scanner(new FileReader("./res/levels/Level" + level + ".txt"));
            for (int i = 0; i < HEIGHT; i++) {
                String hash = scan.nextLine();
                for (int j = 0; j < WIDTH; j++) {
                    tileMap[i][j] = hash.charAt(j);
                    if (tileMap[i][j] == '#') {
                        object = new Wall(j, i, Sprite.wall.getFxImage());
                    } else if (tileMap[i][j] == '*') {
                        object = new Brick(j, i, Sprite.brick.getFxImage());
                    } else {
                        object = new Grass(j, i, Sprite.grass.getFxImage());
                    }
                    cells.add(object);
                    bombs.add(bomb);
                }
            }
            for (int i = 0; i < 13; i++) {
                for (int j = 0; j < 31; j++) {
                    System.out.print(tileMap[i][j]);
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
