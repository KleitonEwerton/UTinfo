package com.u.t.info.src;

import java.util.List;

/*
Integrantes do grupo:
Nome                            Matricula
Ágata Meireles Carvalho         202065001AC
Kleiton Ewerton de Oliveira     202065050AC
Luiz Miguel Batista Silva       202065060A
Nikolas Oliver Sales Genesio    202065072AC
 */

public interface Vendas {

    public Vendedor getVendedor();

    public void setVendedor(Vendedor vendedor);

    public Produto getProduto();

    public void setProdutos(Produto produto);

    public double getValor();

    public void setValor(double valor);
    
    public void setCliente(Cliente cliente);
    
    public Cliente getCliente();

}
