package net.dohaw.firstgame.runnable;

import java.util.Timer;
import java.util.TimerTask;

public abstract class BaseRunnable extends TimerTask {

    private Timer timer;

    public BaseRunnable(){
        this.timer = new Timer();
    }

    public void scheduleRepeatedTask(int delay, int interval){
        timer.scheduleAtFixedRate(this, delay * 1000, interval * 1000);
    }

    public void scheduleLaterTask(int delay){
        timer.schedule(this, delay * 1000);
    }

    public void stopTask(){
        timer.cancel();
    }

}
