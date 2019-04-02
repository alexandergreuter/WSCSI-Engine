/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.games.GameObjects.DynamicGameObjects;

import ch.bbbaden.games.Engine.DynamicGameObject;
import ch.bbbaden.games.Engine.Prefab.Pathfinder.PathFinder;

import java.util.ArrayList;

import ch.bbbaden.games.Engine.Starter;
import ch.bbbaden.games.GameObjects.Components.UpdateComponents.MoveComponent.Direction;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

/**
 * @author greut
 */

public class Zombie extends DynamicGameObject {

    private int x;
    private int y;
    private int health = 50;
    private CSIColor color;
    private Player player;
    private Direction direction;
    private String icon;

    private boolean update = false;

    public Zombie(int x, int y, CSIColor color, Direction direction) {
        this.player = Starter.loop.getPlayer();
        this.x = x;
        this.y = y;
        this.color = color;
        this.direction = direction;
        changeIcon(direction);
    }

    @Override
    public void onSetup() {

    }

    @Override
    public void update(WSwingConsoleInterface csi, ArrayList<DynamicGameObject> dynamicGameObjects) {
        if (update) {
            huntPlayer(csi);
        } else {
            update = true;
        }

        for (DynamicGameObject dynamicGameObject : dynamicGameObjects) {
            if (dynamicGameObject.getX() == x && dynamicGameObject.getY() == y && !this.equals(dynamicGameObject)) {
                dynamicGameObject.addHealth(-3);
            }
        }
    }

    private void huntPlayer(WSwingConsoleInterface csi) {
        int oldX = x;
        int oldY = y;

        int[] xy = new PathFinder().nextInt(x, y, player.getX(), player.getY(), csi);
        x = xy[0];
        y = xy[1];

        if (oldX > x) {
            changeIcon(Direction.LEFT);
        } else if (oldX < x) {
            changeIcon(Direction.RIGHT);
        } else if (oldY > y) {
            changeIcon(Direction.UP);
        } else if (oldY < y) {
            changeIcon(Direction.DOWN);
        }
    }

    private void changeIcon(Direction direction) {
        switch (direction) {
            case UP:
                icon = "˄";
                break;
            case DOWN:
                icon = "˅";
                break;
            case LEFT:
                icon = "˂";
                break;
            case RIGHT:
                icon = "˃";
                break;
            default:
                //do nothing
                break;
        }
    }

    @Override
    public void addHealth(int health) {
        this.health += health;
    }

    @Override
    public boolean doRender() {
        return health <= 0;
    }

    @Override
    public CSIColor getColor() {
        return color;
    }

    @Override
    public String getIcon() {
        return icon;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
