
package com.u.t.info.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.u.t.info.src.Vendedor;
import java.io.FileNotFoundException;
import java.io.IOException;
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

public class JSONVendedor {
    
    public static String toJSONVendedor(Vendedor vendedor) {
        Gson gson = new Gson();
        return gson.toJson(vendedor);
    }

    public static String toJSONSVendedores(List<Vendedor> vendas) {
        Gson gson = new Gson();
        return gson.toJson(vendas);
    }

    public static Vendedor toVendedor(String json) {
        Gson gson = new Gson();
        Vendedor vendedor = gson.fromJson(json, Vendedor.class);
        return vendedor;
    }

    public static List<Vendedor> toVendedores(String json) {
        Gson gson = new Gson();
        Type vendedoresTipo = new TypeToken<ArrayList<Vendedor>>() {
        }.getType();
        List<Vendedor> vendedores = gson.fromJson(json, vendedoresTipo);
        return vendedores;
    }
    
    public static List<Vendedor> lerVendedores(){
        
        List<Vendedor> listVendedores = new ArrayList<>();    
        
        try{
            
            String lerArquivo = Arquivo.lerArquivo("arquivos/vendedores.json");
            listVendedores = toVendedores(lerArquivo);
            
        } catch (FileNotFoundException ex) {
            
            //System.out.println("Erro ao abrir o arquivo das vendas");
        }
        
        return listVendedores;
    }
    
    public static void salvarVendedoressJSON(List<Vendedor> listVendedor){
        
        try{
            String toJSONVendedor = JSONVendedor.toJSONSVendedores(listVendedor);
            Arquivo.escreverArquivo("arquivos/vendedores.json",toJSONVendedor);
            
        } catch (IOException ex) {
            
            System.out.println("Erro ao salvar os vendedores em arquivos/vendedores.json");
            
        }
    }
    
}
