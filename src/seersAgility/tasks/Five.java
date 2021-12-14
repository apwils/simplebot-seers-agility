package seersAgility.tasks;

import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;

public class Five extends Task {

    public Five(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() {

        return ctx.players.getLocal().getLocation().distanceTo(ctx.objects.populate().filter(14931).nearest().next().getLocation()) < 14;
    }

    @Override
    public void run() {
        System.out.print("stage 4");

        final SimpleObject gap = (SimpleObject) ctx.objects.populate().filter(14931).nearest().next();
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
