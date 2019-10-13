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
    PATTERN VISITOR
    Interfaccia Visitor per la gestione dei vari oggetti che possono usufruire del Taxi

*/
public interface Visitor {
    public void visit(Persona p);
    public void visit(Bagagli l);
}
