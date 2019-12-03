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
        listOfYears = getYear();
        listOfYears = addMonthAndRate(listOfYears);
        System.out.println(listOfYears);
    }

    public static Map getYear() throws IOException {
        File file = new File("/home/misi/Downloads/euro.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int counter = 0;
        Map<Integer, HashMap> listOfYears = new HashMap<>();
        while ((st = br.readLine()) != null) {
            if (counter > 0) {
                String[] year = st.split(" ", 3);
                listOfYears.put(Integer.parseInt(year[0]), new HashMap());
            }
            counter++;
        }
        return listOfYears;
    }

    public static Map addMonthAndRate(Map listOfYears) throws IOException {
        File file = new File("/home/misi/Downloads/euro.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int counter = 0;
        HashMap<Integer, Integer> innerMap = new HashMap<>();
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