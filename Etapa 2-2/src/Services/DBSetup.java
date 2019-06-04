package Services;

import Objects.Events;
import Objects.Concerts;
import Objects.Venue;
import Services.Services;
import Services.ConnectionShop;
import org.h2.engine.User;


import java.sql.*;

import static Services.ConnectionShop.*;

public class DBSetup {

    public static void main(String[] args) {
        //Events event = new Events();
        //initDatabase(event);
        //event.setListOfEvents(listOfEvents);
        //event.printConcerts(event.getConcerts());
    }


    public static void initDatabase(/*Events event*/) {
        try (Connection connection = ConnectionShop.getConnection()) {
            Statement stmt = connection.createStatement();
            stmt.execute("drop table if exists user");
            stmt.execute(
                    "create table " +
                            "concerte (" +
                            "name varchar2(200)," +
                            "eventType varchar2(200)," +
                            "id  number(4)," +
                            "startDate varchar2(200)" +
                            "endDate varchar2(200)" +
                            "startDate varchar2(200)" +
                            "artist varchar2(200)" +
                            "tour varchar2(200)" +
                            "location varchar2(200)" +
                            "capacity number(6)" +
                            "openAir varchar2(200)" +
                            "Seated varchar2(200)" +
                            ")");
            stmt.execute("drop sequence if exists user_id_seq");
            stmt.execute("create sequence user_id_seq");
            //for (int counter = 0; counter < 5; counter++) {
                //userService.createNewUser("test" + counter, "test-address", "test" + counter + "@test.com");
                //event = new Concerts("Metallica30", "CONCERT", 1234, "2019-11-21 20:30:00", "2019-11-22 01:30:00",  "Metallica", "Black Album",
                //        new Venue("Arena Nationala", 50000, true, false));
            //}

        } catch (SQLException ex) {
            System.out.println("Could not finish database setup!");
            ex.printStackTrace();
        }



    }

    public static void insertConcerts() {
        String insert = "INSERT INTO concerte(IRONMAIDEN30,Concert,2918,2019-11-21 20:25:00,2019-11-21 22:30:00,Iron Maiden,Iron Maiden,Arena Nationala,50000,True,False)";

        try (
                Connection con = DriverManager.getConnection(URL, USER, PASS);
                PreparedStatement s = con.prepareStatement(insert);
        ) {

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void afisare() {
        try{
            //Class.forName("com.mysql.jdbc.Driver").newInstance();

            //serverhost = localhost, port=3306, username=root, password=123
            Connection cn=DriverManager.getConnection(URL, USER, PASS);
            Statement smt=cn.createStatement();




            try (Connection connection = ConnectionShop.getConnection()) {
                smt.execute("drop table if exists user");
                smt.execute(
                        "create table " +
                                "concerte (" +
                                "name varchar2(200)," +
                                "eventType varchar2(200)," +
                                "id  number(4)," +
                                "startDate varchar2(200)" +
                                "endDate varchar2(200)" +
                                "startDate varchar2(200)" +
                                "artist varchar2(200)" +
                                "tour varchar2(200)" +
                                "location varchar2(200)" +
                                "capacity number(6)" +
                                "openAir varchar2(200)" +
                                "Seated varchar2(200)" +
                                ")");
                smt.execute("drop sequence if exists user_id_seq");
                smt.execute("create sequence user_id_seq");
                //for (int counter = 0; counter < 5; counter++) {
                //userService.createNewUser("test" + counter, "test-address", "test" + counter + "@test.com");
                //event = new Concerts("Metallica30", "CONCERT", 1234, "2019-11-21 20:30:00", "2019-11-22 01:30:00",  "Metallica", "Black Album",
                //        new Venue("Arena Nationala", 50000, true, false));
                //}

            } catch (SQLException ex) {
                System.out.println("Could not finish database setup!");
                ex.printStackTrace();
            }




            //query to display all records from table employee
            String q="Select * from concerte";

            //to execute query
            ResultSet rs=smt.executeQuery(q);

            //to print the resultset on console
            if(rs.next()){
                do{
                    System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getString(5));
                }while(rs.next());
            }
            else{
                System.out.println("Record Not Found...");
            }
            cn.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}