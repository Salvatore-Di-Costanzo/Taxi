/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Salvatore Di Costanzo    -   Matricola:0124/001483
 */
public class Viaggia {
    
    private static String Scelta;
    
    public static void viaggia(List<Trasporto> lista,Taxi[] taxi,HandlerCoR h) throws SQLException
    {
       ///Downcast
       ///Quando vogliamo utilizzare un metodo proprio di un oggetto incluso all'interno di una lista dobbiamo
       ///per forza di cose operare un Downcast
       Persona app = (Persona) lista.get(0);
        /*   ARGOMENTI handleRequest
            1° Oggetto Request
            2° Array Taxi per permettere la selezione e la modifica della disponibilità
       */
       h.handleRequest(new RequestCoR(app.getPosPartenza(),app.getPosArrivo(),taxi),taxi); 
       SceltaPercorso tempo = new SceltaPercorso();
       SceltaPercorso spazio = new SceltaPercorso();
       tempo.setPercorsoStrategy(new timeStrategy());
       spazio.setPercorsoStrategy(new lenghtStrategy());
       for(int i=0;i<5;i++)
           if(!taxi[i].getLibero())
           {
               if(Scelta.equals("veloce"))
               {
                        JOptionPane.showMessageDialog(null,"Hai Scelto il Percorso più Veloce...");
                        Connessione conn;
                        conn = Connessione.getConnessione();
                        String query = "Delete from CRONOCORSE where PASSEGGERO = ? ";
                        try (PreparedStatement ps = conn.connect.prepareStatement(query)) {
                            ps.setString(1, app.getNome());
                            ps.executeUpdate();
                            ps.close();
                            JOptionPane.showMessageDialog(null,"Cliente in viaggio...\n"+app.getNome()+" è arrivato a destinazione!\nPrezzo Corsa: "+taxi[i].getPrezzoTotale()+"€");
                            
            
                        }catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
                        tempo.Prenota(taxi[i]); 
                        app.setPosPartenza();
                        taxi[i].setPosizione(app.getPosArrivo());
                        taxi[i].setStato(true);
                        taxi[i].clear();
                        lista.set(0,app);
                        i=5;
               
               } else
                   
               {
                    JOptionPane.showMessageDialog(null,"Hai Scelto il Percorso più Breve...");
                    Connessione conn;
                        conn = Connessione.getConnessione();
                        String query = "Delete from CRONOCORSE where PASSEGGERO = ? ";
                        try (PreparedStatement ps = conn.connect.prepareStatement(query)) {
                            ps.setString(1, app.getNome());
                            ps.executeUpdate();
                            ps.close();
                            JOptionPane.showMessageDialog(null,"Cliente in viaggio...\n"+app.getNome()+" è arrivato a destinazione!\nPrezzo Corsa: "+taxi[i].getPrezzoTotale()+"€");
                            
            
                        }catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
                        spazio.Prenota(taxi[i]); 
                        app.setPosPartenza();
                        taxi[i].setPosizione(app.getPosArrivo());
                        taxi[i].setStato(true);
                        taxi[i].clear();
                        lista.set(0,app);
                        i=5;
               
               
               }
           }
        
    }
       
    public static void Scelta(String Scelta)
    {
        Viaggia.Scelta = Scelta;
    }
    public String getScelta()
    {
        return Scelta;
    }
}
