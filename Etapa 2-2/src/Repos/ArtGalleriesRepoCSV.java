package Repos;

import Objects.ArtGalleries;
import Objects.Concerts;
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


public class ArtGalleriesRepoCSV  {
    private ArrayList<ArtGalleries> artgalleries = new ArrayList<ArtGalleries>();
    private static int counter = 0;
    public ArtGalleriesRepoCSV(String fileName) {
        try {
            File file = new File(fileName);
            FileInputStream fileInputStream = new FileInputStream(file);
            Scanner scanner = new Scanner(fileInputStream);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");

                try {
                    artgalleries.add(new ArtGalleries(values[0], values[1], new Integer(values[2]), values[3], values[4], values[5], values[6], new Venue(values[7], new Integer(values[8]), new Boolean(values[9]), new Boolean(values[10]))));
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

    public ArrayList<ArtGalleries> getArtGalleries() {
        return artgalleries;
    }
}