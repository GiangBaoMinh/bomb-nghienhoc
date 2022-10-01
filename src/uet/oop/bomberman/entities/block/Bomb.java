package uet.oop.bomberman.entities.block;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.blocks;
import static uet.oop.bomberman.BombermanGame.player;

public class Bomb extends Entity {
    public static int numberOfBomb = 1;
    public static long timeCurrent;
    public static long timeTemp;

    public Bomb(int x, int y, Image img) {
        super(x, y, img);
    }

    public static void setBomb() {
        if (numberOfBomb == 1) {
            numberOfBomb--;
            int x = player.getX() / 48;
            int y = player.getY() / 48;
            x = Math.round((float) x);
            y = Math.round((float) y);
            Entity bomb = new Bomb(x, y, Sprite.bomb.getFxImage());
            blocks.add(bomb);
        }
    }

    public static void handleAnimationPutBomb() {

    }


    @Override
    public void update() {
    }
}
