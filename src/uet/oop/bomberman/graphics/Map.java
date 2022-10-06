package uet.oop.bomberman.graphics;

import uet.oop.bomberman.entities.block.Brick;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.block.Grass;
import uet.oop.bomberman.entities.block.Wall;
import uet.oop.bomberman.BombermanGame;
import static uet.oop.bomberman.BombermanGame.*;

import javafx.scene.Scene;
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

    Entity object;

    public Map(Scene scene, int level) {
        this.scene = scene;
        loadLevel(level);
    }

    public void loadLevel(int level) {
        tileMap = new char[HEIGHT][WIDTH];
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
                    } else if(tileMap[i][j] == '1'){
                        object = new Brick(j, i, Sprite.brick.getFxImage());
                    }
                    else {
                        object = new Grass(j, i, Sprite.grass.getFxImage());
                    }
                    blocks.add(object);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
