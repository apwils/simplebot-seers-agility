package seersAgility;

import seersAgility.tasks.*;
import simple.hooks.scripts.Category;
import simple.hooks.scripts.ScriptManifest;
import simple.hooks.scripts.task.Task;
import simple.hooks.scripts.task.TaskScript;
import simple.hooks.simplebot.ChatMessage;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ScriptManifest(author = "Apwils", name = "Apwils | Seers Agility", category = Category.AGILITY, version = "1.0",
        description = "Start at anywhere.", discord = "Andrew w#0376", servers = { "Zaros" })

public class SeersAgility extends TaskScript {
    private List tasks = new ArrayList();


    private int laps;
    private String status;
    private long startTime;

    @Override
    public boolean prioritizeTasks() {
        return true;
    }

    @Override
    public List<Task> tasks() {
        return tasks;
    }

    @Override
    public void onProcess() {
        super.onProcess();
        status  =  getScriptStatus();
    }

    @Override
    public void onExecute() {
        startTime = System.currentTimeMillis();
        tasks.addAll(Arrays.asList(
                new Mog(ctx),
                new Five(ctx),
                new Four(ctx),
                new Three(ctx),
                new Two(ctx),
                new One(ctx),
                new Start(ctx)
        ));
    }

    @Override
    public void onTerminate() {

    }

    @Override
    public void onChatMessage(ChatMessage chatMessage) {

    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(5, 2, 192, 72);

        g.setColor(Color.decode("#303030"));
        g.drawRect(5, 2, 192, 72);

        g.setColor(Color.decode("#4d4d4d"));
        g.drawLine(8, 24, 194, 24);

        g.setColor(Color.decode("#3150ad"));
        g.drawString("v. " + "1.0", 160, 20);

        g.setColor(Color.decode("#787878"));
        g.drawString("Apwils | Seers Rooftop", 12, 20);
        g.drawString("Time: " + ctx.paint.formatTime(System.currentTimeMillis() - startTime), 14, 42);
        g.drawString("Status: " + status, 14, 56);
//        g.drawString("Laps: " + laps + " (" + ctx.paint.valuePerHour(laps, startTime) + ")", 14, 70);


    }
}
