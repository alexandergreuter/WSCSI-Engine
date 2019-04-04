package ch.bbbaden.games.Engine;

import ch.bbbaden.games.Scenes.StartScene;

public class ScenesManager {

    Scene currentScene;

    public ScenesManager() {
        currentScene = new StartScene();
    }

    public void update() {
        currentScene.update();
    }

    public void setCurrentScene(Scene currentScene) {
        this.currentScene = currentScene;
    }
}
