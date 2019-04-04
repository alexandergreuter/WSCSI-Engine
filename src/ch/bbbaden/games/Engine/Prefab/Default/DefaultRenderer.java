package ch.bbbaden.games.Engine.Prefab.Default;

import ch.bbbaden.games.Engine.GameObject;
import ch.bbbaden.games.Engine.Prefab.Components.Renderer;
import ch.bbbaden.games.Engine.Scene;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

public class DefaultRenderer implements Renderer {
    @Override
    public void render(Scene scene, WSwingConsoleInterface csi) {
        csi.cls();
        for (GameObject gameObject : scene.getGameObjects()) {
            if (gameObject.getX() >= 0 && gameObject.getX() <= WSwingConsoleInterface.getXdim() && gameObject.getY() >= 0 && gameObject.getX() <= WSwingConsoleInterface.getYdim()) {
                csi.print(gameObject.getX(), gameObject.getY(), gameObject.getIcon());
            }
        }
        csi.refresh();
    }
}
