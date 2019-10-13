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
    Classe Taxi per la gestione dei veicoli

*/
public class Taxi implements Visitor {
 ///Variabili utili
 /*
        totalFare   ->  Prezzo Totale per la Corsa
        libero      ->  Tiene traccia della disponibilità del Taxi
        pos         ->  Posizione del Taxi sul Grafo
 */
 private static float totalFare;
 private boolean libero = true ;
 private char pos;
 private String nomeTaxi;
//Costruttore
public Taxi(int pos) {
        this.pos = (char)pos;
}
 ///Override deli metodi dell'interfaccia Visitor
 @Override
 public void visit(Persona p) {
    totalFare += (p.getTariffa() * DijkstrasAlgorithm.minDistanza[p.getPosPartenza()-'A'][p.getPosArrivo()-'A'] * p.getNumeroDiPersone());
 }
 

 
 @Override
 public void visit(Bagagli l) {
    totalFare += (l.getTariffa() * l.getNumBagagli());
 }
 
    /**
     *
     * @return
     */
public float getPrezzoTotale() {
    return totalFare;
 }
 ///Restituisce la Posizione attuale del Taxi
 public char getPos(){
     return pos;
 }

    public void setPos(char pos){
     this.pos=pos;
 }
///Restituisce lo stato attuale del Taxi    -> true = libero / false = occupato
public boolean getLibero()
{
    return libero;
}
///Metodo per settare la disponibilità del Taxi una volta Occupato / Liberato
public void setStato(boolean stato)
{
    libero = stato;
}

public void setNome(String nomeTaxi)
{
    this.nomeTaxi = nomeTaxi;
}

public String getNome()
{
    return nomeTaxi;
}
public void setPosizione(char pos)
{
    this.pos = pos;
}

public void clear()
{
    Taxi.totalFare = (float) 0.00;
}
}
