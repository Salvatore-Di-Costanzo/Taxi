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

/*
    TEMPLATE CHAIN OF RESPONSIBILITY
    Creo la classe ConcreteHandlerPercorso per andare ad estendere la classe
    astratta HandlerCoR, riscrivo il medoto handleRequest per la gestione della lista
*/
public class ConcreteHandlerPercorso extends HandlerCoR {
    private static int i = 0 ;
    @Override
    public void handleRequest(RequestCoR request,Taxi[] taxi) {
       if(taxi[i].getLibero())
       {
           System.out.println("\nHo selezionato il Taxi: "+taxi[i].getNome());
           taxi[i].setStato(false);
           int j = i;
           i=0;
       }
       else
       {
           i=(((i+1)%5));
           taxi_successor.handleRequest(request,taxi);
       }   
    }
    
    
}
