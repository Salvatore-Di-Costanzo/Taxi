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
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Salvatore Di Costanzo    -   Matricola:0124/001483
 */
public class HomeController implements Initializable {
    
    
    @FXML
    private ToggleGroup group1;

    @FXML
    private ToggleButton expeseBtn;

    @FXML
    private BorderPane rootLayout;
    @FXML
    private ToggleGroup group11;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        changeScene("Benvenuto.fxml");
    }
    public  void changeScene(String scenePath){
        
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource(scenePath));
        AnchorPane pane = new AnchorPane();
    try{
            pane = (AnchorPane) loader.load();
            rootLayout.setCenter(pane);
        }
        catch(Exception e){
        }
     
    }
    
    @FXML
    public void setCorsa(ActionEvent event) {
        changeScene("InserimentoDati.fxml");
    }

    @FXML
    void getTaxi(ActionEvent event) {
        changeScene("Tabella.fxml");
            
    }

    /**
     *
     * @param event
     */
    @FXML
    void Home(ActionEvent event) {
            changeScene("Benvenuto.fxml");
    }
    
    @FXML
    void Login(ActionEvent event) {
            changeScene("Login.fxml");
    }
    
    public void callHome()
    {
        this.Home(null);
    
    }
    
}
    

 
