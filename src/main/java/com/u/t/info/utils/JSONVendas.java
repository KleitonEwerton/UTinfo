
package com.u.t.info.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.u.t.info.src.Venda;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/*
Integrantes do grupo:
Nome                            Matricula
Ágata Meireles Carvalho         202065001AC
Kleiton Ewerton de Oliveira     202065050AC
Luiz Miguel Batista Silva       202065060A
Nikolas Oliver Sales Genesio    202065072AC
 */

public class JSONVendas {
    
     public static String toJSONVenda(Venda venda) {
        Gson gson = new Gson();
        return gson.toJson(venda);
    }

    public static String toJSONSVendas(List<Venda> vendas) {
        Gson gson = new Gson();
        return gson.toJson(vendas);
    }

    public static Venda toVenda(String json) {
        Gson gson = new Gson();
        Venda venda = gson.fromJson(json, Venda.class);
        return venda;
    }

    public static List<Venda> toVendas(String json) {
        Gson gson = new Gson();
        Type vendasTipo = new TypeToken<ArrayList<Venda>>() {
        }.getType();
        List<Venda> vendas = gson.fromJson(json, vendasTipo);
        return vendas;
    }
    
    public static List<Venda> lerVendas(){
        
        List<Venda> listSupervisores = new ArrayList<>();    
        
        try{
            

            String lerArquivo = Arquivo.lerArquivo("arquivos/vendas.json");


            listSupervisores = toVendas(lerArquivo);
            
        } catch (FileNotFoundException ex) {
            
            //System.out.println("Erro ao abrir o arquivo das vendas");
        }
        
        return listSupervisores;
    }
    
}
