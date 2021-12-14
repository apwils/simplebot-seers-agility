package seersAgility.tasks;

import net.runelite.api.coords.WorldPoint;
import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleGroundItem;
import simple.robot.api.ClientContext;

public class Mog extends Task {


    public Mog(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() {
        System.out.print("check mog");

        return !ctx.groundItems.populate().filter(11849).filterWithin(7).isEmpty();
    }

    @Override
    public void run() {
        System.out.print("Getting MOG");
        final SimpleGroundItem mog = ctx.groundItems.populate().filter(11849).nearest().next();
        final WorldPoint tile = mog.getLocation();
        ctx.pathing.clickSceneTile(tile, false, false);

    }

    @Override
    public String status() {
        return "Picking up MOG.";
    }
}
