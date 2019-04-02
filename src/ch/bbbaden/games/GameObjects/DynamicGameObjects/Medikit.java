/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.games.GameObjects.DynamicGameObjects;

import java.util.ArrayList;

import ch.bbbaden.games.Engine.DynamicGameObject;
import ch.bbbaden.games.Engine.Starter;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

/**
 * @author greut
 */
public class Medikit extends DynamicGameObject {

    private int x;
    private int y;
    private CSIColor color;
    private boolean dead = false;
    private Player player;
    private boolean found = false;

    private final static String ICON = "M";

    public Medikit(int x, int y, CSIColor color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.player = Starter.loop.getPlayer();
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void update(WSwingConsoleInterface csi, ArrayList<DynamicGameObject> dynamicGameObjects) {
        for (DynamicGameObject dynamicGameObject : dynamicGameObjects) {
            if (dynamicGameObject.getX() == x && dynamicGameObject.getY() == y && !this.equals(dynamicGameObject)) {
                dynamicGameObject.addHealth(+10);
                dead = true;
            }
        }
    }

    @Override
    public boolean doRender() {
        return dead;
    }

    @Override
    public CSIColor getColor() {
        return color;
    }

    @Override
    public void addHealth(int health) {
        //do nothing
    }

    @Override
    public String getIcon() {
        return ICON;
    }
}
