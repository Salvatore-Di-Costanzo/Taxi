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
public class timeStrategy implements methodPercorrenza {
    @Override
    public void metodoPercorrenza(Taxi Id)
    {
        System.out.println("Il Taxi: "+Id.getNome()+" ha scelto il percorso con tempo di percorrenza più basso");
    }
    
}
