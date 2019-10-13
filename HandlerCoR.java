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
    Vado a creare dapprima una classe astratta per definire un metodo che dovrà
    essere riscritto nella classe concreta per la gestione del servizio di scelta taxi
    e un metodo setSuccessor per andare a collegare i vari Handler
*/
public abstract class HandlerCoR {
    ///devo implementare il ConcreteHandler per ordinare i taxi e poi per selezionare tra quelli liberi il più vicino
    protected HandlerCoR taxi_successor;
    public void setSuccessor(HandlerCoR successivo)
    {
        taxi_successor = successivo;
    }

    /**
     *
     * @param request
     * @param taxi
     */
    public abstract void handleRequest(RequestCoR request,Taxi[] taxi);  
}
