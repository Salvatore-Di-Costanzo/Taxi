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
    Classe Bagagli per la scrittura delle proprietà dell'oggetto Trasportabile in Taxi
*/
public class Bagagli implements Trasporto {
 
 private final static float tariffa  = 1;
 private final int num_bagagli;
 
 public Bagagli(int  num) {
 num_bagagli = num;
 } 
 
 @Override
 public void accept(Visitor visitor) {
 visitor.visit(this);
 }
 
   ///Metoti get e set
 public float getTariffa()
 {
     return tariffa;
 }
 
 public int getNumBagagli()
 {
     return num_bagagli;
 }
}
