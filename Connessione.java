/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto;

import java.sql.*;

/**
 *
 * @author Salvatore Di Costanzo    -   Matricola:0124/001483
 */
public class Connessione {
    private static Connessione instance;
    public Connection connect;
    ///
    private Connessione(){
        try{
            // Installa driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Connessione
            connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","DB","prog3");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static Connessione getConnessione(){
        if(instance == null){
            instance = new Connessione();
        }
        return instance;
    }

    Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
