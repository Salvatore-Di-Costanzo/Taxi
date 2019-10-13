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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Salvatore Di Costanzo    -   Matricola:0124/001483
 */
public class LogTaxiController implements Initializable {
    @FXML
    private Pane rootLayout;
    @FXML
    private TextField nome;
    @FXML
    private TextField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void controllogin(ActionEvent event) {
        Connessione conn;
        conn = Connessione.getConnessione();
        String query  = "select * from TAXI WHERE NOME = ? and PASSWORD = ?";
            try (PreparedStatement ps = conn.connect.prepareStatement(query)) {
                ps.setString(1, nome.getText());
                ps.setString(2, password.getText());
                ResultSet rs = ps.executeQuery();
                String verifica_nome = null;
                String verifica_pass = null;
                while(rs.next())
                {
                    verifica_nome = rs.getString("NOME");
                    verifica_pass = rs.getString("PASSWORD");
                }
                if (verifica_nome != null || verifica_pass != null)
                {
                JOptionPane.showMessageDialog(null,"OK!");
                ps.close();
                changeScene("Tabella.fxml");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Dati Errati!!!!");
                    ps.close();
                }
            } catch(Exception e){
            if (e instanceof SQLException)
                JOptionPane.showMessageDialog(null,"ERRORE SQL");
            else JOptionPane.showMessageDialog(null,"Altro Errore!!");
                }

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
    
}
