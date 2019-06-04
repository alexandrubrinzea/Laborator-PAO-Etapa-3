package Repos;

import Objects.CinemaIMAX;
import Objects.Concerts;

import java.io.FileWriter;

import java.io.FileWriter;
import java.util.ArrayList;


import java.io.FileWriter;
import java.util.ArrayList;


public class CinemaIMAXRepo {
    private static int counter = 0;
    private ArrayList<CinemaIMAX> cinemaimax = new ArrayList<CinemaIMAX>();

    public CinemaIMAXRepo() {
        CinemaIMAXRepoCSV cinemaimaxRepoCSV = new CinemaIMAXRepoCSV("C:\\Users\\alex_\\Desktop\\Etapa 2-2\\src\\CinemaIMAX.csv");
        counter = cinemaimaxRepoCSV.getCounter();
        cinemaimax = cinemaimaxRepoCSV.getCinemaIMAX();
    }
    public void CinemaIMAXWriter(String fileName, Concerts ob){
        try{
            FileWriter fw = new FileWriter(fileName,true);
            fw.write(ob.toString() + System.lineSeparator());
            fw.close();}
        catch(Exception e){ System.out.println(e);}
    }

    public void addCinemaIMAX() throws Exception{
        CinemaIMAX a = new CinemaIMAX();
        counter++;
        a.AddCinemaIMAX(counter);
        cinemaimax.add(a);
    }

    public void printAllIMAXRepo(){
        for(int i = 0 ; i < cinemaimax.size(); i++)
            cinemaimax.get(i).PrintCinemaIMAX();
    }

    public ArrayList<CinemaIMAX> getCinemaIMAX() {
        return cinemaimax;
    }
}