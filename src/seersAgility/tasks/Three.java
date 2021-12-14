package seersAgility.tasks;

import net.runelite.api.coords.WorldPoint;
import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;
import simple.robot.utils.WorldArea;

public class Three extends Task {

    public Three(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() {

        return ctx.players.getLocal().getLocation().distanceTo(ctx.objects.populate().filter(14929).nearest().next().getLocation()) < 10;
    }

    @Override
    public void run() {
        System.out.print("stage 3");

        final SimpleObject gap = (SimpleObject) ctx.objects.populate().filter(14929).nearest().next();
        gap.turnTo();
        if(gap.click(0)){
//            ctx.sleep(2000);
        }
    }

    @Override
    public String status() {
        return "Completing course.";
    }
}
