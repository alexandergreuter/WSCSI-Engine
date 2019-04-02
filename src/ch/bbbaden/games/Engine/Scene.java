package ch.bbbaden.games.Engine;

import java.util.ArrayList;

public abstract class Scene {

    private ArrayList<DynamicGameObject> dynamicGameObjects;
    private ArrayList<StaticGameObject> staticGameObjects;

    public Scene() {
        dynamicGameObjects = new ArrayList<DynamicGameObject>();
        setupGameBoard();
        setupGameObjects();
        if (dynamicGameObjects == null) {
            System.out.println("no Game Objects");
        }
    }

    public ArrayList<DynamicGameObject> getDynamicGameObjects() {
        return dynamicGameObjects;
    }

    public ArrayList<StaticGameObject> getStaticGameObjects() {
        return staticGameObjects;
    }

    public void addDynamicGameObject(DynamicGameObject dynamicGameObject) {
        dynamicGameObjects.add(dynamicGameObject);
    }

    protected abstract void setupGameBoard();

    public abstract void setupGameObjects();

}
