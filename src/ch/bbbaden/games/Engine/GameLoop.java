/*
 */
package ch.bbbaden.games.Engine;

/**
 * @author Michael Schneider (michael.schneider@bbbaden.ch) / edited by Alexander Greuter
 */
public class GameLoop {

    private final int TARGET_FPS = 15;
    private ScenesManager scenesManager;
    private boolean exit = false;

    public void run() {
        scenesManager = new ScenesManager();
        loop();
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    private void loop() {
        long lastLoop;
        while (!exit) {
            lastLoop = System.currentTimeMillis();
            scenesManager.update();
            try {
                Thread.sleep((System.currentTimeMillis() - lastLoop + 1) * (TARGET_FPS / 1000));
            } catch (Exception e) {
            }
        }
    }
}
