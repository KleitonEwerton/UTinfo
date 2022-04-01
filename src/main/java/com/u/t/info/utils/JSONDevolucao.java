package com.u.t.info.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.u.t.info.src.Devolucao;
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

public class JSONDevolucao {
    
    public static String toJSONDevolucao(Devolucao devolucao) {
        Gson gson = new Gson();
        return gson.toJson(devolucao);
    }

    public static String toJSONDevolucoes(List<Devolucao> devolucoes) {
        Gson gson = new Gson();
        return gson.toJson(devolucoes);
    }

    public static Devolucao toDevolucao(String json) {
        Gson gson = new Gson();
        Devolucao devolucao = gson.fromJson(json, Devolucao.class);
        return devolucao;
    }

    public static List<Devolucao> toDevolucaoes(String json) {
        Gson gson = new Gson();
        Type devolucaoTipo = new TypeToken<ArrayList<Devolucao>>() {
        }.getType();
        List<Devolucao> devolucoes = gson.fromJson(json, devolucaoTipo);
        return devolucoes;
    }
    
    public static List<Devolucao> lerDevolucao(){
        
        List<Devolucao> listDevolucao = new ArrayList<>();    
        
        try{
            
            String lerArquivo = Arquivo.lerArquivo("arquivos/devolucoes.json");
            listDevolucao = toDevolucaoes(lerArquivo);
            
        } catch (FileNotFoundException ex) {
            
            System.out.println("Erro ao abrir o arquivo dos produtos arquivos/devolucoes.json");
        }
        
        return listDevolucao;
    }
}
