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
class DijkstrasAlgorithm { 
  
    /*
        Predispongo le variabili utili
    */
    private static final int NO_PARENT = -1; 
    static final int[][] minDistanza = new int[25][25]; 
    private static int sorg;
  
    /*
        Algoritmo di Dijkstra che lavora sulla matrice di adiacenza del Grafo e su un vertice di partenza
    */
    static void dijkstra(int[][] MatriceAdiacenza, 
                                        int startVertex) 
    { 
        ///Setto la sorgente e il numero di vertici
        sorg = startVertex;
        int nVertici = MatriceAdiacenza[0].length; 
        
        boolean[] aggiunto = new boolean[nVertici]; 
  
        /*
            Inizializzo tutte le distanze a Infinito e setto tutti i verici aggiunti a falso
        */
        for (int indiceVertici = 0; indiceVertici < nVertici; indiceVertici++) 
        { 
            minDistanza[startVertex][indiceVertici] = Integer.MAX_VALUE; 
            aggiunto[indiceVertici] = false; 
        } 
        ///Setto la distanza del vertice da se stesso a 0  
       
        minDistanza[startVertex][startVertex] = 0; 
  
        ///Array parents che contiene il cammino minimo
        int[] parents = new int[nVertici]; 
  
        ///Il vertice di partenza lo settiamo senza Parent
        parents[startVertex] = NO_PARENT; 
  
        ///Ricerchiamo il cammino minimo per tutti i vertici
        for (int i = 1; i < nVertici; i++) 
        { 
  
            /*
                Scegliamo il vertice più vicino di cui calcolare la distanza dall'insieme dei
                vertici non ancora elaborati
            */
            int VerticeProssimo = -1;
            int DistanzaLocale = Integer.MAX_VALUE; 
            for (int vertexIndex = 0; vertexIndex < nVertici;  vertexIndex++) 
            { 
                if (!aggiunto[vertexIndex] && minDistanza[startVertex][vertexIndex] < DistanzaLocale)  
                { 
                    VerticeProssimo = vertexIndex; 
                    DistanzaLocale = minDistanza[startVertex][vertexIndex]; 
                } 
            } 
  
            ///Marco il vertice selezionato come elaborato
            aggiunto[VerticeProssimo] = true; 
  
            /// Aggiorno il valore della distanza dei vertici adiacenti rispetto a quello scelto 
            for (int vertexIndex = 0; vertexIndex < nVertici;  vertexIndex++)  
            { 
                int DistanzaArco = MatriceAdiacenza[VerticeProssimo][vertexIndex]; 
                  
                if (DistanzaArco > 0 && ((DistanzaLocale + DistanzaArco) < minDistanza[startVertex][vertexIndex]))  
                { 
                    parents[vertexIndex] = VerticeProssimo; 
                    minDistanza[startVertex][vertexIndex] = DistanzaLocale +  DistanzaArco; 
                } 
            } 
        } 
        
        printSolution(startVertex, minDistanza, parents,sorg); 
    } 
    ///Utility per la stampa dei Vertici Adiacenti
    private static void printSolution(int VerticePartenza, 
                                      int[][] distanze, 
                                      int[] parents,int sorg) 
    { 
        int nVertices = distanze.length; 
        System.out.println("Dal Vertice: "+(char)(sorg+'A'));
        System.out.print("Vertici\t\t Distanza\tPercorso"); 
          
        for (int vertexIndex = 0;  
                 vertexIndex < nVertices;  
                 vertexIndex++)  
        { 
            if (vertexIndex != VerticePartenza)  
            { 
                System.out.print("\n" + (char)(VerticePartenza+'A') + " -> "); 
                System.out.print((char)(vertexIndex+'A') + " \t\t "); 
                System.out.print(distanze[sorg][vertexIndex] + "\t\t"); 
                printPath(vertexIndex, parents); 
            } 
        } 
    } 
  
    ///Utility per la stampa del percorso più breve
    private static void printPath(int VerticeCorrente, int[] parents) 
    { 
          
        if (VerticeCorrente == NO_PARENT) 
        { 
            return; 
        } 
        printPath(parents[VerticeCorrente], parents); 
        System.out.print((char)(VerticeCorrente+'A') + " "); 
    } 
    
    ///Utility per restituire gli elementi che compongono il vettore del path più breve rispetto ad una sorgente
    public static int[] VetDist(int sorg,int nVertici)
    {
        return minDistanza[sorg];
    }
    
} 