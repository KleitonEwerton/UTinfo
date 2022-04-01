
package com.u.t.info.tables;

import com.u.t.info.src.Fornecedor;
import com.u.t.info.utils.Arquivo;
import com.u.t.info.utils.JSONFornecedor;
import static com.u.t.info.utils.JSONFornecedor.lerFornecedores;
import java.io.IOException;

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

public class TableFornecedores extends AbstractTableModel{
    
    private final String[] colunas = new String[]{"Razao Social","CNPJ","CEP", "Lista De Produtos"};
    private List<Fornecedor> listFornecedores = new ArrayList<>();    
    
   
    public TableFornecedores(){
        
        listFornecedores  = lerFornecedores();
        
    }
    
    @Override
    public String getColumnName(int indexColuna){
        return colunas[indexColuna];
    }
    
    @Override 
    public int getRowCount() {
        return this.listFornecedores.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int indexLinha, int indexColuna) {
        
        switch(indexColuna){
            
            case 0:
                return this.listFornecedores.get(indexLinha).getRazaoSocial();      
            case 1:
                return this.listFornecedores.get(indexLinha).getCnpj();     
            case 2:
                return this.listFornecedores.get(indexLinha).getCep();
            case 3:
                return this.listFornecedores.get(indexLinha).getListaDeProdutos(); 
            
        }
        return null;
        
    }
    
    public void atualizaTabela(){
        
        this.listFornecedores = lerFornecedores();
        this.fireTableDataChanged();
        
    }
  
    public void addNovoFornecedor(Fornecedor produto) throws IOException{
        this.listFornecedores.add(produto);      
        this.fireTableDataChanged();  
        salvarFornecedores();
        
    }
    
    public void removerFornecedor(int indexLinha){
        
        this.listFornecedores.remove(indexLinha);                        
        this.fireTableRowsDeleted(indexLinha,indexLinha); 
        salvarFornecedores();
    }
    
    
    public Fornecedor getFornecedor(int indexLinha){
        return this.listFornecedores.get(indexLinha);
    }

    public List<Fornecedor> getListFornecedores() {
        return listFornecedores;
    }
    
    private void salvarFornecedores(){
        
        String toJSON = JSONFornecedor.toJSONFornecedores(listFornecedores);
        
        try{
            
            Arquivo.escreverArquivo("arquivos/fornecedores.json",toJSON);
            
        } catch (IOException ex) {
            
            System.out.println("Erro ao salvar os fornecedores");
            
        }
        
    }
    
}
