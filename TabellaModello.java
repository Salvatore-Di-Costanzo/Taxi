/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto;

/**
 *
 * @author Salvatore Di Costanzo    -   Matricola:0124/001483
 */
public class TabellaModello {
    String Nome,Taxi;
    public TabellaModello(String Nome,String Taxi)
    {
        this.Nome = Nome;
        this.Taxi = Taxi;
    }
    
    public String getNome()
    {
        return Nome;
    }
    
    public String getTaxi()
    {
        return Taxi;
    }
    
    public void setNome(String Nome)
    {
        this.Nome =  Nome;
    }
    
    public void setTaxi(String Taxi)
    {
        this.Taxi = Taxi;
    }
}
