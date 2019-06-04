package Repos;

import Objects.Concerts;
import Objects.TheatrePlays;
import Objects.Venue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

//import default.Objects.Concerts.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class TheatrePlaysRepoCSV  {
    private ArrayList<TheatrePlays> theatreplays = new ArrayList<TheatrePlays>();
    private static int counter = 0;
    public TheatrePlaysRepoCSV(String fileName) {
        try {
            File file = new File(fileName);
            FileInputStream fileInputStream = new FileInputStream(file);
            Scanner scanner = new Scanner(fileInputStream);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");

                try {
                    theatreplays.add(new TheatrePlays(values[0], values[1], new Integer(values[2]), values[3], values[4], values[5], values[6], values[7], values[8], new Venue(values[9], new Integer(values[10]), new Boolean(values[11]), new Boolean(values[12]))));
                    counter = new Integer(values[2]);
                } catch (Exception ex) {System.out.println("Cound not create : "+ex.getMessage()); }
            }
        } catch (FileNotFoundException exe) {
            System.out.println("Cound not create : "+exe.getMessage());
        }
    }

    public int getCounter() {
        return counter;
    }

    public ArrayList<TheatrePlays> getTheatrePlays() {
        return theatreplays;
    }
}