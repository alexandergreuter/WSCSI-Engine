package ch.bbbaden.games.Engine.Prefab.Components;

import ch.bbbaden.games.Engine.GameObject;

public interface Collider {
    void onCollision(Collider collider);
}
