/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Salvatore Di Costanzo    -   Matricola:0124/001483
 */
public class LoginController implements Initializable {
    
    
    @FXML
    private Pane rootLayout;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    
    
    @FXML
    private void setTaxi(ActionEvent event) throws IOException {
            changeScene("LogTaxi.fxml");
    }

    @FXML
    private void setCorsa(ActionEvent event) throws IOException {
            changeScene("LogPasseggero.fxml");
    }


    
    
}
