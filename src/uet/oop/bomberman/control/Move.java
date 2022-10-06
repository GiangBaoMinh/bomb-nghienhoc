package uet.oop.bomberman.control;

import uet.oop.bomberman.entities.animal.Animal;
import uet.oop.bomberman.entities.animal.Bomber;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.control.Blocked;

public class Move {
    public static void checkRun(Animal animal) {
        if (animal instanceof Bomber && animal.getCount() > 0) {
            setDirection(animal.getDirection(), animal, 1);
            animal.setCount(animal.getCount() - 1);
        }
    }

    private static void setDirection(String direction, Animal animal, int isMove) {
        switch (direction) {
            case "right":
                moveAnimationRight(animal);
                animal.setX(animal.getX() + isMove);
                break;
            case "left":
                moveAnimationLeft(animal);
                animal.setX(animal.getX() - isMove);
                break;
            case "up":
                moveAnimationUp(animal);
                animal.setY(animal.getY() - isMove);
                break;
            case "down":
                moveAnimationDown(animal);
                animal.setY(animal.getY() + isMove);
                break;
        }
    }

    public static void down(Animal animal) {
        if (animal instanceof Bomber) {
            animal.setDirection("down");
            animal.setCount(4);
        }
        else{
            System.out.println("Block down!");
        }
    }

    private static void moveAnimationDown(Animal animal) {
        if (animal instanceof Bomber && Blocked.checkBottom(animal)) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.player_down.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.player_down_1.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.player_down.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.player_down_2.getFxImage());
                animal.setSwap(1);
            }
        }
    }

    public static void up(Animal animal) {
        if (animal instanceof Bomber && Blocked.checkUp(animal)) {
            animal.setDirection("up");
            animal.setCount(4);
        }
        else{
            System.out.println("Block up!");
        }
    }

    private static void moveAnimationUp(Animal animal) {
        if (animal instanceof Bomber) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.player_up.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.player_up_1.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.player_up.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.player_up_2.getFxImage());
                animal.setSwap(1);
            }
        }
    }

    public static void left(Animal animal) {
        if (animal instanceof Bomber && Blocked.checkLeft(animal)) {
            animal.setDirection("left");
            animal.setCount(4);
        }
        else{
            System.out.println("Block left!");
        }
    }

    private static void moveAnimationLeft(Animal animal) {
        if (animal instanceof Bomber) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.player_left.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.player_left_1.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.player_left.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.player_left_2.getFxImage());
                animal.setSwap(1);
            }
        }
    }

    public static void right(Animal animal) {
        if (animal instanceof Bomber && Blocked.checkRight(animal)) {
            animal.setDirection("right");
            animal.setCount(4);
        }

        else{
            System.out.println("Block right!");
        }
    }

    private static void moveAnimationRight(Animal animal) {
        if (animal instanceof Bomber) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.player_right.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.player_right_1.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.player_right.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.player_right_2.getFxImage());
                animal.setSwap(1);
            }
        }
    }
}
