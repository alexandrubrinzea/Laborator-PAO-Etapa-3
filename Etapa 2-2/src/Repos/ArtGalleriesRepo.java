package Repos;

import Objects.ArtGalleries;
import Objects.Concerts;
import java.io.FileWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.FileWriter;
import java.util.ArrayList;

public class ArtGalleriesRepo {
    private static int counter = 0;
    private ArrayList<ArtGalleries> artgalleries = new ArrayList<ArtGalleries>();

    public ArtGalleriesRepo() {
        ArtGalleriesRepoCSV artgalleriesRepoCSV = new ArtGalleriesRepoCSV("C:\\Users\\alex_\\Desktop\\Etapa 2-2\\src\\ArtGalleries.csv");
        counter = artgalleriesRepoCSV.getCounter();
        artgalleries = artgalleriesRepoCSV.getArtGalleries();
    }
    public void ArtGalleriesWriter(String fileName, ArtGalleries ob){
        try{
            FileWriter fw = new FileWriter(fileName,true);
            fw.write(ob.toString() + System.lineSeparator());
            fw.close();}
        catch(Exception e){ System.out.println(e);}
    }

    public void addArtGalleries() throws Exception{
        ArtGalleries a = new ArtGalleries();
        counter++;
        a.AddArtGalleries(counter);
        artgalleries.add(a);
    }

    public void printAllArtGalleries(){
        for(int i = 0 ; i < artgalleries.size(); i++)
            artgalleries.get(i).PrintArtGalleries();
    }

    public ArrayList<ArtGalleries> getArtGalleries() {
        return artgalleries;
    }
}