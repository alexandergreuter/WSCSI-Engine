package ch.bbbaden.games.Engine.Prefab.Default;

import ch.bbbaden.games.Engine.GameObject;
import ch.bbbaden.games.Engine.Prefab.Components.Collider;
import ch.bbbaden.games.Engine.Prefab.Components.CollisionHandler;

import java.util.ArrayList;

public class DefaultCollisionHandler implements CollisionHandler {
    @Override
    public void checkForCollision(ArrayList<Collider> colliders) {
        for (Collider collider : colliders) {
            GameObject gameObject = (GameObject) collider;
            for (Collider collider1 : colliders) {
                GameObject gameObject1 = (GameObject) collider1;
                if (gameObject != gameObject1 && (gameObject.getX() - gameObject1.getX() >= -1 || gameObject.getX() - gameObject1.getX() <= 1 || gameObject.getY() - gameObject1.getY() >= -1 || gameObject.getY() - gameObject1.getY() <= 1)) {
                    (collider1).onCollision(collider);
                }
            }
        }
    }
}
