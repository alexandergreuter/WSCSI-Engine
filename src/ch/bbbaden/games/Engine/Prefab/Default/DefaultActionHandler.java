package ch.bbbaden.games.Engine.Prefab.Default;

import ch.bbbaden.games.Engine.Prefab.Components.Action;
import ch.bbbaden.games.Engine.Prefab.Components.ActionHandler;
import net.slashie.libjcsi.CharKey;

public class DefaultActionHandler extends ActionHandler {

    @Override
    public void keyPressed(int i) {
        switch (i) {
            case CharKey.w:
            case CharKey.W:
                notifyListeners(Action.W);
                break;
            case CharKey.a:
            case CharKey.A:
                notifyListeners(Action.A);
                break;
            case CharKey.S:
            case CharKey.s:
                notifyListeners(Action.S);
                break;
            case CharKey.D:
            case CharKey.d:
                notifyListeners(Action.D);
                break;
            case CharKey.UARROW:
                notifyListeners(Action.UP);
                break;
            case CharKey.DARROW:
                notifyListeners(Action.DOWN);
                break;
            case CharKey.LARROW:
                notifyListeners(Action.LEFT);
                break;
            case CharKey.RARROW:
                notifyListeners(Action.RIGHT);
                break;
            default: //ignored
        }
    }
}

