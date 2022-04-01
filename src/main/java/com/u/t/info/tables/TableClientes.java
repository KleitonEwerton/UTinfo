/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u.t.info.tables;

import com.u.t.info.src.Cliente;
import com.u.t.info.utils.JSONCliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
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
 * @author luiz
 */
public class TableClientes extends AbstractTableModel{

    private final String[] colunas = new String[]{"Nome", "Telefone", "CPF","Endereço", "Tipo"};
    private List<Cliente> listaCliente = new ArrayList<>();    
    
   
    public TableClientes(){
        listaCliente = JSONCliente.lerCliente();
    }
    
    @Override
    public String getColumnName(int indexColuna){
        return colunas[indexColuna];
    }
    
    @Override 
    public int getRowCount() {
        return this.listaCliente.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int indexLinha, int indexColuna) {
        
        switch(indexColuna){
            
            case 0:
                return this.listaCliente.get(indexLinha).getNome();      
            case 1:
                return this.listaCliente.get(indexLinha).getTelefone();     
            case 2:
                return this.listaCliente.get(indexLinha).getCpf();
            case 3:
                return this.listaCliente.get(indexLinha).getRua() +" "+this.listaCliente.get(indexLinha).getNumero() ;

            case 4:
                return this.listaCliente.get(indexLinha).getTipo();
        }
        return null;
        
    }
  
    public void addNovoCliente(Cliente cliente){
        this.listaCliente.add(cliente);      
        this.fireTableDataChanged();          
        
    }
    
    
    public void removerCliente(int indexLinha){
        this.listaCliente.remove(indexLinha);                        
        this.fireTableRowsDeleted(indexLinha,indexLinha); 
    }

    public Cliente getCliente(int indexLinha){
        return this.listaCliente.get(indexLinha);
    }

}
