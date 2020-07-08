import java.util.Timer;
import java.util.TimerTask;

public class ScheduleTask extends TimerTask {

    public void run() {
        executeAtevery5sec();
    }

    public void executeAtevery5sec() {
        System.out.println(System.currentTimeMillis());
    }

    public void testfu() {
        Timer timer = new Timer();
        TimerTask task = new ScheduleTask();

        timer.schedule(task, 2000, 5000);  // 2000 - delay (can set to 0 for imme
    }
}






