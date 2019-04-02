/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.games.GameObjects.DynamicGameObjects;

import ch.bbbaden.games.Engine.DynamicGameObject;
import ch.bbbaden.games.GameObjects.Components.UpdateComponents.MoveComponent.Direction;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

import java.util.ArrayList;

import static net.slashie.libjcsi.wswing.WSwingConsoleInterface.getXdim;
import static net.slashie.libjcsi.wswing.WSwingConsoleInterface.getYdim;

/**
 * @author greut
 */
public class Player extends DynamicGameObject {

    private int health = 100;
    private int points;
    private CSIColor color;
    private Direction direction;
    private String icon;

    private boolean exit = false;

    private int lastKeyPressed;

    public Player(int x, int y, CSIColor color, Direction direction) {
        super(x, y);
        this.color = color;
        this.direction = direction;
        changeIcon(direction);
    }

    public void action(int charKey, WSwingConsoleInterface csi) {
        int playerNextX = super.getX();
        int playerNextY = super.getY();

        lastKeyPressed = charKey;
        switch (lastKeyPressed) {
            case CharKey.w:
                changeIcon(Direction.UP);
                if (y - 1 >= 0 && '#' != csi.peekChar(x, y - 1)) {
                    playerNextY = y - 1;
                    points++;
                }
                break;
            case CharKey.s:
                changeIcon(Direction.DOWN);
                //getYdim() is edge + 1 for some reason
                if (y + 1 <= getYdim() - 1 && '#' != csi.peekChar(x, y + 1)) {
                    playerNextY = y + 1;
                    points++;
                }
                break;
            case CharKey.a:
                changeIcon(Direction.LEFT);
                if (x - 1 >= 0 && '#' != csi.peekChar(x - 1, y)) {
                    playerNextX = x - 1;
                    points++;
                }
                break;
            case CharKey.d:
                //getXdim() is edge + 1 for some reason
                changeIcon(Direction.RIGHT);
                if (x + 1 <= getXdim() - 1 && '#' != csi.peekChar(x + 1, y)) {
                    playerNextX = x + 1;
                    points++;
                }
                break;
            case CharKey.ESC:
                exit = true;
                break;
            default: //No Key Pressed
        }

        x = playerNextX;
        y = playerNextY;

        clearAllInputs();
    }

    public int getHealth() {
        return health;

    }

    public void addHealth(int health) {
        this.health += health;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public void onSetup() {

    }

    @Override
    public void update(WSwingConsoleInterface csi, ArrayList<DynamicGameObject> dynamicGameObjects) {
        csi.addKeyEventListener(this);
        if (lastKeyPressed != -1) {
            action(lastKeyPressed, csi);
        }
    }

    private void clearAllInputs() {
        lastKeyPressed = -1;
    }

    private void changeIcon(Direction direction) {
        //i know its duplicate but the uml says nothing about a direction class...
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

    // Draw everything
    public void render(WSwingConsoleInterface csi, ArrayList<DynamicGameObject> dynamicGameObjects) {
        csi.restore();

        for (DynamicGameObject gObj : dynamicGameObjects) {
            csi.print(gObj.getX(), gObj.getY(), gObj.getIcon(), gObj.getColor());
        }
        csi.print(1, 0, "health: " + this.getHealth() + " score: " + points);

        csi.refresh();
    }

    public boolean isExit() {
        return exit;
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
    public void keyPressed(int key) {
        lastKeyPressed = key;
    }

    @Override
    public String getIcon() {
        return icon;
    }
}
