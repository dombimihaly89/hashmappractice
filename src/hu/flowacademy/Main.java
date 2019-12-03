package hu.flowacademy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /*String line1 = Files.readAllLines(Paths.get("/home/misi/Downloads/euro.txt")).get(1);
        line1 = line1.substring(0, 4);
        List<Integer> years = new ArrayList<>(); 
        years.add(Integer.parseInt(line1));*/

        Map<Integer, HashMap> listOfYears = new HashMap<>();
        listOfYears = addMonthAndRate();
        System.out.println(listOfYears);

        for (Map.Entry<Integer, HashMap> entry : listOfYears.entrySet()) {
            //System.out.print(entry.getKey() + ". ");
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