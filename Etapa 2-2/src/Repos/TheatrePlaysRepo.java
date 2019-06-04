package Repos;

import Objects.Concerts;
import Objects.TheatrePlays;

import java.io.FileWriter;

import java.io.FileWriter;
import java.util.ArrayList;


import java.io.FileWriter;
import java.util.ArrayList;


public class TheatrePlaysRepo {
    private static int counter = 0;
    private ArrayList<TheatrePlays> theatreplays = new ArrayList<TheatrePlays>();

    public TheatrePlaysRepo() {
        TheatrePlaysRepoCSV theatreplaysRepoCSV = new TheatrePlaysRepoCSV("C:\\Users\\alex_\\Desktop\\Etapa 2-2\\src\\TheatrePlays.csv");
        counter = theatreplaysRepoCSV.getCounter();
        theatreplays = theatreplaysRepoCSV.getTheatrePlays();
    }
    public void TheatrePlaysWriter(String fileName, TheatrePlays ob){
        try{
            FileWriter fw = new FileWriter(fileName,true);
            fw.write(ob.toString() + System.lineSeparator());
            fw.close();}
        catch(Exception e){ System.out.println(e);}
    }

    public void addTheatrePlays() throws Exception{
        TheatrePlays a = new TheatrePlays();
        counter++;
        a.AddTheatrePlays(counter);
        theatreplays.add(a);
    }

    public void printAllTheatrePlays(){
        for(int i = 0 ; i < theatreplays.size(); i++)
            theatreplays.get(i).PrintTheatrePlays();
    }

    public ArrayList<TheatrePlays> getTheatrePlays() {
        return theatreplays;
    }
}