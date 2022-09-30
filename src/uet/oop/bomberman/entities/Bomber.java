package uet.oop.bomberman.entities;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.graphics.SpriteSheet;

public class Bomber extends Entity {
    Scene scene = null;
    public int WIDTH = 31;
    public int HEIGHT = 13;
    public boolean up = false;
    public boolean down = false;
    public boolean right = false;
    public boolean left = false;
    public boolean space = false;
    public int speed = 16;
    public boolean moving = false;
    public Sprite[] playerAnimUp, playerAnimDown, playerAnimRight, playerAnimLeft, bombAnimation;
    public int indexOfMove = 0;
    public int indexOfBomb = 0;
    public int bombCount = 1;

    public Bomber(int x, int y, Image img, Scene scene) {
        super(x, y, img);
        this.scene = scene;
        handleKeyPressed(this.scene);
    }

    public void handleKeyPressed( Scene scene) {
        scene.setOnKeyPressed(keyEvent -> {
            switch (keyEvent.getCode()) {
                case W:
                    this.up = true;
                    moving = true;
                    handleMove();
                    break;
                case S:
                    this.down = true;
                    moving = true;
                    handleMove();
                    break;
                case A:
                    this.left = true;
                    moving = true;
                    handleMove();
                    break;
                case D:
                    this.right = true;
                    moving = true;
                    handleMove();
                    break;
                case SPACE:
                    setBomb();
                    System.out.println("Space");
                    break;
            }
        });
        scene.setOnKeyReleased(keyEvent -> {
            switch (keyEvent.getCode()) {
                case W:
                    this.up = false;
                    break;
                case S:
                    this.down = false;
                    break;
                case A:
                    this.left = false;
                    break;
                case D:
                    this.right = false;
                    break;
            }
        });
    }

    public void handleMove() {
        moveAnimation();
        if (moving) {
            indexOfMove++;
            if (indexOfMove > 2) {
                indexOfMove = 0;
            }
            if (this.up) {
                this.img = playerAnimUp[indexOfMove].getFxImage();
                this.y += -speed;
            }
            if (this.down) {
                this.img = playerAnimDown[indexOfMove].getFxImage();
                this.y += speed;
            }
            if (this.left) {
                this.img = playerAnimLeft[indexOfMove].getFxImage();
                this.x += -speed;
            }
            if (this.right) {
                this.img = playerAnimRight[indexOfMove].getFxImage();
                this.x += speed;
            }
        }
    }

    public void moveAnimation() {
        playerAnimLeft = new Sprite[3];
        playerAnimDown = new Sprite[3];
        playerAnimUp = new Sprite[3];
        playerAnimRight = new Sprite[3];
        for (int i = 0; i <= 2; i++) {
            playerAnimLeft[i] = new Sprite(Sprite.DEFAULT_SIZE, 3, i, SpriteSheet.tiles, 12, 16);
            playerAnimRight[i] = new Sprite(Sprite.DEFAULT_SIZE, 1, i, SpriteSheet.tiles, 12, 16);
            playerAnimDown[i] = new Sprite(Sprite.DEFAULT_SIZE, 2, i, SpriteSheet.tiles, 12, 16);
            playerAnimUp[i] = new Sprite(Sprite.DEFAULT_SIZE, 0, i, SpriteSheet.tiles, 12, 16);
        }
    }


    public void setBomb() {
        bombAnimation();
        if (bombCount >= 1) {
            indexOfBomb++;
            if (indexOfBomb > 2) {
                indexOfBomb = 0;
            }
            if (this.space) {
                Bomb bomb = new Bomb(this.x, this.y, bombAnimation[0].getFxImage());
                bomb.img = bombAnimation[indexOfBomb].getFxImage();
                bombCount--;
            }
            bombCount++;
        }
    }

    public void bombAnimation() {
        bombAnimation = new Sprite[3];
        for (int i = 0; i <= 2; i++) {
            bombAnimation[i] = new Sprite(Sprite.DEFAULT_SIZE, i, 3, SpriteSheet.tiles, 15, 15);
        }
    }

    public boolean checkWall() {
        if (this.y == 0 || this.y == HEIGHT - 1 || this.x == 0 || this.x == WIDTH - 1
                || (this.x % 2 == 0 && this.y % 2 == 0)) {
            return false;
        }
        return true;
    }

    @Override
    public void update() {

    }
}
