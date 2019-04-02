/*
 */
package ch.bbbaden.games.Engine;

import java.util.ArrayList;
import java.util.List;

import ch.bbbaden.games.GameObjects.DynamicGameObjects.Player;
import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

/**
 * @author Michael Schneider (michael.schneider@bbbaden.ch) / edited by Alexander Greuter
 */
public class GameLoop {

    final int TARGET_FPS = -1;
    final long OPTIMAL_TIME = 1000 / TARGET_FPS;

    private final WSwingConsoleInterface csi;

    private Player player;
    private ArrayList<DynamicGameObject> dynamicGameObjects;

    ScenesManager scenesManager;

    private boolean redraw;
    private boolean gameOver = false;

    public GameLoop() {
        csi = new WSwingConsoleInterface("Basic Game - Game Loop Edition");
        System.out.println("X-Dimension: " + csi.getXdim());
        System.out.println("Y-Dimension: " + csi.getYdim());
    }

    public Player getPlayer() {
        return player;
    }

    public void run() {

         scenesManager = new ScenesManager(csi);

        //starting game Loop
        loop();

        if (gameOver) {
            showGameOverScreen();

            csi.waitKey(CharKey.SPACE);
            run();
        } else {
            csi.print(1, 20, "Press space to exit");
            csi.refresh();

            csi.waitKey(CharKey.SPACE);
            System.exit(0);
        }
    }

    private void loop() {
        // The main Game loop
        boolean exit = false;
        gameOver = false;
        redraw = true;

        long lastLoopTime = System.currentTimeMillis();

        while (!exit && !gameOver) {

            // Draw everything
            if (redraw) {
                player.render(csi, dynamicGameObjects);
                redraw = false;
            }

            //checking if we have to exit
            exit = player.isExit();
        }
    }

    private void showStartMenu() {
        csi.cls();
        csi.print(2, 2, "Welcome press Space to start");
        csi.refresh();
        csi.waitKey(CharKey.SPACE);
    }

    private void showGameOverScreen() {
        csi.cls();
        csi.print(35, 2, "GAME OVER!");
        csi.print(29, 4, "Press space to play again");
    }

    private void setupGameBoard() {

    }

    private void setupGameObjects() {

    }

    // Game actions
    private void doGameUpdates() {
        List<DynamicGameObject> dynamicGameObjectsToRemove = new ArrayList<>();
        for (DynamicGameObject dynamicGameObject : dynamicGameObjects) {
            if (dynamicGameObject.doRender()) {
                if (dynamicGameObject.equals(player)) {
                    gameOver = true;
                } else {
                    dynamicGameObjectsToRemove.add(dynamicGameObject);
                }
            } else {
                dynamicGameObject.update(csi, dynamicGameObjects);
            }
        }
        dynamicGameObjects.removeAll(dynamicGameObjectsToRemove);
        redraw = true;
    }
}
