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
    Interfaccia Trasporto per la gestione dei Visitor
*/
public interface Trasporto {
    public void accept(Visitor v);
}
