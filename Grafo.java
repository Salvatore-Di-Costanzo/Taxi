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
public class Grafo {
    /*
        Predispongo le strutture necessarie
    */
      private int[][] sensori;
      private int[][] MatriceAdiacenza;
      private int numVertici;
      /*
            COSTRUTTORE GRAFO
            A partire del numero di vertici andiamo a creare la matrice di adiacenza
      */
      public Grafo(int numVertici) {
          this.numVertici = numVertici;
          MatriceAdiacenza = new int [numVertici][numVertici];
          sensori = new int [numVertici][numVertici];
          setSensori();
    }
      /*    Utility per l'aggiunta degli archi tra i vertici
            Poichè si tratta di un Grafo non orientato la matrice risulta essere uguali nelle due componenti triangolari
            quindi quando andiamo a creare un arco tra A->B esiste un arco dello stesso peso da B->A
      */
      public void addArco(int i, int j) {
                ///Ho impostato un valore compreso tra 1 e 40 per i pesi degli archi
                MatriceAdiacenza[i][j]=MatriceAdiacenza[j][i]= (int)((Math.random()*40));
    }
      ///Utility per la rimozione degli archi
      public void rimuoviArco(int i, int j) {
                MatriceAdiacenza[i][j]=MatriceAdiacenza[j][i]= 0;
    }
      ///Ritorna il valore dell'arco date le due coordinate
      public int distArco(int i, int j) {
                  return MatriceAdiacenza[i][j];
    }
      ///Ritorna l'intera matrice di adiacenza (Utile per Dijkstra)
      public int[][] Matrice()  {
          return MatriceAdiacenza;
    }
    
      public void setSensori()
      {
          for(int i=0;i<numVertici;i++)
              for(int j=i+1;j<numVertici;j++)
                  sensori[i][j]=sensori[j][i]=(int)((Math.random()*5)+1);
                    ///Carichiamo i tempi rilevati dai "sensori" per la percorrenza media in termini
                    ///di minuti tra le varie postazioni compreso tra 1 e 5 min;    
      }
      public void getSensori()
      {
          for(int i=0;i<numVertici;i++)
          {
              System.out.println();
              for(int j=0;j<numVertici;j++)
              {
                  System.out.print(" "+sensori[i][j]);
              }
          }
      }

}