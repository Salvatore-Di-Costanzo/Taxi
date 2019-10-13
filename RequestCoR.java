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
    Creo la classe RequestCoR per raggruppare l'insieme della informazioni necessarie
    per una corretta gestione dei taxi durante a loro chiamata
*/
public final class RequestCoR {
    ///Variabili tutili
    private final int vertice_partenza;
    private final int vertice_arrivo;
    ///Con il vertice di partenza vado a ordinare i taxi rispetto a quest'ultimo
    public RequestCoR(char vertice_partenza,char vertice_arrivo,Taxi[] taxi)
    {
        this.vertice_partenza = (int)(vertice_partenza-'A');
        this.vertice_arrivo   = (int)(vertice_arrivo-'A');
        SelTaxi(taxi);
    }
    public int getValue_partenza()
    {
        return vertice_partenza;
    }
    public int getValue_arrivo()
    {
        return vertice_arrivo;
    }
    ///Ordino i taxi rispetto al vertice di partenza
    public void SelTaxi(Taxi[] taxi)
    {
        taxi = Ordina.insertionSort(DijkstrasAlgorithm.VetDist(vertice_partenza,25),taxi);
        System.out.println("\n");
        ///Stampo i path in ordine crescente
        for(int j=0;j<5;j++)
            System.out.println(taxi[j].getPos() + " " + taxi[j].getNome());
    }
    
}
