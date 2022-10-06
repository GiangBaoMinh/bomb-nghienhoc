package uet.oop.bomberman.control;

import uet.oop.bomberman.entities.Entity;
import static uet.oop.bomberman.BombermanGame.*;

public class Blocked {
    public static boolean checkBottom(Entity entity){
        System.out.print("down " + (entity.getX() / 48) + " "+ entity.getY() / 48 + "\n");
        return tileMap[entity.getX() / 48][entity.getY() / 48 + 1] == ' ';
    }
    public static boolean checkUp(Entity entity){
        System.out.print("up "+(entity.getX() / 48) + " "+ entity.getY() / 48 + "\n");
        return tileMap[entity.getX() / 48][entity.getY() / 48 - 1] == ' ';
    }
    public static boolean checkRight(Entity entity){
        System.out.print("right" + (entity.getX() / 48) + " "+ (entity.getY() / 48) + "\n");
        return tileMap[entity.getX() / 48 + 1][entity.getY() / 48] == ' ';
    } 
    public static boolean checkLeft(Entity entity){
        System.out.print("left " + (entity.getX() / 48) + " "+ entity.getY() / 48 + "\n");
        return tileMap[entity.getX() / 48 - 1][entity.getY() / 48] == ' ';
    }

}
