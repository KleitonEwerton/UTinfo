/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u.t.info.tables;

import com.u.t.info.src.Funcionario;
import static com.u.t.info.src.Funcionario.retornaListaFuncionarios;
import com.u.t.info.src.Gerente;
import com.u.t.info.src.Supervisor;
import com.u.t.info.src.Vendedor;

import static com.u.t.info.utils.JSONGerente.salvarGerentesJSON;
import static com.u.t.info.utils.JSONSupervisor.salvarSupervisoresJSON;
import static com.u.t.info.utils.JSONVendedor.salvarVendedoressJSON;

import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/*
Integrantes do grupo:
Nome                            Matricula
Ágata Meireles Carvalho         202065001AC
Kleiton Ewerton de Oliveira     202065050AC
Luiz Miguel Batista Silva       202065060A
Nikolas Oliver Sales Genesio    202065072AC
 */

public class TableFuncionarios extends AbstractTableModel{
    
    private final String[] colunas = new String[]{"CPF","Nome", "Contato", "CEP","Ocupação"};
    private List<Funcionario> listFuncionarios;    
    
   
    public TableFuncionarios(){
        this.listFuncionarios = new ArrayList<>();
        this.listFuncionarios = retornaListaFuncionarios();
        
    }
    
    @Override
    public String getColumnName(int indexColuna){
        return colunas[indexColuna];
    }
    
    @Override 
    public int getRowCount() {
        return this.listFuncionarios.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int indexLinha, int indexColuna) {
        
        switch(indexColuna){
            
            case 0:
                return this.listFuncionarios.get(indexLinha).getCpf();      
            case 1:
                return this.listFuncionarios.get(indexLinha).getNome();     
            case 2:
                return this.listFuncionarios.get(indexLinha).getContato();
            case 3:
                return this.listFuncionarios.get(indexLinha).getCep();
            case 4:
                switch (this.listFuncionarios.get(indexLinha).getClass().getTypeName())
                {
                    case "com.u.t.info.src.Gerente":
                        return "Gerente";
                    case "com.u.t.info.src.Supervisor":
                        return "Supervisor";
                    case "com.u.t.info.src.Vendedor":
                        return "Vendedor";
                }
                
        }
        return null;
        
    }
    
  
    public void atualizaTabela(){
        
        this.listFuncionarios = retornaListaFuncionarios();
        this.fireTableDataChanged();
        
    }
    
    public void addNovoFuncionario(Funcionario produto){
        this.listFuncionarios.add(produto);      
        this.fireTableDataChanged();          
        salvarFuncionarios();
    }
    
    public void removerFuncionario(int indexLinha){
        
        this.listFuncionarios.remove(indexLinha);                        
        this.fireTableRowsDeleted(indexLinha,indexLinha); 
        salvarFuncionarios();
    }
    
    
    public Funcionario getFuncionario(int indexLinha){
        return this.listFuncionarios.get(indexLinha);
    }
    
    public List<Funcionario> getListFornecedores() {
        return listFuncionarios;
    }
    
    private void salvarFuncionarios(){
        
        List<Gerente> listGerente       = new ArrayList<>();
        List<Supervisor> listSupervisor = new ArrayList<>();
        List<Vendedor> listVendedor     = new ArrayList<>();
        
        for(Funcionario funcionario: this.listFuncionarios){
            
            switch (funcionario.getClass().getTypeName())
                {
                    case "com.u.t.info.src.Gerente":
                        listGerente.add((Gerente) funcionario);
                        break;
                    case "com.u.t.info.src.Supervisor":
                        listSupervisor.add((Supervisor) funcionario);
                        break;
                    case "com.u.t.info.src.Vendedor":
                        listVendedor.add((Vendedor) funcionario);
                        break;
                }
            
        }
        
        salvarGerentesJSON(listGerente);
        salvarVendedoressJSON(listVendedor);
        salvarSupervisoresJSON(listSupervisor);
       
        
    }
    
    
}
