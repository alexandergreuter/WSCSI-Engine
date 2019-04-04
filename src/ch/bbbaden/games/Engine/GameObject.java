/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.games.Engine;

import ch.bbbaden.games.Engine.Prefab.Components.Direction;

/**
 * @author greut
 */
public abstract class GameObject {

    private int x;
    private int y;

    private int nextX;
    private int nextY;

    private boolean changed = false;

    private boolean render;
    private String icon;

    public GameObject(int x, int y, boolean render, String icon) {
        this.x = x;
        this.y = y;
        this.nextX = x;
        this.nextY = y;
        this.render = render;
        this.icon = icon;
    }

    public void update(Scene scene){
        if(changed) {
            x = nextX;
            y = nextY;
            changed = false;
            scene.setRedraw(true);
        }
    }

    protected boolean hasChanged() {
        return changed;
    }

    protected void setChanged(boolean changed){
        this.changed = changed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getIcon() {
        return icon;
    }

    protected void move(Direction direction, int fields) {
        switch (direction) {
            case UP:
                nextY -= fields;
                break;
            case DOWN:
                nextY += fields;
                break;
            case LEFT:
                nextX -= fields;
                break;
            case RIGHT:
                nextX += fields;
            default:
                break;
        }
    }
}
