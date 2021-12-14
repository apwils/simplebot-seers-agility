package seersAgility.tasks;

import net.runelite.api.coords.WorldPoint;
import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;
import simple.robot.utils.WorldArea;

public class One extends Task {

    public One(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() {

        return ctx.players.getLocal().getLocation().distanceTo(ctx.objects.populate().filter(14928).nearest().next().getLocation()) < 14;

    }

    @Override
    public void run() {
        System.out.print("stage 1");

        final SimpleObject gap = (SimpleObject) ctx.objects.populate().filter(14928).nearest().next();
        gap.turnTo();
        if(gap.click(0)){
//            ctx.sleep(3000);
        }
    }

    @Override
    public String status() {
        return "Completing course.";
    }
}
