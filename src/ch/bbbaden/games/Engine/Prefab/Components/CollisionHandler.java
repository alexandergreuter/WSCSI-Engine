package ch.bbbaden.games.Engine.Prefab.Components;

import ch.bbbaden.games.Engine.GameObject;

import java.util.ArrayList;

public interface CollisionHandler {
    void checkForCollision(ArrayList<Collider> colliders);
}
