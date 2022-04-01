package com.u.t.info.tables;

import com.u.t.info.src.Venda;
import static com.u.t.info.utils.JSONVendas.lerVendas;
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
 * @author KleitonEwerton
 */
public class TableVendas extends AbstractTableModel{
    
    private final String[] colunas = new String[]{"Vendedor", "Cliente","Produto","Valor"};
    private List<Venda> listVenda = new ArrayList<>();    
    
   
    public TableVendas(){
        
        listVenda = lerVendas();
        
    }
    
    @Override
    public String getColumnName(int indexColuna){
        return colunas[indexColuna];
    }
    
    @Override 
    public int getRowCount() {
        return this.listVenda.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int indexLinha, int indexColuna) {
        
        switch(indexColuna){
            
            case 0:
                return this.listVenda.get(indexLinha).getVendedor().getCpf();  
            case 1:
                return this.listVenda.get(indexLinha).getCliente().getCpf();
            case 2:
                return this.listVenda.get(indexLinha).getProduto().getCodigo();
            case 3:
                return this.listVenda.get(indexLinha).getValor();
            
        }
        return null;
        
    }
    
    
    public void atualizaTabela(){
        
        this.listVenda = lerVendas();
        this.fireTableDataChanged();
        
    }
    
}
