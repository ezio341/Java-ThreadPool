/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
 public class Task implements Runnable {

     private String nama;

     public Task(String nama) {
         this.nama = nama;
     }

     @Override
     public void run() {
         for (int i = 0; i < 10; i++) {
             System.out.println("" + nama + " result: " + i);
             Long delay = (long) (Math.random() * 10);
             try {
                 TimeUnit.SECONDS.sleep(delay);
             } catch (InterruptedException ex) {
                 Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
     }

 }
