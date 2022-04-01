package com.u.t.info.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.u.t.info.src.Produto;
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

public class JSONProduto {
    
    public static String toJSONProduto(Produto produto) {
        Gson gson = new Gson();
        return gson.toJson(produto);
    }

    public static String toJSONProdutos(List<Produto> produtos) {
        Gson gson = new Gson();
        return gson.toJson(produtos);
    }

    public static Produto toProduto(String json) {
        Gson gson = new Gson();
        Produto produto = gson.fromJson(json, Produto.class);
        return produto;
    }

    public static List<Produto> toProdutos(String json) {
        Gson gson = new Gson();
        Type produtosTipo = new TypeToken<ArrayList<Produto>>() {
        }.getType();
        List<Produto> produtos = gson.fromJson(json, produtosTipo);
        return produtos;
    }
    
    public static List<Produto> lerProdutos(){
        
        List<Produto> listProdutos = new ArrayList<>();    
        
        try{
            
            String lerArquivo = Arquivo.lerArquivo("arquivos/produtos.json");
            listProdutos = toProdutos(lerArquivo);
            
        } catch (FileNotFoundException ex) {
            
            System.out.println("Erro ao abrir o arquivo dos produtos arquivos/produtos.json");
        }
        
        return listProdutos;
    }
}
