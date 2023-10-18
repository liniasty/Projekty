package com.example.helloworld;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Kalkulator {
    public static ArrayList<String> list = new ArrayList<String>();
    public static String wyswietl(){
        StringBuilder builder = new StringBuilder();
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            builder.append(iterator.next());
        }
        String text=builder.toString();
        if(text.equals("")){
            return"0";
        }
        return text;
    }
    public static String przelicz(ArrayList<String> list) {
        StringBuilder builder = new StringBuilder();
        for (String element : list) {
            builder.append(element);
        }
        String wynik = builder.toString();
        Float bufor = 0f;
        String[] split = wynik.split(" ");

        for (int i = 0; i < split.length; i++) {
            if (i != 0 && i != split.length - 1) {
                if (split[i].equals("+")) {
                    bufor = Float.parseFloat(split[i - 1]) + Float.parseFloat(split[i + 1]);
                    split[i + 1] = String.valueOf(bufor);
                } else if (split[i].equals("-")) {
                    bufor = Float.parseFloat(split[i - 1]) - Float.parseFloat(split[i + 1]);
                    split[i + 1] = String.valueOf(bufor);
                } else if (split[i].equals("*")) {
                    bufor = Float.parseFloat(split[i - 1]) * Float.parseFloat(split[i + 1]);
                    split[i + 1] = String.valueOf(bufor);
                } else if (split[i].equals("/")) {
                    if (split[i + 1].equals("0")) {
                        return "ERROR";
                    }
                    bufor = Float.parseFloat(split[i - 1]) / Float.parseFloat(split[i + 1]);
                    split[i + 1] = String.valueOf(bufor);
                }
            }
        }
        Kalkulator.list.clear();

        return String.valueOf(bufor);
    }
}
