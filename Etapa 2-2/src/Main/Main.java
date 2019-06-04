package Main;

import Objects.ArtGalleries;
import Objects.Concerts;
import Objects.Events;
import Objects.Venue;
import Repos.ArtGalleriesRepo;
import Repos.CinemaIMAXRepo;
import Repos.ConcertsRepo;
import Repos.TheatrePlaysRepo;
import Services.Services;
import Services.DisplayConcertsDB;
import Services.DBSetup;

import java.io.FileWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static Services.ConnectionShop.*;
import static Services.ConnectionShop.PASS;

public class Main extends Application{
    static String URL = "jdbc:h2:tcp://localhost/~/test";
    static String USER = "sa";
    static String PASS = "";
    static String DRIVER_NAME = "org.h2.Driver";

    public static Connection getConnection() throws Exception{
        try {
            Class.forName(DRIVER_NAME);
            Connection con =  DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connected");
            return con;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }



    public static void createTable() throws Exception{
        try{
            Connection con = getConnection();
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS cinema(id int NOT NULL AUTO_INCREMENT, nume_event varchar(255), artist varchar(255), PRIMARY KEY(id))");
            create.executeUpdate();
        }catch (Exception e){System.out.println(e);}
        finally {
            System.out.println("Function complete");
        }
    }


    public static void insertIntoTable(String var1, String var2) throws Exception{
        try{
            Connection con = getConnection();
            PreparedStatement inserted = con.prepareStatement("INSERT INTO concerte2(artist, nume_event) values ('"+var1+"', '"+var2+"')");
            inserted.executeUpdate();
        } catch(Exception e){System.out.println(e);}
        finally {
            System.out.println("Insert Completed.");
        }
    }

    public static void insertIntoTableCinema(String var1, String var2) throws Exception{
        try{
            Connection con = getConnection();
            PreparedStatement inserted = con.prepareStatement("INSERT INTO cinema(artist, nume_event) values ('"+var1+"', '"+var2+"')");
            inserted.executeUpdate();
        } catch(Exception e){System.out.println(e);}
        finally {
            System.out.println("Insert Completed.");
        }
    }

    public static ArrayList<String> selectAll() throws Exception{
        try{
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement("SELECT id, artist, nume_event FROM cinema");
            ResultSet result = statement.executeQuery();
            ArrayList<String> array = new ArrayList<String>();
            while(result.next()){
                System.out.println(result.getString("id"));
                System.out.println(" ");
                System.out.println(result.getString("artist"));
                System.out.println(" ");
                System.out.println(result.getString("nume_event"));

                array.add(result.getString("id"));
                array.add(result.getString("artist"));
                array.add(result.getString("nume_event"));
            }
            System.out.println("All records have been selected");
            return array;
        }catch(Exception e){System.out.println(e);}
        return null;
    }




    private static Services service = Services.getService();




    public static void main(String[] args) throws Exception
    {
        Application.launch(args);
        int option;
        Scanner input = new Scanner(System.in);


        DisplayConcertsDB displayConcertsDB = new DisplayConcertsDB();
        DBSetup dBSetup = new DBSetup();

        ConcertsRepo concertsRepo = new ConcertsRepo();
        concertsRepo.ConcertsWriter("C:\\Users\\alex_\\Desktop\\Etapa 2-2\\src\\Concerte.csv", concertsRepo.getConcerts().get(concertsRepo.getConcerts().size()-1));
        ArtGalleriesRepo artGalleriesRepo = new ArtGalleriesRepo();
        CinemaIMAXRepo cinemaIMAXRepo = new CinemaIMAXRepo();
        TheatrePlaysRepo theatrePlaysRepo = new TheatrePlaysRepo();





        Events e1 = new Concerts("Metallica30", "CONCERT", 1234, "2019-11-21 20:30:00", "2019-11-22 01:30:00",  "Metallica", "Black Album",
                new Venue("Arena Nationala", 50000, true, false));
        Events e2 = new ArtGalleries("Expozitie Brancusi", "ART", 1516, "2019-11-25 08:00:00", "2019-12-22 20:00:00", "Brancusi", "Sculpturi", new Venue("Muzeu de arta", 2000, false, false));
        Events e3 = new Concerts("Bullet For My Valentine", "CONCERT", 1264, "2019-12-21 20:30:00", "2019-12-22 01:30:00", "Bullet For My Valetine", "BFMV",
                new Venue("Arena Nationala", 50000, true, false));
        Services s1 = new Services();


        List<Events> listOfEvents = new ArrayList<Events>();

        listOfEvents.add(e1);
        listOfEvents.add(e2);
        listOfEvents.add(e3);


        ArrayList<String> array = new ArrayList<String>();

        System.out.println("What would you like to do? \n 1. Print all concerts \n 2. Print all art galleries \n 3. Print all concerts from CSV " +
                "\n 4. Print all art galleries from CSV \n 5. Print all IMAX Movies from CSV \n 6. Print all theatre plays from CSV");
        option = input.nextInt();

        //insertIntoTableCinema("Avengers Endgame", "IMAX Afi Palace");
        //selectAll();

        switch(option)
        {
            case 1:
                    s1.setListOfEvents(listOfEvents);
                    s1.printConcerts(s1.getConcerts());
                    break;

            case 2:
                    s1.setListOfEvents(listOfEvents);
                    s1.printAllGalleries(s1.getArtGalleries());
                    break;

            case 3:
                    //for(int i = 0; i < concertsRepo.getConcerts().size()-1; i++)
                    concertsRepo.printAllConcerts();
                try{
                    FileWriter fv = new FileWriter("C:\\Users\\alex_\\Desktop\\Etapa 2-2\\src\\Audit.csv",true);
                    fv.write("printConcertsFromCSV , "+ (new Date()).toString() + System.lineSeparator());
                    fv.close();
                }
                catch(Exception e){ System.out.println(e);}
                    break;

            case 4:
                    artGalleriesRepo.printAllArtGalleries();
                try{
                    FileWriter fv = new FileWriter("C:\\Users\\alex_\\Desktop\\Etapa 2-2\\src\\Audit.csv",true);
                    fv.write("printArtGalleriesFromCSV , "+ (new Date()).toString() + System.lineSeparator());
                    fv.close();
                }
                catch(Exception e){ System.out.println(e);}
                    break;

            case 5:
                    cinemaIMAXRepo.printAllIMAXRepo();
                try{
                    FileWriter fv = new FileWriter("C:\\Users\\alex_\\Desktop\\Etapa 2-2\\src\\Audit.csv",true);
                    fv.write("printIMAXMoviesFromCSV , "+ (new Date()).toString() + System.lineSeparator());
                    fv.close();
                }
                catch(Exception e){ System.out.println(e);}
                    break;

            case 6:
                    theatrePlaysRepo.printAllTheatrePlays();
                try{
                    FileWriter fv = new FileWriter("C:\\Users\\alex_\\Desktop\\Etapa 2-2\\src\\Audit.csv",true);
                    fv.write("printTheatrePlaysFromCSV , "+ (new Date()).toString() + System.lineSeparator());
                    fv.close();
                }
                catch(Exception e){ System.out.println(e);}
                    break;

            case 7:
                concertsRepo.addConcert();
                concertsRepo.ConcertsWriter("C:\\Users\\alex_\\Desktop\\Etapa 2-2\\src\\Concerte.csv", concertsRepo.getConcerts().get(concertsRepo.getConcerts().size()-2));

                try{
                FileWriter fv = new FileWriter("C:\\Users\\alex_\\Desktop\\Etapa 2-2\\src\\Audit.csv",true);
                fv.write("test , "+ (new Date()).toString() + System.lineSeparator());
                fv.close();
                }
                catch(Exception e){ System.out.println(e);}
                break;

            case 8:
                //dBSetup.initDatabase();
                //dBSetup.insertConcerts();
                //displayConcertsDB.afisare();
                //getConnection();
                //afisare();
                //createTable();
                //insertIntoTable("Avengers Endgame", "IMAX Afi Palace", "cinema");
                //array = selectAll();
                //System.out.println("Ceva " + array.get(0));
                selectAll();
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        //FXMLLoader loader = new FXMLLoader(getClass().getResource("Resources/GraphicInterface.fxml"));
        //loader.setController(new MainController(path));
        //Pane mainPane = loader.load();
        Pane mainPane = (Pane) FXMLLoader.load(getClass().getClassLoader().getResource("GraphicInterface.fxml"));
        primaryStage.setScene(new Scene(mainPane));
        primaryStage.show();
        //MyController myController;
        //myController.onClick();
    }

}
