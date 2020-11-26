/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

/**
 *
 * @author ASUS
 */
public class AssignMessage implements Callable<MessageGen>{
    private MessageGen m;

    @Override
    public MessageGen call() throws Exception {
        SimpleDateFormat dateformat = new SimpleDateFormat("EE, dd MMMM yyyy");
        SimpleDateFormat timeformat = new SimpleDateFormat("hh:mm:ss a");
        m = new MessageGen(timeformat.format(new Date()), dateformat.format(new Date()), getRandMessage());
        return m;
    }
    
    public HashMap<Integer, Character> getcharmap(){
        String ch = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        HashMap<Integer, Character> map = new HashMap<>();
        List<Character> arrc = new ArrayList<>();
        //put into the list
        for(char a : ch.toCharArray()){
            arrc.add(a);
        }
        //put into the map
        for(int i=0 ; i<arrc.size() ; i++){
            map.put(i, arrc.get(i));
        }
        return map;
    }
    
    public String getRandMessage(){
        HashMap<Integer, Character> map = getcharmap();
        String message = "";
        //randomize character
        Random randChar = new Random();
        //randomize message length
        Random randLength = new Random();
        for(int i = 0; i<randLength.nextInt(10)+6;i++){
            message+=map.get(randChar.nextInt(52));
        }
        return message;
    }
}
