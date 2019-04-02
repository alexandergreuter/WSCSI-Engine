package ch.bbbaden.games.Scenes.Scene2;

import ch.bbbaden.games.Engine.Scene;
import ch.bbbaden.games.GameObjects.Components.UpdateComponents.MoveComponent.Direction;
import ch.bbbaden.games.GameObjects.DynamicGameObjects.Medikit;
import ch.bbbaden.games.GameObjects.DynamicGameObjects.Trap;
import ch.bbbaden.games.GameObjects.DynamicGameObjects.Zombie;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

public class Scene2 extends Scene {

    public Scene2(WSwingConsoleInterface csi) {
        super(csi);
    }

    public void setupGameBoard(WSwingConsoleInterface csi) {
        csi.cls();
        csi.print(2, 2, "#####################");
        csi.print(2, 3, "#     ####          #");
        csi.print(2, 4, "#                   #");
        csi.print(2, 5, "#########           #");
        csi.print(2, 6, "#               #####");
        csi.print(2, 7, "     #              #");
        csi.print(2, 8, "#        ############");
        csi.print(2, 9, "## ####   ###########");
        csi.print(2, 10, "#  #####           #");
        csi.print(2, 11, "## #############   #");
        csi.print(2, 12, "##       ###     ###");
        csi.print(2, 13, "#######  ### #######");
        csi.print(2, 14, "#     #  ###     ###");
        csi.print(2, 15, "# #####  ###########");
        csi.print(2, 16, "#        ###########");
        csi.print(2, 17, "####################");
        csi.saveBuffer();
        csi.refresh();
    }

    public void setupGameObjects() {
        //super.dynamicGameObjects.add(DynamicGameObject);
        super.dynamicGameObjects.add(new Trap(7, 3, CSIColor.ATOMIC_TANGERINE));
        super.dynamicGameObjects.add(new Medikit(7, 6, CSIColor.ATOMIC_TANGERINE));
        super.dynamicGameObjects.add(new Zombie(3, 3, CSIColor.RED, Direction.RIGHT));
        super.dynamicGameObjects.add(new Zombie(3, 4, CSIColor.RED, Direction.RIGHT));
    }
}
