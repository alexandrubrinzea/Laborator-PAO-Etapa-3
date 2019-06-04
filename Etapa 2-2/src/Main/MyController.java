package Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static Main.Main.selectAll;



public class MyController {

    ArrayList<String> array = new ArrayList<String>();

    @FXML
    private Button concertsButton;

    @FXML
    private TextArea textArea;

    @FXML
    void onClick(ActionEvent event) throws Exception{
        array = selectAll();
        //System.out.println("Ceva " + array.get(0));
        //textArea.setText(array.get(0) + " " + array.get(1) + " " + array.get(2));
        //textArea.setText(array.get(1));
        //textArea.setText(array.get(2));
        Connection con = Main.getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT id, artist, nume_event FROM concerte2");
        ResultSet result = statement.executeQuery();
        ArrayList<String> array = new ArrayList<String>();
        while(result.next()){
            textArea.appendText(result.getString("id"));
            textArea.appendText("       ");
            textArea.appendText(result.getString("artist"));
            textArea.appendText("       ");
            textArea.appendText(result.getString("nume_event"));
            textArea.appendText("\n");
        }
    }

    @FXML
    void onClickCinema(ActionEvent event) throws Exception{
        array = selectAll();
        //System.out.println("Ceva " + array.get(0));
        //textArea.setText(array.get(0) + " " + array.get(1) + " " + array.get(2));
        //textArea.setText(array.get(1));
        //textArea.setText(array.get(2));
        Connection con = Main.getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT id, artist, nume_event FROM cinema");
        ResultSet result = statement.executeQuery();
        ArrayList<String> array = new ArrayList<String>();
        while(result.next()){
            textArea.appendText(result.getString("id"));
            textArea.appendText("       ");
            textArea.appendText(result.getString("artist"));
            textArea.appendText("       ");
            textArea.appendText(result.getString("nume_event"));
            textArea.appendText("\n");
        }
    }

}
