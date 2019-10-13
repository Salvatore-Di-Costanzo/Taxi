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
public class Persona implements Trasporto 
{
    private String nome;
    private char posPartenza;
    private char posArrivo;
    private final static float tariffa = (float) 2.50; ///Prezzo sia per km che per tempo stimato
    private int numeroDiPersone;
 
 public Persona(String nome,int n,char posPartenza,char posArrivo) {
 this.nome = nome;
 numeroDiPersone = n;
 this.posPartenza = posPartenza;
 this.posArrivo  = posArrivo;
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
 
 public int getNumeroDiPersone()
 {
     return numeroDiPersone;
 }
 public String getNome()
    {
        return nome;
    }
public char getPosPartenza()
    {
        return posPartenza;
    }
public char getPosArrivo()
    {
        return posArrivo;
    }
 public void setPosPartenza()
 {
     this.posPartenza = this.posArrivo;
 }

} 

