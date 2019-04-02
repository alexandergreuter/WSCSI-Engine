package ch.bbbaden.games.Engine;

import ch.bbbaden.games.GameObjects.Components.EventComponents.ActionComponent.ActionListener;
import net.slashie.libjcsi.wswing.KeyEventListener;

import java.util.ArrayList;

public class EventComponentsHandler implements KeyEventListener {

    public ArrayList<ActionListener> actionListeners = new ArrayList<>();

    @Override
    public void keyPressed(int i) {

    }

    public void addActionListener(ActionListener actionListener) {
        actionListeners.add(actionListener);
    }
}
