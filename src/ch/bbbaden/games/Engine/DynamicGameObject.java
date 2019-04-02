/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.games.Engine;

import java.util.ArrayList;

import ch.bbbaden.games.GameObjects.Components.UpdateComponents.UpdateComponent;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

/**
 * @author greut
 */
public abstract class DynamicGameObject implements GameObject{

    private int x;
    private int y;

    private ArrayList<UpdateComponent> components;

    public DynamicGameObject(int x, int y){
        this.x = x;
        this.y = y;
    }

    //Arguments to remove
    public abstract void update(WSwingConsoleInterface csi, ArrayList<DynamicGameObject> dynamicGameObjects);

    //to remove
    public abstract String getIcon();

    public abstract boolean doRender();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //to remove
    public abstract CSIColor getColor();

    //to remove
    public abstract void addHealth(int health);

    public void addComponent(UpdateComponent component) {
        components.add(component);
    }
}
