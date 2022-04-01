/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u.t.info.utils;

import javax.swing.JOptionPane;

/*
Integrantes do grupo:
Nome                            Matricula
Ágata Meireles Carvalho         202065001AC
Kleiton Ewerton de Oliveira     202065050AC
Luiz Miguel Batista Silva       202065060A
Nikolas Oliver Sales Genesio    202065072AC
 */

/**
 *
 * @author KleitonEwerton
 */
public class Utils {

    /**
     * Metodo para confirmar a exclusao
     * @return a opcao escolhida
     */
    public static int confirmacaoExclusao(){
        
        return JOptionPane.showConfirmDialog(null,"Você realmente quer fazer isso?","Excluir",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        
    }
    
}
