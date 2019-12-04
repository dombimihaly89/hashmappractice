package hu.flowacademy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Map<Integer, HashMap> listOfYears = new HashMap<>();
        listOfYears = addMonthAndRate(); // ezzel a metódussal rakjuk bele a fájl tartalmát egy HashMap-be.
        makeList(listOfYears); // kiíratjuk a HashMap tartalmát szépen.
        System.out.println();
        System.out.println("Legnagyobb euro: " + maxEuroReturner(listOfYears)); // legnagyobb eurót íratjuk ki.
        System.out.println();
        averageExchangeRate(listOfYears); //átlag árfolyamot íratjuk ki.

    }

    public static void makeList(Map<Integer, HashMap> listOfYears) {
        for (Map.Entry<Integer, HashMap> entry : listOfYears.entrySet()) {
            HashMap<Integer, Integer> innerMap = entry.getValue();
            for(Map.Entry<Integer, Integer> innerEntry : innerMap.entrySet()) {
                System.out.println(entry.getKey() + ". " + monthReturner(innerEntry.getKey()) + ": " + forintReturner(innerEntry.getValue()) + " forint " +
                        fillerReturner(innerEntry.getValue()) + " fillér.");
            }
        }
    }

    public static Map addMonthAndRate() throws IOException {
        File file = new File("/home/misi/Downloads/euro.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int counter = 0;
        HashMap<Integer, Integer> innerMap = new HashMap<>();
        Map<Integer, HashMap> listOfYears = new HashMap<>();
        while ((st = br.readLine()) != null) {
            if (counter > 0) {
                String[] year = st.split(" ", 3);
                if (Integer.parseInt(year[1]) == 1) innerMap = new HashMap<>();
                innerMap.put(Integer.parseInt(year[1]), Integer.parseInt(year[2]));
                listOfYears.put(Integer.parseInt(year[0]), innerMap);
            }
            counter++;
        }
        return listOfYears;
    }

    public static String monthReturner (int number) {
        if (number == 1) return "január";
        if (number == 2) return "február";
        if (number == 3) return "március";
        if (number == 4) return "április";
        if (number == 5) return "május";
        if (number == 6) return "június";
        if (number == 7) return "július";
        if (number == 8) return "augusztus";
        if (number == 9) return "szeptember";
        if (number == 10) return "október";
        if (number == 11) return "november";
        if (number == 12) return "december";
        else return " ";
    }

    public static int forintReturner (int number) {
        return number / 100;
    }

    public static int fillerReturner (int number) {
        return number % 100;
    }

    public static String maxEuroReturner (Map<Integer, HashMap> listOfYears) {
        int max = 0;
        for (Map.Entry<Integer, HashMap> entry : listOfYears.entrySet()) {
            HashMap<Integer, Integer> innerMap = entry.getValue();
            for(Map.Entry<Integer, Integer> innerEntry : innerMap.entrySet()) {
                if(innerEntry.getValue() > max) max = innerEntry.getValue();
            }
        }
        return forintReturner(max) + " forint " + fillerReturner(max) + " fillér.";
    }

    public static void averageExchangeRate(Map<Integer, HashMap> listOfYears) {
        for (Map.Entry<Integer, HashMap> entry : listOfYears.entrySet()) {
            HashMap<Integer, Integer> innerMap = entry.getValue();
            int sum = 0;
            for(Map.Entry<Integer, Integer> innerEntry : innerMap.entrySet()) {
                sum += innerEntry.getValue();
            }
            if (entry.getKey() == 2009) System.out.println(entry.getKey() + "-ben " + forintReturner((sum / 11)) + " forint " + forintReturner((sum / 11)) + "fillér volt az átlagárfolyam.");
            else System.out.println(entry.getKey() + "-ben " + forintReturner((sum / 12)) + " forint " + forintReturner((sum / 12)) + "fillér volt az átlagárfolyam.");
        }
    }
}


    /*File file = new File("/home/misi/Downloads/euro.txt");
    BufferedReader br = new BufferedReader(new FileReader(file));
    String st;
    int counter = 0;
    HashMap<Integer, Integer> innerMap = new HashMap<>();
        while ((st = br.readLine()) != null) {
                if (counter > 0) {
                String[] year = st.split(" ", 3);
                if (Integer.parseInt(year[1]) == 1) innerMap.clear();
                innerMap.put(Integer.parseInt(year[1]), Integer.parseInt(year[2]));
                listOfYears.put(Integer.parseInt(year[0]), innerMap);
                }
                counter++;
                }
                return listOfYears;*/