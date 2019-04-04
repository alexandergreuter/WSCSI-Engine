package ch.bbbaden.games.Engine;

import ch.bbbaden.games.Engine.Prefab.Components.*;
import ch.bbbaden.games.Engine.Prefab.Default.DefaultActionHandler;
import ch.bbbaden.games.Engine.Prefab.Default.DefaultCollisionHandler;
import ch.bbbaden.games.Engine.Prefab.Default.DefaultRenderer;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

import java.util.ArrayList;

public abstract class Scene {

    private ArrayList<GameObject> gameObjects = new ArrayList<>();

    private CollisionHandler collisionhandler;
    private Renderer renderer;
    private ActionHandler actionHandler;
    private WSwingConsoleInterface csi;
    private boolean updateActionListeners = true;
    private boolean redraw = true;

    public Scene() {
        setupGameObjects();
        this.actionHandler = new DefaultActionHandler();
        this.collisionhandler = new DefaultCollisionHandler();
        this.renderer = new DefaultRenderer();
        csi = new WSwingConsoleInterface("Basic Game - Game Loop Edition");
        csi.addKeyEventListener(actionHandler);
    }

    public Scene(DefaultActionHandler actionHandler, DefaultCollisionHandler collisionhandler, Renderer renderer) {
        setupGameObjects();
        this.actionHandler = actionHandler;
        this.collisionhandler = collisionhandler;
        this.renderer = renderer;
        csi = new WSwingConsoleInterface("Basic Game - Game Loop Edition");
        csi.addKeyEventListener(actionHandler);
    }

    public Renderer getRenderer() {
        return renderer;
    }

    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
        System.out.println(renderer);
    }

    public void update() {
        for (GameObject gameObject : gameObjects) {
            gameObject.update(this);
        }
        if (redraw) {
            System.out.println("redrawing");
            System.out.println(renderer);
            renderer.render(this, csi);
            redraw = false;
        }
        collisionhandler.checkForCollision(getColliders());
        if (updateActionListeners) {
            actionHandler.updateActionListeners(getActionListeners());
            updateActionListeners = false;
        }
    }

    public ArrayList<GameObject> getGameObjects() {
        return gameObjects;
    }

    private ArrayList<Collider> getColliders() {
        ArrayList<Collider> colliders = new ArrayList<>();
        for (GameObject gameObject : gameObjects) {
            if (gameObject instanceof Collider) colliders.add((Collider) gameObject);
        }
        return colliders;
    }

    public ArrayList<ActionListener> getActionListeners() {
        ArrayList<ActionListener> actionListeners = new ArrayList<>();
        for (GameObject gameObject : gameObjects) {
            if (gameObject instanceof ActionListener) actionListeners.add((ActionListener) gameObject);
        }
        return actionListeners;
    }

    public void addGameObject(GameObject gameObject) {
        gameObjects.add(gameObject);
        if (gameObject instanceof ActionListener) updateActionListeners = true;
    }

    public void setRedraw(boolean redraw) {
        this.redraw = redraw;
    }

    public abstract void setupGameObjects();

}
