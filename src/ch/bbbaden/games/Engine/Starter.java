/*
 */
package ch.bbbaden.games.Engine;

import ch.bbbaden.games.Engine.GameLoop;

/**
 *
 * @author Michael Schneider (michael.schneider@bbbaden.ch)
 */
public class Starter {

    public static GameLoop loop;
    
    public static void main(String[] args) {
       loop = new GameLoop();
       loop.run();
    }
}
