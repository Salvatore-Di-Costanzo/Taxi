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
public class Prenotazione {
    
    private PrenStrategy strategy;
    public void setPrenStrategy(PrenStrategy metodo)
    {
        this.strategy = metodo;
    }
    public void Prenota(Persona Utente)
    {
        strategy.metodoPrenotazione(Utente);
    }
}
