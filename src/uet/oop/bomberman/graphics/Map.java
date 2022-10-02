package uet.oop.bomberman.graphics;

import javafx.scene.Scene;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.animal.Balloon;
import uet.oop.bomberman.entities.animal.Oneal;
import uet.oop.bomberman.entities.block.Brick;
import uet.oop.bomberman.entities.block.Grass;
import uet.oop.bomberman.entities.block.Portal;
import uet.oop.bomberman.entities.block.Wall;
import uet.oop.bomberman.items.BombItem;
import uet.oop.bomberman.items.FlameItem;
import uet.oop.bomberman.items.SpeedItem;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import static uet.oop.bomberman.BombermanGame.blocks;

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

    public Map(Scene scene, int level) {
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
                    object = new Grass(j, i, Sprite.grass.getFxImage());
                    if (tileMap[i][j] == '#') {
                        object = new Wall(j, i, Sprite.wall.getFxImage());
                    }
                    if (tileMap[i][j] == '*' || tileMap[i][j] == 's' || tileMap[i][j] == 'f' || tileMap[i][j] == 'b') {
                        object = new Brick(j, i, Sprite.brick.getFxImage());
                    }
                    if (tileMap[i][j] == 's') {
                        object = new SpeedItem(j, i, Sprite.powerup_speed.getFxImage());
                        blocks.add(object);
                        object = new Brick(j, i, Sprite.brick.getFxImage());
                    }
                    if (tileMap[i][j] == 'f') {
                        object = new FlameItem(j, i, Sprite.powerup_flames.getFxImage());
                        blocks.add(object);
                        object = new Brick(j, i, Sprite.brick.getFxImage());
                    }
                    if (tileMap[i][j] == 'b') {
                        object = new BombItem(j, i, Sprite.powerup_bombs.getFxImage());
                        blocks.add(object);
                        object = new Brick(j, i, Sprite.brick.getFxImage());
                    }
                    if (tileMap[i][j] == 'x') {
                        object = new Portal(j, i, Sprite.portal.getFxImage());
                        blocks.add(object);
                        object = new Brick(j, i, Sprite.brick.getFxImage());
                    }
                    if (tileMap[i][j] == '1') {
                        object = new Balloon(j, i, Sprite.balloom_left1.getFxImage());
                    }
                    if (tileMap[i][j] == '2') {
                        object = new Oneal(j, i, Sprite.oneal_left1.getFxImage());
                    }
                    blocks.add(object);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
