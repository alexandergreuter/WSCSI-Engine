package ch.bbbaden.games.Scenes;

import ch.bbbaden.games.Engine.Prefab.Default.DefaultActionHandler;
import ch.bbbaden.games.Engine.Prefab.Default.DefaultCollisionHandler;
import ch.bbbaden.games.Engine.Scene;
import ch.bbbaden.games.GameObjects.DynamicGameObjects.Camera;
import ch.bbbaden.games.GameObjects.DynamicGameObjects.Player;

public class StartScene extends Scene {

    public void setupGameObjects() {
        addGameObject(new Player(3, 4));
        Camera camera = new Camera(20,20,false);
        setRenderer(camera);
        addGameObject(camera);
    }
}
