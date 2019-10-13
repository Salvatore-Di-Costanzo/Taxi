/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Salvatore Di Costanzo    -   Matricola:0124/001483
 */
public class InserimentoDatiController implements Initializable {
    @FXML
    private Pane rootLayout;
    @FXML
    private TextField NomeInput;
    @FXML
    private TextField NumInput;
    @FXML
    private TextField PosArrivoInput;
    @FXML
    private TextField PosPartInput;
    @FXML
    private TextField NumeroValigie;

    
    private static String nome_inserito;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void InziaCorsa(ActionEvent event) throws SQLException, IOException {
      String[] PrenStrategia = { "SMS" , "EMail"};
      Progetto.list.clear();
      Connessione conn;
      conn = Connessione.getConnessione();
      String query = "UPDATE TAB set NUM_PASSEGGERI = ?, POS_PARTENZA = ?, POS_ARRIVO = ?, NUM_BAGAGLI = ? WHERE  UTENTE = ?";
        try (PreparedStatement ps = conn.connect.prepareStatement(query)) {
            ps.setInt   (1, Integer.parseInt(NumInput.getText()));
            ps.setString(2, PosPartInput.getText());
            ps.setString(3, PosArrivoInput.getText());
            ps.setInt   (4, Integer.parseInt(NumeroValigie.getText()));
            ps.setString(5, NomeInput.getText());
            ps.executeUpdate();
            ps.close();
            
        }
      String query2  = "select * from TAB WHERE UTENTE = ?";
            try (PreparedStatement ps = conn.connect.prepareStatement(query2)) {
                ps.setString(1, NomeInput.getText());
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Progetto.list.add(new Persona(rs.getString("UTENTE"),rs.getInt("NUM_PASSEGGERI"),rs.getString("POS_PARTENZA").charAt(0),rs.getString("POS_ARRIVO").charAt(0)));
                    Progetto.list.add(new Bagagli(rs.getInt("NUM_BAGAGLI")));
                }
                ps.close();
            }   
       String query3  = "INSERT INTO CRONOCORSE (PASSEGGERO,TAXI_ASSEGNATO) VALUES (?,?) ";
            try (PreparedStatement ps = conn.connect.prepareStatement(query3)) {
                ps.setString(1, NomeInput.getText());
                ps.setString(2, Progetto.getTaxi());
                ResultSet rs = ps.executeQuery();
                ps.close();
            }   
            
        JFrame frame = new JFrame("Input Dialog");
        String SceltaStrategia = (String) JOptionPane.showInputDialog(  frame, 
                                                                        "Come vuoi Inoltrare la richiesta?",
                                                                        "Scegli il metodo di invio",
                                                                        JOptionPane.QUESTION_MESSAGE, 
                                                                        null, 
                                                                        PrenStrategia, 
                                                                        PrenStrategia[0]);
        if(SceltaStrategia.equals("SMS"))   {Progetto.PrenotaViaSms(Progetto.list);}
        else                                {Progetto.PrenotaViaEmail(Progetto.list);}    
        changeScene("Login.fxml");    
      
    }
    
    public  void changeScene(String scenePath) throws IOException{
        
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource(scenePath));
        Pane pane = FXMLLoader.load(getClass().getResource(scenePath));
    try{
            pane = (Pane) loader.load();
            rootLayout.getChildren().clear();
            rootLayout.getChildren().add(pane);
        }
        catch(Exception e){
        }
     
    }
    
    public static void caricaLista(String nome) throws SQLException
    {
        Progetto.list.clear();
        Connessione conn;
        conn = Connessione.getConnessione();
        String query2  = "select * from TAB WHERE UTENTE = ?";
            try (PreparedStatement ps = conn.connect.prepareStatement(query2)) {
                ps.setString(1, nome);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Progetto.list.add(new Persona(rs.getString("UTENTE"),rs.getInt("NUM_PASSEGGERI"),rs.getString("POS_PARTENZA").charAt(0),rs.getString("POS_ARRIVO").charAt(0)));
                    Progetto.list.add(new Bagagli(rs.getInt("NUM_BAGAGLI")));
                }
                ps.close();
            }catch (SQLException e) {};   
    
    }    
}
