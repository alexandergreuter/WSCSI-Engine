package ch.bbbaden.games.GameObjects.DynamicGameObjects;

import ch.bbbaden.games.Engine.DynamicGameObject;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

import java.util.ArrayList;

public class Camera extends DynamicGameObject {

    public Camera(int x, int y) {
        super(x, y);
    }

    @Override
    public void update(WSwingConsoleInterface csi, ArrayList<DynamicGameObject> dynamicGameObjects) {

    }

    @Override
    public String getIcon() {
        return null;
    }

    @Override
    public boolean doRender() {
        return false;
    }

    @Override
    public CSIColor getColor() {
        return null;
    }

    @Override
    public void addHealth(int health) {

    }
}
