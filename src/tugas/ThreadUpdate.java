/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class ThreadUpdate extends Thread{
    UIThreadPool view;

    public ThreadUpdate(UIThreadPool view) {
        this.view = view;
    }
    
    @Override
    public void run(){
        //thread pool for update clock
        ExecutorService clockexecutor = Executors.newFixedThreadPool(10);
        //thread pool for sowing message
        ScheduledExecutorService messageexecutor = Executors.newSingleThreadScheduledExecutor();
        int i=0;
        while(i<5){
            try {
                MessageGen clock = clockexecutor.submit(new AssignMessage()).get();
                //update message every 1 second
                MessageGen message = messageexecutor.schedule(new AssignMessage(), 1, TimeUnit.SECONDS).get();
                view.getDate().setText(clock.getDate());
                view.getTime().setText(clock.getTime());
                view.getTextpane().setText(view.getTextpane().getText()+"\n"+message.getTime()
                        +" -> "+message.getMessage());
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(ThreadUpdate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
