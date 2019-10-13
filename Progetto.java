/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class Progetto {    
    /*
        Oggetti utili
    
    */
        static final List<Trasporto> list = new ArrayList<>();
    
    ///Creo i 5 Taxi disponibili sulla mappa 
        static final Taxi[] taxi = new Taxi[5];
        
    ///Creo gli Handler per la gestione dei taxi
        private static final HandlerCoR h1 = new ConcreteHandlerPercorso();
        private static final HandlerCoR h2 = new ConcreteHandlerPercorso();
        private static final HandlerCoR h3 = new ConcreteHandlerPercorso();
        private static final HandlerCoR h4 = new ConcreteHandlerPercorso();
        private static final HandlerCoR h5 = new ConcreteHandlerPercorso();
        private static Object StyleSystem;
    
    
    public static void inizia() throws SQLException 
    {
        //Progetto.CaricaLista();
       
        
        ///Assegno ai Taxi una posizione di partenza a partire dalla Postazione A
        for(int i=0;i<5;i++)
            taxi[i] = new Taxi('A'+i);
        ///Assegno loro dei nomi identificativi
        taxi[0].setNome("Alpha");
        taxi[1].setNome("Beta");
        taxi[2].setNome("Gamma");
        taxi[3].setNome("Delta");
        taxi[4].setNome("Epsilon");
        ///Setto i successori
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);
        h3.setSuccessor(h4);
        h4.setSuccessor(h5);
        
        
        
       
       
        ///Carico un Grafo con 25 postazioni (ho previsto una città abbastanza grande)
        Grafo grafo = new Grafo(25);
        ///Setto gli archi -> Grafo completamente connesso non orientato
        for(int i=0;i<25;i++)
            for(int j=i;j<25;j++)
                grafo.addArco(i,j);
        ///Stampo la matrice contenente i dati medi rilevati dai sensori posti alle estremità delle due postazioni
        System.out.println();
        System.out.println();
        grafo.getSensori();
        
        
        ///Eseguo Dijkstra per trovare i path tra le varie postazioni e le stampo
        for(int i=0;i<25;i++)
        {   
            System.out.println("\n");
            DijkstrasAlgorithm.dijkstra(grafo.Matrice(),i);
        }    
    }
    
    public static void iniziaViaggio() throws SQLException
    {
        Viaggia.viaggia(list,taxi,h1);
    }
    
    public static void PrenotaViaSms(List list)
    {
       Prenotazione prenSms = new Prenotazione();
       prenSms.setPrenStrategy(new smsStrategy());
       prenSms.Prenota((Persona)list.get(0));
    
    }
    
    public static void PrenotaViaEmail(List list)
    {
       Prenotazione prenEmail = new Prenotazione();
       prenEmail.setPrenStrategy(new emailStrategy());
       prenEmail.Prenota((Persona)list.get(0));
    }
    
    public static String getTaxi()
    {
    
        return taxi[0].getNome();
    }
    
    
    
 }
    

