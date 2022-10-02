package uet.oop.bomberman.entities.block;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.blocks;
import static uet.oop.bomberman.BombermanGame.player;

public class Bomb extends Entity {
    public static int numberOfBomb = 1;
    public static int explosion = 0;
    public static int swapAnimation = 1;
    public static long timeCurrent;
    public static long timeTemp;
    public static Entity bomb;

    public Bomb(int x, int y, Image img) {
        super(x, y, img);
    }

    public static void setBomb() {
        if (numberOfBomb == 1) {
            numberOfBomb--;
            explosion = 1;
            timeCurrent = System.currentTimeMillis();
            timeTemp = timeCurrent;
            int x = player.getX() / 48;
            int y = player.getY() / 48;
            x = Math.round((float) x);
            y = Math.round((float) y);
            bomb = new Bomb(x, y, Sprite.bomb.getFxImage());
            blocks.add(bomb);
        }
    }

    public static void handleAnimationPutBomb() {
        if (swapAnimation == 1) {
            bomb.setImg(Sprite.bomb.getFxImage());
            swapAnimation = 2;
        } else if (swapAnimation == 2) {
            bomb.setImg(Sprite.bomb_1.getFxImage());
            swapAnimation = 3;
        } else if (swapAnimation == 3) {
            bomb.setImg(Sprite.bomb.getFxImage());
            swapAnimation = 4;
        } else if (swapAnimation == 4) {
            bomb.setImg(Sprite.bomb_2.getFxImage());
            swapAnimation = 1;
        }
    }

    public static void handleAnimationExplosion() {
        bomb.setImg(Sprite.bomb_exploded.getFxImage());
    }

    public static void timeAnimationPutBomb() {
        if (explosion == 1) {
            if (System.currentTimeMillis() - timeCurrent < 2000) {
                if (System.currentTimeMillis() - timeTemp > 100) {
                    handleAnimationPutBomb();
                    timeTemp += 100;
                }
            }
            else {
                explosion = 2;
                timeCurrent = System.currentTimeMillis();
                timeTemp = timeCurrent;
            }
        }
    }

    public static void timeAnimationExplosion() {
        if (explosion == 2) {
            if (System.currentTimeMillis() - timeCurrent < 1000L) {
                if (System.currentTimeMillis() - timeTemp > 100L) {
                    handleAnimationExplosion();
                    timeTemp += 100L;
                }
            }
            else {
                explosion = 0;
                timeCurrent = System.currentTimeMillis();
                timeTemp = timeCurrent;
            }
        }
    }


    @Override
    public void update() {
        timeAnimationPutBomb();
        timeAnimationExplosion();
    }
}
