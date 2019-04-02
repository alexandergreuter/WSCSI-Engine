package ch.bbbaden.games.Engine;

import ch.bbbaden.games.Scenes.StartScene.StartScene;

public class ScenesManager {

    Scene currentScene;

    public ScenesManager() {
        currentScene = new StartScene();
    }

    public Scene getCurrentScene() {

        return currentScene;
    }

    public void setCurrentScene(Scene currentScene) {
        this.currentScene = currentScene;
    }
}
