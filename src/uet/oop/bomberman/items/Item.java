package uet.oop.bomberman.items;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;

public abstract class Item extends Entity {
    protected boolean pick = false;

    public Item(int x, int y, Image img) {
        super(x, y, img);
    }

    public Item(boolean isPick) {

    }

    public Item() {

    }

    public boolean isPick() {
        return pick;
    }

    public void setPick(boolean pick) {
        this.pick = pick;
    }

    @Override
    public void update() {

    }
}
