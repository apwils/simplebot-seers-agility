package seersAgility.tasks;

import net.runelite.api.Point;
import net.runelite.api.coords.WorldPoint;
import simple.hooks.scripts.task.Task;
import simple.hooks.simplebot.Game;
import simple.hooks.simplebot.teleporter.Teleporter;
import simple.hooks.wrappers.SimpleLocalPlayer;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;

public class Start extends Task {

    private static WorldPoint startPoint = new WorldPoint(2730, 3488, 0);

    public Start(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() {
        final SimpleLocalPlayer player = (SimpleLocalPlayer) ctx.players.getLocal();
        return (
                player.getLocation().getPlane() == 0
        );
    }

    @Override
    public void run() {

        ctx.game.tab(Game.Tab.MAGIC);
        ctx.sleep(300);
        ctx.mouse.click(565, 220, false);
        ctx.sleep(300);
        ctx.mouse.click(565, 275, true);
        ctx.sleep(1000);

        ctx.viewport.pitch(40);
        ctx.viewport.angle(-40);
        ctx.game.tab(Game.Tab.INVENTORY);
        ctx.sleep(1000);
        final SimpleObject wall = (SimpleObject) ctx.objects.populate().filter(25899).filter(new WorldPoint(2729,3489, 0)).nearest().next();

        if(wall.click(0)){
            ctx.sleep(3000);
        }
    }

    @Override
    public String status() {
        return "Teleporting to course.";
    }
}
