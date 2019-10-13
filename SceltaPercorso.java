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
public class SceltaPercorso {
    
    private methodPercorrenza strategy;
    public void setPercorsoStrategy(methodPercorrenza metodo)
    {
        this.strategy = metodo;
    }
    public void Prenota(Taxi Id)
    {
        strategy.metodoPercorrenza(Id);
    }
    
}
