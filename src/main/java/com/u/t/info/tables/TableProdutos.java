/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u.t.info.tables;

import com.u.t.info.src.Produto;
import com.u.t.info.utils.Arquivo;
import com.u.t.info.utils.JSONProduto;
import static com.u.t.info.utils.JSONProduto.lerProdutos;
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

public class TableProdutos extends AbstractTableModel{
    
    private final String[] colunas = new String[]{"Nome", "Codigo", "Preco de Compra", "Preco de Venda", "Fornecedor", "Descricao", "Modelo", "Estoque", "Estoque Minimo"};
    private List<Produto> listProduto = new ArrayList<>();    
    
   
    public TableProdutos(){
        listProduto = JSONProduto.lerProdutos();
    }
    
    @Override
    public String getColumnName(int indexColuna){
        return colunas[indexColuna];
    }
    
    @Override 
    public int getRowCount() {
        return this.listProduto.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int indexLinha, int indexColuna) {
        
        switch(indexColuna){
            
            case 0:
                return this.listProduto.get(indexLinha).getNome();      
            case 1:
                return this.listProduto.get(indexLinha).getCodigo();     
            case 2:
                return this.listProduto.get(indexLinha).getPrecoCompra();
            case 3:
                return this.listProduto.get(indexLinha).getPrecoVenda(); 
            case 4:
                return this.listProduto.get(indexLinha).getFornecedor();
            case 5:
                return this.listProduto.get(indexLinha).getDescricao();
            case 6:
                return this.listProduto.get(indexLinha).getModelo();
            case 7:
                return this.listProduto.get(indexLinha).getQtdeEstoque();
            case 8:
                return this.listProduto.get(indexLinha).getEstoqueMinimo();
        }
        return null;
        
    }
    
  
    public void atualizaTabela(){
        
        this.listProduto = lerProdutos();
        this.fireTableDataChanged();
        
    }
    
    public void addNovoProduto(Produto produto){
        this.listProduto.add(produto);      
        this.fireTableDataChanged();  
        salvarProdutos();       
        
    }
    
    
    public void removerProduto(int indexLinha){
        this.listProduto.remove(indexLinha);                        
        this.fireTableRowsDeleted(indexLinha,indexLinha); 
        salvarProdutos();  
    }
    
    
    public Produto getProduto(int indexLinha){
        return this.listProduto.get(indexLinha);
    }
    
    public List<Produto> getListFornecedores() {
        return listProduto;
    }
    
    private void salvarProdutos(){
        
        String toJSON = JSONProduto.toJSONProdutos(listProduto);
        
        try{
            
            Arquivo.escreverArquivo("arquivos/produtos.json",toJSON);
            
        } catch (IOException ex) {
            
            System.out.println("Erro ao salvar os fornecedores");
            
        }
        
    }
}
