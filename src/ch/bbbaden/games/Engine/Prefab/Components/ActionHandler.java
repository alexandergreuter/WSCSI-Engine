package ch.bbbaden.games.Engine.Prefab.Components;

import net.slashie.libjcsi.wswing.KeyEventListener;

import java.util.ArrayList;

public abstract class ActionHandler implements KeyEventListener {
    private ArrayList<ActionListener> actionListeners = new ArrayList<>();

    public void updateActionListeners(ArrayList<ActionListener> actionListeners){
        this.actionListeners = actionListeners;
    }

    public void notifyListeners(Action action) {
        for (ActionListener actionListener : actionListeners) {
            actionListener.onAction(action);
        }
    }
}
