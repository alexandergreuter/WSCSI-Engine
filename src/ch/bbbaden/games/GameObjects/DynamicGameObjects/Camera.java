package ch.bbbaden.games.GameObjects.DynamicGameObjects;

import ch.bbbaden.games.Engine.GameObject;
import ch.bbbaden.games.Engine.Prefab.Components.Action;
import ch.bbbaden.games.Engine.Prefab.Components.ActionListener;
import ch.bbbaden.games.Engine.Prefab.Components.Direction;
import ch.bbbaden.games.Engine.Prefab.Components.Renderer;
import ch.bbbaden.games.Engine.Scene;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

import java.util.ArrayList;

public class Camera extends GameObject implements Renderer, ActionListener {

    private ArrayList<Action> tempBlockedActions = new ArrayList<>();

    public Camera(int x, int y, boolean render) {
        super(x, y, render, "C");
    }

    @Override
    public void render(Scene scene, WSwingConsoleInterface csi) {
        int xOffset = - Math.abs(getX() / 2);
        System.out.println("x: " + getX());
        System.out.println("y: " + getY());
        System.out.println("xOffset: " + xOffset);
        int yOffset = - Math.abs(getY() / 2);
        System.out.println("yOffset: " + yOffset);
        csi.cls();
        for (GameObject gameObject : scene.getGameObjects()) {
            if (gameObject.getX() + xOffset >= 0 && gameObject.getX() + xOffset <= WSwingConsoleInterface.getXdim() && gameObject.getY() + yOffset >= 0 && gameObject.getX() + xOffset <= WSwingConsoleInterface.getYdim()) {
                csi.print((gameObject.getX() + xOffset), (gameObject.getY() + yOffset), gameObject.getIcon());
            }
        }
        csi.refresh();
    }

    @Override
    public void onAction(Action action) {
        if (!hasChanged()) {
            tempBlockedActions.clear();
        }

        if (!tempBlockedActions.contains(action)) {
            switch (action) {
                case UP:
                    move(Direction.UP, 1);
                    break;
                case LEFT:
                    move(Direction.LEFT, 1);
                    break;
                case RIGHT:
                    move(Direction.RIGHT, 1);
                    break;
                case DOWN:
                    move(Direction.DOWN, 1);
                    break;
                default:
                    break;
            }
            tempBlockedActions.add(action);
        }

        setChanged(true);
    }
}
