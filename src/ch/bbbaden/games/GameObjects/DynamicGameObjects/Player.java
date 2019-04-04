/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.games.GameObjects.DynamicGameObjects;

import ch.bbbaden.games.Engine.GameObject;
import ch.bbbaden.games.Engine.Prefab.Components.Action;
import ch.bbbaden.games.Engine.Prefab.Components.ActionListener;
import ch.bbbaden.games.Engine.Prefab.Components.Collider;
import ch.bbbaden.games.Engine.Prefab.Components.Direction;

import java.util.ArrayList;

/**
 * @author greut
 */
public class Player extends GameObject implements ActionListener, Collider {

    private ArrayList<Action> tempBlockedActions = new ArrayList<>();

    public Player(int x, int y) {
        super(x, y, true, "P");
    }

    @Override
    public void onAction(Action action) {
        if (!hasChanged()) {
            tempBlockedActions.clear();
        }

        if (!tempBlockedActions.contains(action)) {
            switch (action) {
                case W:
                    move(Direction.UP, 1);
                    break;
                case A:
                    move(Direction.LEFT, 1);
                    break;
                case D:
                    move(Direction.RIGHT, 1);
                    break;
                case S:
                    move(Direction.DOWN, 1);
                    break;
                default:
                    break;
            }
            tempBlockedActions.add(action);
        }

        setChanged(true);
    }

    @Override
    public void onCollision(Collider collider) {

    }
}
