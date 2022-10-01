package uet.oop.bomberman.entities.block;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.graphics.SpriteSheet;

public class Bomb extends Entity {
    Scene scene = null;
    Image img;
    public boolean exploded = false;
    int countToExplode, intervalToExplode = 4;
    public Sprite[] bombAnimation;
    public int bombCount = 1;
    public int indexOfBomb = 0;

    public Bomb(int x, int y, Image img) {
        super(x, y, img);
    }


    @Override
    public void update() {

    }
}
