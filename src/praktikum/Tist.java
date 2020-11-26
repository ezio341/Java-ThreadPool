/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum;

import java.util.concurrent.Callable;

/**
 *
 * @author ASUS
 */
 public class Tist implements Callable<String> {
     private int [] arr;
     private String name;

     public Tist(String name, int [] arr) {
         this.arr = arr;
         this.name = name;
     }

     @Override
     public String call() throws Exception {
         int total = 0;
         for(int i=0 ; i<arr.length ; i++){
             total += arr[i];
         }
         return name + total;
     }
 }
