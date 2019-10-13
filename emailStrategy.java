/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto;

import javax.swing.JOptionPane;

/**
 *
 * @author Salvatore Di Costanzo    -   Matricola:0124/001483
 */
public class emailStrategy implements PrenStrategy {
    @Override
    public void metodoPrenotazione(Persona Utente)
    {
        JOptionPane.showMessageDialog(null,"Prenotazione effettuata via Email per: "+Utente.getNome()+" parte da: "+Utente.getPosPartenza());
    }
}
