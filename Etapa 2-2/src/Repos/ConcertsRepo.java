package Repos;

import Objects.Concerts;

import java.io.FileWriter;

import java.io.FileWriter;
import java.util.ArrayList;


import java.io.FileWriter;
import java.util.ArrayList;


public class ConcertsRepo {
    private static int counter = 0;
    private ArrayList<Concerts> concerts = new ArrayList<Concerts>();

    public ConcertsRepo() {
        ConcertsRepoCSV concertsRepoCSV = new ConcertsRepoCSV("C:\\Users\\alex_\\Desktop\\Etapa 2-2\\src\\Concerte.csv");
        counter = concertsRepoCSV.getCounter();
        concerts = concertsRepoCSV.getConcerts();
    }
    public void ConcertsWriter(String fileName, Concerts ob){
        try{
            FileWriter fw = new FileWriter(fileName,true);
            fw.write(ob.toString() + System.lineSeparator());
            fw.close();}
        catch(Exception e){ System.out.println(e);}
    }

    public void addConcert() throws Exception{
        Concerts a = new Concerts();
        counter++;
        a.AddConcert(counter);
        concerts.add(a);
    }

    public void printAllConcerts(){
        for(int i = 0 ; i < concerts.size(); i++)
            concerts.get(i).PrintConcerts();
    }

    public ArrayList<Concerts> getConcerts() {
        return concerts;
    }
}