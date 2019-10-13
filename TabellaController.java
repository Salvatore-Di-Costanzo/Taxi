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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Salvatore Di Costanzo    -   Matricola:0124/001483
 */
public class TabellaController implements Initializable {
    

    /**
     * Initializes the controller class.
     */
    @FXML
    private Pane rootLayout;
    
    @FXML
    private TableView<TabellaModello> table;
    
    @FXML
    private TableColumn<TabellaModello, String> Passeggero;

    @FXML
    private TableColumn<TabellaModello, String> Taxi;

    
    ObservableList<TabellaModello> oblist = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connessione conn;
        conn = Connessione.getConnessione();
        String query  = "select * from CRONOCORSE ";
            try (PreparedStatement ps = conn.connect.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    oblist.add(new TabellaModello(rs.getString(1),rs.getString(2)));
                }
                ps.close();
            } catch (SQLException ex) {
            Logger.getLogger(TabellaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Passeggero.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        Taxi.setCellValueFactory(new PropertyValueFactory<>("Taxi"));
        table.setItems(oblist); 
    }    
    
    
    @FXML
    void iniziaViaggio(ActionEvent event) throws SQLException, IOException {
        String[] SceltaPercorso = { "Percorso Breve" , "Percorso Veloce"};
        for(Trasporto t : Progetto.list)
            t.accept(Progetto.taxi[0]);
        JFrame frame = new JFrame("Input Dialog");
        String SceltaStrategia = (String) JOptionPane.showInputDialog(frame, 
        "Come vuoi Inoltrare la richiesta?",
        "Scegli il metodo di invio",
        JOptionPane.QUESTION_MESSAGE, 
        null, 
        SceltaPercorso, 
        SceltaPercorso[0]);
        if(SceltaStrategia.equals("Percorso Breve"))   {Viaggia.Scelta("veloce");}
        else                                           {Viaggia.Scelta("tempo"); } 
        TabellaModello dati = table.getSelectionModel().getSelectedItem();
        InserimentoDatiController.caricaLista(dati.getNome());
        Progetto.iniziaViaggio();    
        changeScene("Tabella.fxml");
    }

    @FXML
    void rifiutaViaggio(ActionEvent event) throws SQLException, IOException {
        TabellaModello dati = table.getSelectionModel().getSelectedItem();
                    Connessione conn;
                        conn = Connessione.getConnessione();
                        String query = "Delete from CRONOCORSE WHERE PASSEGGERO = ?";
                        try (PreparedStatement ps = conn.connect.prepareStatement(query)) {
                            ps.setString(1,dati.getNome());
                            ps.executeUpdate();
                            ps.close();
                            JOptionPane.showMessageDialog(null,"Richiesta Rifiutata!!");
                        }catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
            changeScene("Tabella.fxml");
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
