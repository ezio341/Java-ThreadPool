/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Praktikum2 {
    public static void main(String[] args){
        ExecutorService executor = Executors.newFixedThreadPool(5);
        try {
            for(int i=0; i<10;i++){
                Tist t = new Tist("GET -> ", new int[]{1,2,3,4,5});
                System.out.println(executor.submit(t).get(1, TimeUnit.SECONDS));
            }
        } catch (InterruptedException | ExecutionException | TimeoutException ex) {
            Logger.getLogger(Praktikum2.class.getName()).log(Level.SEVERE, null, ex);
        }
        executor.shutdown();
    }
}
