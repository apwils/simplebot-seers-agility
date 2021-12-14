package seersAgility.tasks;

import net.runelite.api.coords.WorldPoint;
import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleGroundItem;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;
import simple.robot.utils.WorldArea;

public class Two extends Task {

    public Two(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() {

        return !ctx.objects.populate().filter(14932).filterWithin(8).isEmpty();
    }

    @Override
    public void run() {
        System.out.print("stage 2");
        ctx.viewport.angle(120);

        final SimpleObject gap = (SimpleObject) ctx.objects.populate().filter(14932).nearest().next();
        final WorldPoint tile = gap.getLocation();
        ctx.pathing.clickSceneTile(tile, false, false);
//        ctx.sleep(4000);
    }

    @Override
    public String status() {
        return "Completing course.";
    }
}
