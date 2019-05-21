/*
 */
package ch.bbbaden.games;

import java.util.logging.Logger;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.wswing.KeyEventListener;
import net.slashie.libjcsi.wswing.MouseEventListener;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

/**
 *
 * @author Michael Schneider (michael.schneider@bbbaden.ch)
 */
public class LibBasicsGameLoop implements KeyEventListener, MouseEventListener {

    final int TARGET_FPS = 60;
    final long OPTIMAL_TIME = 1000 / TARGET_FPS;

    private final WSwingConsoleInterface csi;
    private int playerX, playerY;
    private boolean exit = false;

    private int lastKeyPressed;
    private int lastMouseClickLeftX;
    private int lastMouseClickLeftY;
    private int lastMouseClickRightX;
    private int lastMouseClickRightY;

    private boolean redraw;

    public LibBasicsGameLoop() {
        csi = new WSwingConsoleInterface("Basic Game - Game Loop Edition");
        System.out.println("X-Dimension: " + csi.getXdim());
        System.out.println("Y-Dimension: " + csi.getYdim());
    }

    public void run() {
        csi.addKeyEventListener(this);
        csi.addMouseEventListener(this);
        clearAllInputs();

        // Draw basic board
        setupGameBoard();

        // The main Game loop
        boolean exit = false;
        redraw = true;
        long lastLoopTime = System.currentTimeMillis();
        while (!exit) {
            // Calculate how long we slept
            long now = System.currentTimeMillis();
            long delta = now - lastLoopTime;
            lastLoopTime = now;

            // Update the game logic
            doGameUpdates(delta);

            // Draw everyting
            if (redraw) {
                render();
                redraw = false;
            }

            // Sleep
            try {
                Thread.sleep(OPTIMAL_TIME - (System.currentTimeMillis() - lastLoopTime));
            } catch (InterruptedException ex) {
                // We are OK with that
            }

        }
        csi.print(1, 20, "Press space to exit");
        csi.refresh();
        csi.waitKey(CharKey.SPACE);

        System.exit(0);
    }

    private void setupGameBoard() {
        csi.cls();
        csi.print(5, 5, "Welcome to TEH game!", CSIColor.BABY_BLUE);
        csi.saveBuffer();
        csi.refresh();
    }

    // Game actions
    private void doGameUpdates(long delta) {
        int playerNextX = playerX;
        int playerNextY = playerY;

        if (lastKeyPressed != -1) {
            switch (lastKeyPressed) {
                case CharKey.UARROW:
                    playerNextY = playerY - 1;
                    break;
                case CharKey.DARROW:
                    playerNextY = playerY + 1;
                    break;
                case CharKey.LARROW:
                    playerNextX = playerX - 1;
                    break;
                case CharKey.RARROW:
                    playerNextX = playerX + 1;
                    break;
                case CharKey.Q:
                case CharKey.q:
                    exit = true;
                    break;
                default: //No Key Pressed
            }

            playerX = playerNextX;
            playerY = playerNextY;
            redraw = true;
        }

        clearAllInputs();
    }

    // Draw everything
    private void render() {
        csi.restore();
        csi.print(playerX, playerY, "@", CSIColor.ATOMIC_TANGERINE);
        csi.refresh();
    }

    private void clearAllInputs() {
        lastKeyPressed = -1;
        lastMouseClickLeftX = -1;
        lastMouseClickLeftY = -1;
        lastMouseClickRightX = -1;
        lastMouseClickRightY = -1;
    }

    @Override
    public void keyPressed(int key) {
        lastKeyPressed = key;
    }

    @Override
    public void leftMouseButtonClicked(int x, int y) {
        lastMouseClickLeftX = x;
        lastMouseClickLeftY = y;
    }

    @Override
    public void rightMouseButtonClicked(int x, int y) {
        lastMouseClickRightX = x;
        lastMouseClickRightY = y;
    }

}
