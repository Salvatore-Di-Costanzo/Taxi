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
    Per andare ad effettuare l'ordinamento dei Taxi rispetto alla posizione
    della Persona che lo richiede implemento un semplice InsertinSort particolarmente
    utile quando si vanno a gestire piccole quantità di dati
*/
public class Ordina {

/*
    Argomenti di Input
    1° Array che contiene i percorsi minimi rispetto alla sorgente calcolati da Dijkstra
    2° Array dei Taxi da ordinare dal più vicino alla postazione della Persona
*/
public static Taxi[] insertionSort(int[] arr,Taxi[] taxi){
    ///Predispondo un array per segnare le distanze rispetto alla postazione della Persona
   int[]  distanze_taxi = new int[5];
   for(int i=0;i<5;i++)
   {
       ///Carico l'array prelevando solamente le distanze rispetto alle posizioni attuali dei Taxi
       distanze_taxi[i] = arr[taxi[i].getPos()-'A'];
   }
   System.out.println("\n");
   ///Eseguo l'ordinamento e di conseguenza riordino l'array dei Taxy rispetto alla loro vicinanza
   for(int i=0;i<5;i++)
       System.out.println(taxi[i].getPos()+ " "+distanze_taxi[i]);
        for (int i = 1; i < 5; ++i) { 
            int key = distanze_taxi[i]; 
            Taxi app = taxi[i];
            int j = i - 1; 
            while (j >= 0 && distanze_taxi[j] > key) { 
                distanze_taxi[j + 1] = distanze_taxi[j]; 
                taxi[j + 1] = taxi[j];
                j = j - 1; 
            } 
            distanze_taxi[j + 1] = key; 
            taxi[j + 1] = app;
        } 
    return taxi;
    }
}

