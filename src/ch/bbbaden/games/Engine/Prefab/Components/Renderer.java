package ch.bbbaden.games.Engine.Prefab.Components;

import ch.bbbaden.games.Engine.Scene;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

public interface Renderer {
    void render(Scene scene, WSwingConsoleInterface csi);
}
