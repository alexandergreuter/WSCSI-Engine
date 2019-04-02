package ch.bbbaden.games.Scenes.StartScene;

import ch.bbbaden.games.Engine.Scene;
import ch.bbbaden.games.GameObjects.Components.UpdateComponents.MoveComponent.Direction;
import ch.bbbaden.games.GameObjects.DynamicGameObjects.Zombie;
import net.slashie.libjcsi.CSIColor;

public class StartScene extends Scene {

    public void setupStaticGameObjects() {

    }

    @Override
    protected void setupGameBoard() {

    }

    public void setupGameObjects() {
        addDynamicGameObject(new Zombie(3, 4, CSIColor.RED, Direction.RIGHT));
    }
}
